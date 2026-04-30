package net.kblwbl.riftwalker.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kblwbl.riftwalker.RiftWalker;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //----====((   ITEMS   ))====----\\
    public static final Item RIFT_RIPPER = registerItem("rift_ripper",
            new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))
            )
    );

    //----====(( REGISTERS ))====----\\
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(RiftWalker.MOD_ID,  name), item);
    }

    public static void registerModItems() {
        RiftWalker.LOGGER.info("Registering items for " + RiftWalker.MOD_ID + "...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(RIFT_RIPPER);
        });
    }
}
