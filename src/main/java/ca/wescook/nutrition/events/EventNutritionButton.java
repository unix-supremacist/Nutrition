package ca.wescook.nutrition.events;

import ca.wescook.nutrition.Nutrition;
import ca.wescook.nutrition.gui.GuiButtonIcon;
import ca.wescook.nutrition.gui.ModGuiHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventNutritionButton {
	private GuiButton buttonNutrition;
	private int NUTRITION_ID = 800;

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void guiOpen(GuiScreenEvent.InitGuiEvent.Post event) {
		// If any inventory except player inventory is opened, get out
		GuiScreen gui = event.gui;
		if (!(gui instanceof GuiInventory))
			return;

		// TODO: 1.11 offers GuiContainer#getGuiLeft().  Remove access transformers in 1.11 port.
		// Button position
		int xPosition = ((GuiInventory) gui).guiLeft + 97;
		int yPosition = ((GuiInventory) gui).guiTop + 61;

		// Create button
		event.buttonList.add(this.buttonNutrition = new GuiButtonIcon(NUTRITION_ID, xPosition, yPosition, 18, 17, new ItemStack(Items.carrot)));
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void guiButtonClick(GuiScreenEvent.ActionPerformedEvent.Post event) {
		// Only continue if nutrition button is pressed
		if (!event.button.equals(buttonNutrition))
			return;

		// Get data
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		World world = Minecraft.getMinecraft().theWorld;

		// Open GUI
		player.openGui(Nutrition.instance, ModGuiHandler.NUTRITION_GUI_ID, world, (int) player.posX, (int) player.posY, (int) player.posZ);
	}
}
