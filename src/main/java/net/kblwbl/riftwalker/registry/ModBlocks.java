package net.kblwbl.riftwalker.registry;

import net.kblwbl.riftwalker.RiftWalker;
import net.kblwbl.riftwalker.block.RiftshadeCropBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    // Transparent Block List \\
    public static List<Block> BLOCK_CUTOUT = new ArrayList<>();

    //----====((  BLOCKS  ))====----\\

    // Flower + Plant Blocks \\
    public static final Block RIFTSHADE_CROP = cutout(registerWithoutItem(
            "riftshade_crop",
            new RiftshadeCropBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY))
    ));


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
