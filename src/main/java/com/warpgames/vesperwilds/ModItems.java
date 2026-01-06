package com.warpgames.vesperwilds;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ModItems {

    // 1. Define the Key (The "ID Card")
    // Note: Mojang Mappings use "ResourceLocation" instead of "Identifier"
    public static final ResourceKey<Item> RAW_VESPERITE_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath("vesper_wilds", "raw_vesperite")
    );

    // 2. Define the Item
    public static final Item RAW_VESPERITE = registerItem(
            new Item(new Item.Properties().setId(RAW_VESPERITE_KEY))
    );

    // 3. Helper Method
    private static Item registerItem(Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath("vesper-wilds", "raw_vesperite"),
                item
        );
    }
    // --- NEW: GLINT BERRIES (Food) ---
    public static final ResourceKey<Item> GLINT_BERRIES_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath("vesper_wilds", "glint_berries")
    );
    public static final Item GLINT_BERRIES = registerItem("glint_berries",
            new Item(new Item.Properties()
                    .setId(GLINT_BERRIES_KEY)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build())) // Makes it edible!
    );

    // --- NEW: VELVET LOG (BlockItem) ---
    public static final ResourceKey<Item> VELVET_LOG_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath("vesper_wilds", "velvet_log")
    );
    // We use "BlockItem" to link the Item in hand to the Block on the ground
    public static final Item VELVET_LOG = registerItem("velvet_log",
            new BlockItem(ModBlocks.VELVET_LOG, new Item.Properties().setId(VELVET_LOG_KEY))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath("vesper_wilds", name),
                item
        );
    }
    public static void registerModItems() {
        // Just calling this method triggers the static block above
        System.out.println("Registering Mod Items for vesper-wilds");
    }
}