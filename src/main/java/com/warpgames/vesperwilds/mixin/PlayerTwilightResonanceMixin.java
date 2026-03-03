package com.warpgames.vesperwilds.mixin;

import com.warpgames.vesperwilds.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Player.class)
public class PlayerTwilightResonanceMixin {

    /**
     * Boosts mining speed by 20% when using Vesperite tools in low light (< 7).
     */
    @Inject(method = "getDestroySpeed", at = @At("RETURN"), cancellable = true)
    private void vesperWilds$applyTwilightResonanceMining(BlockState state, CallbackInfoReturnable<Float> cir) {
        Player player = (Player) (Object) this;

        // Check if holding a valid Vesperite tool for mining (Pickaxe, Axe, Shovel,
        // Hoe)
        boolean isVesperiteMiningTool = player.getMainHandItem().is(ModItems.VESPERITE_PICKAXE) ||
                player.getMainHandItem().is(ModItems.VESPERITE_AXE) ||
                player.getMainHandItem().is(ModItems.VESPERITE_SHOVEL) ||
                player.getMainHandItem().is(ModItems.VESPERITE_HOE);

        if (isVesperiteMiningTool) {
            // Check light level at player's position
            int lightLevel = player.level().getMaxLocalRawBrightness(player.blockPosition());

            if (lightLevel < 7) {
                float originalSpeed = cir.getReturnValue();
                // We don't boost 1.0F speeds (like mining obsidian with your hand)
                // We only boost actual fast-mining speeds the tool provides to blocks it can
                // harvest
                if (originalSpeed > 1.0F) {
                    cir.setReturnValue(originalSpeed * 1.2f);
                }
            }
        }
    }

    /**
     * Boosts attack damage by +2 when using a Vesperite Sword or Axe in low light
     * (< 7).
     */
    @ModifyVariable(method = "attack", at = @At(value = "STORE", ordinal = 0), ordinal = 0)
    private float vesperWilds$applyTwilightResonanceAttack(float baseDamage) {
        Player player = (Player) (Object) this;

        boolean isVesperiteWeapon = player.getMainHandItem().is(ModItems.VESPERITE_SWORD) ||
                player.getMainHandItem().is(ModItems.VESPERITE_AXE);

        if (isVesperiteWeapon) {
            int lightLevel = player.level().getMaxLocalRawBrightness(player.blockPosition());

            if (lightLevel < 7) {
                return baseDamage + 2.0F;
            }
        }
        return baseDamage;
    }
}
