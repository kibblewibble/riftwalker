package net.kblwbl.riftwalker.mixin.server;

import net.kblwbl.riftwalker.item.CrownOfHubrisItem;
import net.kblwbl.riftwalker.registry.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin{

    @Shadow public abstract PlayerInventory getInventory();

    @Inject(method="onKilledOther", at = @At("HEAD"), cancellable = true)
    public void killPlayerCheck(ServerWorld world, LivingEntity other, CallbackInfoReturnable<Boolean> cir){
        if(other.isPlayer() && this.getInventory().getArmorStack(3).isOf(ModItems.CROWN_OF_HUBRIS)){
            CrownOfHubrisItem.increaseHubris((PlayerEntity)(Object)this);
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
