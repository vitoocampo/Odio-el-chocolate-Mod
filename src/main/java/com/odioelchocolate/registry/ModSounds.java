package com.odioelchocolate.registry;

import com.odioelchocolate.OdioElChocolate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, OdioElChocolate.MODID);

    public static final RegistryObject<SoundEvent> CHOCOCHASE1 = register("chocochase1");
    public static final RegistryObject<SoundEvent> CHOCOCHASE2 = register("chocochase2");
    public static final RegistryObject<SoundEvent> CHOCOSPAWN = register("chocospawn");

    private ModSounds() {
    }

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name,
                () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(OdioElChocolate.MODID, name)));
    }
}
