package net.kblwbl.riftwalker.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.Iterator;

public class PermanentEffect {
    static public boolean keepEffect(LivingEntity instance, RegistryEntry<StatusEffect> keepEffect) {
        if (instance.getWorld().isClient) {
            return false;
        } else {
            Iterator<StatusEffectInstance> iterator = instance.getActiveStatusEffects().values().iterator();

            boolean bl;
            for (bl = false; iterator.hasNext(); bl = true) {
                StatusEffectInstance effect = iterator.next();
                if (effect.getEffectType().equals(keepEffect)) {
                    continue;
                }
//
//                instance.onStatusEffectRemoved(effect);
                iterator.remove();
            }

            return bl;
        }
    }
}