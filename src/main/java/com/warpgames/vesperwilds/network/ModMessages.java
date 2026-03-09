package com.warpgames.vesperwilds.network;

import com.warpgames.vesperwilds.network.packet.VelvetEclipseSyncS2CPacket;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class ModMessages {
    public static void registerS2CPackets() {
        PayloadTypeRegistry.playS2C().register(VelvetEclipseSyncS2CPacket.ID, VelvetEclipseSyncS2CPacket.CODEC);
    }
}
