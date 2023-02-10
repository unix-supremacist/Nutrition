package ca.wescook.nutrition.events;

import ca.wescook.nutrition.utility.ChatCommand;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class EventServerStart {
	@Mod.EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		event.registerServerCommand(new ChatCommand());
	}
}
