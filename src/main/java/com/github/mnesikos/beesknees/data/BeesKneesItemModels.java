package com.github.mnesikos.beesknees.data;

import com.github.mnesikos.beesknees.BeesKnees;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BeesKneesItemModels extends ItemModelProvider {
    public BeesKneesItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BeesKnees.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        orientableWithBottom("birch_beehive", modLoc("block/birch_beehive_side"), modLoc("block/birch_beehive_front"), modLoc("block/birch_beehive_end"), modLoc("block/birch_beehive_end"));
    }
}
