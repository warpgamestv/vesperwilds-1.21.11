package com.warpgames.vesperwilds.mixin;

import com.warpgames.vesperwilds.event.VelvetEclipseManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CropBlock.class)
public class CropBlockMixin {

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    private void vesperWilds$haltEclipseCropGrowth(BlockState state, ServerLevel level, BlockPos pos,
            RandomSource random, CallbackInfo ci) {
        if (VelvetEclipseManager.isEclipseActive() && level.canSeeSkyFromBelowWater(pos)) { // canSeeSky typically means
                                                                                            // exposed to the sky
            ci.cancel();
        }
    }
}
