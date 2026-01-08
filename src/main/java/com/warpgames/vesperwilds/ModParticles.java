package com.warpgames.vesperwilds;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.Identifier;

import static com.warpgames.vesperwilds.VesperWilds.MOD_ID;

public class ModParticles {

    public static final SimpleParticleType VELVET_FALLING_LEAF = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                Identifier.fromNamespaceAndPath(MOD_ID, "velvet_falling_leaf"),
                VELVET_FALLING_LEAF);
    }
}