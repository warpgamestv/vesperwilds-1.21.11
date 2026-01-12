package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.item.ModToolMaterials;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
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

    // Stone & Bricks
    public static final ResourceKey<Item> VESPER_STONE_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesper_stone"));
    public static final Item VESPER_STONE = registerItem("vesper_stone",
            new BlockItem(ModBlocks.VESPER_STONE, new Item.Properties().setId(VESPER_STONE_KEY)));

    public static final ResourceKey<Item> VESPER_STONE_BRICKS_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesper_stone_bricks"));
    public static final Item VESPER_STONE_BRICKS = registerItem("vesper_stone_bricks",
            new BlockItem(ModBlocks.VESPER_STONE_BRICKS, new Item.Properties().setId(VESPER_STONE_BRICKS_KEY)));

    public static final ResourceKey<Item> VESPER_STONE_BRICK_STAIRS_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesper_stone_brick_stairs"));
    public static final Item VESPER_STONE_BRICK_STAIRS = registerItem("vesper_stone_brick_stairs",
            new BlockItem(ModBlocks.VESPER_STONE_BRICK_STAIRS, new Item.Properties().setId(VESPER_STONE_BRICK_STAIRS_KEY)));

    public static final ResourceKey<Item> VESPER_STONE_BRICK_SLAB_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesper_stone_brick_slab"));
    public static final Item VESPER_STONE_BRICK_SLAB = registerItem("vesper_stone_brick_slab",
            new BlockItem(ModBlocks.VESPER_STONE_BRICK_SLAB, new Item.Properties().setId(VESPER_STONE_BRICK_SLAB_KEY)));

    public static final ResourceKey<Item> VESPER_STONE_BRICK_WALL_KEY = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesper_stone_brick_wall"));
    public static final Item VESPER_STONE_BRICK_WALL = registerItem("vesper_stone_brick_wall",
            new BlockItem(ModBlocks.VESPER_STONE_BRICK_WALL, new Item.Properties().setId(VESPER_STONE_BRICK_WALL_KEY)));

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

    public static final ResourceKey<Item> VESPERITE_INGOT_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_ingot")
    );
    public static final Item VESPERITE_INGOT = registerItem("vesperite_ingot",
            new Item(new Item.Properties().setId(VESPERITE_INGOT_KEY))
    );

public static final ResourceKey<Item> VELVET_FERN_KEY = ResourceKey.create(
        BuiltInRegistries.ITEM.key(),
        Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_fern")
);
    public static final Item VELVET_FERN = registerItem("velvet_fern",
            new BlockItem(ModBlocks.VELVET_FERN, new Item.Properties().setId(VELVET_FERN_KEY))
    );

    public static final ResourceKey<Item> VESPER_SPROUTS_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesper_sprouts")
    );
    public static final Item VESPER_SPROUTS = registerItem("vesper_sprouts",
            new BlockItem(ModBlocks.VESPER_SPROUTS, new Item.Properties().setId(VESPER_SPROUTS_KEY))
    );

    public static final ResourceKey<Item> EMBER_SHELF_FUNGUS_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "ember_shelf_fungus")
    );
    public static final Item EMBER_SHELF_FUNGUS = registerItem("ember_shelf_fungus",
            new BlockItem(ModBlocks.EMBER_SHELF_FUNGUS, new Item.Properties().setId(EMBER_SHELF_FUNGUS_KEY))
    );

    //Tools and Weapons
// 1. SWORD
    public static final ResourceKey<Item> VESPERITE_SWORD_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_sword")
    );
    public static final Item VESPERITE_SWORD = registerItem("vesperite_sword",
            new Item(new Item.Properties()
                    .setId(VESPERITE_SWORD_KEY)
                    // .sword(Material, Attack Damage, Attack Speed)
                    .sword(ModToolMaterials.VESPERITE, 3.0F, -2.4F)
            )
    );

    // 2. SHOVEL
    public static final ResourceKey<Item> VESPERITE_SHOVEL_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_shovel")
    );
    public static final Item VESPERITE_SHOVEL = registerItem("vesperite_shovel",
            new Item(new Item.Properties()
                    .setId(VESPERITE_SHOVEL_KEY)
                    .shovel(ModToolMaterials.VESPERITE, 1.5F, -3.0F)
            )
    );

    // 3. PICKAXE
    public static final ResourceKey<Item> VESPERITE_PICKAXE_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_pickaxe")
    );
    public static final Item VESPERITE_PICKAXE = registerItem("vesperite_pickaxe",
            new Item(new Item.Properties()
                    .setId(VESPERITE_PICKAXE_KEY)
                    .pickaxe(ModToolMaterials.VESPERITE, 1.0F, -2.8F)
            )
    );

    // 4. AXE
    public static final ResourceKey<Item> VESPERITE_AXE_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_axe")
    );
    public static final Item VESPERITE_AXE = registerItem("vesperite_axe",
            new Item(new Item.Properties()
                    .setId(VESPERITE_AXE_KEY)
                    .axe(ModToolMaterials.VESPERITE, 6.0F, -3.1F)
            )
    );

    // 5. HOE
    public static final ResourceKey<Item> VESPERITE_HOE_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_hoe")
    );
    public static final Item VESPERITE_HOE = registerItem("vesperite_hoe",
            new Item(new Item.Properties()
                    .setId(VESPERITE_HOE_KEY)
                    .hoe(ModToolMaterials.VESPERITE, -2.0F, -1.0F)
            )
    );

    public static final ResourceKey<Item> VESPERITE_LANTERN_KEY = ResourceKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_lantern")
    );
    public static final Item VESPERITE_LANTERN = registerItem("vesperite_lantern",
            new BlockItem(ModBlocks.VESPERITE_LANTERN, new Item.Properties().setId(VESPERITE_LANTERN_KEY))
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