package com.warpgames.vesperwilds.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;

public class VesperiteLanternBlock extends LanternBlock {
    public VesperiteLanternBlock(Properties properties) {
        super(properties);
    }
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        // 1. Calculate the center of the block
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.7D; // Slightly higher than center
        double f = (double)pos.getZ() + 0.5D;

        // 2. Small chance to spawn a particle (matches vanilla Torch/Lantern frequency)
        if (random.nextFloat() < 0.3f) {

            // 3. Spawn a "Witch Magic" particle (Purple Sparkle)
            // You can also try PORTAL (falling purple dust) or DRAGON_BREATH (pink cloud)
            level.addParticle(ParticleTypes.WITCH, d, e, f, 0.0D, 0.0D, 0.0D);

            // 4. Spawn a "Portal" particle that moves slightly
            level.addParticle(ParticleTypes.PORTAL,
                    d + (random.nextDouble() - 0.5D) * 0.5D,
                    e + (random.nextDouble() - 0.5D) * 0.5D,
                    f + (random.nextDouble() - 0.5D) * 0.5D,
                    (random.nextDouble() - 0.5D) * 0.5D,
                    -random.nextDouble(),
                    (random.nextDouble() - 0.5D) * 0.5D);
        }
    }
}