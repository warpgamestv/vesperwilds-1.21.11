package com.warpgames.vesperwilds.entity.client;

import com.warpgames.vesperwilds.VesperWilds;
import com.warpgames.vesperwilds.entity.custom.GloomStalkerEntity;
import net.minecraft.resources.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GloomStalkerModel extends DefaultedEntityGeoModel<GloomStalkerEntity> {
    public GloomStalkerModel() {
        super(Identifier.fromNamespaceAndPath(VesperWilds.MOD_ID, "gloom_stalker"));
    }
}
