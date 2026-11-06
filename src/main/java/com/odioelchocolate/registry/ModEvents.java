package com.odioelchocolate.registry;

import com.odioelchocolate.OdioElChocolate;
import com.odioelchocolate.entity.ChocolateEntity;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OdioElChocolate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEvents {
    private ModEvents() {
    }

    @SubscribeEvent
    public static void onAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CHOCOLATE.get(), ChocolateEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void onCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.CHOCOLATE_SPAWN_EGG.get());
        }
    }
}
