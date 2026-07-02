package com.denied403.creativefly.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name="creative_fly")
public class Configs implements ConfigData {
    @ConfigEntry.Gui.Excluded
    private boolean creativeFlyToggled = false;
    @ConfigEntry.BoundedDiscrete(min=5L, max=100L)
    private int toggledFlySpeed = 50;

    private float ensureRange(float value, float min, float max) {
        return Math.clamp(value, min, max);
    }

    public boolean isCreativeFlyToggled() {
        return this.creativeFlyToggled;
    }

    public void setCreativeFly(boolean status){
        this.creativeFlyToggled = status;
    }

    public float getMinFlySpeed() {
        return 0.05f;
    }

    public float getMaxFlySpeed() {
        return 1.0f;
    }

    public float getToggledFlySpeed() {
        float flySpeed = this.toggledFlySpeed / 100.0f;
        return this.ensureRange(flySpeed, this.getMinFlySpeed(), this.getMaxFlySpeed());
    }

    public void setToggledFlySpeed(float speed) {
        float flySpeed = this.ensureRange(speed, this.getMinFlySpeed(), this.getMaxFlySpeed());
        this.toggledFlySpeed = Math.round(flySpeed * 100.0f);
    }

    public float getCurrentFlySpeed() {
        return this.isCreativeFlyToggled() ? this.getToggledFlySpeed() : this.getMinFlySpeed();
    }
}
