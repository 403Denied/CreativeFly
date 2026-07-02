package com.denied403.creativefly.mixin;

import com.denied403.creativefly.CreativeFly;
import com.denied403.creativefly.CreativeFlyOptions;
import com.denied403.creativefly.config.Configs;
import net.minecraft.world.entity.player.Abilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= Abilities.class)
public class AbilitiesMixin {
    @Inject(method="setFlyingSpeed", at=@At(value="HEAD"))
    private void disableSpeedOnSet(float value, CallbackInfo ci){
        if(CreativeFly.isConfigNotLoaded()) {
            return;
        }
        Configs config = CreativeFly.getConfig();
        if(config.isCreativeFlyToggled()) {
            CreativeFlyOptions.turnOffSilentCreativeFly();
        }
    }
}
