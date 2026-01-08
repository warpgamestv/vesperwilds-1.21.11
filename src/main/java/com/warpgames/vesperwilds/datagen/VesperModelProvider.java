package com.warpgames.vesperwilds.datagen;

import com.warpgames.vesperwilds.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import org.jspecify.annotations.NonNull;

public class VesperModelProvider extends FabricModelProvider {
    public VesperModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        // 1. Logs
        // Uses 'woodProvider' (Mojang) instead of 'registerLog' (Yarn)
        blockStateModelGenerator.woodProvider(ModBlocks.VELVET_LOG).logWithHorizontal(ModBlocks.VELVET_LOG);

        // 2. The "Texture Pool" for the Family
        // We use 'var' here so you don't have to worry about the complex class name.
        // Uses 'family' (Mojang) instead of 'registerCubeAllModelTexturePool' (Yarn)
        var velvetPool = blockStateModelGenerator.family(ModBlocks.VELVET_PLANKS);

        // 3. Generate the variants from the pool
        velvetPool.stairs(ModBlocks.VELVET_STAIRS);
        velvetPool.slab(ModBlocks.VELVET_SLAB);
        velvetPool.fence(ModBlocks.VELVET_FENCE);
        velvetPool.fenceGate(ModBlocks.VELVET_FENCE_GATE);
        velvetPool.button(ModBlocks.VELVET_BUTTON);
        velvetPool.pressurePlate(ModBlocks.VELVET_PRESSURE_PLATE);

        // 4. Door and Trapdoor
        // Uses 'createDoor' (Mojang) instead of 'registerDoor' (Yarn)
        blockStateModelGenerator.createDoor(ModBlocks.VELVET_DOOR);
        blockStateModelGenerator.createTrapdoor(ModBlocks.VELVET_TRAPDOOR);
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        // Leave empty for now
    }
}