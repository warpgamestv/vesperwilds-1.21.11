package com.warpgames.vesperwilds.worldgen;

import com.warpgames.vesperwilds.ModBlocks;
import com.warpgames.vesperwilds.ModBiomes; // Make sure this points to where you registered your Biome Key
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRuleData {
    private static final SurfaceRules.RuleSource VESPER_STONE = makeStateRule(ModBlocks.VESPER_STONE);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);

    public static SurfaceRules.RuleSource makeRules() {
        // 1. Define the Condition: Are we in the Vesper Grove?
        SurfaceRules.ConditionSource isVesperGrove = SurfaceRules.isBiome(ModBiomes.VESPER_GROVE);

        // 2. The Rule Sequence
        return SurfaceRules.sequence(
                // If true, run our custom rules. If false, the game ignores this and uses vanilla rules automatically.
                SurfaceRules.ifTrue(isVesperGrove,
                        SurfaceRules.sequence(
                                // Rule 1: Grass on top
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK),

                                // Rule 2: Vesper Stone just below the surface
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, VESPER_STONE)
                        )
                )
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}