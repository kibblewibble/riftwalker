package net.kblwbl.riftwalker.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kblwbl.riftwalker.RiftWalker;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //----====((   GROUPS   ))====----\\
    public static final ItemGroup RIFTWALKER_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RiftWalker.MOD_ID, "riftwalker_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RIFT_RIPPER))
                    .displayName(Text.translatable("itemgroup.riftwalker.riftwalker_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RIFT_RIPPER);
                    }).build());

    //----====(( REGISTERS ))====----\\
    public static void registerItemGroups() {
        RiftWalker.LOGGER.info("Registering Item groups for " + RiftWalker.MOD_ID + "...");
    }
}
