package com.warpgames.vesperwilds.item.client;

import com.warpgames.vesperwilds.VesperWilds;
import com.warpgames.vesperwilds.item.custom.VelvetCloakItem;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class VelvetCloakModel extends GeoModel<VelvetCloakItem> {

    @Override
    public Identifier getModelResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID,
                "armor/velvet_cloak");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState state) {
        return Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID,
                "textures/armor/velvet_cloak.png");
    }

    @Override
    public Identifier getAnimationResource(VelvetCloakItem animatable) {
        return Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID,
                "armor/velvet_cloak");
    }
}
