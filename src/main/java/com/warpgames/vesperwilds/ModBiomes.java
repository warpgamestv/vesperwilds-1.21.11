package com.warpgames.vesperwilds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    // This registers the key "vesper_wilds:vesper_grove"
    public static final ResourceKey<Biome> VESPER_GROVE = ResourceKey.create(
            Registries.BIOME,
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesper_grove")
    );

    public static void registerBiomes() {
        VesperWilds.LOGGER.info("Registering Biomes for " + VesperWilds.MOD_ID);
    }
}