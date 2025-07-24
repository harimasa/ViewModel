package ru.harimasa;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.lwjgl.glfw.GLFW;
import ru.harimasa.viewmodel.config.VMScreen;

public class ViewModel implements ModInitializer {
	public static KeyBinding openConfig;

	@Override
	public void onInitialize() {
		VMScreen.CONFIG.load();
		openConfig = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.viewmodel.openscreen", InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_INSERT, "category.viewmodel"));
		antiLogSpam();
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (openConfig.wasPressed()) {
				Screen configScreen = VMScreen.screen(client.currentScreen);
				client.setScreen(configScreen);
			}
		});
	}

	public void antiLogSpam() {
		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		Configuration config = ctx.getConfiguration();
		String YACL = "YetAnotherConfigLib";
		LoggerConfig YACLConfigLogger = config.getLoggerConfig(YACL);
		if (!YACLConfigLogger.getName().equals(YACL)) {
			YACLConfigLogger = new LoggerConfig(YACL, Level.WARN, true);
			config.addLogger(YACL, YACLConfigLogger);
		}
		YACLConfigLogger.setLevel(Level.WARN);
		ctx.updateLoggers();
	}
}