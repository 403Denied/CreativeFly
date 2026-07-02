package com.denied403.creativefly;

import com.denied403.creativefly.config.Configs;
import com.denied403.creativefly.util.InfoProvider;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class CreativeFlyOptions {
    private static final Configs config = CreativeFly.getConfig();
    public static boolean isSpeedControl = false;

    public static void toggleCreativeFly(){
        Player player = Minecraft.getInstance().player;
        if(player == null || !player.getAbilities().flying) {
            return;
        }
        config.setCreativeFly(!config.isCreativeFlyToggled());
        AutoConfig.getConfigHolder(Configs.class).save();
        InfoProvider.showCreativeFlyMessage(config.isCreativeFlyToggled());
        if(!config.isCreativeFlyToggled()){
            player.getAbilities().setFlyingSpeed(config.getMinFlySpeed());
            player.onUpdateAbilities();
        }
    }

    public static void turnOffSilentCreativeFly(){
        config.setCreativeFly(false);
    }

    public static void turnOnSilentCreativeFly(){
        config.setCreativeFly(true);
    }

    public static void speedControlCreativeFly(){
        InfoProvider.showCreativeFlySpeed(Math.round(config.getToggledFlySpeed() * 100.0f));
    }

    public static boolean getIsSpeedControl(){
        return isSpeedControl;
    }

    public static void setIsSpeedControl(boolean state){
        isSpeedControl = state;
    }
}
