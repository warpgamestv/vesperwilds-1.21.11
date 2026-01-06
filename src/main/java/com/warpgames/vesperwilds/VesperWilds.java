package com.warpgames.vesperwilds;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VesperWilds implements ModInitializer {
	public static final String MOD_ID = "vesper_wilds";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks(); // <-- ADD THIS LINE

		// Add to Creative Tab
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(content -> {
			content.accept(ModItems.RAW_VESPERITE);
			content.accept(ModItems.GLINT_BERRIES);
		});

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(content -> {
			content.accept(ModItems.VELVET_LOG);
		});

		LOGGER.info("Hello Fabric world!");
	}
}