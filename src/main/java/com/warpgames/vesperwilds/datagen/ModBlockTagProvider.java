package com.warpgames.vesperwilds.datagen;

import com.jcraft.jorbis.Block;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import com.warpgames.vesperwilds.ModBlocks; // Ensure this imports your ModBlocks class
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
// 1. Use 'getOrCreateTagBuilder' (Standard Fabric way)
        // do NOT use 'getOrCreateRawBuilder' (That was your second error)

        // Connects your fences to other fences
        valueLookupBuilder(BlockTags.FENCES)
                .add(ModBlocks.VELVET_FENCE);

        // Makes them burnable and mineable with axes
        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.VELVET_FENCE);

        // Connects gates to walls
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.VELVET_FENCE_GATE);

        //adds blocks to the wooden doors & doors tags
        valueLookupBuilder(BlockTags.DOORS)
                .add(ModBlocks.VELVET_DOOR);
        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.VELVET_DOOR);

        //adds blocks to the wooden trapdoors & trapdoors tags
        valueLookupBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.VELVET_TRAPDOOR);
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.VELVET_TRAPDOOR);

        //adds blocks to the planks tag
        valueLookupBuilder(BlockTags.PLANKS)
                .add(ModBlocks.VELVET_PLANKS);

        //adds blocks to the wooden buttons tag
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.VELVET_BUTTON);

        //adds blocks to the wooden pressure plate tag
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.VELVET_PRESSURE_PLATE);

        //adds blocks to the wooden stairs tag
        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.VELVET_STAIRS);

        //adds blocks to the wooden slab tag
        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.VELVET_SLAB);

        // 1. Allow Pickaxes to mine it (Fixes the "No Drop" and speed issue)
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VESPERITE_ORE)
                .add(ModBlocks.DEEPSLATE_VESPERITE_ORE);
                //.add(ModBlocks.RAW_VESPERITE_BLOCK); // If you have a storage block

        // 2. Set the Tier (Requires Iron Tool or better)
        // Without this, a wooden pickaxe might break it but drop nothing.
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.VESPERITE_ORE)
                .add(ModBlocks.DEEPSLATE_VESPERITE_ORE);
                //.add(ModBlocks.RAW_VESPERITE_BLOCK);
        // 1. Mineable with Pickaxe
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VESPER_STONE)
                .add(ModBlocks.VESPER_STONE_BRICKS)
                .add(ModBlocks.VESPER_STONE_BRICK_STAIRS)
                .add(ModBlocks.VESPER_STONE_BRICK_SLAB)
                .add(ModBlocks.VESPER_STONE_BRICK_WALL)
                .add(ModBlocks.VESPERITE_ORE)           // (Add these if you haven't already)
                .add(ModBlocks.DEEPSLATE_VESPERITE_ORE);

// 2. Tool Tier (Stone Tool or better mimics Deepslate)
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.VESPER_STONE)
                .add(ModBlocks.VESPER_STONE_BRICKS)
                .add(ModBlocks.VESPER_STONE_BRICK_STAIRS)
                .add(ModBlocks.VESPER_STONE_BRICK_SLAB)
                .add(ModBlocks.VESPER_STONE_BRICK_WALL)
                .add(ModBlocks.VESPERITE_ORE)
                .add(ModBlocks.DEEPSLATE_VESPERITE_ORE);
        // 3. Walls
        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.VESPER_STONE_BRICK_WALL);

// 4. Stairs
        valueLookupBuilder(BlockTags.STAIRS)
                .add(ModBlocks.VESPER_STONE_BRICK_STAIRS);

// 5. Slabs
        valueLookupBuilder(BlockTags.SLABS)
                .add(ModBlocks.VESPER_STONE_BRICK_SLAB);

        valueLookupBuilder(BlockTags.BASE_STONE_OVERWORLD)
                .add(ModBlocks.VESPER_STONE);

    }
}