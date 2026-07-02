package com.denied403.creativefly;

import com.denied403.creativefly.config.Configs;
import com.denied403.creativefly.event.KeyInputHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class CreativeFly implements ClientModInitializer {
	private static ConfigHolder<Configs> configHolder;

	public static Configs getConfig(){
		return configHolder.getConfig();
	}

	public static boolean isConfigNotLoaded() {
		return configHolder == null;
	}

	@Override
	public void onInitializeClient() {
		KeyInputHandler.register();
		configHolder = AutoConfig.register(Configs.class, JanksonConfigSerializer::new);
	}
}
