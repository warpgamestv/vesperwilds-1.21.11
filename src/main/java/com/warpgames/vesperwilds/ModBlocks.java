package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.block.custom.EmberShelfFungusBlock;
import com.warpgames.vesperwilds.block.custom.VesperiteLanternBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier; // Or net.minecraft.util.Identifier depending on your setup
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import com.warpgames.vesperwilds.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.Optional;

public class ModBlocks {

    // =================================================================
    // 1. DEFINE ALL KEYS FIRST (Prevents "Block ID not set" Crash)
    // =================================================================

    public static final ResourceKey<Block> VELVET_LOG_KEY = key("velvet_log");
    public static final ResourceKey<Block> VELVET_PLANKS_KEY = key("velvet_planks");
    public static final ResourceKey<Block> VELVET_STAIRS_KEY = key("velvet_stairs");
    public static final ResourceKey<Block> VELVET_SLAB_KEY = key("velvet_slab");
    public static final ResourceKey<Block> VELVET_FENCE_KEY = key("velvet_fence");
    public static final ResourceKey<Block> VELVET_FENCE_GATE_KEY = key("velvet_fence_gate");
    public static final ResourceKey<Block> VELVET_DOOR_KEY = key("velvet_door");
    public static final ResourceKey<Block> VELVET_TRAPDOOR_KEY = key("velvet_trapdoor");
    public static final ResourceKey<Block> VELVET_BUTTON_KEY = key("velvet_button");
    public static final ResourceKey<Block> VELVET_PRESSURE_PLATE_KEY = key("velvet_pressure_plate");
    public static final ResourceKey<Block> VELVET_LEAVES_KEY = key("velvet_leaves");
    public static final ResourceKey<Block> VELVET_SAPLING_KEY = key("velvet_sapling");
    public static final ResourceKey<Block> GLINT_BERRY_BUSH_KEY = key("glint_berry_bush");
    public static final ResourceKey<Block> VESPERITE_ORE_KEY = key("vesperite_ore");
    public static final ResourceKey<Block> DEEPSLATE_VESPERITE_ORE_KEY = key("deepslate_vesperite_ore");
    public static final ResourceKey<Block> VESPER_STONE_KEY = key("vesper_stone");
    public static final ResourceKey<Block> VESPER_STONE_BRICKS_KEY = key("vesper_stone_bricks");
    public static final ResourceKey<Block> VESPER_STONE_BRICK_STAIRS_KEY = key("vesper_stone_brick_stairs");
    public static final ResourceKey<Block> VESPER_STONE_BRICK_SLAB_KEY = key("vesper_stone_brick_slab");
    public static final ResourceKey<Block> VESPER_STONE_BRICK_WALL_KEY = key("vesper_stone_brick_wall");
    public static final ResourceKey<Block> VESPERITE_LANTERN_KEY = key("vesperite_lantern");

    // The New Plants (These were missing before!)
    public static final ResourceKey<Block> VELVET_FERN_KEY = key("velvet_fern");
    public static final ResourceKey<Block> VESPER_SPROUTS_KEY = key("vesper_sprouts");
    public static final ResourceKey<Block> EMBER_SHELF_FUNGUS_KEY = key("ember_shelf_fungus");


    // =================================================================
    // 2. DEFINE BLOCKS (Now safe to use keys)
    // =================================================================

    public static final Block VELVET_LOG = registerBlock("velvet_log",
            new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD)
                    .setId(VELVET_LOG_KEY)));

    public static final Block VELVET_PLANKS = registerBlock("velvet_planks",
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD)
                    .setId(VELVET_PLANKS_KEY)));

    public static final Block VELVET_STAIRS = registerBlock("velvet_stairs",
            new StairBlock(VELVET_PLANKS.defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(2.0f, 3.0f).sound(SoundType.WOOD).setId(VELVET_STAIRS_KEY)));

    public static final Block VELVET_SLAB = registerBlock("velvet_slab",
            new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(2.0f, 3.0f).sound(SoundType.WOOD).setId(VELVET_SLAB_KEY)));

    public static final Block VELVET_FENCE = registerBlock("velvet_fence",
            new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(2.0f, 3.0f).sound(SoundType.WOOD).setId(VELVET_FENCE_KEY)));

    public static final Block VELVET_FENCE_GATE = registerBlock("velvet_fence_gate",
            new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of()
                    .strength(2.0f, 3.0f).sound(SoundType.WOOD).setId(VELVET_FENCE_GATE_KEY)));

    public static final Block VELVET_DOOR = registerBlock("velvet_door",
            new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(3.0f).sound(SoundType.WOOD).noOcclusion().setId(VELVET_DOOR_KEY)));

    public static final Block VELVET_TRAPDOOR = registerBlock("velvet_trapdoor",
            new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(3.0f).sound(SoundType.WOOD).noOcclusion().setId(VELVET_TRAPDOOR_KEY)));

    public static final Block VELVET_BUTTON = registerBlock("velvet_button",
            new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.of()
                    .noCollision().strength(0.5f).setId(VELVET_BUTTON_KEY)));

    public static final Block VELVET_PRESSURE_PLATE = registerBlock("velvet_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(0.5f).setId(VELVET_PRESSURE_PLATE_KEY)));

    public static final Block VELVET_LEAVES = registerBlock("velvet_leaves",
            new VelvetLeavesBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).sound(SoundType.GRASS).noOcclusion().setId(VELVET_LEAVES_KEY)));

    public static final TreeGrower VELVET_TREE_GROWER = new TreeGrower(
            "velvet_tree",
            Optional.of(ModConfiguredFeatures.MEGA_VESPER_TREE_KEY),
            Optional.of(ModConfiguredFeatures.VELVET_TREE_KEY),
            Optional.empty()
    );

    public static final Block VELVET_SAPLING = registerBlock("velvet_sapling",
            new SaplingBlock(VELVET_TREE_GROWER, BlockBehaviour.Properties.of()
                    .noCollision().instabreak().sound(SoundType.GRASS).setId(VELVET_SAPLING_KEY)));

    public static final Block GLINT_BERRY_BUSH = registerBlock("glint_berry_bush",
            new GlintBerryBushBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion().noCollision().setId(GLINT_BERRY_BUSH_KEY)
                    .lightLevel(state -> state.getValue(GlintBerryBushBlock.AGE) == 3 ? 5 : 0)));

    public static final Block VESPERITE_ORE = registerBlock("vesperite_ore",
            new Block(Block.Properties.of()
                    .setId(VESPERITE_ORE_KEY).mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(3.0f, 3.0f)));

    public static final Block DEEPSLATE_VESPERITE_ORE = registerBlock("deepslate_vesperite_ore",
            new Block(Block.Properties.of()
                    .setId(DEEPSLATE_VESPERITE_ORE_KEY).mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(4.5f, 3.0f)));

    // --- NEW PLANTS (Now using the keys defined at the top!) ---

    public static final Block VELVET_FERN = registerBlock("velvet_fern",
            new DoublePlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .replaceable()
                    .noCollision()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .pushReaction(PushReaction.DESTROY)
                    .setId(VELVET_FERN_KEY)));

    public static final Block VESPER_SPROUTS = registerBlock("vesper_sprouts",
            new TallGrassBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .replaceable()
                    .noCollision()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .pushReaction(PushReaction.DESTROY)
                    .setId(VESPER_SPROUTS_KEY)));

    public static final Block EMBER_SHELF_FUNGUS = registerBlock("ember_shelf_fungus",
            new EmberShelfFungusBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .lightLevel((state) -> 5)
                    .noCollision()
                    .instabreak()
                    .sound(SoundType.WOOD)
                    .pushReaction(PushReaction.DESTROY)
                    .setId(EMBER_SHELF_FUNGUS_KEY)));

    // 1. Vesper Stone
    public static final Block VESPER_STONE = registerBlock("vesper_stone",
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 6.0f)
                    .sound(SoundType.DEEPSLATE)
                    .setId(VESPER_STONE_KEY))); // <-- Added this

    // 2. Vesper Stone Bricks
    public static final Block VESPER_STONE_BRICKS = registerBlock("vesper_stone_bricks",
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 6.0f)
                    .sound(SoundType.DEEPSLATE_BRICKS)
                    .setId(VESPER_STONE_BRICKS_KEY))); // <-- Added this

    // 3. Stairs
    public static final Block VESPER_STONE_BRICK_STAIRS = registerBlock("vesper_stone_brick_stairs",
            new StairBlock(Blocks.DEEPSLATE_BRICKS.defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.DEEPSLATE)
                            .requiresCorrectToolForDrops()
                            .strength(3.0f, 6.0f)
                            .sound(SoundType.DEEPSLATE_BRICKS)
                            .setId(VESPER_STONE_BRICK_STAIRS_KEY))); // <-- Added this

    // 4. Slabs
    public static final Block VESPER_STONE_BRICK_SLAB = registerBlock("vesper_stone_brick_slab",
            new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 6.0f)
                    .sound(SoundType.DEEPSLATE_BRICKS)
                    .setId(VESPER_STONE_BRICK_SLAB_KEY))); // <-- Added this

    // 5. Walls
    public static final Block VESPER_STONE_BRICK_WALL = registerBlock("vesper_stone_brick_wall",
            new WallBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 6.0f)
                    .sound(SoundType.DEEPSLATE_BRICKS)
                    .setId(VESPER_STONE_BRICK_WALL_KEY))); // <-- Added this

    public static final Block VESPERITE_LANTERN = registerBlock("vesperite_lantern",
            new VesperiteLanternBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel((state) -> 15) // Maximum Light
                    .noOcclusion()
                    .setId(VESPERITE_LANTERN_KEY)));


    // =================================================================
    // 3. HELPER METHODS
    // =================================================================

    private static ResourceKey<Block> key(String name) {
        return ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, name));
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(
                BuiltInRegistries.BLOCK,
                Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, name),
                block
        );
    }

    public static void registerModBlocks() {
        VesperWilds.LOGGER.info("Registering Mod Blocks for " + VesperWilds.MOD_ID);
    }
}