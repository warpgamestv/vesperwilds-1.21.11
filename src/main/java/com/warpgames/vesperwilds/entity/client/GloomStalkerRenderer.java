package com.warpgames.vesperwilds.entity.client;

import com.warpgames.vesperwilds.entity.custom.GloomStalkerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class GloomStalkerRenderer<R extends LivingEntityRenderState & GeoRenderState>
        extends GeoEntityRenderer<GloomStalkerEntity, R> {
    public GloomStalkerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GloomStalkerModel());
        this.shadowRadius = 0.5f;
    }
}
