package com.warpgames.vesperwilds.datagen;

import com.warpgames.vesperwilds.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup; // standard for 1.21 MojMap
import com.warpgames.vesperwilds.ModBlocks; // Ensure this points to your blocks
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // --- Basic Blocks (Drop Themselves) ---
        dropSelf(ModBlocks.VESPERITE_LANTERN);
        dropSelf(ModBlocks.VELVET_LOG);
        //dropSelf(ModBlocks.VELVET_WOOD);
        //dropSelf(ModBlocks.STRIPPED_VELVET_LOG);
        //dropSelf(ModBlocks.STRIPPED_VELVET_WOOD);
        dropSelf(ModBlocks.VELVET_PLANKS);
        dropSelf(ModBlocks.VELVET_STAIRS);
        dropSelf(ModBlocks.VELVET_FENCE);
        dropSelf(ModBlocks.VELVET_FENCE_GATE);
        dropSelf(ModBlocks.VELVET_TRAPDOOR);
        dropSelf(ModBlocks.VELVET_BUTTON);
        dropSelf(ModBlocks.VELVET_PRESSURE_PLATE);
        dropSelf(ModBlocks.VELVET_SAPLING);
        dropSelf(ModBlocks.EMBER_SHELF_FUNGUS);
        dropSelf(ModBlocks.VESPER_SPROUTS);
        dropSelf(ModBlocks.VESPER_STONE); // Or make it drop Cobble if you want!
        dropSelf(ModBlocks.VESPER_STONE_BRICKS);
        dropSelf(ModBlocks.VESPER_STONE_BRICK_STAIRS);
        dropSelf(ModBlocks.VESPER_STONE_BRICK_WALL);
        add(ModBlocks.VESPER_STONE_BRICK_SLAB, createSlabItemTable(ModBlocks.VESPER_STONE_BRICK_SLAB));

        //Fern dropping. Making sure it only drops one fern and not two or none.
        this.add(ModBlocks.VELVET_FERN, createDoublePlantWithSeedDrops(ModBlocks.VELVET_FERN, Block.byItem(ModItems.VELVET_FERN)));

        // Ores drop correctly
        add(ModBlocks.VESPERITE_ORE, createOreDrop(ModBlocks.VESPERITE_ORE, ModItems.RAW_VESPERITE));
        add(ModBlocks.DEEPSLATE_VESPERITE_ORE, createOreDrop(ModBlocks.DEEPSLATE_VESPERITE_ORE, ModItems.RAW_VESPERITE));

        // --- Special Blocks (Use 'add' + helper methods) ---

        // Doors: Use 'createDoorTable'
        add(ModBlocks.VELVET_DOOR, createDoorTable(ModBlocks.VELVET_DOOR));

        // Slabs: Use 'createSlabItemTable'
        add(ModBlocks.VELVET_SLAB, createSlabItemTable(ModBlocks.VELVET_SLAB));

        // Leaves: Use 'createLeavesDrops'
        // Arguments: (LeavesBlock, SaplingBlock, ChanceArray...)
        // Note: You might need to check the exact arguments for 'createLeavesDrops' in your version,
        // typically it's just (block, sapling, chances).
        add(ModBlocks.VELVET_LEAVES, createLeavesDrops(ModBlocks.VELVET_LEAVES, ModBlocks.VELVET_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
    }
}