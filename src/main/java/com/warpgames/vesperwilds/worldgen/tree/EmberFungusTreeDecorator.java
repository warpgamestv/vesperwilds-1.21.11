package com.warpgames.vesperwilds.worldgen.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec; // Import MapCodec
import com.warpgames.vesperwilds.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class EmberFungusTreeDecorator extends TreeDecorator {

    // FIX: Define variable type as MapCodec<...>, NOT Codec<...>
    public static final MapCodec<EmberFungusTreeDecorator> CODEC = Codec.floatRange(0.0F, 1.0F)
            .fieldOf("probability")
            .xmap(EmberFungusTreeDecorator::new, (decorator) -> decorator.probability);

    private final float probability;

    public EmberFungusTreeDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecoratorTypes.EMBER_FUNGUS;
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        context.logs().forEach((pos) -> {
            if (random.nextFloat() < this.probability) {
                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                if (context.isAir(pos.relative(direction))) {
                    context.setBlock(pos.relative(direction),
                            ModBlocks.EMBER_SHELF_FUNGUS.defaultBlockState()
                                    .setValue(BlockStateProperties.HORIZONTAL_FACING, direction));
                }
            }
        });
    }
}