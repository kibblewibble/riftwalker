package net.kblwbl.riftwalker.registry;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.kblwbl.riftwalker.function.deaths.AfterDeath;
import net.kblwbl.riftwalker.function.deaths.AfterRespawn;

public class ModDeaths {
    public static void init(){
        ServerPlayerEvents.AFTER_RESPAWN.register(AfterRespawn::applyRotRespawn);
        ServerLivingEntityEvents.AFTER_DEATH.register(AfterDeath::sicknessToRot);
    }
}
