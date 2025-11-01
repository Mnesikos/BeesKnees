package com.github.mnesikos.beesknees.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BKBeehiveBlockEntity extends BeehiveBlockEntity {
    public BKBeehiveBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BeesKneesBlockEntities.BEEHIVE.get();
    }
}
