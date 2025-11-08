package com.github.mnesikos.beesknees.block;

import com.github.mnesikos.beesknees.BeesKnees;
import com.github.mnesikos.beesknees.item.BeesKneesItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BeesKneesBlocks {
    public static final DeferredRegister<Block> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, BeesKnees.MOD_ID);

    public static final RegistryObject<Block> SPRUCE_BEEHIVE = registerWithItem("spruce_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> BIRCH_BEEHIVE = registerWithItem("birch_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> JUNGLE_BEEHIVE = registerWithItem("jungle_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ACACIA_BEEHIVE = registerWithItem("acacia_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> DARK_OAK_BEEHIVE = registerWithItem("dark_oak_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> MANGROVE_BEEHIVE = registerWithItem("mangrove_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> CHERRY_BEEHIVE = registerWithItem("cherry_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> BAMBOO_BEEHIVE = registerWithItem("bamboo_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> CRIMSON_BEEHIVE = registerWithItem("crimson_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> WARPED_BEEHIVE = registerWithItem("warped_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));

    public static final RegistryObject<Block> PINK_BEEHIVE = registerWithItem("pink_beehive", () -> new BKBeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));

    private static <T extends Block> RegistryObject<T> registerWithItem(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = REGISTRAR.register(name, block);
        BeesKneesItems.REGISTRAR.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties()));
        return registryObject;
    }

    @OnlyIn(Dist.CLIENT)
    public static void setRenderLayers() {
        RenderType translucent = RenderType.translucent();
        ItemBlockRenderTypes.setRenderLayer(PINK_BEEHIVE.get(), translucent);
    }
}
