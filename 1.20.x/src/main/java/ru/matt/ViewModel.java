package ru.matt;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.matt.api.ClothConfigConfig;

public class ViewModel implements ModInitializer {
	public static final ClothConfigConfig MOD_CONFIG = AutoConfig.register(ClothConfigConfig.class, GsonConfigSerializer::new).get();
    public static final Logger LOGGER = LoggerFactory.getLogger("viewmodel");

	@Override
	public void onInitialize() {
		LOGGER.info("Evatablepvp the best hvh server, but brominemc the best of pvp/cpvp practice server!");
	}
}