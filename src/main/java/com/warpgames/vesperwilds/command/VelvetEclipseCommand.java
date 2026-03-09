package com.warpgames.vesperwilds.command;

import com.mojang.brigadier.CommandDispatcher;
import com.warpgames.vesperwilds.event.VelvetEclipseManager;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class VelvetEclipseCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            registerCommand(dispatcher);
        });
    }

    private static void registerCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("velvet_eclipse")
                .then(Commands.literal("start")
                        .executes(context -> {
                            VelvetEclipseManager.startEclipse(context.getSource().getLevel());
                            context.getSource().sendSuccess(() -> Component.literal("Started The Velvet Eclipse"),
                                    true);
                            return 1;
                        }))
                .then(Commands.literal("stop")
                        .executes(context -> {
                            VelvetEclipseManager.stopEclipse(context.getSource().getLevel());
                            context.getSource().sendSuccess(() -> Component.literal("Stopped The Velvet Eclipse"),
                                    true);
                            return 1;
                        })));
    }
}
