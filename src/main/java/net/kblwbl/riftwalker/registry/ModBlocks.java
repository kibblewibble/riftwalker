package net.kblwbl.riftwalker.registry;

import net.kblwbl.riftwalker.RiftWalker;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    // Transparent block list \\
    public static List<Block> BLOCK_CUTOUT = new ArrayList<>();

    //----====((  BLOCKS  ))====----\\



    //----====(( REGISTERS ))====----\\
    public static void init() {}

    public static Block register(String id, Block block) {
        block = registerWithoutItem(id, block);
        ModItems.registerBlockItem(block);
        return block;
    }

    public static Block registerWithoutItem(String id, Block block) {
        return Registry.register(Registries.BLOCK, RiftWalker.id(id), block);
    }

    private static Block cutout(Block block) {
        BLOCK_CUTOUT.add(block);
        return block;
    }
}
