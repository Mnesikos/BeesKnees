package com.github.mnesikos.beesknees.data;

import com.github.mnesikos.beesknees.BeesKnees;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BeesKneesBlockModels extends BlockModelProvider {
    public BeesKneesBlockModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BeesKnees.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
