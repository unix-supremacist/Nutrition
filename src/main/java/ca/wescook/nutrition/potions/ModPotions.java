package ca.wescook.nutrition.potions;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.registry.GameRegistry;

import java.util.UUID;

// A simple potion implementation to avoid visible rendering in the inventory screen
public class ModPotions {
	public static PotionToughness toughness;
	public static PotionMalnourished malnourished;
	public static PotionNourished nourished;

	static final UUID TOUGHNESS_HEALTH = UUID.fromString("d80b5ec3-8cf9-4b74-bc0d-6f3ef7b48b2e");
	static final UUID TOUGHNESS_ARMOR = UUID.fromString("f42431e4-8efc-44d2-8249-fea2a2cb418e");
	static final UUID TOUGHNESS_ATTACK_SPEED = UUID.fromString("10d42c27-f160-4909-a523-9b2553e14eac");
	static final UUID NOURISHMENT_HEALTH = UUID.fromString("bdafe0c7-5881-4505-802e-e18f6c419554");
	static final UUID MALNOURISHMENT_HEALTH = UUID.fromString("ea9cebf7-7c7a-4a89-a04f-221dab8ffdf7");

	public static void registerPotions() {
		// Toughness
		toughness = new PotionToughness(true, new ResourceLocation("nutrition", "textures/potions/toughness.png"));
		toughness.setPotionName("Toughness");
		toughness.setRegistryName("toughness");
		toughness.setBeneficial();
		toughness.registerPotionAttributeModifier(SharedMonsterAttributes.MAX_HEALTH, TOUGHNESS_HEALTH.toString(), 0D, 0);
		toughness.registerPotionAttributeModifier(SharedMonsterAttributes.ARMOR_TOUGHNESS, TOUGHNESS_ARMOR.toString(), 0D, 0);
		toughness.registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, TOUGHNESS_ATTACK_SPEED.toString(), 0D, 0);
		GameRegistry.register(toughness);

		// Nourished
		nourished = new PotionNourished(true, new ResourceLocation("nutrition", "textures/potions/nourished.png"));
		nourished.setPotionName("Nourished");
		nourished.setRegistryName("nourished");
		nourished.registerPotionAttributeModifier(SharedMonsterAttributes.MAX_HEALTH, NOURISHMENT_HEALTH.toString(), 0D, 0);
		GameRegistry.register(nourished);

		// Malnourished
		malnourished = new PotionMalnourished(true, new ResourceLocation("nutrition", "textures/potions/malnourished.png"));
		malnourished.setPotionName("Malnourished");
		malnourished.setRegistryName("malnourished");
		malnourished.registerPotionAttributeModifier(SharedMonsterAttributes.MAX_HEALTH, MALNOURISHMENT_HEALTH.toString(), 0D, 0);
		GameRegistry.register(malnourished);
	}
}
