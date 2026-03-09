package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.particle.VelvetFallingLeafParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap; // This will turn white (found)
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

public class VesperWildsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.VELVET_LEAVES, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VELVET_SAPLING, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GLINT_BERRY_BUSH, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VELVET_DOOR, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VELVET_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        ParticleFactoryRegistry.getInstance().register(ModParticles.VELVET_FALLING_LEAF,
                VelvetFallingLeafParticle.Provider::new);
        BlockRenderLayerMap.putBlock(ModBlocks.VELVET_FERN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VESPER_SPROUTS, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.EMBER_SHELF_FUNGUS, ChunkSectionLayer.CUTOUT);

        net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking.registerGlobalReceiver(
                com.warpgames.vesperwilds.network.packet.VelvetEclipseSyncS2CPacket.ID,
                (payload, context) -> {
                    context.client().execute(() -> {
                        com.warpgames.vesperwilds.event.VelvetEclipseClientManager.setEclipseActive(payload.active());
                    });
                });

        net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents.DISCONNECT
                .register((handler, client) -> {
                    com.warpgames.vesperwilds.event.VelvetEclipseClientManager.setEclipseActive(false);
                });
    }
}