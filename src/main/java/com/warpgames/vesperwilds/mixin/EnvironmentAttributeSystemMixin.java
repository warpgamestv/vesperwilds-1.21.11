package com.warpgames.vesperwilds.mixin;

import com.warpgames.vesperwilds.event.VelvetEclipseManager;
import com.warpgames.vesperwilds.event.VelvetEclipseClientManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.attribute.EnvironmentAttributeSystem;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnvironmentAttributeSystem.class)
public class EnvironmentAttributeSystemMixin {

    @Inject(method = "addDefaultLayers", at = @At("RETURN"))
    private static void vesperWilds$applyEclipseAttributes(EnvironmentAttributeSystem.Builder builder, Level level,
            CallbackInfo ci) {
        // We override the sky color
        builder.addTimeBasedLayer(EnvironmentAttributes.SKY_COLOR, (originalColor, time) -> {
            boolean isActive = false;
            if (level.isClientSide()) {
                isActive = VelvetEclipseClientManager.isEclipseActive();
            } else {
                isActive = VelvetEclipseManager.isEclipseActive();
            }

            if (isActive) {
                // Return a deep purple (A, R, G, B)
                return net.minecraft.util.ARGB.color(255, 51, 13, 77);
            }
            return originalColor;
        });

        // We override the sky light level to darken the sky (0.0 to 15.0 range, where
        // 15 is bright)
        builder.addTimeBasedLayer(EnvironmentAttributes.SKY_LIGHT_LEVEL, (originalLevel, time) -> {
            boolean isActive = false;
            if (level.isClientSide()) {
                isActive = VelvetEclipseClientManager.isEclipseActive();
            } else {
                isActive = VelvetEclipseManager.isEclipseActive();
            }

            if (isActive) {
                return 4.0F; // Dark as a thunderstorm or night
            }
            return originalLevel;
        });
    }
}
