package ru.matt;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.matt.api.ClothConfigConfig;

import java.lang.invoke.MethodHandles;

public class ViewModel implements ModInitializer {
	public static final IEventBus EVENT_BUS = new EventBus();
	public static final ClothConfigConfig MOD_CONFIG = AutoConfig.register(ClothConfigConfig.class, GsonConfigSerializer::new).get();
    public static final Logger LOGGER = LoggerFactory.getLogger("viewmodel");
	public static ru.matt.model.ViewModel viewModel = new ru.matt.model.ViewModel();

	@Override
	public void onInitialize() {
		EVENT_BUS.registerLambdaFactory("ru.matt", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
		EVENT_BUS.subscribe(viewModel);
		LOGGER.info("Evatablepvp the best hvh server, but brominemc the best of pvp/cpvp practice server!");
	}
}