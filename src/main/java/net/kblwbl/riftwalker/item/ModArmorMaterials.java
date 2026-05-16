package net.kblwbl.riftwalker.item;

import net.kblwbl.riftwalker.RiftWalker;
import net.kblwbl.riftwalker.registry.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    @SuppressWarnings("all")
    public static final RegistryEntry<ArmorMaterial> RIFTSHADE_PETAL_ARMOR_MATERIAL = registerArmorMaterial("rift_petal",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 2);
            }), 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, () -> Ingredient.ofItems(ModItems.RIFTSHADE_PETAL),
                    List.of(new ArmorMaterial.Layer(RiftWalker.id("rift_petal"))), 0, 0));

    //----====(( REGISTERS ))====----\\
    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, RiftWalker.id(name), material.get());
    }

}
