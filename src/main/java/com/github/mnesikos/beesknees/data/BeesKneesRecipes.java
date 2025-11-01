package com.github.mnesikos.beesknees.data;

import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BeesKneesRecipes extends RecipeProvider {
    public BeesKneesRecipes(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BeesKneesBlocks.BIRCH_BEEHIVE.get()).unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
                .pattern("PPP").pattern("HHH").pattern("PPP")
                .define('P', Blocks.BIRCH_PLANKS)
                .define('H', Items.HONEYCOMB)
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.BEEHIVE).unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
                .pattern("PPP").pattern("HHH").pattern("PPP")
                .define('P', Blocks.OAK_PLANKS)
                .define('H', Items.HONEYCOMB)
                .save(consumer);
    }
}
