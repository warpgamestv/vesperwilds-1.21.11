package com.warpgames.vesperwilds.network.packet;

import com.warpgames.vesperwilds.VesperWilds;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record VelvetEclipseSyncS2CPacket(boolean active) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<VelvetEclipseSyncS2CPacket> ID = new CustomPacketPayload.Type<>(
            Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "velvet_eclipse_sync"));

    public static final StreamCodec<RegistryFriendlyByteBuf, VelvetEclipseSyncS2CPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL,
            VelvetEclipseSyncS2CPacket::active,
            (Boolean b) -> new VelvetEclipseSyncS2CPacket(b));

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
