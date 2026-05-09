package net.kblwbl.riftwalker.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kblwbl.riftwalker.RiftWalker;
import net.kblwbl.riftwalker.item.RiftRipperItem;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final RegistryKey<ItemGroup> RIFTWALKER_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, RiftWalker.id("riftwalker_group"));
    public static final ItemGroup RIFTWALKER_GROUP = FabricItemGroup.builder()
            .icon(() -> ModItems.RIFT_RIPPER.getDefaultStack())
            .displayName(Text.translatable("itemGroup.riftwalker"))
            .build();


    //----====((   ITEMS   ))====----\\
    public static final Item RIFT_RIPPER = register("rift_ripper",
            new RiftRipperItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))
            ));

    public static final Item RIFT_PETAL = register("rift_petal",
            new Item(new Item.Settings()));


    //----====(( REGISTERS ))====----\\
    public static void init() {  Registry.register(Registries.ITEM_GROUP, RIFTWALKER_GROUP_KEY, RIFTWALKER_GROUP);  }

    public static Item registerBlockItem(Block block) {
        return register(Registries.BLOCK.getId(block), new BlockItem(block, new Item.Settings()));
    }

    public static Item register(String id, Item item) {  return register(RiftWalker.id(id), item);  }

    public static Item register(Identifier id, Item item) {
        Item returnItem = Registry.register(Registries.ITEM, id, item);
        ItemGroupEvents.modifyEntriesEvent(RIFTWALKER_GROUP_KEY).register(itemGroup -> itemGroup.add(returnItem.getDefaultStack()));
        return returnItem;
    }
}

