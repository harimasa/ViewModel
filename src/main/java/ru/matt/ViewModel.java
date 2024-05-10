package ru.matt;

import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.matt.api.ViewModelConfig;

import java.lang.invoke.MethodHandles;

/*
	View model on minecraft 1.20.x
	@author: deadlyPig
 */

public class ViewModel implements ModInitializer {
	public static final IEventBus EVENT_BUS = new EventBus();
    public static final Logger LOGGER = LoggerFactory.getLogger("viewmodel");
	public static ru.matt.model.ViewModel viewModel = new ru.matt.model.ViewModel();

	@Override
	public void onInitialize() {
		ViewModelConfig.load();
		EVENT_BUS.registerLambdaFactory("ru.matt", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
		EVENT_BUS.subscribe(viewModel);
		LOGGER.info("Evatablepvp the best hvh server, but brominemc the best of pvp/cpvp practice server!");
	}
}