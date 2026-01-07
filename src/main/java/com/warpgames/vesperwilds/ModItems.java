package com.warpgames.vesperwilds;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ModItems {

    // Helper Method
    private static Item registerItem(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, name),
                item
        );
    }

    // Items
    public static final ResourceKey<Item> RAW_VESPERITE_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "raw_vesperite")
    );
    public static final Item RAW_VESPERITE = registerItem("raw_vesperite",
            new Item(new Item.Properties().setId(RAW_VESPERITE_KEY))
    );

    public static final ResourceKey<Item> GLINT_BERRIES_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "glint_berries")
    );
    public static final Item GLINT_BERRIES = registerItem("glint_berries",
            new Item(new Item.Properties()
                    .setId(GLINT_BERRIES_KEY)
                    .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build()))
    );

    public static final ResourceKey<Item> VELVET_LOG_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_log")
    );
    public static final Item VELVET_LOG = registerItem("velvet_log",
            new BlockItem(ModBlocks.VELVET_LOG, new Item.Properties().setId(VELVET_LOG_KEY))
    );

    public static void registerModItems() {
        VesperWilds.LOGGER.info("Registering Mod Items for " + VesperWilds.MOD_ID);
    }
}