package com.warpgames.vesperwilds.worldgen.tree;

import com.warpgames.vesperwilds.VesperWilds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class ModTreeDecoratorTypes {
    public static final TreeDecoratorType<EmberFungusTreeDecorator> EMBER_FUNGUS =
            Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE,
                    Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "ember_fungus"),
                    new TreeDecoratorType<>(EmberFungusTreeDecorator.CODEC)); // This should now match perfectly

    public static void register() {
        // Called in ModInitializer
    }
}