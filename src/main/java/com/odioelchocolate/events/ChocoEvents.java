package com.odioelchocolate.events;

import com.odioelchocolate.OdioElChocolate;
import com.odioelchocolate.command.ChocoSoundCommand;
import com.odioelchocolate.entity.ChocolateEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = OdioElChocolate.MODID)
public final class ChocoEvents {
    private ChocoEvents() {
    }

    @SubscribeEvent
    public static void onUseFinish(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) {
            return;
        }
        Item item = event.getItem().getItem();
        if (item == Items.COOKIE) {
            onCookie(player);
        } else if (item == Items.MILK_BUCKET) {
            onMilk(player);
        }
    }

    /** Cualquier jugador a 32 bloques o menos de un Chocolate que termine una galleta lo hace desaparecer. */
    private static void onCookie(ServerPlayer player) {
        ServerLevel level = player.serverLevel();
        double range = ChocolateEntity.COOKIE_RANGE;
        AABB box = player.getBoundingBox().inflate(range);
        for (ChocolateEntity mob : level.getEntitiesOfClass(ChocolateEntity.class, box)) {
            if (mob.distanceToSqr(player) <= range * range) {
                mob.vanishWithGhasts();
            }
        }
    }

    /** La leche quita la velocidad que dio el mob: el mob desaparece y el tramposo paga. */
    private static void onMilk(ServerPlayer player) {
        ServerLevel level = player.serverLevel();
        List<ChocolateEntity> found = new ArrayList<>();
        for (Entity entity : level.getAllEntities()) {
            if (entity instanceof ChocolateEntity mob && mob.isGrantingSpeedTo(player)) {
                found.add(mob);
            }
        }
        if (found.isEmpty()) {
            return;
        }
        for (ChocolateEntity mob : found) {
            mob.vanishWithGhasts();
        }
        ChocoPunishment.punish(player);
    }

    @SubscribeEvent
    public static void onCommands(RegisterCommandsEvent event) {
        ChocoSoundCommand.register(event.getDispatcher());
    }
}
