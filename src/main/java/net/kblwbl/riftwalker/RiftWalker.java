package net.kblwbl.riftwalker;

import net.fabricmc.api.ModInitializer;

import net.kblwbl.riftwalker.registry.*;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RiftWalker implements ModInitializer {
    public static final String MOD_ID = "riftwalker";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.init();

        ModEffects.init();
        ModDataComponents.init();
        ModAttachmentTypes.init();
        ModSounds.init();
        ModDamageTypes.init();

        ModCommands.init();
    }

    // riftwalker:path_name
    public static Identifier id(String name) {
        return Identifier.of(MOD_ID, name);
    }
}