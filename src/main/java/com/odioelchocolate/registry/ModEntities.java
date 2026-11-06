package com.odioelchocolate.registry;

import com.odioelchocolate.OdioElChocolate;
import com.odioelchocolate.entity.ChocolateEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OdioElChocolate.MODID);

    public static final RegistryObject<EntityType<ChocolateEntity>> CHOCOLATE = ENTITIES.register("chocolate",
            () -> EntityType.Builder.of(ChocolateEntity::new, MobCategory.MONSTER)
                    .sized(1.0F, 1.9F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(OdioElChocolate.MODID, "chocolate").toString()));

    private ModEntities() {
    }
}
