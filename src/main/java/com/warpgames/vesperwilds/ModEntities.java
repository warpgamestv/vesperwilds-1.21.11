package com.warpgames.vesperwilds;

import com.warpgames.vesperwilds.entity.custom.VelvetMothEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    // Define the Moth using the helper method below
    public static final EntityType<VelvetMothEntity> VELVET_MOTH = register(
            "velvet_moth",
            EntityType.Builder.of(VelvetMothEntity::new, MobCategory.AMBIENT)
                    .sized(0.5f, 0.5f) // Uses '.sized' (Mojang) instead of '.dimensions'
    );

    // Helper method to handle the ResourceKey creation automatically
    private static <T extends net.minecraft.world.entity.Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        // 1. Create the Identifier
        Identifier id = Identifier.fromNamespaceAndPath("vesper_wilds", name);

        // 2. Create the ResourceKey (This is what the .build() method was asking for!)
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);

        // 3. Build and Register
        return Registry.register(
                BuiltInRegistries.ENTITY_TYPE,
                id,
                builder.build(key) // Pass the key to .build()
        );
    }

    public static void registerModEntities() {
        System.out.println("Registering Entities for vesper_wilds");
    }
}