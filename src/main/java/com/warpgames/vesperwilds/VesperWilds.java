package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.entity.client.VelvetMothRenderer;
import com.warpgames.vesperwilds.entity.custom.VelvetMothEntity;
import com.warpgames.vesperwilds.worldgen.ModConfiguredFeatures;
import com.warpgames.vesperwilds.worldgen.ModEntitySpawns;
import com.warpgames.vesperwilds.worldgen.ModSurfaceRuleData;
import com.warpgames.vesperwilds.worldgen.tree.ModTreeDecoratorTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLibConstants;
import terrablender.api.SurfaceRuleManager;

public class VesperWilds implements ModInitializer {
	public static final String MOD_ID = "vesper_wilds";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// --- CREATIVE TAB REGISTRATION ---
	public static final CreativeModeTab VESPER_TAB = Registry.register(
			BuiltInRegistries.CREATIVE_MODE_TAB,
			Identifier.fromNamespaceAndPath(MOD_ID, "vesper_tab"),
			FabricItemGroup.builder()
					.icon(() -> new ItemStack(ModItems.VESPERITE_ORE_ITEM)) // Icon for the tab
					.title(Component.literal("Vesper Wilds")) // Title of the tab
					.displayItems((context, entries) -> {
						// Add all your items here!
						entries.accept(ModItems.RAW_VESPERITE);
						entries.accept(ModItems.VESPERITE_ORE_ITEM);
						entries.accept(ModItems.DEEPSLATE_VESPERITE_ORE_ITEM);
						entries.accept(ModItems.GLINT_BERRIES);
						entries.accept(ModItems.VELVET_LOG);
						entries.accept(ModItems.VELVET_PLANKS);
						entries.accept(ModItems.VELVET_LEAVES);
						entries.accept(ModItems.VELVET_SAPLING);
						entries.accept(ModItems.VELVET_STAIRS_ITEM);
						entries.accept(ModItems.VELVET_DOOR_ITEM);
						entries.accept(ModItems.VELVET_FENCE_GATE_ITEM);
						entries.accept(ModItems.VELVET_FENCE_ITEM);
						entries.accept(ModItems.VELVET_TRAPDOOR_ITEM);
						entries.accept(ModItems.VELVET_BUTTON_ITEM);
						entries.accept(ModItems.VELVET_PRESSURE_PLATE_ITEM);
						entries.accept(ModItems.VELVET_SLAB_ITEM);
						entries.accept(ModItems.VELVET_FERN);
						entries.accept(ModItems.VESPER_SPROUTS);
						entries.accept(ModItems.EMBER_SHELF_FUNGUS);
						entries.accept(ModBlocks.VESPER_STONE);
						entries.accept(ModBlocks.VESPER_STONE_BRICKS);
						entries.accept(ModBlocks.VESPER_STONE_BRICK_STAIRS);
						entries.accept(ModBlocks.VESPER_STONE_BRICK_SLAB);
						entries.accept(ModBlocks.VESPER_STONE_BRICK_WALL);
						entries.accept(ModItems.VESPERITE_INGOT);
						entries.accept(ModItems.VESPERITE_NUGGET);
						entries.accept(ModItems.VESPERITE_PICKAXE);
						entries.accept(ModItems.VESPERITE_AXE);
						entries.accept(ModItems.VESPERITE_SHOVEL);
						entries.accept(ModItems.VESPERITE_SWORD);
						entries.accept(ModItems.VESPERITE_HOE);
						entries.accept(ModItems.BOTTLED_MOTH);

					})
					.build()
	);

	@Override
	public void onInitialize() {
		GeckoLibConstants.init();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBiomes.registerBiomes();
		ModParticles.registerParticles();
		ModTreeDecoratorTypes.register();
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRuleData.makeRules());
		ModEntities.registerModEntities();
		ModEntitySpawns.addSpawns();
		FabricDefaultAttributeRegistry.register(
				ModEntities.VELVET_MOTH,
				VelvetMothEntity.createAttributes());
		EntityRenderers.register(ModEntities.VELVET_MOTH, VelvetMothRenderer::new);
		// Note: TerraBlender registration is now handled in VesperTerraBlender.java

		LOGGER.info("Vesper Wilds Initialized!");
	}
}