package fr.titi.infinityore.data.recipe;

import fr.titi.infinityore.init.ModBlocks;
import fr.titi.infinityore.init.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;


import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {

    public RecipeGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(ModBlocks.OSMIUM_ORE.get())
                .define('S', ModItems.OSMIUM_INGOT.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.OSMIUM_INGOT.get()))
                .save(consumer);
    }
}
