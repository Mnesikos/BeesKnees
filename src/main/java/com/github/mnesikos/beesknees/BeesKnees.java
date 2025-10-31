package com.github.mnesikos.beesknees;

import com.github.mnesikos.beesknees.block.BeesKneesBlocks;
import com.github.mnesikos.beesknees.item.BeesKneesItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

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
        BeesKneesItems.REGISTRAR.register(bus);
        CREATIVE_MODE_TABS.register(bus);

        bus.addListener(this::setup);
        bus.addListener(this::gatherData);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void gatherData(final GatherDataEvent event) {
    }
}
