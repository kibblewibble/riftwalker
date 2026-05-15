package net.kblwbl.riftwalker.mixin.server;

import net.kblwbl.riftwalker.registry.ModEffects;
import net.kblwbl.riftwalker.util.effect.PermanentEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.HashSet;

@Mixin(LivingEntity.class)
public abstract class TotemMixin {
    @Redirect(method="tryUseTotem", at = @At(value="INVOKE", target = "Lnet/minecraft/entity/LivingEntity;" +
            "clearStatusEffects()Z"))
    public boolean bypassTotem(LivingEntity instance) {
        var effectArray = new HashSet<RegistryEntry<StatusEffect>>();
            effectArray.add(ModEffects.RIFT_ROT);
        return PermanentEffect.keepEffect(instance, effectArray);
    }
}