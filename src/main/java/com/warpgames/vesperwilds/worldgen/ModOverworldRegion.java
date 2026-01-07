package com.warpgames.vesperwilds.worldgen;

import com.mojang.datafixers.util.Pair;
import com.warpgames.vesperwilds.ModBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            // FIX IS HERE:
            // 1. Method is "replaceBiome"
            // 2. NO "true" or "false" at the start
            builder.replaceBiome(
                    Biomes.FOREST,
                    ModBiomes.VESPER_GROVE
            );
        });
    }
}