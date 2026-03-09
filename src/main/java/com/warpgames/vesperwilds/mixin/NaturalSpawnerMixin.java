package com.warpgames.vesperwilds.mixin;

import com.warpgames.vesperwilds.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NaturalSpawner.class)
public class NaturalSpawnerMixin {

    // matching the signature from Line 207 of your NaturalSpawner.java file
    @Inject(method = "isValidSpawnPostitionForType", at = @At("HEAD"), cancellable = true)
    private static void checkVesperiteLantern(
            ServerLevel serverLevel,
            MobCategory mobCategory,
            StructureManager structureManager,
            ChunkGenerator chunkGenerator,
            MobSpawnSettings.SpawnerData spawnerData,
            BlockPos.MutableBlockPos pos,
            double distance,
            CallbackInfoReturnable<Boolean> cir) {

        // 1. Get the entity type from the spawner data
        EntityType<?> entityType = spawnerData.type();

        // 2. Safety Check
        if (entityType == null)
            return;

        // 3. Filter: Only stop MONSTERS
        if (entityType.getCategory() == MobCategory.MONSTER) {

            // 4. Radius Scan (16 blocks)
            int radius = 16;
            BlockPos minPos = pos.offset(-radius, -radius, -radius);
            BlockPos maxPos = pos.offset(radius, radius, radius);

            // We use serverLevel to check block states because 'levelReader' isn't passed
            // here,
            // but ServerLevel extends it, so it works perfectly.
            for (BlockPos checkPos : BlockPos.betweenClosed(minPos, maxPos)) {
                if (serverLevel.getBlockState(checkPos).is(ModBlocks.VESPERITE_LANTERN)) {
                    cir.setReturnValue(false); // Cancel the spawn
                    return;
                }
            }
        }
    }

    @Inject(method = "mobsAt", at = @At("RETURN"), cancellable = true)
    private static void injectEclipseMobs(
            ServerLevel serverLevel,
            StructureManager structureManager,
            ChunkGenerator chunkGenerator,
            net.minecraft.world.entity.MobCategory mobCategory,
            BlockPos blockPos,
            net.minecraft.core.Holder<net.minecraft.world.level.biome.Biome> holder,
            CallbackInfoReturnable<net.minecraft.util.random.WeightedList<MobSpawnSettings.SpawnerData>> cir) {

        if (mobCategory == net.minecraft.world.entity.MobCategory.MONSTER
                && com.warpgames.vesperwilds.event.VelvetEclipseManager.isEclipseActive()) {
            net.minecraft.util.random.WeightedList<MobSpawnSettings.SpawnerData> original = cir.getReturnValue();
            if (original == null) {
                original = MobSpawnSettings.EMPTY_MOB_LIST;
            }

            net.minecraft.util.random.WeightedList.Builder<MobSpawnSettings.SpawnerData> builder = net.minecraft.util.random.WeightedList
                    .builder();
            for (net.minecraft.util.random.Weighted<MobSpawnSettings.SpawnerData> entry : original.unwrap()) {
                builder.add(entry.value(), entry.weight());
            }

            // Add Gloom Stalker to the spawn pool during the eclipse with a common weight
            // (50).
            builder.add(new MobSpawnSettings.SpawnerData(com.warpgames.vesperwilds.ModEntities.GLOOM_STALKER, 1, 2),
                    50);

            cir.setReturnValue(builder.build());
        }
    }
}