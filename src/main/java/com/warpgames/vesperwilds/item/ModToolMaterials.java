package com.warpgames.vesperwilds.item;

import com.warpgames.vesperwilds.VesperWilds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {

    // 1. Create the Tag for what repairs the tool
    public static final TagKey<Item> VESPERITE_REPAIR_TAG = TagKey.create(Registries.ITEM,
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "vesperite_tool_materials"));

    // 2. Define the Material Record
    // (Mining Level Tag, Durability, Mining Speed, Attack Damage, Enchantability, Repair Tag)
    public static final ToolMaterial VESPERITE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            450,
            7.0F,
            2.5F,
            22,
            VESPERITE_REPAIR_TAG
    );
}