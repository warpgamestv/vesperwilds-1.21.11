package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.VesperWilds;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.animatable.GeoAnimatable;

public class Reflector {
    public static void main(String[] args) {
        DefaultedEntityGeoModel<GeoAnimatable> model = new DefaultedEntityGeoModel<>(
                Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "gloom_stalker"));
        System.out.println("Model Resource: " + model.getModelResource(null));
        System.out.println("Texture Resource: " + model.getTextureResource(null));
        System.out.println("Animation Resource: " + model.getAnimationResource(null));
    }
}
