package com.github.mnesikos.beesknees;

import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import com.github.mnesikos.beesknees.block.entity.BeesKneesBlockEntities;
import com.github.mnesikos.beesknees.data.*;
import com.github.mnesikos.beesknees.item.BeesKneesItems;
import com.github.mnesikos.beesknees.poi.BeesKneesPoiTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.List;

@Mod(BeesKnees.MOD_ID)
public class BeesKnees {
    public static final String MOD_ID = "beesknees";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<CreativeModeTab> BEES_KNEES_GROUP = CREATIVE_MODE_TABS.register("beesknees_group", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MOD_ID + ".beesknees_group"))
            .icon(() -> BeesKneesItems.EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> BeesKneesItems.REGISTRAR.getEntries().forEach(item -> output.accept(item.get())))
            .build());

    public BeesKnees(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();

        BeesKneesBlocks.REGISTRAR.register(bus);
        BeesKneesBlockEntities.REGISTRAR.register(bus);
        BeesKneesItems.REGISTRAR.register(bus);
        CREATIVE_MODE_TABS.register(bus);

        BeesKneesPoiTypes.REGISTRAR.register(bus);

        bus.addListener(this::setup);
        bus.addListener(this::setupClient);
        bus.addListener(this::gatherData);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void setupClient(final FMLClientSetupEvent event) {
        BeesKneesBlocks.setRenderLayers();
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        dataGenerator.addProvider(event.includeClient(), new BeesKneesBlockModels(packOutput, event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeClient(), new BeesKneesBlockStates(packOutput, event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeClient(), new BeesKneesItemModels(packOutput, event.getExistingFileHelper()));

        BeesKneesTagsProviders.BeesKneesBlockTags blockTagsProvider = new BeesKneesTagsProviders.BeesKneesBlockTags(packOutput, event.getLookupProvider(), event.getExistingFileHelper());
        dataGenerator.addProvider(event.includeServer(), blockTagsProvider);
        dataGenerator.addProvider(event.includeServer(), new BeesKneesTagsProviders.BeesKneesPoiTypeTags(packOutput, event.getLookupProvider(), event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(BeesKneesLootTables::new, LootContextParamSets.BLOCK))));
        dataGenerator.addProvider(event.includeServer(), new BeesKneesRecipes(packOutput));
    }
}
