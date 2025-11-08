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
        beehive("spruce_beehive");
        beehive("birch_beehive");
        beehive("jungle_beehive");
        beehive("acacia_beehive");
        beehive("dark_oak_beehive");
        beehive("mangrove_beehive");
        beehive("cherry_beehive");
        beehive("bamboo_beehive");
        beehive("crimson_beehive");
        beehive("warped_beehive");
        coloredTerracottaBeehive("pink_beehive");
    }

    public void beehive(String name) {
        orientableWithBottom(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_front"), modLoc("block/" + name + "_end"), modLoc("block/" + name + "_end"));
    }

    public void coloredTerracottaBeehive(String name) {
        withExistingParent(name, modLoc("block/overlay_beehive")).texture("all", mcLoc("block/" + name.split("_beehive")[0] + "_terracotta"));
    }
}
