package com.warpgames.vesperwilds.worldgen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import com.warpgames.vesperwilds.ModBiomes;
import terrablender.api.Region;
import terrablender.api.RegionType;
import java.util.function.Consumer;

public class VesperRegion extends Region {
    public VesperRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        // ⚠️ DEBUG MODE: This line forces your biome to replace PLAINS.
        // If you find Plains, you find your biome.
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> builder.replaceBiome(Biomes.PLAINS, ModBiomes.VESPER_FIELDS));
    }
}