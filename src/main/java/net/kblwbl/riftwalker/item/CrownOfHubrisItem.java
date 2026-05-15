package net.kblwbl.riftwalker.item;

import net.kblwbl.riftwalker.util.effect.ModifyEffectStatus;
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
        if (!player.hasStatusEffect(ModEffects.HUBRIS)) {
            player.addStatusEffect(new StatusEffectInstance(ModEffects.HUBRIS, 20 * 60, 0, false, true));
        } else {
            // Add 60 seconds and 1 level to Hubris
            ModifyEffectStatus.effectModify(player, ModEffects.HUBRIS, 1, 20 * 30, false, false);
        }
    }
}
