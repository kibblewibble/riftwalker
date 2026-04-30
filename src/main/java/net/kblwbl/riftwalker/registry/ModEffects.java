package net.kblwbl.riftwalker.registry;

import net.kblwbl.riftwalker.RiftWalker;
import net.kblwbl.riftwalker.effect.RiftPlagueEffect;
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
                            Identifier.of(RiftWalker.MOD_ID, "rift_sickness"), -2.0,
                            EntityAttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(RiftWalker.MOD_ID, "rift_sickness"), -0.05F,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            Identifier.of(RiftWalker.MOD_ID, "rift_sickness"), -0.5,
                            EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> RIFT_PLAGUE = registerStatusEffect("rift_plague",
            new RiftPlagueEffect(StatusEffectCategory.HARMFUL, 0x1c0933)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                            Identifier.of(RiftWalker.MOD_ID, "rift_plague"), -2.0,
                            EntityAttributeModifier.Operation.ADD_VALUE));


    //----====(( REGISTERS ))====----\\
    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(RiftWalker.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        RiftWalker.LOGGER.info("Registering effects for " + RiftWalker.MOD_ID + "...");
    }
}
