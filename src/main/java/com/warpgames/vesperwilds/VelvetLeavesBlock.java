package com.warpgames.vesperwilds;

import com.mojang.serialization.MapCodec;
import com.warpgames.vesperwilds.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class VelvetLeavesBlock extends LeavesBlock {
    public static final MapCodec<VelvetLeavesBlock> CODEC = simpleCodec(VelvetLeavesBlock::new);

    public VelvetLeavesBlock(BlockBehaviour.Properties properties) {
        super(0.5F, properties);
    }

    @Override
    public MapCodec<? extends LeavesBlock> codec() {
        return CODEC;
    }

    // --- DEBUG: Override animateTick DIRECTLY ---
    // This bypasses the parent "LeavesBlock" logic entirely.
    // It ignores "isFaceFull" (so it works on the ground).
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        // Run standard leaf logic (water drips, etc.)
        super.animateTick(state, level, pos, random);

        // FORCE SPAWN: 1 in 10 chance per tick (Very frequent)
        if (random.nextInt(10) == 0) {
            // Spawn BELOW the block
            double x = pos.getX() + random.nextDouble();
            double z = pos.getZ() + random.nextDouble();
            double y = pos.getY() - 0.1D;

            level.addParticle(ModParticles.VELVET_FALLING_LEAF, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }

    // We still keep this to satisfy the abstract class requirement,
    // but our custom animateTick above does the real work now.
    @Override
    public void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        // Empty
    }
}