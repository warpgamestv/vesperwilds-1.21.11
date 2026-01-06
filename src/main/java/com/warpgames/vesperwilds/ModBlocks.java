package com.warpgames.vesperwilds;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {

    // 1. Define the Key
    public static final ResourceKey<Block> VELVET_LOG_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath("vesper_wilds", "velvet_log")
    );

    // 2. Define the Block
    // We use "RotatedPillarBlock" so it can face sideways like a real log
    public static final Block VELVET_LOG = registerBlock(
            new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(VELVET_LOG_KEY))
    );

    // 3. Helper Method
    private static Block registerBlock(Block block) {
        return Registry.register(
                BuiltInRegistries.BLOCK,
                Identifier.fromNamespaceAndPath("vesper_wilds", "velvet_log"),
                block
        );
    }

    public static void registerModBlocks() {
        System.out.println("Registering Mod Blocks for vesper_wilds");
    }
}