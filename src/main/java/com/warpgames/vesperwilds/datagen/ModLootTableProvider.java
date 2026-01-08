package com.warpgames.vesperwilds.datagen;

import com.warpgames.vesperwilds.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup; // standard for 1.21 MojMap
import com.warpgames.vesperwilds.ModBlocks; // Ensure this points to your blocks
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // --- Basic Blocks (Drop Themselves) ---
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