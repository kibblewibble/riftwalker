package net.kblwbl.riftwalker;

import net.fabricmc.api.ClientModInitializer;

public class RiftWalkerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RiftWalker.LOGGER.info("THE RIFTWALKER IS ALIIIVEEE!!!!");
    }
}