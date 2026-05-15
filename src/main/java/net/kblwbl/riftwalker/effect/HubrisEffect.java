package net.kblwbl.riftwalker.effect;

import net.kblwbl.riftwalker.registry.ModDamageTypes;
import net.kblwbl.riftwalker.registry.ModEffects;
import net.kblwbl.riftwalker.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class HubrisEffect extends StatusEffect {

    public HubrisEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(!entity.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.CROWN_OF_HUBRIS)&&entity.hasStatusEffect(ModEffects.HUBRIS)){
            entity.damage(ModDamageTypes.create(entity, ModDamageTypes.HUBRIS_DAMAGE), (float) amplifier / 2 );
            entity.removeStatusEffect(ModEffects.HUBRIS);
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }


}
