package com.warpgames.vesperwilds;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import com.warpgames.vesperwilds.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.Optional; // Important Import!

public class ModBlocks {

    // --- VELVET LOG ---
    public static final ResourceKey<Block> VELVET_LOG_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_log")
    );
    public static final Block VELVET_LOG = registerBlock("velvet_log",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(VELVET_LOG_KEY))
    );

    // --- VELVET PLANKS ---
    public static final ResourceKey<Block> VELVET_PLANKS_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_planks")
    );
    public static final Block VELVET_PLANKS = registerBlock("velvet_planks",
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(VELVET_PLANKS_KEY))
    );

    // --- VELVET WOOD FAMILY ---

    // 1. Stairs (Copies properties from Planks)
    public static final ResourceKey<Block> VELVET_STAIRS_KEY = ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_stairs"));
    public static final Block VELVET_STAIRS = registerBlock("velvet_stairs",
            new StairBlock(VELVET_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(VELVET_PLANKS).setId(VELVET_STAIRS_KEY)));

    // 2. Slab
    public static final ResourceKey<Block> VELVET_SLAB_KEY = ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_slab"));
    public static final Block VELVET_SLAB = registerBlock("velvet_slab",
            new SlabBlock(BlockBehaviour.Properties.ofFullCopy(VELVET_PLANKS).setId(VELVET_SLAB_KEY)));

    // 3. Fence
    public static final ResourceKey<Block> VELVET_FENCE_KEY = ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_fence"));
    public static final Block VELVET_FENCE = registerBlock("velvet_fence",
            new FenceBlock(BlockBehaviour.Properties.ofFullCopy(VELVET_PLANKS).setId(VELVET_FENCE_KEY)));

    // 4. Fence Gate
    public static final ResourceKey<Block> VELVET_FENCE_GATE_KEY = ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_fence_gate"));
    public static final Block VELVET_FENCE_GATE = registerBlock("velvet_fence_gate",
            new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(VELVET_PLANKS).setId(VELVET_FENCE_GATE_KEY)));

    // 5. Door (Requires BlockSetType - using OAK defaults for now)
    public static final ResourceKey<Block> VELVET_DOOR_KEY = ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_door"));
    public static final Block VELVET_DOOR = registerBlock("velvet_door",
            new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(VELVET_DOOR_KEY)));

    // 6. Trapdoor
    public static final ResourceKey<Block> VELVET_TRAPDOOR_KEY = ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_trapdoor"));
    public static final Block VELVET_TRAPDOOR = registerBlock("velvet_trapdoor",
            new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(VELVET_TRAPDOOR_KEY)));

    // 7. Button
    public static final ResourceKey<Block> VELVET_BUTTON_KEY = ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_button"));
    public static final Block VELVET_BUTTON = registerBlock("velvet_button",
            new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(VELVET_BUTTON_KEY)));

    // 8. Pressure Plate
    public static final ResourceKey<Block> VELVET_PRESSURE_PLATE_KEY = ResourceKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_pressure_plate"));
    public static final Block VELVET_PRESSURE_PLATE = registerBlock("velvet_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(VELVET_PRESSURE_PLATE_KEY)));

    // --- VELVET LEAVES ---
    public static final ResourceKey<Block> VELVET_LEAVES_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_leaves")
    );
    public static final Block VELVET_LEAVES = registerBlock("velvet_leaves",
            // Make sure you have the VelvetLeavesBlock.java file created from the previous step!
            new VelvetLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
                    .setId(VELVET_LEAVES_KEY)
                    .noOcclusion())
    );

    // --- VELVET SAPLING ---
    public static final ResourceKey<Block> VELVET_SAPLING_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_sapling")
    );

    // FIX: Define the TreeGrower right here!
    // We use Optional.empty() for now because we haven't created the actual Tree Feature yet.
    public static final TreeGrower VELVET_TREE_GROWER = new TreeGrower(
            "velvet_tree",
            Optional.of(ModConfiguredFeatures.MEGA_VESPER_TREE_KEY),// Mega Tree (Jungle-style)
            Optional.of(ModConfiguredFeatures.VELVET_TREE_KEY), // Regular Tree
            Optional.empty()  // Flowers (Bees)
    );

    public static final Block VELVET_SAPLING = registerBlock("velvet_sapling",
            new SaplingBlock(
                    VELVET_TREE_GROWER, // Pass the grower we defined above
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)
                            .setId(VELVET_SAPLING_KEY)
                            .noOcclusion()
                            .noCollision()
            )
    );

    // --- GLINT BERRY BUSH ---
    public static final ResourceKey<Block> GLINT_BERRY_BUSH_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "glint_berry_bush")
    );
    public static final Block GLINT_BERRY_BUSH = registerBlock("glint_berry_bush",
            new GlintBerryBushBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)
                            .setId(GLINT_BERRY_BUSH_KEY)
                            .lightLevel(state -> state.getValue(GlintBerryBushBlock.AGE) == 3 ? 5 : 0) // Glow logic
                            .noOcclusion()
                            .noCollision()
            )
    );
    public static final ResourceKey<Block> VESPERITE_ORE_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_ore")
    );

    public static final Block VESPERITE_ORE = registerBlock("vesperite_ore",
            new Block(Block.Properties.of()
                    .setId(VESPERITE_ORE_KEY) // <--- THIS WAS MISSING
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 3.0f)));

    // --- DEEPSLATE ORE ---
    public static final ResourceKey<Block> DEEPSLATE_VESPERITE_ORE_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK.key(),
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "deepslate_vesperite_ore")
    );

    public static final Block DEEPSLATE_VESPERITE_ORE = registerBlock("deepslate_vesperite_ore",
            new Block(Block.Properties.of()
                    .setId(DEEPSLATE_VESPERITE_ORE_KEY) // <--- THIS WAS MISSING
                    .mapColor(MapColor.DEEPSLATE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(4.5f, 3.0f)));

    // --- HELPER METHOD ---
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