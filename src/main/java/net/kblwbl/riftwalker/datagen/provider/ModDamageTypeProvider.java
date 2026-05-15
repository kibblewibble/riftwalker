package net.kblwbl.riftwalker.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kblwbl.riftwalker.registry.ModDamageTypes;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModDamageTypeProvider extends FabricTagProvider<DamageType> {
    public ModDamageTypeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.DAMAGE_TYPE, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(DamageTypeTags.BYPASSES_ARMOR)
                .addOptional(ModDamageTypes.RIFT_DAMAGE)
                .addOptional(ModDamageTypes.HUBRIS_DAMAGE);
        getOrCreateTagBuilder(DamageTypeTags.BYPASSES_ENCHANTMENTS)
                .addOptional(ModDamageTypes.RIFT_DAMAGE)
                .addOptional(ModDamageTypes.HUBRIS_DAMAGE);
        getOrCreateTagBuilder(DamageTypeTags.NO_KNOCKBACK)
                .addOptional(ModDamageTypes.RIFT_DAMAGE)
                .addOptional(ModDamageTypes.HUBRIS_DAMAGE);
        getOrCreateTagBuilder(DamageTypeTags.BYPASSES_EFFECTS)
                .addOptional(ModDamageTypes.RIFT_DAMAGE)
                .addOptional(ModDamageTypes.HUBRIS_DAMAGE);
    }
}