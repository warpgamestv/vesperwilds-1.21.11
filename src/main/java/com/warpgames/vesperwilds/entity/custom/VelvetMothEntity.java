package com.warpgames.vesperwilds.entity.custom;

import com.warpgames.vesperwilds.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.object.PlayState;
import software.bernie.geckolib.animation.state.AnimationTest;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

// 1. Implement 'GeoEntity' to let GeckoLib handle animations
// 2. Implement 'FlyingAnimal' so it behaves like a flyer
public class VelvetMothEntity extends PathfinderMob implements GeoEntity, FlyingAnimal {

    // This cache stores the animation state
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public VelvetMothEntity(EntityType<? extends PathfinderMob> entityType, Level level) {

        super(entityType, level);
        this.moveControl = new FlyingMoveControl(this, 20, true);
    }

    // --- 1. ATTRIBUTES (Health, Speed, Flying) ---
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)       // 5 Hearts
                .add(Attributes.FLYING_SPEED, 0.6f)      // Fast flyer
                .add(Attributes.MOVEMENT_SPEED, 0.25D)    // Ground speed
                .add(Attributes.FOLLOW_RANGE, 32.0D);// Detection range
    }

    // 4. Override Navigation to handle 3D paths
    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation navigation = new FlyingPathNavigation(this, level);
        navigation.setCanOpenDoors(false);
        navigation.setCanFloat(true);
        return navigation;
    }

    // 5. Prevent Fall Damage (Moths shouldn't die if they land)
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
        // Do nothing
    }

    // --- 2. GOALS (AI Behavior) ---
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this)); // Don't drown
        this.goalSelector.addGoal(2, new MothWanderGoal(this)); // Custom flying wander
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    // --- 3. GECKOLIB ANIMATION SETUP ---
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // CHANGE 1: Remove 'this' from the start of the arguments
        // Format: new AnimationController<>(name, transition_length, predicate)
        controllers.add(new AnimationController<>("controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationTest<VelvetMothEntity> event) {
        if (event.isMoving()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.velvet_moth.flight"));
        }

        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {

        return this.cache;
    }

    // --- 4. BREEDING (Optional, required by Animal class) ---
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null; // Moths don't breed (yet!)
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        // Check if player is holding a Glass Bottle
        if (itemStack.is(Items.GLASS_BOTTLE)) {
            // Play a "pop" sound (like corking a bottle)
            player.playSound(SoundEvents.BOTTLE_FILL, 1.0F, 1.0F);

            // If not in Creative Mode, remove the glass bottle
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }

            // Give the player the "Bottled Moth"
            ItemStack bottledMoth = new ItemStack(ModItems.BOTTLED_MOTH);

            // If the inventory is full, drop it on the ground; otherwise add to inventory
            if (!player.getInventory().add(bottledMoth)) {
                player.drop(bottledMoth, false);
            }

            // Remove the Moth from the world
            this.discard();

            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public boolean isFlying() {
        return !this.onGround();
    }
    // Custom Goal: Pick a random spot in the air and fly there
    static class MothWanderGoal extends Goal {
        private final VelvetMothEntity mob;

        public MothWanderGoal(VelvetMothEntity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return this.mob.getNavigation().isDone() && this.mob.getRandom().nextInt(10) == 0;
        }

        @Override
        public boolean canContinueToUse() {
            return this.mob.getNavigation().isInProgress();
        }

        @Override
        public void start() {
            // Pick a random point in 3D space
            Vec3 randomPos = this.findPos();
            if (randomPos != null) {
                this.mob.getNavigation().moveTo(randomPos.x, randomPos.y, randomPos.z, 1.0D);
            }
        }

        private Vec3 findPos() {
            RandomSource random = this.mob.getRandom();
            // Try to find a spot 10 blocks away, 7 blocks up/down
            for (int i = 0; i < 10; i++) {
                BlockPos pos = this.mob.blockPosition().offset(
                        random.nextInt(20) - 10,
                        random.nextInt(14) - 7,
                        random.nextInt(20) - 10
                );

                // Only go there if it's air
                if (this.mob.level().getBlockState(pos).isAir()) {
                    return Vec3.atCenterOf(pos);
                }
            }
            return null;
        }
    }
}