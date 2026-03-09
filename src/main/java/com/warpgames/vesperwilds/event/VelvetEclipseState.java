package com.warpgames.vesperwilds.event;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import net.minecraft.world.level.storage.DimensionDataStorage;

public class VelvetEclipseState extends SavedData {
    public boolean active = false;
    public long lastDayChecked = -1;

    public static final Codec<VelvetEclipseState> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    Codec.BOOL.fieldOf("active").forGetter(s -> s.active),
                    Codec.LONG.fieldOf("lastDayChecked").forGetter(s -> s.lastDayChecked))
                    .apply(instance, (active, lastDayChecked) -> {
                        VelvetEclipseState state = new VelvetEclipseState();
                        state.active = active;
                        state.lastDayChecked = lastDayChecked;
                        return state;
                    }));

    public static final SavedDataType<VelvetEclipseState> TYPE = new SavedDataType<>(
            "vesperwilds_velvet_eclipse",
            VelvetEclipseState::new,
            CODEC,
            DataFixTypes.SAVED_DATA_COMMAND_STORAGE);

    public VelvetEclipseState() {
    }

    public static VelvetEclipseState getServerState(MinecraftServer server) {
        // We save the event in the Overworld's data storage, as the eclipse is an
        // Overworld event
        DimensionDataStorage storage = server.overworld().getDataStorage();
        return storage.computeIfAbsent(TYPE);
    }
}
