package net.kblwbl.riftwalker.util.death;

import net.kblwbl.riftwalker.registry.ModAttachmentTypes;
import net.kblwbl.riftwalker.registry.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;

@SuppressWarnings("UnstableApiUsage, unused")
public class AfterRespawn {
    public static void applyRotRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        if(Boolean.TRUE.equals(oldPlayer.getAttached(ModAttachmentTypes.ROTTED))){
            newPlayer.addStatusEffect(new StatusEffectInstance(ModEffects.RIFT_ROT, -1, 0, false, false));
        }
    }
}
//||Boolean.TRUE.equals(newPlayer.getAttached(ModAttachmentTypes.ROTTED))