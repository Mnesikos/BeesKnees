package com.github.mnesikos.beesknees.block.entity;

import com.github.mnesikos.beesknees.BeesKnees;
import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BeesKneesBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BeesKnees.MOD_ID);

    public static final RegistryObject<BlockEntityType<BKBeehiveBlockEntity>> BEEHIVE = REGISTRAR.register("beehive", () -> BlockEntityType.Builder.of(BKBeehiveBlockEntity::new, BeesKneesBlocks.BIRCH_BEEHIVE.get()).build(null));
}
