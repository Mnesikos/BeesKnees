package com.github.mnesikos.beesknees.poi;

import com.github.mnesikos.beesknees.BeesKnees;
import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Collectors;

public class BeesKneesPoiTypes {
    public static final DeferredRegister<PoiType> REGISTRAR = DeferredRegister.create(ForgeRegistries.POI_TYPES, BeesKnees.MOD_ID);

    public static final RegistryObject<PoiType> BEEHIVE = REGISTRAR.register("beehive", () -> new PoiType(getBlockStates(Set.of(
            BeesKneesBlocks.SPRUCE_BEEHIVE.get(), BeesKneesBlocks.BIRCH_BEEHIVE.get(), BeesKneesBlocks.JUNGLE_BEEHIVE.get(), BeesKneesBlocks.ACACIA_BEEHIVE.get(),
            BeesKneesBlocks.DARK_OAK_BEEHIVE.get(), BeesKneesBlocks.MANGROVE_BEEHIVE.get(), BeesKneesBlocks.CHERRY_BEEHIVE.get(), BeesKneesBlocks.BAMBOO_BEEHIVE.get(),
            BeesKneesBlocks.CRIMSON_BEEHIVE.get(), BeesKneesBlocks.WARPED_BEEHIVE.get(),
            BeesKneesBlocks.PINK_BEEHIVE.get())),
            0, 1));

    private static Set<BlockState> getBlockStates(Set<Block> blocks) {
        return blocks.stream().flatMap(block -> block.getStateDefinition().getPossibleStates().stream()).collect(Collectors.toUnmodifiableSet());
    }
}
