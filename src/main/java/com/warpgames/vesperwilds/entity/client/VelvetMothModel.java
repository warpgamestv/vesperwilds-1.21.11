package com.warpgames.vesperwilds.entity.client;

import com.warpgames.vesperwilds.VesperWilds;
import com.warpgames.vesperwilds.entity.custom.VelvetMothEntity;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

// Extend 'DefaultedEntityGeoModel' instead of just 'GeoModel'
public class VelvetMothModel extends DefaultedEntityGeoModel<VelvetMothEntity> {

    public VelvetMothModel() {
        // This single line tells GeckoLib to look for:
        // Model:     assets/vesper_wilds/geckolib/models/velvet_moth.geo.json
        // Animation: assets/vesper_wilds/geckolib/animations/velvet_moth.animation.json
        // Texture:   assets/vesper_wilds/textures/entity/velvet_moth.png
        super(Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_moth"));
    }
}