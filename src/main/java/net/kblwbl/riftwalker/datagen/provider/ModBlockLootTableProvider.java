package net.kblwbl.riftwalker.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kblwbl.riftwalker.block.RiftshadeCropBlock;
import net.kblwbl.riftwalker.registry.ModBlocks;
import net.kblwbl.riftwalker.registry.ModItems;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        // Drops Itself \\
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.RIFTSHADE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(RiftshadeCropBlock.AGE, 8));

        addDrop(ModBlocks.RIFTSHADE_CROP, cropDrops(ModBlocks.RIFTSHADE_CROP, ModItems.RIFTSHADE_PETAL, ModItems.RIFTSHADE_SEEDS, builder));
    }
}
