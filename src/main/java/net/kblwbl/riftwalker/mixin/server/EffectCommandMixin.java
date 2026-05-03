package net.kblwbl.riftwalker.mixin.server;

import net.kblwbl.riftwalker.registry.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.command.EffectCommand;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;
import java.util.Objects;

import static net.kblwbl.riftwalker.registry.ModAttachmentTypes.PLAGUED;

@Mixin(EffectCommand.class)
public class EffectCommandMixin {

    @SuppressWarnings("UnstableApiUsage")
    @Inject(method = "executeClear*", at = @At("TAIL"), cancellable = true)
    private static boolean clearRiftRot(ServerCommandSource source, Collection<? extends Entity> targets, RegistryEntry<StatusEffect> statusEffect, CallbackInfoReturnable<Boolean> cir) {
        for (Entity entity : targets) {
            if (entity instanceof LivingEntity && ((LivingEntity) entity).clearStatusEffects()) {
                if (statusEffect == ModEffects.RIFT_ROT) {
                    Objects.requireNonNull(MinecraftClient.getInstance().getNetworkHandler()).sendChatMessage("Hello from Fabric mod!");
                    cir.setReturnValue(entity.setAttached(PLAGUED, false));
                }
            }
        }
        return true;
    }
}

