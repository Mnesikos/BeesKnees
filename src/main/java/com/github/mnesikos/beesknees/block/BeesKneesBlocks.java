package com.github.mnesikos.beesknees.block;

import com.github.mnesikos.beesknees.BeesKnees;
import com.github.mnesikos.beesknees.item.BeesKneesItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BeesKneesBlocks {
    public static final DeferredRegister<Block> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, BeesKnees.MOD_ID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = registerWithItem("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    private static <T extends Block> RegistryObject<T> registerWithItem(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = REGISTRAR.register(name, block);
        BeesKneesItems.REGISTRAR.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties()));
        return registryObject;
    }
}
