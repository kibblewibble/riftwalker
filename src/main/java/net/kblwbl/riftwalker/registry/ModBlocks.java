package net.kblwbl.riftwalker.registry;

import net.kblwbl.riftwalker.RiftWalker;
import net.kblwbl.riftwalker.block.ModFlowerBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.block.Blocks.createFlowerPotBlock;

public class ModBlocks {

    // Transparent Block List \\
    public static List<Block> BLOCK_CUTOUT = new ArrayList<>();

    //----====((  BLOCKS  ))====----\\

    // Flower + Plant Blocks \\
    public static Block RIFT_ROSE = cutout(register("rift_rose", new ModFlowerBlock(
            ModEffects.RIFT_SICKNESS, 10, AbstractBlock.Settings.copy(Blocks.CORNFLOWER))));

    // Flower Pot \\
    public static final Block POTTED_RIFT_ROSE = cutout(registerWithoutItem("potted_rift_rose", createFlowerPotBlock(RIFT_ROSE)));


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
