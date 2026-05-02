package net.kblwbl.riftwalker.registry;

import net.kblwbl.riftwalker.RiftWalker;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModDamageTypes {
    public static void init(){}

    //----====((DAMAGE TYPES))====----\\
    public static final RegistryKey<DamageType> RIFT_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, RiftWalker.id("rift_damage"));

    //----====(( REGISTERS ))====----\\
    public static DamageSource create(LivingEntity entity, RegistryKey<DamageType> key) {
        return new DamageSource(entity.getWorld().getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}