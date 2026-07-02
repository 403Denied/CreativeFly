package com.denied403.creativefly.event;

import com.denied403.creativefly.CreativeFlyOptions;
import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_CREATIVEFLY = "creativefly";
    public static final String KEY_TOGGLE_FLY = "key.creativefly.toggle_fly";
    public static int TIME_WAIT_PRESS = 0;
    public static KeyMapping toggleFlyKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(_ -> {
            if (toggleFlyKey.isDown()){
                if(++TIME_WAIT_PRESS == 1){
                    CreativeFlyOptions.toggleCreativeFly();
                }
                if (TIME_WAIT_PRESS >= 10){
                    CreativeFlyOptions.speedControlCreativeFly();
                    CreativeFlyOptions.turnOnSilentCreativeFly();
                    CreativeFlyOptions.setIsSpeedControl(true);
                }
            } else {
                TIME_WAIT_PRESS = 0;
                CreativeFlyOptions.setIsSpeedControl(false);
            }
        });
    }

    public static void register() {
        toggleFlyKey = KeyMappingHelper.registerKeyMapping(new KeyMapping(KEY_TOGGLE_FLY, InputConstants.Type.KEYSYM, 74, KeyMapping.Category.register(Identifier.fromNamespaceAndPath("creativefly", KEY_CATEGORY_CREATIVEFLY))));
        KeyInputHandler.registerKeyInputs();
    }
}
