package com.warpgames.vesperwilds.worldgen;

import com.warpgames.vesperwilds.ModBlocks;
import com.warpgames.vesperwilds.VesperWilds;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> VELVET_TREE_PLACED_KEY = registerKey("velvet_tree");
    public static final ResourceKey<PlacedFeature> MEGA_VESPER_TREE_PLACED_KEY = registerKey("mega_vesper_tree");
    public static final ResourceKey<PlacedFeature> GLINT_BERRY_PATCH_PLACED_KEY = registerKey("glint_berry_patch");

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

    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, modifiers));
    }

}