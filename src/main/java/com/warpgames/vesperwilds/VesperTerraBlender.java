package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.worldgen.VesperRegion;
import net.minecraft.resources.Identifier;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class VesperTerraBlender implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        // Registers your region with TerraBlender
        Regions.register(new VesperRegion(
                Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesper_region"),
                10 // Weight (rarity)
        ));
    }
}