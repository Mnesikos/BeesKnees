package com.github.mnesikos.beesknees.item;

import com.github.mnesikos.beesknees.BeesKnees;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BeesKneesItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, BeesKnees.MOD_ID);

    public static final RegistryObject<Item> EXAMPLE_ITEM = REGISTRAR.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build())));
}
