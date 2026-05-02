package net.kblwbl.riftwalker.mixin;

import net.kblwbl.riftwalker.registry.ModEffects;
import net.kblwbl.riftwalker.effect.PermanentEffect;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public abstract class TotemMixin {
    @Redirect(method="tryUseTotem", at = @At(value="INVOKE", target="Lnet/minecraft/entity/LivingEntity;" +
            "clearStatusEffects()Z"))
    public boolean bypassTotem(LivingEntity instance) {
        return PermanentEffect.keepEffect(instance, ModEffects.RIFT_ROT);
    }
}