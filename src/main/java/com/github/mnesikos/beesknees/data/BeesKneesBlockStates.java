package com.github.mnesikos.beesknees.data;

import com.github.mnesikos.beesknees.BeesKnees;
import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

public class BeesKneesBlockStates extends BlockStateProvider {
    public BeesKneesBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BeesKnees.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        beehiveBlock(BeesKneesBlocks.SPRUCE_BEEHIVE.get());
        beehiveBlock(BeesKneesBlocks.BIRCH_BEEHIVE.get());
        beehiveBlock(BeesKneesBlocks.JUNGLE_BEEHIVE.get());
        beehiveBlock(BeesKneesBlocks.ACACIA_BEEHIVE.get());
        beehiveBlock(BeesKneesBlocks.DARK_OAK_BEEHIVE.get());
        beehiveBlock(BeesKneesBlocks.MANGROVE_BEEHIVE.get());
        beehiveBlock(BeesKneesBlocks.CHERRY_BEEHIVE.get());
        beehiveBlock(BeesKneesBlocks.BAMBOO_BEEHIVE.get());
        beehiveBlock(BeesKneesBlocks.CRIMSON_BEEHIVE.get());
        beehiveBlock(BeesKneesBlocks.WARPED_BEEHIVE.get());
        overlayBeehiveBlock(BeesKneesBlocks.PINK_BEEHIVE.get(), Blocks.PINK_TERRACOTTA);
    }

    public void beehiveBlock(Block block) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();
        Function<BlockState, ModelFile> honeyModelFunc = $ -> models().orientableWithBottom(name + "_honey", modLoc("block/" + name + "_side"), modLoc("block/" + name + "_front_honey"), modLoc("block/" + name + "_end"), modLoc("block/" + name + "_end")).texture("particle", "#side");
        Function<BlockState, ModelFile> modelFunc = $ -> models().orientableWithBottom(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_front"), modLoc("block/" + name + "_end"), modLoc("block/" + name + "_end")).texture("particle", "#side");
        getVariantBuilder(block)
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(state.getValue(BlockStateProperties.LEVEL_HONEY) == 5 ? honeyModelFunc.apply(state) : modelFunc.apply(state))
                        .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
                        .build()
                );
    }

    public void overlayBeehiveBlock(Block block, Block blockTextureAll) {
        String name = ForgeRegistries.BLOCKS.getKey(block).getPath();
        Function<BlockState, ModelFile> honeyModelFunc = $ -> models().withExistingParent(name + "_honey", modLoc("block/overlay_beehive")).texture("all", blockTexture(blockTextureAll)).texture("overlayfront", modLoc("block/overlay_beehive_front_honey"));
        Function<BlockState, ModelFile> modelFunc = $ -> models().withExistingParent(name, modLoc("block/overlay_beehive")).texture("all", blockTexture(blockTextureAll));
        getVariantBuilder(block)
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(state.getValue(BlockStateProperties.LEVEL_HONEY) == 5 ? honeyModelFunc.apply(state) : modelFunc.apply(state))
                        .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
                        .build()
                );
    }
}
