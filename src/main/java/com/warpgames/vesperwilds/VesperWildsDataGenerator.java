package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.datagen.ModWorldGenerator; // Import this!
import com.warpgames.vesperwilds.worldgen.ModConfiguredFeatures;
import com.warpgames.vesperwilds.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class VesperWildsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		// ADD THIS LINE:
		pack.addProvider(ModWorldGenerator::new);
	}

	// ADD THIS METHOD:
	// This builds the registry so the generator knows what keys exist
	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		// ADD THIS LINE:
		registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}