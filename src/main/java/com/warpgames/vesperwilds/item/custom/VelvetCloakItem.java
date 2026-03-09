package com.warpgames.vesperwilds.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VelvetCloakItem extends Item {

    public VelvetCloakItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, net.minecraft.server.level.ServerLevel level, Entity entity,
            EquipmentSlot slotId) {
        if (entity instanceof Player player) {
            ItemStack chestpiece = player.getItemBySlot(EquipmentSlot.CHEST);
            if (!chestpiece.isEmpty() && chestpiece.getItem() == this) {
                player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0, false, false, true));
            }
        }
        super.inventoryTick(stack, level, entity, slotId);
    }
}
