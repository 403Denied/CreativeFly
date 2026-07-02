package com.denied403.creativefly.util;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class InfoProvider {
    private static final Minecraft client = Minecraft.getInstance();

    public static void showCreativeFlyMessage(boolean enabled){
        MutableComponent message = Component.translatable("text.creative_fly.message.creativefly.text");
        if(enabled){
            MutableComponent messageEnable = Component.translatable("text.creative_fly.message.creativefly.enabled");
            messageEnable.withStyle(ChatFormatting.GREEN);
            message.append(messageEnable);
        } else {
            MutableComponent messageDisable = Component.translatable("text.creative_fly.message.creativefly.disabled");
            messageDisable.withStyle(ChatFormatting.RED);
            message.append(messageDisable);
        }
        InfoProvider.client.gui.hud.setOverlayMessage(message, false);
    }

    public static void showCreativeFlySpeed(int speed){
        MutableComponent message = Component.translatable("text.creative_fly.message.creativefly.speed");
        MutableComponent speedComponent = Component.literal(String.valueOf(speed));
        speedComponent.withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD);
        message.append(speedComponent);
        InfoProvider.client.gui.hud.setOverlayMessage(message, false);
    }
}
