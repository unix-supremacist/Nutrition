package ca.wescook.nutrition.capabilities;

import jline.internal.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import cpw.mods.common.capabilities.Capability;
import cpw.mods.common.capabilities.CapabilityInject;
import cpw.mods.common.capabilities.ICapabilitySerializable;

// Creates and holds default implementation.  Offers Capability access, and optionally handles serialization.
public class CapProvider implements ICapabilitySerializable<NBTBase> {
	// Inject capability into field
	@CapabilityInject(CapInterface.class)
	public static final Capability<CapInterface> NUTRITION_CAPABILITY = null;

	private CapInterface instance;

	// Constructor passes entity to implementation
	public CapProvider(EntityPlayer player) {
		instance = new CapImplementation(player);
		//instance = NUTRITION_CAPABILITY.getDefaultInstance();
	}

	// Check if capability exists
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == NUTRITION_CAPABILITY)
			return true;
		return false;
	}

	// Return capability instance
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == NUTRITION_CAPABILITY)
			return NUTRITION_CAPABILITY.cast(instance);
		return null;
	}

	// Serialize and write NBT
	@Override
	public NBTBase serializeNBT() {
		return NUTRITION_CAPABILITY.getStorage().writeNBT(NUTRITION_CAPABILITY, instance, null);
	}

	// Deserialize and read NBT
	@Override
	public void deserializeNBT(NBTBase nbt) {
		NUTRITION_CAPABILITY.getStorage().readNBT(NUTRITION_CAPABILITY, instance, null, nbt);
	}
}
