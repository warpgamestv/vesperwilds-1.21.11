package com.warpgames.vesperwilds.item;

import com.warpgames.vesperwilds.VesperWilds;
import com.warpgames.vesperwilds.util.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;
import java.util.Map;

public class ModArmorMaterials {
        public static final Holder<ArmorMaterial> VELVET = Holder.direct(new ArmorMaterial(
                        15, // durability
                        new EnumMap<>(Map.of(
                                        ArmorType.BOOTS, 1,
                                        ArmorType.LEGGINGS, 2,
                                        ArmorType.CHESTPLATE, 3,
                                        ArmorType.HELMET, 1,
                                        ArmorType.BODY, 3)), // defense
                        15, // enchantability
                        SoundEvents.ARMOR_EQUIP_LEATHER,
                        0.0F, // toughness
                        0.0F, // knockbackResistance
                        ModTags.Items.VELVET_CLOAK_REPAIR_INGREDIENT,
                        ResourceKey.create(
                                        ResourceKey.createRegistryKey(Identifier.fromNamespaceAndPath("minecraft",
                                                        "equipment_asset")),
                                        Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet"))));
}
