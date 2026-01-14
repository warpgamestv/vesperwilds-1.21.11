package com.warpgames.vesperwilds.datagen;

import com.warpgames.vesperwilds.ModBlocks;
import com.warpgames.vesperwilds.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VELVET_PLANKS, 4)
                        .requires(ModBlocks.VELVET_LOG)
                        .unlockedBy(getHasName(ModBlocks.VELVET_LOG), has(ModBlocks.VELVET_LOG)) // This line is REQUIRED
                        .save(output);
                // --- NEW RECIPES ---

                // Stairs
                stairBuilder(ModBlocks.VELVET_STAIRS, Ingredient.of(ModBlocks.VELVET_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.VELVET_PLANKS), has(ModBlocks.VELVET_PLANKS))
                        .save(output);

                // Slabs
                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VELVET_SLAB, Ingredient.of(ModBlocks.VELVET_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.VELVET_PLANKS), has(ModBlocks.VELVET_PLANKS))
                        .save(output);

                // Fence
                fenceBuilder(ModBlocks.VELVET_FENCE, Ingredient.of(ModBlocks.VELVET_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.VELVET_PLANKS), has(ModBlocks.VELVET_PLANKS))
                        .save(output);

                // Fence Gate
                fenceGateBuilder(ModBlocks.VELVET_FENCE_GATE, Ingredient.of(ModBlocks.VELVET_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.VELVET_PLANKS), has(ModBlocks.VELVET_PLANKS))
                        .save(output);

                // Door
                doorBuilder(ModBlocks.VELVET_DOOR, Ingredient.of(ModBlocks.VELVET_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.VELVET_PLANKS), has(ModBlocks.VELVET_PLANKS))
                        .save(output);

                // Trapdoor
                trapdoorBuilder(ModBlocks.VELVET_TRAPDOOR, Ingredient.of(ModBlocks.VELVET_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.VELVET_PLANKS), has(ModBlocks.VELVET_PLANKS))
                        .save(output);

                // Button
                buttonBuilder(ModBlocks.VELVET_BUTTON, Ingredient.of(ModBlocks.VELVET_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.VELVET_PLANKS), has(ModBlocks.VELVET_PLANKS))
                        .save(output);

                // Pressure Plate
                pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.VELVET_PRESSURE_PLATE, Ingredient.of(ModBlocks.VELVET_PLANKS))
                        .unlockedBy(getHasName(ModBlocks.VELVET_PLANKS), has(ModBlocks.VELVET_PLANKS))
                        .save(output);

                // 1. Vesper Stone -> Vesper Stone Bricks (4 Stone = 4 Bricks)
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VESPER_STONE_BRICKS, ModBlocks.VESPER_STONE);

                // 2. Vesper Stone Bricks -> Stairs, Slabs, Walls
                stairBuilder(ModBlocks.VESPER_STONE_BRICK_STAIRS, Ingredient.of(ModBlocks.VESPER_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.VESPER_STONE_BRICKS), has(ModBlocks.VESPER_STONE_BRICKS))
                        .save(exporter);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VESPER_STONE_BRICK_SLAB, Ingredient.of(ModBlocks.VESPER_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.VESPER_STONE_BRICKS), has(ModBlocks.VESPER_STONE_BRICKS))
                        .save(exporter);

                wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VESPER_STONE_BRICK_WALL, Ingredient.of(ModBlocks.VESPER_STONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.VESPER_STONE_BRICKS), has(ModBlocks.VESPER_STONE_BRICKS))
                        .save(exporter);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VESPER_STONE_BRICKS, ModBlocks.VESPER_STONE, 1);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VESPER_STONE_BRICK_STAIRS, ModBlocks.VESPER_STONE_BRICKS, 1);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VESPER_STONE_BRICK_SLAB, ModBlocks.VESPER_STONE_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VESPER_STONE_BRICK_WALL, ModBlocks.VESPER_STONE_BRICKS, 1);

                shaped(RecipeCategory.TOOLS, ModItems.VESPERITE_PICKAXE)
                        .pattern("VVV")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.VESPERITE_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VESPERITE_INGOT), has(ModItems.VESPERITE_INGOT))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, ModItems.VESPERITE_SWORD)
                        .pattern(" V ")
                        .pattern(" V ")
                        .pattern(" S ")
                        .define('V', ModItems.VESPERITE_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VESPERITE_INGOT), has(ModItems.VESPERITE_INGOT))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, ModItems.VESPERITE_AXE)
                        .pattern("VV ")
                        .pattern("VS ")
                        .pattern(" S ")
                        .define('V', ModItems.VESPERITE_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VESPERITE_INGOT), has(ModItems.VESPERITE_INGOT))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, ModItems.VESPERITE_SHOVEL)
                        .pattern(" V ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.VESPERITE_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VESPERITE_INGOT), has(ModItems.VESPERITE_INGOT))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, ModItems.VESPERITE_HOE)
                        .pattern("VV ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('V', ModItems.VESPERITE_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.VESPERITE_INGOT), has(ModItems.VESPERITE_INGOT))
                        .save(exporter);

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.VESPERITE_INGOT, RecipeCategory.MISC, ModItems.VESPERITE_NUGGET);

                //furnace, blast furnace, and smoker recipes
                List<ItemLike> VESPERITE_SMELTABLES = List.of(ModItems.RAW_VESPERITE, ModBlocks.VESPERITE_ORE, ModBlocks.DEEPSLATE_VESPERITE_ORE);

// 1. BLAST FURNACE (Blasting)
                for (ItemLike item : VESPERITE_SMELTABLES) {
                    SimpleCookingRecipeBuilder.blasting(
                                    Ingredient.of(item),             // Input
                                    RecipeCategory.MISC,             // Category
                                    ModItems.VESPERITE_INGOT,        // Output
                                    0.7f,                            // XP (float)
                                    100                              // Time (int) - 100 ticks = 5 seconds
                            )
                            .group("vesperite") // Optional grouping
                            .unlockedBy(getHasName(item), has(item)) // The unlock criterion
                            .save(exporter, getConversionRecipeName(ModItems.VESPERITE_INGOT, item) + "_from_blasting");
                }

// 2. REGULAR FURNACE (Smelting)
                for (ItemLike item : VESPERITE_SMELTABLES) {
                    SimpleCookingRecipeBuilder.smelting(
                                    Ingredient.of(item),
                                    RecipeCategory.MISC,
                                    ModItems.VESPERITE_INGOT,
                                    0.7f,
                                    200 // 200 ticks = 10 seconds
                            )
                            .group("vesperite")
                            .unlockedBy(getHasName(item), has(item))
                            .save(exporter, getConversionRecipeName(ModItems.VESPERITE_INGOT, item) + "_from_smelting");
                }
            }
        };
    }

    @Override
    public String getName() {
        return "VesperRecipeProvider";
    }
}