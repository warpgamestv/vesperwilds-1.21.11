package com.warpgames.vesperwilds.datagen;

import com.warpgames.vesperwilds.ModBlocks;
import com.warpgames.vesperwilds.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        // 1. Logs
        // Uses 'woodProvider' (Mojang) instead of 'registerLog' (Yarn)
        blockStateModelGenerator.woodProvider(ModBlocks.VELVET_LOG).logWithHorizontal(ModBlocks.VELVET_LOG);

        // 2. The "Texture Pool" for the Family
        // We use 'var' here so you don't have to worry about the complex class name.
        // Uses 'family' (Mojang) instead of 'registerCubeAllModelTexturePool' (Yarn)
        var velvetPool = blockStateModelGenerator.family(ModBlocks.VELVET_PLANKS);

        // 3. Generate the variants from the pool
        velvetPool.stairs(ModBlocks.VELVET_STAIRS);
        velvetPool.slab(ModBlocks.VELVET_SLAB);
        velvetPool.fence(ModBlocks.VELVET_FENCE);
        velvetPool.fenceGate(ModBlocks.VELVET_FENCE_GATE);
        velvetPool.button(ModBlocks.VELVET_BUTTON);
        velvetPool.pressurePlate(ModBlocks.VELVET_PRESSURE_PLATE);

        // 4. Door and Trapdoor
        // Uses 'createDoor' (Mojang) instead of 'registerDoor' (Yarn)
        blockStateModelGenerator.createDoor(ModBlocks.VELVET_DOOR);
        blockStateModelGenerator.createTrapdoor(ModBlocks.VELVET_TRAPDOOR);

        //Cross Blocks, such as saplings, sprouts, other plants...

        //stone and stone variants
        // 1. Simple Cube for the base stone
        blockStateModelGenerator.createTrivialCube(ModBlocks.VESPER_STONE);

        // 2. Texture Pool for the Bricks (Auto-generates stairs/slabs/walls!)
        BlockModelGenerators.BlockFamilyProvider brickFamily = blockStateModelGenerator.family(ModBlocks.VESPER_STONE_BRICKS);
        brickFamily.stairs(ModBlocks.VESPER_STONE_BRICK_STAIRS);
        brickFamily.slab(ModBlocks.VESPER_STONE_BRICK_SLAB);
        brickFamily.wall(ModBlocks.VESPER_STONE_BRICK_WALL);
        blockStateModelGenerator.createLantern(ModBlocks.VESPERITE_LANTERN);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.RAW_VESPERITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GLINT_BERRIES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VESPERITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VESPERITE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VESPERITE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VESPERITE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VESPERITE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VESPERITE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}