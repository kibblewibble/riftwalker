package net.kblwbl.riftwalker;

import net.fabricmc.api.ModInitializer;

import net.kblwbl.riftwalker.registry.ModDataComponents;
import net.kblwbl.riftwalker.registry.ModEffects;
import net.kblwbl.riftwalker.registry.ModItemGroups;
import net.kblwbl.riftwalker.registry.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RiftWalker implements ModInitializer {
    public static final String MOD_ID = "riftwalker";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();

        ModEffects.registerEffects();
        ModDataComponents.registerDataComponentTypes();
    }
}