package net.kblwbl.riftwalker.registry;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.kblwbl.riftwalker.function.respawn.AfterRespawn;

public class ModRespawn {
    public static void init(){
        ServerPlayerEvents.AFTER_RESPAWN.register(AfterRespawn::applyRotRespawn);
    }
}
