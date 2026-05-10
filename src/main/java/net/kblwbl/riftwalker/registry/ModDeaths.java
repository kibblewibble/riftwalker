package net.kblwbl.riftwalker.registry;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.kblwbl.riftwalker.function.death.AfterDeath;
import net.kblwbl.riftwalker.function.death.AfterRespawn;

public class ModDeaths {

    //----====(( REGISTERS ))====----\\
    public static void init(){
        ServerPlayerEvents.AFTER_RESPAWN.register(AfterRespawn::applyRotRespawn);
        ServerLivingEntityEvents.AFTER_DEATH.register(AfterDeath::sicknessToRot);
    }
}
