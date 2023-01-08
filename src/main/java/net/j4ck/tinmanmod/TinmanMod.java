package net.j4ck.tinmanmod;

import net.fabricmc.api.ModInitializer;
import net.j4ck.tinmanmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Very important comment
public class TinmanMod implements ModInitializer {

	public static final String MOD_ID = "tinmanmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
