package com.warpgames.vesperwilds.entity.client;

import com.warpgames.vesperwilds.entity.custom.VelvetMothEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class VelvetMothRenderer <R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<VelvetMothEntity, R> {
    public VelvetMothRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new VelvetMothModel());
        this.shadowRadius = 0.4f; // Optional: Adjusts the size of the shadow under the mob
    }
}