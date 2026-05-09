package net.kblwbl.riftwalker.registry;

import net.kblwbl.riftwalker.RiftWalker;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {


    //----====(( REGISTERS ))====----\\
    public static void init() {}

    public static SoundEvent register(String name){
        Identifier id = RiftWalker.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
