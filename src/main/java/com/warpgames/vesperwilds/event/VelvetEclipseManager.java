package com.warpgames.vesperwilds.event;

import com.warpgames.vesperwilds.VesperWilds;
import com.warpgames.vesperwilds.network.packet.VelvetEclipseSyncS2CPacket;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

public class VelvetEclipseManager {
    // We now use VelvetEclipseState for persistent data.
    // We still keep a transient ACTIVE flag for fast client checks and server
    // queries without Level context.
    private static boolean ACTIVE = false;

    public static void init() {
        ServerTickEvents.END_WORLD_TICK.register(level -> {
            if (level.dimension() == Level.OVERWORLD) {
                tickEclipse(level);
            }
        });

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            // Load state when server starts/player joins
            VelvetEclipseState state = VelvetEclipseState.getServerState(server);
            ACTIVE = state.active;
            ServerPlayNetworking.send(handler.player, new VelvetEclipseSyncS2CPacket(ACTIVE));
        });

        net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.SERVER_STOPPED.register(server -> {
            ACTIVE = false;
        });
    }

    private static void tickEclipse(ServerLevel level) {
        long totalTime = level.getDayTime();
        long currentDay = totalTime / 24000L;
        long timeOfDay = totalTime % 24000L;

        VelvetEclipseState state = VelvetEclipseState.getServerState(level.getServer());
        ACTIVE = state.active; // Keep the fast check in sync

        // During the morning (0 to 1000 ticks), roll for eclipse if we haven't today
        if (currentDay > state.lastDayChecked && timeOfDay >= 0 && timeOfDay < 1000) {
            state.lastDayChecked = currentDay;
            state.setDirty();

            // 5% chance for a Velvet Eclipse to start
            if (level.random.nextFloat() < 0.05f) {
                startEclipse(level);
            }
        }

        // The eclipse ends exactly when night hits (13000 ticks)
        if (ACTIVE && timeOfDay >= 13000L) {
            stopEclipse(level);
        }
    }

    public static void startEclipse(ServerLevel level) {
        VelvetEclipseState state = VelvetEclipseState.getServerState(level.getServer());
        if (!state.active) {
            state.active = true;
            state.setDirty();
            ACTIVE = true;

            for (ServerPlayer player : level.players()) {
                ServerPlayNetworking.send(player, new VelvetEclipseSyncS2CPacket(true));
            }
            VesperWilds.LOGGER.info("The Velvet Eclipse has begun over the Overworld!");
        }
    }

    public static void stopEclipse(ServerLevel level) {
        VelvetEclipseState state = VelvetEclipseState.getServerState(level.getServer());
        if (state.active) {
            state.active = false;
            state.setDirty();
            ACTIVE = false;

            for (ServerPlayer player : level.players()) {
                ServerPlayNetworking.send(player, new VelvetEclipseSyncS2CPacket(false));
            }
            VesperWilds.LOGGER.info("The Velvet Eclipse has ended, night resumes its natural course.");
        }
    }

    public static boolean isEclipseActive() {
        return ACTIVE;
    }
}
