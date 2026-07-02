package com.denied403.creativefly.mixin;

import com.denied403.creativefly.CreativeFly;
import com.denied403.creativefly.config.Configs;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value=Player.class)
public class MixinFlySpeed {
    @Inject(method="getFlyingSpeed", at=@At(value="HEAD"), cancellable=true)
    private void overrideFlySpeed(CallbackInfoReturnable<Float> cir) {
        if(CreativeFly.isConfigNotLoaded()) {
            return;
        }
        Configs config = CreativeFly.getConfig();
        Player player = Minecraft.getInstance().player;
        if(config.isCreativeFlyToggled() && player != null && player.getAbilities().flying && player.getAbilities().instabuild) {
            cir.setReturnValue(config.getCurrentFlySpeed());
        }
    }
}
