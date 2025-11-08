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
        woodenBeehive(consumer, BeesKneesBlocks.SPRUCE_BEEHIVE.get(), Blocks.SPRUCE_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.BIRCH_BEEHIVE.get(), Blocks.BIRCH_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.JUNGLE_BEEHIVE.get(), Blocks.JUNGLE_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.ACACIA_BEEHIVE.get(), Blocks.ACACIA_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.DARK_OAK_BEEHIVE.get(), Blocks.DARK_OAK_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.MANGROVE_BEEHIVE.get(), Blocks.MANGROVE_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.CHERRY_BEEHIVE.get(), Blocks.CHERRY_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.BAMBOO_BEEHIVE.get(), Blocks.BAMBOO_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.CRIMSON_BEEHIVE.get(), Blocks.CRIMSON_PLANKS);
        woodenBeehive(consumer, BeesKneesBlocks.WARPED_BEEHIVE.get(), Blocks.WARPED_PLANKS);
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
