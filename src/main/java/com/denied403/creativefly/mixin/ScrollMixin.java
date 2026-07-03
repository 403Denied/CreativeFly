package com.denied403.creativefly.mixin;

import com.denied403.creativefly.CreativeFly;
import com.denied403.creativefly.CreativeFlyOptions;
import com.denied403.creativefly.config.Configs;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value=MouseHandler.class)
public class ScrollMixin {
    @Inject(method="onScroll", at=@At(value="HEAD"), cancellable = true)
    private void scrollFlySpeed(long handle, double xoffset, double yoffset, CallbackInfo ci) {
        if(CreativeFlyOptions.getIsSpeedControl()){
            int i = (int)Math.signum(yoffset);
            Configs config = CreativeFly.getConfig();
            float speedDelta = config.getToggledFlySpeed() + i / 100f;
            config.setToggledFlySpeed(speedDelta);
            AutoConfig.getConfigHolder(Configs.class).save();
            ci.cancel();
        }
    }
}
