package eu.pixelstube.cloud.bootstrap.bungeecord.events;

import eu.pixelstube.cloud.service.ICloudService;
import net.md_5.bungee.api.plugin.Event;

/**
 * This file was created by Max H. (Haizoooon)
 * Date: 29.05.2021
 * Copyright© 2021 Max H.
 **/
public class BungeeCloudServiceUpdateEvent extends Event {

    private final ICloudService cloudService;

    public BungeeCloudServiceUpdateEvent(ICloudService cloudService) {
        this.cloudService = cloudService;
    }

    public ICloudService getCloudService() {
        return cloudService;
    }
}
