package net.kblwbl.riftwalker.util.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.HashSet;
import java.util.Iterator;

public class PermanentEffect {
    static public boolean keepEffect(LivingEntity instance, HashSet<RegistryEntry<StatusEffect>> keepEffect) {
        if (instance.getWorld().isClient) {
            return false;
        } else {
            Iterator<StatusEffectInstance> iterator = instance.getActiveStatusEffects().values().iterator();

            boolean bl;
            for (bl = false; iterator.hasNext(); bl = true) {
                StatusEffectInstance effect = iterator.next();
                if (keepEffect.contains(effect.getEffectType())) {
                    continue;
                }

                instance.onStatusEffectRemoved(effect);
                iterator.remove();
            }

            return bl;
        }
    }
}