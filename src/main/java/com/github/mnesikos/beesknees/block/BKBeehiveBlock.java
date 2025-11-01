package com.github.mnesikos.beesknees.block;

import com.github.mnesikos.beesknees.block.entity.BeesKneesBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BKBeehiveBlock extends BeehiveBlock {
    public BKBeehiveBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BeesKneesBlockEntities.BEEHIVE.get().create(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> entityType) {
        return level.isClientSide ? null : createTickerHelper(entityType, BeesKneesBlockEntities.BEEHIVE.get(), BeehiveBlockEntity::serverTick);
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative() && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof BeehiveBlockEntity) {
                BeehiveBlockEntity beehiveblockentity = (BeehiveBlockEntity) blockentity;
                ItemStack itemstack = new ItemStack(this);
                int i = state.getValue(HONEY_LEVEL);
                boolean flag = !beehiveblockentity.isEmpty();
                if (flag || i > 0) {
                    if (flag) {
                        CompoundTag compoundtag = new CompoundTag();
                        compoundtag.put("Bees", beehiveblockentity.writeBees());
                        BlockItem.setBlockEntityData(itemstack, BeesKneesBlockEntities.BEEHIVE.get(), compoundtag);
                    }

                    CompoundTag compoundtag1 = new CompoundTag();
                    compoundtag1.putInt("honey_level", i);
                    itemstack.addTagElement("BlockStateTag", compoundtag1);
                    ItemEntity itementity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), itemstack);
                    itementity.setDefaultPickUpDelay();
                    level.addFreshEntity(itementity);
                }
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }
}
