package com.warpgames.vesperwilds.worldgen;

import com.warpgames.vesperwilds.ModBlocks;
import com.warpgames.vesperwilds.VesperWilds;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.VegetationPatchFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> VELVET_TREE_PLACED_KEY = registerKey("velvet_tree");
    public static final ResourceKey<PlacedFeature> MEGA_VESPER_TREE_PLACED_KEY = registerKey("mega_vesper_tree");
    public static final ResourceKey<PlacedFeature> GLINT_BERRY_PATCH_PLACED_KEY = registerKey("glint_berry_patch");
    // Register Keys
    public static final ResourceKey<PlacedFeature> VELVET_FERN_PLACED_KEY = registerKey("velvet_fern_placed");
    public static final ResourceKey<PlacedFeature> VESPER_SPROUTS_PLACED_KEY = registerKey("vesper_sprouts_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        // 1. Get the Configured Feature (The Shape) we made earlier
        var configuredFeatureRegistry = context.lookup(Registries.CONFIGURED_FEATURE);
        var velvetTreeConfig = configuredFeatureRegistry.getOrThrow(ModConfiguredFeatures.VELVET_TREE_KEY);

        // 2. Register the Placed Feature (The Rules)
        // "treePlacement" uses standard rules: On Dirt/Grass, not in water, 10% chance per chunk, etc.
        register(context, VELVET_TREE_PLACED_KEY, velvetTreeConfig,
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(12, 0.1f, 1), ModBlocks.VELVET_SAPLING));
    var megaTreeConfig = configuredFeatureRegistry.getOrThrow(ModConfiguredFeatures.MEGA_VESPER_TREE_KEY);

    // 3. REGISTER THE MEGA PLACEMENT
    // We use the same rules (Extra count), but usually Mega trees are rarer.
    // We will handle the rarity in the Biome file, so just use standard placement here.
    register(context, MEGA_VESPER_TREE_PLACED_KEY, megaTreeConfig,
             VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1f, 1), ModBlocks.VELVET_SAPLING));

        var glintPatchConfig = configuredFeatureRegistry.getOrThrow(ModConfiguredFeatures.GLINT_BERRY_PATCH_KEY);

        // RarityFilter.onAverageOnceEvery(32) means it's somewhat rare (like pumpkin patches)
        register(context, GLINT_BERRY_PATCH_PLACED_KEY, glintPatchConfig,
                List.of(
                        RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));


// 1. VELVET FERN PLACEMENT
        // "Place 4 patches per chunk"
        register(context, VELVET_FERN_PLACED_KEY,
                configuredFeatureRegistry.getOrThrow(ModConfiguredFeatures.VELVET_FERN_KEY),
                List.of(
                        CountPlacement.of(4), // How many clumps per chunk?
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, // Places on top of the highest block
                        BiomeFilter.biome()
                ));

        // 2. VESPER SPROUTS PLACEMENT
        // "Place 15 patches per chunk" (Dense like grass)
        register(context, VESPER_SPROUTS_PLACED_KEY,
                configuredFeatureRegistry.getOrThrow(ModConfiguredFeatures.VESPER_SPROUTS_KEY),
                List.of(
                        CountPlacement.of(15),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                )); // 15 patches per chunk

    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, modifiers));
    }

}