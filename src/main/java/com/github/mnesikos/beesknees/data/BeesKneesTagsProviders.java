package com.github.mnesikos.beesknees.data;

import com.github.mnesikos.beesknees.BeesKnees;
import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import com.github.mnesikos.beesknees.poi.BeesKneesPoiTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BeesKneesTagsProviders {
    public static class BeesKneesBlockTags extends BlockTagsProvider {
        public BeesKneesBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, BeesKnees.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(BlockTags.MINEABLE_WITH_AXE).add(
                    BeesKneesBlocks.BIRCH_BEEHIVE.get()
            );
            tag(BlockTags.BEEHIVES).add(
                    BeesKneesBlocks.BIRCH_BEEHIVE.get()
            );
        }
    }

    public static class BeesKneesPoiTypeTags extends PoiTypeTagsProvider {
        public BeesKneesPoiTypeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, BeesKnees.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(PoiTypeTags.BEE_HOME).add(BeesKneesPoiTypes.BEEHIVE.getKey());
        }
    }
}
