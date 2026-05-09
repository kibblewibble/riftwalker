package net.kblwbl.riftwalker.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kblwbl.riftwalker.registry.ModBlocks;
import net.kblwbl.riftwalker.registry.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RIFT_PETAL, 4)
                .input(ModBlocks.RIFT_ROSE)
                .criterion("has_rift_rose", conditionsFromItem(ModBlocks.RIFT_ROSE))
                .offerTo(exporter);

//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RIFT_RIPPER)
//                .pattern("N")
//                .input('N', Items.BEDROCK)
//                .criterion(hasItem(Items.BEDROCK), conditionsFromItem(Items.BEDROCK))
//                .offerTo(exporter);
    }
}
