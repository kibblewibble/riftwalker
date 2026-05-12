package net.kblwbl.riftwalker.function.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.Objects;

public class ModifyEffectStatus {
    public static void effectModify(PlayerEntity entity, RegistryEntry<StatusEffect> statusEffect, int amplifierModifier, int durationModifier, boolean overwriteDuration, boolean overwriteAmplifier){
        int amplifier = Objects.requireNonNull(entity.getStatusEffect(statusEffect)).getAmplifier();
        int duration = Objects.requireNonNull(entity.getStatusEffect(statusEffect)).getDuration();
        boolean ambient = Objects.requireNonNull(entity.getStatusEffect(statusEffect)).isAmbient();
        boolean visible = Objects.requireNonNull(entity.getStatusEffect(statusEffect)).shouldShowParticles();

        // if overwriteDuration == true, set durationModifier to the new duration, else, add durationModifier to duration
        duration = !overwriteDuration ? duration + durationModifier : durationModifier;
        amplifier = !overwriteAmplifier ? amplifier + amplifierModifier : amplifierModifier;

        entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, amplifier, ambient, visible));
    }
}
