package com.warpgames.vesperwilds;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlintBerryBushBlock extends BushBlock implements BonemealableBlock {
    // 1. Codec Fix
    public static final MapCodec<GlintBerryBushBlock> CODEC = simpleCodec(GlintBerryBushBlock::new);

    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public GlintBerryBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    @SuppressWarnings("unchecked")
    public MapCodec<BushBlock> codec() {
        return (MapCodec<BushBlock>) (Object) CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return state.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(state, level, pos, context);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 3;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int i = state.getValue(AGE);
        if (i < 3 && level.getRawBrightness(pos.above(), 0) >= 9) {
            if (random.nextInt(5) == 0) {
                level.setBlock(pos, state.setValue(AGE, i + 1), 2);
            }
        }
    }

    // --- THE FIX ---
    // Matches the BlockBehavior.java snippet you provided exactly.
    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        int age = blockState.getValue(AGE);
        boolean isFullGrown = age == 3;

        // Harvest Logic
        if (age > 1) {
            int count = 1 + level.random.nextInt(2);
            popResource(level, blockPos, new ItemStack(ModItems.GLINT_BERRIES, count + (isFullGrown ? 1 : 0)));
            level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

            BlockState newState = blockState.setValue(AGE, 1);
            level.setBlock(blockPos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, newState));

            return InteractionResult.SUCCESS;
        }

        // Pass to super if not harvesting
        return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return state.getValue(AGE) < 3;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.getValue(AGE) + 1);
        level.setBlock(pos, state.setValue(AGE, i), 2);
    }
}