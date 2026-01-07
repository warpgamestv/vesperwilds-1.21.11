package com.warpgames.vesperwilds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    // The "Key" that points to your JSON file
    public static final ResourceKey<Biome> VESPER_FIELDS = ResourceKey.create(
            Registries.BIOME,
            Identifier.fromNamespaceAndPath("vesper_wilds", "vesper_fields")
    );

    public static void registerBiomes() {
        System.out.println("Registering Biomes for vesper_wilds");
    }
}