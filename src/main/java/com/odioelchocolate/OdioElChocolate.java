package com.odioelchocolate;

import com.mojang.logging.LogUtils;
import com.odioelchocolate.registry.ModEntities;
import com.odioelchocolate.registry.ModItems;
import com.odioelchocolate.registry.ModSounds;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(OdioElChocolate.MODID)
public class OdioElChocolate {
    public static final String MODID = "odioelchocolate";
    public static final Logger LOGGER = LogUtils.getLogger();

    public OdioElChocolate() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModSounds.SOUNDS.register(modBus);
        ModEntities.ENTITIES.register(modBus);
        ModItems.ITEMS.register(modBus);
    }
}
