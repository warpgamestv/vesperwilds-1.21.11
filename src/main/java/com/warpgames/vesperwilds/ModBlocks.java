package com.warpgames.vesperwilds;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import com.warpgames.vesperwilds.worldgen.ModConfiguredFeatures;
import java.util.Optional; // Important Import!

public class ModBlocks {

    // --- VELVET LOG ---
    public static final ResourceKey<Block> VELVET_LOG_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_log")
    );
    public static final Block VELVET_LOG = registerBlock("velvet_log",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(VELVET_LOG_KEY))
    );

    // --- VELVET PLANKS ---
    public static final ResourceKey<Block> VELVET_PLANKS_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_planks")
    );
    public static final Block VELVET_PLANKS = registerBlock("velvet_planks",
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(VELVET_PLANKS_KEY))
    );

    // --- VELVET LEAVES ---
    public static final ResourceKey<Block> VELVET_LEAVES_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_leaves")
    );
    public static final Block VELVET_LEAVES = registerBlock("velvet_leaves",
            // Make sure you have the VelvetLeavesBlock.java file created from the previous step!
            new VelvetLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
                    .setId(VELVET_LEAVES_KEY)
                    .noOcclusion())
    );

    // --- VELVET SAPLING ---
    public static final ResourceKey<Block> VELVET_SAPLING_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_sapling")
    );

    // FIX: Define the TreeGrower right here!
    // We use Optional.empty() for now because we haven't created the actual Tree Feature yet.
    public static final TreeGrower VELVET_TREE_GROWER = new TreeGrower(
            "velvet_tree",
            Optional.of(ModConfiguredFeatures.MEGA_VESPER_TREE_KEY),// Mega Tree (Jungle-style)
            Optional.of(ModConfiguredFeatures.VELVET_TREE_KEY), // Regular Tree
            Optional.empty()  // Flowers (Bees)
    );

    public static final Block VELVET_SAPLING = registerBlock("velvet_sapling",
            new SaplingBlock(
                    VELVET_TREE_GROWER, // Pass the grower we defined above
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)
                            .setId(VELVET_SAPLING_KEY)
                            .noOcclusion()
                            .noCollision()
            )
    );

    // --- GLINT BERRY BUSH ---
    public static final ResourceKey<Block> GLINT_BERRY_BUSH_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "glint_berry_bush")
    );
    public static final Block GLINT_BERRY_BUSH = registerBlock("glint_berry_bush",
            new GlintBerryBushBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)
                            .setId(GLINT_BERRY_BUSH_KEY)
                            .lightLevel(state -> state.getValue(GlintBerryBushBlock.AGE) == 3 ? 5 : 0) // Glow logic
                            .noOcclusion()
                            .noCollision()
            )
    );

    // --- HELPER METHOD ---
    private static Block registerBlock(String name, Block block) {
        return Registry.register(
                BuiltInRegistries.BLOCK,
                Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, name),
                block
        );
    }

    public static void registerModBlocks() {
        VesperWilds.LOGGER.info("Registering Mod Blocks for " + VesperWilds.MOD_ID);
    }
}