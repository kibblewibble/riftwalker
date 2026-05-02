package net.kblwbl.riftwalker.effect;

import net.kblwbl.riftwalker.registry.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class RiftSicknessEffect extends StatusEffect {

    public RiftSicknessEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier){
        // if effect level is 5 or greater
        if(amplifier >= 4){
            entity.damage(ModDamageTypes.create(entity, ModDamageTypes.RIFT_DAMAGE), 1.0F);
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
