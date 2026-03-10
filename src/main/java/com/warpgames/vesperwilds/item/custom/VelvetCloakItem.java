package com.warpgames.vesperwilds.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.manager.AnimatableManager;

import java.util.function.Consumer;

public class VelvetCloakItem extends Item implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public VelvetCloakItem(Properties properties) {
        super(properties);
        GeoItem.registerSyncedAnimatable(this);
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private com.warpgames.vesperwilds.item.client.VelvetCloakRenderer<?> renderer;

            @Override
            public software.bernie.geckolib.renderer.GeoArmorRenderer<?, ?> getGeoArmorRenderer(
                    net.minecraft.world.item.ItemStack itemStack,
                    net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
                if (this.renderer == null) {
                    this.renderer = new com.warpgames.vesperwilds.item.client.VelvetCloakRenderer<>();
                }
                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // No animations for the cloak currently
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
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
