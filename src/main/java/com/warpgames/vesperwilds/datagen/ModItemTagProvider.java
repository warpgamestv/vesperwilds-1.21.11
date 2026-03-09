package com.warpgames.vesperwilds.datagen;

import com.warpgames.vesperwilds.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(TagKey.create(Registries.ITEM, Identifier.parse("c:raw_materials/vesperite")))
                .add(ModItems.RAW_VESPERITE);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.VESPERITE_SWORD);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.VESPERITE_AXE);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.VESPERITE_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.VESPERITE_SHOVEL);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.VESPERITE_HOE);
    }
}
