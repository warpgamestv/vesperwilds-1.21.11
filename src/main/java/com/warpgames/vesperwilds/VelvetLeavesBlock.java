package com.warpgames.vesperwilds;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class VelvetLeavesBlock extends LeavesBlock {
    // 1. Define the Codec
    public static final MapCodec<VelvetLeavesBlock> CODEC = simpleCodec(VelvetLeavesBlock::new);

    public VelvetLeavesBlock(BlockBehaviour.Properties properties) {
        // FIX IS HERE: We added '0.5F' as the first argument.
        // This tells the game how often particles should spawn (0.5 is standard).
        super(0.5F, properties);
    }

    @Override
    public MapCodec<? extends LeavesBlock> codec() {
        return CODEC;
    }

    // 2. Define the Particles
    @Override
    public void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(15) == 0) {
            BlockPos blockPos = pos.below();
            if (level.getBlockState(blockPos).canBeReplaced() || level.getBlockState(blockPos).isSolid()) {
                // Using Cherry Leaves particles for now (pink falling petals)
                level.addParticle(ParticleTypes.CHERRY_LEAVES,
                        pos.getX() + random.nextDouble(),
                        pos.getY() - 0.2D,
                        pos.getZ() + random.nextDouble(),
                        0.0D, 0.0D, 0.0D);
            }
        }
    }
}