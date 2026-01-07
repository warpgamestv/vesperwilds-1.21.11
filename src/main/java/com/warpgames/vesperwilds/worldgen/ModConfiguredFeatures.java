package com.warpgames.vesperwilds.worldgen;

import com.warpgames.vesperwilds.GlintBerryBushBlock;
import com.warpgames.vesperwilds.ModBlocks;
import com.warpgames.vesperwilds.VesperWilds;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;

public class ModConfiguredFeatures {
    // This Key is what we will give to the Sapling later!
    public static final ResourceKey<ConfiguredFeature<?, ?>> VELVET_TREE_KEY = registerKey("velvet_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_VESPER_TREE_KEY = registerKey("mega_vesper_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLINT_BERRY_PATCH_KEY = registerKey("glint_berry_patch");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // Defines the "Velvet Tree"
        register(context, VELVET_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        // 1. TRUNK: Much Taller & "Fancy"
                        // Base 6 + Random 6 = Trees are 6-12 blocks tall.
                        // This creates enough room to walk underneath.
                        BlockStateProvider.simple(ModBlocks.VELVET_LOG),
                        new FancyTrunkPlacer(10, 6, 0),

                        // 2. FOLIAGE: Cherry Style (Draping & Fluffy)
                        // This removes the "Ball" look and makes it look like a magical canopy.
                        BlockStateProvider.simple(ModBlocks.VELVET_LEAVES),
                        new CherryFoliagePlacer(
                                ConstantInt.of(4), // Radius (4 blocks wide! Very grand)
                                ConstantInt.of(0), // Offset
                                ConstantInt.of(5), // Height (Tall canopy)
                                0.25f,             // Hanging leaf chance (draping effect)
                                0.5f,              // Corner hole chance (makes it look organic/messy)
                                0.166f,            // Hanging leaf extension chance
                                0.33f              // Hanging leaf extension count
                        ),

                        // 3. FEATURE SIZE: (Required for calculation)
                        new TwoLayersFeatureSize(1, 0, 2)
                ).build());

        // 2. REGISTER THE NEW "MEGA" TREE
        register(context, MEGA_VESPER_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                // TRUNK: Giant 2x2 Trunk (Like a Jungle Tree)
                // Base 10 + Random 14 = Massive trees (24 blocks tall max)
                BlockStateProvider.simple(ModBlocks.VELVET_LOG),
                new MegaJungleTrunkPlacer(10, 2, 14),

                // FOLIAGE: Giant Cherry Canopy
                // We reuse the Cherry style but make it wider (radius 5) and taller (height 7)
                BlockStateProvider.simple(ModBlocks.VELVET_LEAVES),
                new CherryFoliagePlacer(
                        ConstantInt.of(5), // Radius (Huge canopy)
                        ConstantInt.of(0), // Offset
                        ConstantInt.of(7), // Height
                        0.3f, 0.5f, 0.322f, 0.33f // Same hanging leaves settings
                ),

                // FEATURE SIZE: (Required for 2x2 trees)
                new TwoLayersFeatureSize(1, 1, 2)
        ).build());

        // Register the Patch
        register(context, GLINT_BERRY_PATCH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                BlockStateProvider.simple(
                                        ModBlocks.GLINT_BERRY_BUSH.defaultBlockState().setValue(GlintBerryBushBlock.AGE, 3) // Spawn fully grown
                                )
                        )
                )
        );

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}