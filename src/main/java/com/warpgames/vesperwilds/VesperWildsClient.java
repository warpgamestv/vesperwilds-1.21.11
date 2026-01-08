package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.particle.VelvetFallingLeafParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap; // This will turn white (found)
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;


public class VesperWildsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.VELVET_LEAVES, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VELVET_SAPLING, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GLINT_BERRY_BUSH, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VELVET_DOOR, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VELVET_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        ParticleFactoryRegistry.getInstance().register(ModParticles.VELVET_FALLING_LEAF, VelvetFallingLeafParticle.Provider::new);
    }
}