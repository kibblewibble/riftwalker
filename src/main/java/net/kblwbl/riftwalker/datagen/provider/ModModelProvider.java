package net.kblwbl.riftwalker.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kblwbl.riftwalker.block.RiftshadeCropBlock;
import net.kblwbl.riftwalker.registry.ModBlocks;
import net.kblwbl.riftwalker.registry.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.RIFTSHADE_CROP, RiftshadeCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RIFT_RIPPER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CROWN_OF_HUBRIS, Models.GENERATED);

        itemModelGenerator.register(ModItems.RIFTSHADE_PETAL, Models.GENERATED);
    }
}
