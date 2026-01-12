package com.warpgames.vesperwilds.datagen;

import com.warpgames.vesperwilds.ModBiomes;
import com.warpgames.vesperwilds.ModBlocks; // Keep this if you have blocks without items (uncommon)
import com.warpgames.vesperwilds.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder builder) {
        // --- Creative Tab ---
        builder.add("itemgroup.vesper_wilds", "Vesper Wilds");

        // --- Items (Standalones) ---
        builder.add(ModItems.RAW_VESPERITE, "Raw Vesperite");
        //builder.add(ModItems.VESPERITE_INGOT, "Vesperite Ingot");
        builder.add(ModItems.GLINT_BERRIES, "Glint Berries");
        builder.add(ModItems.VELVET_FERN, "Velvet Fern");

        // --- Blocks (Referenced as Items) ---
        // We use ModItems here to force the generator to create "item.vesper_wilds.x" keys
        builder.add(ModItems.VESPERITE_ORE_ITEM, "Vesperite Ore");
        builder.add(ModItems.DEEPSLATE_VESPERITE_ORE_ITEM, "Deepslate Vesperite Ore");
        builder.add(ModItems.VELVET_LOG, "Velvet Log");
        //builder.add(ModItems.VELVET_WOOD, "Velvet Wood");
        //builder.add(ModItems.STRIPPED_VELVET_LOG, "Stripped Velvet Log");
        //builder.add(ModItems.STRIPPED_VELVET_WOOD, "Stripped Velvet Wood");
        builder.add(ModItems.VELVET_PLANKS, "Velvet Planks");
        builder.add(ModItems.VELVET_STAIRS_ITEM, "Velvet Stairs");
        builder.add(ModItems.VELVET_SLAB_ITEM, "Velvet Slab");
        builder.add(ModItems.VELVET_FENCE_ITEM, "Velvet Fence");
        builder.add(ModItems.VELVET_FENCE_GATE_ITEM, "Velvet Fence Gate");
        builder.add(ModItems.VELVET_BUTTON_ITEM, "Velvet Button");
        builder.add(ModItems.VELVET_PRESSURE_PLATE_ITEM, "Velvet Pressure Plate");
        builder.add(ModItems.VELVET_DOOR_ITEM, "Velvet Door");
        builder.add(ModItems.VELVET_TRAPDOOR_ITEM, "Velvet Trapdoor");
        builder.add(ModItems.VELVET_LEAVES, "Velvet Leaves");
        builder.add(ModItems.VELVET_SAPLING, "Velvet Sapling");
        builder.add(ModItems.EMBER_SHELF_FUNGUS, "Ember Shelf Fungus");
        builder.add(ModItems.VESPER_SPROUTS, "Vesper Sprouts");
        builder.add(ModItems.VESPER_STONE, "Vesper Stone");
        builder.add(ModItems.VESPER_STONE_BRICKS, "Vesper Stone Bricks");
        builder.add(ModItems.VESPER_STONE_BRICK_STAIRS, "Vesper Stone Brick Stairs");
        builder.add(ModItems.VESPER_STONE_BRICK_SLAB, "Vesper Stone Brick Slab");
        builder.add(ModItems.VESPER_STONE_BRICK_WALL, "Vesper Stone Brick Wall");
        builder.add(ModItems.VESPERITE_INGOT, "Vesperite Ingot");
        builder.add(ModItems.VESPERITE_SWORD, "Vesperite Sword");
        builder.add(ModItems.VESPERITE_PICKAXE, "Vesperite Pickaxe");
        builder.add(ModItems.VESPERITE_AXE, "Vesperite Axe");
        builder.add(ModItems.VESPERITE_SHOVEL, "Vesperite Shovel");
        builder.add(ModItems.VESPERITE_HOE, "Vesperite Hoe");
        //builder.add(ModItems.VESPERITE_NUGGET, "Vesperite Nugget");
        builder.add(ModItems.VESPERITE_LANTERN, "Vesperite Lantern");


        // --- Biomes ---
        builder.add("biome.vesper_wilds.vesper_grove", "Vesper Grove");
    }
}