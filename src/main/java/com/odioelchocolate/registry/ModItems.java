package com.odioelchocolate.registry;

import com.odioelchocolate.OdioElChocolate;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OdioElChocolate.MODID);

    public static final RegistryObject<Item> CHOCOLATE_SPAWN_EGG = ITEMS.register("chocolate_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CHOCOLATE, 0x3B1F0E, 0xC98A4B, new Item.Properties()));

    private ModItems() {
    }
}
