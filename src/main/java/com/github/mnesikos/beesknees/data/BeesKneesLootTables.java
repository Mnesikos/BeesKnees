package com.github.mnesikos.beesknees.data;

import com.github.mnesikos.beesknees.BeesKnees;
import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyBlockState;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.stream.Collectors;

public class BeesKneesLootTables extends VanillaBlockLoot {
    @Override
    protected void generate() {
        add(BeesKneesBlocks.BIRCH_BEEHIVE.get(), BlockLootSubProvider::createBeeHiveDrop);
        add(BeesKneesBlocks.PINK_BEEHIVE.get(), BlockLootSubProvider::createBeeHiveDrop);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(BeesKnees.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
