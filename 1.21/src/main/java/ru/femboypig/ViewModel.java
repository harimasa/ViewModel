package ru.femboypig;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.femboypig.config.VMScreen;

public class ViewModel implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("viewmodel");

	@Override
	public void onInitialize() {
		VMScreen.CONFIG.load();
	}
}