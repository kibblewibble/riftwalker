package net.kblwbl.riftwalker.item;

import net.kblwbl.riftwalker.function.effect.ModifyEffectStatus;
import net.kblwbl.riftwalker.registry.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;

public class CrownOfHubrisItem extends ArmorItem {
    public CrownOfHubrisItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    public static void increaseHubris(PlayerEntity player) {
        if (!player.hasStatusEffect(ModEffects.HUBRIS)||!player.hasStatusEffect(ModEffects.RIFT_SICKNESS)) {
            player.addStatusEffect(new StatusEffectInstance(ModEffects.HUBRIS, 20 * 60, 0, false, true));
            player.addStatusEffect(new StatusEffectInstance(ModEffects.RIFT_SICKNESS, 20 * 60, 0, false, true));
        } else {
            // Add 60 seconds and 1 level to Hubris and Rift Sickness
            ModifyEffectStatus.effectModify(player, ModEffects.HUBRIS, 1, 20 * 30, false, false);
            // Effectively makes Hubris' level the minimum level of Rift Sickness'
            ModifyEffectStatus.effectModify(player, ModEffects.RIFT_SICKNESS, player.getStatusEffect(ModEffects.HUBRIS).getAmplifier(), 20 * 30, false, false);
        }
    }
}
