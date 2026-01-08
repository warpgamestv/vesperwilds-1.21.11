package com.warpgames.vesperwilds.datagen;

import com.warpgames.vesperwilds.ModBlocks;
import com.warpgames.vesperwilds.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;


public class VesperRecipeProvider extends FabricRecipeProvider {
    public VesperRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
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
            }
        };
    }

    @Override
    public String getName() {
        return "VesperRecipeProvider";
    }
}