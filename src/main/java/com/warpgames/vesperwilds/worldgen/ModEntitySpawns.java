package com.warpgames.vesperwilds.worldgen;

import com.warpgames.vesperwilds.ModBiomes;
import com.warpgames.vesperwilds.ModEntities;
import com.warpgames.vesperwilds.entity.custom.VelvetMothEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.SpawnPlacementTypes; // Note: In 1.21+ this might be SpawnPlacementTypes
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.Biomes;

public class ModEntitySpawns {
    public static void addSpawns() {
        // 1. REGISTER THE BIOME SPAWNS
        // This adds the moth to all "Forest" type biomes.
        // You can also use .includeByKey(ModBiomes.YOUR_BIOME) to add it to your
        // specific biome.
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(ModBiomes.VESPER_GROVE),
                MobCategory.AMBIENT,
                ModEntities.VELVET_MOTH,
                50, // Weight: Higher = more common (Rabbit is 4, Sheep is 12, this is HIGH for
                    // testing)
                1, // Min Group Size
                3 // Max Group Size
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(ModBiomes.VESPER_GROVE),
                MobCategory.MONSTER,
                ModEntities.GLOOM_STALKER,
                20, // Weight for the stalker
                1, // Min Group Size
                2 // Max Group Size
        );

        // 2. REGISTER THE PLACEMENT RULES
        // This tells the game it can spawn on leaves or grass, as long as it's above
        // ground.
        SpawnPlacements.register(
                ModEntities.VELVET_MOTH,
                SpawnPlacementTypes.ON_GROUND, // Moths spawn on blocks, then fly
                Heightmap.Types.MOTION_BLOCKING,
                VelvetMothEntity::checkMobSpawnRules);

        // Gloom Stalker spawns under monster rules (night time, dark areas)
        SpawnPlacements.register(
                ModEntities.GLOOM_STALKER,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);
    }
}