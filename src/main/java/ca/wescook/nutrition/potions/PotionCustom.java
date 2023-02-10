package ca.wescook.nutrition.potions;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PotionCustom extends Potion {
	private boolean visibility;
	private ResourceLocation icon;

	PotionCustom(boolean visibility, ResourceLocation icon) {
		super(false, 0);// we have to get potion ids manually in this version
		this.visibility = visibility;
		this.icon = icon;
	}

	@Override
	public boolean shouldRenderInvText(PotionEffect effect) {
		return visibility;
	}

	// Inventory potion rendering
	@Override
	@SideOnly(Side.CLIENT)
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		if (mc.currentScreen != null) {
			mc.getTextureManager().bindTexture(icon);
			Gui.func_146110_a(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
		}
	}

    //Only a feature in modern 1.9+?
	// On-screen HUD rendering
	/*@Override
	@SideOnly(Side.CLIENT)
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.getTextureManager().bindTexture(icon);
		Gui.func_146110_a(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
	}*/
}
