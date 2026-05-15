package net.kblwbl.riftwalker.registry;

import net.kblwbl.riftwalker.RiftWalker;
import net.kblwbl.riftwalker.effect.HubrisEffect;
import net.kblwbl.riftwalker.effect.RiftRotEffect;
import net.kblwbl.riftwalker.effect.RiftSicknessEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    //----====((  EFFECTS  ))====----\\
    public static final RegistryEntry<StatusEffect> RIFT_SICKNESS = registerStatusEffect("rift_sickness",
            new RiftSicknessEffect(StatusEffectCategory.HARMFUL, 0x311257)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                            Identifier.of(RiftWalker.MOD_ID, "rift_sickness"), -2.0F,
                            EntityAttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(RiftWalker.MOD_ID, "rift_sickness"), -0.05F,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            Identifier.of(RiftWalker.MOD_ID, "rift_sickness"), -0.5F,
                            EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> RIFT_ROT = registerStatusEffect("rift_rot",
            new RiftRotEffect(StatusEffectCategory.HARMFUL, 0x1c0933)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                            Identifier.of(RiftWalker.MOD_ID, "rift_rot"), -2.0F,
                            EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> HUBRIS = registerStatusEffect("hubris",
            new HubrisEffect(StatusEffectCategory.HARMFUL, 0x1c0933)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            Identifier.of(RiftWalker.MOD_ID, "hubris"), 1F,
                            EntityAttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                        Identifier.of(RiftWalker.MOD_ID, "hubris"), -2.0F,
                        EntityAttributeModifier.Operation.ADD_VALUE));


    //----====(( REGISTERS ))====----\\
    public static void init() {}

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, RiftWalker.id(name), statusEffect);
    }
}
