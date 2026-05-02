package net.kblwbl.riftwalker.mixin;

import net.kblwbl.riftwalker.registry.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow
    public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @Inject(method="canHaveStatusEffect", at = @At("HEAD"), cancellable = true)
    private void sicknessControl(StatusEffectInstance effect, CallbackInfoReturnable<Boolean> cir){
        if(this.hasStatusEffect(ModEffects.RIFT_ROT)) {
            cir.setReturnValue(!effect.equals(ModEffects.RIFT_SICKNESS));
        }
    }


}
