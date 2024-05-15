package ru.matt;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.matt.api.VMCScreen;
import ru.matt.api.VMScreen;

public class ViewModel implements ModInitializer {
	public static KeyBinding openconfig;
    public static final Logger LOGGER = LoggerFactory.getLogger("viewmodel");

	@Override
	public void onInitialize() {
		// Load config
		VMCScreen.load();
		// Registered bind for opening config
		openconfig = KeyBindingHelper.registerKeyBinding(new KeyBinding("viewmodel.key", GLFW.GLFW_KEY_UNKNOWN, "ViewModel"));
		ClientTickEvents.END_CLIENT_TICK.register(mc -> {
			if (openconfig.wasPressed()) {
				mc.setScreen(new VMScreen(null));
			}
		});
		// Fun
		LOGGER.info("Evatablepvp the best hvh server, but brominemc the best of pvp/cpvp practice server!");
	}
}