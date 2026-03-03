package com.warpgames.vesperwilds.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.object.PlayState;
import software.bernie.geckolib.animation.state.AnimationTest;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

public class GloomStalkerEntity extends Monster implements GeoEntity, FlyingAnimal {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public GloomStalkerEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.FLYING_SPEED, 0.5f)
                .add(Attributes.MOVEMENT_SPEED, 0.35D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.FOLLOW_RANGE, 24.0D);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation navigation = new FlyingPathNavigation(this, level);
        navigation.setCanOpenDoors(false);
        navigation.setCanFloat(true);
        return navigation;
    }

    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
    }

    public boolean isHanging() {
        if (!this.onGround() && this.getDeltaMovement().lengthSqr() < 0.01) {
            BlockPos posAbove = this.blockPosition().above();
            BlockState stateAbove = this.level().getBlockState(posAbove);
            // Hang if the block above is solid
            return stateAbove.isSolid();
        }
        return false;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(2, new GloomStalkerWanderGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>("controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationTest<GloomStalkerEntity> event) {
        if (this.swinging) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.gloom_stalker.attack"));
        } else if (event.isMoving()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.gloom_stalker.flap"));
        } else if (this.isHanging()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.gloom_stalker.idle"));
        } else {
            // Fallback if not moving and not hanging (e.g., sitting on ground)
            return PlayState.STOP;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public boolean isFlying() {
        return !this.onGround();
    }

    static class GloomStalkerWanderGoal extends Goal {
        private final GloomStalkerEntity mob;
        private BlockPos targetPosition;

        public GloomStalkerWanderGoal(GloomStalkerEntity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return this.mob.getTarget() == null && this.mob.getRandom().nextInt(2) == 0;
        }

        @Override
        public boolean canContinueToUse() {
            return this.mob.getTarget() == null;
        }

        @Override
        public void start() {
            this.targetPosition = null;
        }

        @Override
        public void tick() {
            RandomSource random = this.mob.getRandom();
            if (this.targetPosition != null && (!this.mob.level().isEmptyBlock(this.targetPosition)
                    || this.targetPosition.getY() <= -64)) {
                this.targetPosition = null;
            }

            if (this.targetPosition == null || random.nextInt(30) == 0
                    || this.targetPosition.closerToCenterThan(this.mob.position(), 2.0D)) {
                this.targetPosition = BlockPos.containing(
                        this.mob.getX() + (double) random.nextInt(7) - (double) random.nextInt(7),
                        this.mob.getY() + (double) random.nextInt(6) - 2.0D,
                        this.mob.getZ() + (double) random.nextInt(7) - (double) random.nextInt(7));
            }

            double dx = (double) this.targetPosition.getX() + 0.5D - this.mob.getX();
            double dy = (double) this.targetPosition.getY() + 0.1D - this.mob.getY();
            double dz = (double) this.targetPosition.getZ() + 0.5D - this.mob.getZ();
            Vec3 deltaMove = this.mob.getDeltaMovement();
            Vec3 addedDelta = deltaMove.add(
                    (Math.signum(dx) * 0.5D - deltaMove.x) * 0.1F,
                    (Math.signum(dy) * 0.7F - deltaMove.y) * 0.1F,
                    (Math.signum(dz) * 0.5D - deltaMove.z) * 0.1F);
            this.mob.setDeltaMovement(addedDelta);
            float f = (float) (Mth.atan2(addedDelta.z, addedDelta.x) * (180F / (float) Math.PI)) - 90.0F;
            float g = Mth.wrapDegrees(f - this.mob.getYRot());
            this.mob.zza = 0.5F;
            this.mob.setYRot(this.mob.getYRot() + g);
        }
    }
}
