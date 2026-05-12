package net.kblwbl.riftwalker.util.modify;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.kblwbl.riftwalker.registry.ModItems;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier SNIFFER_DIGGING_GAMEPLAY
            = Identifier.of("minecraft", "gameplay/sniffer_digging");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(SNIFFER_DIGGING_GAMEPLAY.equals(key.getValue())) {
                tableBuilder.modifyPools(pool -> pool
                        .with(ItemEntry.builder(ModItems.RIFT_PETAL))

                );
            }

        });
    }
}