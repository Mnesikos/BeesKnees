package com.github.mnesikos.beesknees.block.entity;

import com.github.mnesikos.beesknees.BeesKnees;
import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BeesKneesBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BeesKnees.MOD_ID);

    public static final RegistryObject<BlockEntityType<BKBeehiveBlockEntity>> BEEHIVE = REGISTRAR.register("beehive", () -> BlockEntityType.Builder.of(BKBeehiveBlockEntity::new,
            BeesKneesBlocks.SPRUCE_BEEHIVE.get(), BeesKneesBlocks.BIRCH_BEEHIVE.get(), BeesKneesBlocks.JUNGLE_BEEHIVE.get(), BeesKneesBlocks.ACACIA_BEEHIVE.get(),
            BeesKneesBlocks.DARK_OAK_BEEHIVE.get(), BeesKneesBlocks.MANGROVE_BEEHIVE.get(), BeesKneesBlocks.CHERRY_BEEHIVE.get(), BeesKneesBlocks.BAMBOO_BEEHIVE.get(),
            BeesKneesBlocks.CRIMSON_BEEHIVE.get(), BeesKneesBlocks.WARPED_BEEHIVE.get(),
            BeesKneesBlocks.PINK_BEEHIVE.get()
    ).build(null));
}
