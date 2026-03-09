package com.warpgames.vesperwilds.util;

import com.warpgames.vesperwilds.VesperWilds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> VELVET_CLOAK_REPAIR_INGREDIENT = createTag("velvet_cloak_repair_ingredient");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, name));
        }
    }
}
