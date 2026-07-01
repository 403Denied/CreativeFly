package com.denied403.creativefly;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreativeFly implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Creative Fly");
	private static ConfigHolder<Configs> configHolder;

	public static Configs getConfig(){
		return (Configs)configHolder.getConfig();
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
