package com.github.mnesikos.beesknees.data;

import com.github.mnesikos.beesknees.BeesKnees;
import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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
        beehiveBlock(BeesKneesBlocks.BIRCH_BEEHIVE.get());
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
}
