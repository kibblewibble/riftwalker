package net.kblwbl.riftwalker.mixin.server;

import net.kblwbl.riftwalker.registry.ModEffects;
import net.kblwbl.riftwalker.util.effect.PermanentEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.MilkBucketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;


@Mixin(MilkBucketItem.class)
public abstract class MilkBucketMixin {
    @Redirect(method="finishUsing", at = @At(value="INVOKE", target = "Lnet/minecraft/entity/LivingEntity;" +
            "clearStatusEffects()Z"))
    private boolean bypassMilkBucket(LivingEntity instance) {
        PermanentEffect.keepEffect(instance, ModEffects.RIFT_ROT);
        PermanentEffect.keepEffect(instance, ModEffects.RIFT_SICKNESS);
        PermanentEffect.keepEffect(instance, ModEffects.HUBRIS);

        return true;
    }
}
