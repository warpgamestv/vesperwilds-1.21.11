package com.warpgames.vesperwilds;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VesperWilds implements ModInitializer {
	public static final String MOD_ID = "vesper_wilds";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// --- CREATIVE TAB REGISTRATION ---
	public static final CreativeModeTab VESPER_TAB = Registry.register(
			BuiltInRegistries.CREATIVE_MODE_TAB,
			Identifier.fromNamespaceAndPath(MOD_ID, "vesper_tab"),
			FabricItemGroup.builder()
					.icon(() -> new ItemStack(ModItems.GLINT_BERRIES)) // Icon for the tab
					.title(Component.literal("Vesper Wilds")) // Title of the tab
					.displayItems((context, entries) -> {
						// Add all your items here!
						entries.accept(ModItems.RAW_VESPERITE);
						entries.accept(ModItems.GLINT_BERRIES);
						entries.accept(ModItems.VELVET_LOG);
						entries.accept(ModItems.VELVET_PLANKS);
						entries.accept(ModItems.VELVET_LEAVES);
						entries.accept(ModItems.VELVET_SAPLING);
					})
					.build()
	);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBiomes.registerBiomes();

		// Note: TerraBlender registration is now handled in VesperTerraBlender.java

		LOGGER.info("Vesper Wilds Initialized!");
	}
}