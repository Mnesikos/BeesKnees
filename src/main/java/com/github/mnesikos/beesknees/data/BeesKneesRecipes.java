package com.github.mnesikos.beesknees.data;

import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BeesKneesRecipes extends RecipeProvider {
    public BeesKneesRecipes(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        woodenBeehive(consumer, Blocks.BEEHIVE, Blocks.OAK_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.BIRCH_BEEHIVE.get(), Blocks.BIRCH_PLANKS);
        coloredBeehive(consumer, BeesKneesBlocks.PINK_BEEHIVE.get().asItem(), Items.PINK_DYE);
    }

    protected static void woodenBeehive(Consumer<FinishedRecipe> consumer, ItemLike woodenBeehive, ItemLike planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, woodenBeehive).group("beehive").unlockedBy("has_honeycomb", has(Items.HONEYCOMB))
                .pattern("PPP").pattern("HHH").pattern("PPP")
                .define('P', planks).define('H', Items.HONEYCOMB).save(consumer);
    }

    protected static void coloredBeehive(Consumer<FinishedRecipe> consumer, ItemLike coloredBeehive, ItemLike dyeItem) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, coloredBeehive).group("beehive").unlockedBy(getHasName(dyeItem), has(dyeItem))
                .requires(Ingredient.of(Items.BEEHIVE, BeesKneesBlocks.BIRCH_BEEHIVE.get().asItem()))
                .requires(dyeItem).save(consumer);
    }
}
