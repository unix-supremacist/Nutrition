package ca.wescook.nutrition.proxy;

import ca.wescook.nutrition.Nutrition;
import ca.wescook.nutrition.capabilities.CapImplementation;
import ca.wescook.nutrition.capabilities.CapInterface;
import ca.wescook.nutrition.capabilities.CapStorage;
import ca.wescook.nutrition.effects.EffectsList;
import ca.wescook.nutrition.events.EventEatFood;
import ca.wescook.nutrition.events.EventPlayerAttachCapability;
import ca.wescook.nutrition.events.EventPlayerClone;
import ca.wescook.nutrition.events.EventPlayerUpdate;
import ca.wescook.nutrition.gui.ModGuiHandler;
import ca.wescook.nutrition.network.ModPacketHandler;
import ca.wescook.nutrition.nutrients.NutrientList;
import ca.wescook.nutrition.potions.ModPotions;
import ca.wescook.nutrition.utility.Config;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.capabilities.CapabilityManager;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		Config.registerConfigs(event.getModConfigurationDirectory()); // Create config files
		ModPacketHandler.registerMessages(); // Register network messages
		CapabilityManager.INSTANCE.register(CapInterface.class, new CapStorage(), CapImplementation.class); // Register capability
		ModPotions.registerPotions(); // Register custom potions

		MinecraftForge.EVENT_BUS.register(new EventPlayerAttachCapability()); // Attach capability to player
		MinecraftForge.EVENT_BUS.register(new EventPlayerClone()); // Player death and warping
		MinecraftForge.EVENT_BUS.register(new EventEatFood()); // Register use item event
		MinecraftForge.EVENT_BUS.register(new EventPlayerUpdate()); // Register update event for nutrition decay and potion effects
	}

	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Nutrition.instance, new ModGuiHandler()); // Register GUI handler
	}

	public void postInit(FMLPostInitializationEvent event) {
		NutrientList.parseJson(); // Parse nutrients from loaded JSONs
		EffectsList.parseJson(); // Parse potion effects from loaded JSONs
	}
}
