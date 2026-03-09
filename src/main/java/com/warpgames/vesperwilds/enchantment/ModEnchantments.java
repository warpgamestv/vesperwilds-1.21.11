package com.warpgames.vesperwilds.enchantment;

import com.warpgames.vesperwilds.VesperWilds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> PENUMBRA = ResourceKey.create(
            Registries.ENCHANTMENT,
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "penumbra"));

    public static void registerModEnchantments() {
        VesperWilds.LOGGER.info("Registering Mod Enchantments for " + VesperWilds.MOD_ID);
    }
}
