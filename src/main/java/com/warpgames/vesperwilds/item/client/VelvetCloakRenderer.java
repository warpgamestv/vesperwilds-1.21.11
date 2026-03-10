package com.warpgames.vesperwilds.item.client;

import com.warpgames.vesperwilds.item.custom.VelvetCloakItem;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class VelvetCloakRenderer<R extends HumanoidRenderState & GeoRenderState>
        extends GeoArmorRenderer<VelvetCloakItem, R> {
    public VelvetCloakRenderer() {
        super(new VelvetCloakModel());
    }
}
