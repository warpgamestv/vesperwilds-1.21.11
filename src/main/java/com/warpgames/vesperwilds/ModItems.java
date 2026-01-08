package com.warpgames.vesperwilds;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ModItems {

    // --- ITEMS ---
    public static final ResourceKey<Item> RAW_VESPERITE_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "raw_vesperite")
    );
    public static final Item RAW_VESPERITE = registerItem("raw_vesperite",
            new Item(new Item.Properties().setId(RAW_VESPERITE_KEY))
    );

    // --- BLOCK ITEMS ---
    public static final ResourceKey<Item> VELVET_LOG_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_log")
    );
    public static final Item VELVET_LOG = registerItem("velvet_log",
            new BlockItem(ModBlocks.VELVET_LOG, new Item.Properties().setId(VELVET_LOG_KEY))
    );

    public static final ResourceKey<Item> VELVET_PLANKS_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_planks")
    );
    public static final Item VELVET_PLANKS = registerItem("velvet_planks",
            new BlockItem(ModBlocks.VELVET_PLANKS, new Item.Properties().setId(VELVET_PLANKS_KEY))
    );

// --- VELVET WOOD ITEMS ---

    // 1. Stairs
    public static final ResourceKey<Item> VELVET_STAIRS_ITEM_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_stairs"));
    public static final Item VELVET_STAIRS_ITEM = registerItem("velvet_stairs",
            new BlockItem(ModBlocks.VELVET_STAIRS, new Item.Properties().setId(VELVET_STAIRS_ITEM_KEY)));

    // 2. Slab
    public static final ResourceKey<Item> VELVET_SLAB_ITEM_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_slab"));
    public static final Item VELVET_SLAB_ITEM = registerItem("velvet_slab",
            new BlockItem(ModBlocks.VELVET_SLAB, new Item.Properties().setId(VELVET_SLAB_ITEM_KEY)));

    // 3. Fence
    public static final ResourceKey<Item> VELVET_FENCE_ITEM_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_fence"));
    public static final Item VELVET_FENCE_ITEM = registerItem("velvet_fence",
            new BlockItem(ModBlocks.VELVET_FENCE, new Item.Properties().setId(VELVET_FENCE_ITEM_KEY)));

    // 4. Fence Gate
    public static final ResourceKey<Item> VELVET_FENCE_GATE_ITEM_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_fence_gate"));
    public static final Item VELVET_FENCE_GATE_ITEM = registerItem("velvet_fence_gate",
            new BlockItem(ModBlocks.VELVET_FENCE_GATE, new Item.Properties().setId(VELVET_FENCE_GATE_ITEM_KEY)));

    // 5. Door
    public static final ResourceKey<Item> VELVET_DOOR_ITEM_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_door"));
    public static final Item VELVET_DOOR_ITEM = registerItem("velvet_door",
            new BlockItem(ModBlocks.VELVET_DOOR, new Item.Properties().setId(VELVET_DOOR_ITEM_KEY)));

    // 6. Trapdoor
    public static final ResourceKey<Item> VELVET_TRAPDOOR_ITEM_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_trapdoor"));
    public static final Item VELVET_TRAPDOOR_ITEM = registerItem("velvet_trapdoor",
            new BlockItem(ModBlocks.VELVET_TRAPDOOR, new Item.Properties().setId(VELVET_TRAPDOOR_ITEM_KEY)));

    // 7. Button
    public static final ResourceKey<Item> VELVET_BUTTON_ITEM_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_button"));
    public static final Item VELVET_BUTTON_ITEM = registerItem("velvet_button",
            new BlockItem(ModBlocks.VELVET_BUTTON, new Item.Properties().setId(VELVET_BUTTON_ITEM_KEY)));

    // 8. Pressure Plate
    public static final ResourceKey<Item> VELVET_PRESSURE_PLATE_ITEM_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_pressure_plate"));
    public static final Item VELVET_PRESSURE_PLATE_ITEM = registerItem("velvet_pressure_plate",
            new BlockItem(ModBlocks.VELVET_PRESSURE_PLATE, new Item.Properties().setId(VELVET_PRESSURE_PLATE_ITEM_KEY)));

    public static final ResourceKey<Item> VELVET_LEAVES_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_leaves")
    );
    public static final Item VELVET_LEAVES = registerItem("velvet_leaves",
            new BlockItem(ModBlocks.VELVET_LEAVES, new Item.Properties().setId(VELVET_LEAVES_KEY))
    );

    // --- VELVET SAPLING ITEM ---
    public static final ResourceKey<Item> VELVET_SAPLING_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_sapling")
    );
    public static final Item VELVET_SAPLING = registerItem("velvet_sapling",
            new BlockItem(ModBlocks.VELVET_SAPLING, new Item.Properties().setId(VELVET_SAPLING_KEY))
    );

    // --- GLINT BERRIES (ITEM) ---
    public static final ResourceKey<Item> GLINT_BERRIES_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "glint_berries")
    );
    public static final Item GLINT_BERRIES = registerItem("glint_berries",
            new BlockItem(
                    ModBlocks.GLINT_BERRY_BUSH, // The block it plants
                    new Item.Properties().setId(GLINT_BERRIES_KEY).food(new net.minecraft.world.food.FoodProperties.Builder()
                            .nutrition(2).saturationModifier(0.1f).build()) // Edible!
            )
    );

    // --- VESPERITE ORE ITEMS ---
    public static final ResourceKey<Item> VESPERITE_ORE_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_ore")
    );
    public static final Item VESPERITE_ORE_ITEM = registerItem("vesperite_ore",
            new BlockItem(ModBlocks.VESPERITE_ORE, new Item.Properties().setId(VESPERITE_ORE_KEY))
    );

    public static final ResourceKey<Item> DEEPSLATE_VESPERITE_ORE_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "deepslate_vesperite_ore")
    );
    public static final Item DEEPSLATE_VESPERITE_ORE_ITEM = registerItem("deepslate_vesperite_ore",
            new BlockItem(ModBlocks.DEEPSLATE_VESPERITE_ORE, new Item.Properties().setId(DEEPSLATE_VESPERITE_ORE_KEY))
    );

    // --- HELPER METHOD ---
    private static Item registerItem(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, name),
                item
        );
    }

    public static void registerModItems() {
        VesperWilds.LOGGER.info("Registering Mod Items for " + VesperWilds.MOD_ID);
    }
}