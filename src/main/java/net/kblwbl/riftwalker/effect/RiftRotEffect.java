package net.kblwbl.riftwalker.effect;

import net.kblwbl.riftwalker.registry.ModAttachmentTypes;
import net.kblwbl.riftwalker.registry.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

@SuppressWarnings("UnstableApiUsage")
public class RiftRotEffect extends StatusEffect {

    public RiftRotEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(ModEffects.RIFT_SICKNESS)) {
            entity.removeStatusEffect(ModEffects.RIFT_SICKNESS);
        }
        entity.setAttached(ModAttachmentTypes.ROTTED, true);
    }
}