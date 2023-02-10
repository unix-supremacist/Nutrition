package ca.wescook.nutrition.events;

import ca.wescook.nutrition.Nutrition;
import ca.wescook.nutrition.capabilities.CapProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventPlayerAttachCapability {
	@SubscribeEvent
	public void AttachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> event) {
		Entity entity = event.getObject();

		// Only check against players
		if (!(entity instanceof EntityPlayer))
			return;

		// Only run on server
		if (entity.worldObj.isRemote)
			return;

		// Attach capability to player
		event.addCapability(new ResourceLocation(Nutrition.MODID, "nutrition"), new CapProvider((EntityPlayer) entity));
	}
}
