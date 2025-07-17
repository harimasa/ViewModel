package ru.harimasa;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import ru.harimasa.viewmodel.config.VMScreen;

public class ViewModel implements ModInitializer {
	public static KeyBinding openConfig;

	@Override
	public void onInitialize() {
		VMScreen.CONFIG.load();
		openConfig = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.viewmodel.openscreen", InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_INSERT, "category.viewmodel"));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (openConfig.wasPressed()) {
				Screen configScreen = VMScreen.screen(client.currentScreen);
				client.setScreen(configScreen);
			}
		});
	}
}