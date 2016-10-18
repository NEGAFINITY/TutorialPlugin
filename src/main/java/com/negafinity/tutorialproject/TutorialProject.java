package com.negafinity.tutorialproject;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.negafinity.tutorialproject.commands.TutorialPluginExecutor;

@Plugin(id = "tutorialproject", name = "Tutorial Project", version = "1.0")
public class TutorialProject
{
	@Inject
	private Logger logger;

	public Logger getLogger()
	{
		return logger;
	}

	@Listener
	public void onInitialize(GameInitializationEvent event)
	{
		this.getLogger().info("Loading...");
		
		CommandSpec tutorialCommandSpec = CommandSpec.builder()
			.description(Text.of("Says different things based on the source"))
			.executor(new TutorialPluginExecutor())
			.build();
		
		Sponge.getCommandManager().register(this, tutorialCommandSpec, Lists.newArrayList("tutorial", "tut"));
		
		this.getLogger().info("Enabled.");
	}
}
