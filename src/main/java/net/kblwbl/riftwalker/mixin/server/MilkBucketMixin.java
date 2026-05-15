package net.kblwbl.riftwalker.mixin.server;

import net.kblwbl.riftwalker.registry.ModEffects;
import net.kblwbl.riftwalker.util.effect.PermanentEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import java.util.HashSet;


@Mixin(MilkBucketItem.class)
public abstract class MilkBucketMixin {
    @Redirect(method="finishUsing", at = @At(value="INVOKE", target = "Lnet/minecraft/entity/LivingEntity;" +
            "clearStatusEffects()Z"))
    private boolean bypassMilkBucket(LivingEntity instance) {
        var effectArray = new HashSet<RegistryEntry<StatusEffect>>();
            effectArray.add(ModEffects.HUBRIS);
            effectArray.add(ModEffects.RIFT_SICKNESS);
            effectArray.add(ModEffects.RIFT_ROT);
        PermanentEffect.keepEffect(instance, effectArray);



        return true;
    }
}
