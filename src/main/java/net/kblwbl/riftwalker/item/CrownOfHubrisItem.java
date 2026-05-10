package net.kblwbl.riftwalker.item;

import net.kblwbl.riftwalker.function.effect.AmplifyEffect;
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

    public static void increaseHubris(PlayerEntity player){
        if(!player.hasStatusEffect(ModEffects.HUBRIS)){
            player.addStatusEffect(new StatusEffectInstance(ModEffects.HUBRIS, 2*60, 0, false, true));
        } else {
            AmplifyEffect.increaseAmplifier(player, ModEffects.HUBRIS, 1, 60, false);
        }
    }
}
