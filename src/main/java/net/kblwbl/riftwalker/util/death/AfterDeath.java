package net.kblwbl.riftwalker.util.death;

import net.kblwbl.riftwalker.registry.ModAttachmentTypes;
import net.kblwbl.riftwalker.registry.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

@SuppressWarnings("UnstableApiUsage")
public class AfterDeath {
    public static void sicknessToRot(LivingEntity entity, DamageSource damageSource){
        if(damageSource.isOf(ModDamageTypes.RIFT_DAMAGE)){
              entity.setAttached(ModAttachmentTypes.ROTTED, true);
        }
    }
}
