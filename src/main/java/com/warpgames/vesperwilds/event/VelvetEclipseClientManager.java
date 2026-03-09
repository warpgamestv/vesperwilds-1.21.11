package com.warpgames.vesperwilds.event;

public class VelvetEclipseClientManager {
    private static boolean ACTIVE = false;

    public static void setEclipseActive(boolean active) {
        ACTIVE = active;
    }

    public static boolean isEclipseActive() {
        return ACTIVE;
    }
}
