package net.kblwbl.riftwalker.mixin;

import net.kblwbl.riftwalker.registry.ModEffects;
import net.kblwbl.riftwalker.effect.PermanentEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.MilkBucketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;


@Mixin(MilkBucketItem.class)
public abstract class MilkBucketMixin {
    @Redirect(method="finishUsing", at=@At(value="INVOKE", target = "Lnet/minecraft/entity/LivingEntity;" +
            "clearStatusEffects()Z"))
    private boolean bypassMilkBucket(LivingEntity instance) {
        if(instance.hasStatusEffect(ModEffects.RIFT_PLAGUE)) {
            return PermanentEffect.keepEffect(instance, ModEffects.RIFT_PLAGUE);
        }
        return PermanentEffect.keepEffect(instance, ModEffects.RIFT_SICKNESS);
    }
}
