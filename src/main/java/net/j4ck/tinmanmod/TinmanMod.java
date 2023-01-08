package net.j4ck.tinmanmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TinmanMod implements ModInitializer {
	public static final String MOD_ID = "tinmanmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		final Item RAW_POTIONIUM = Registry.register(Registries.ITEM, new Identifier("tinmanmod", "raw_potionium"), new Item(new FabricItemSettings()));

		final Item POTIONIUM = Registry.register(Registries.ITEM, new Identifier("tinmanmod", "potionium"), new Item(new FabricItemSettings()));

		final Item POTIONIUM_CHESTPLATE = Registry.register(Registries.ITEM, new Identifier("tinmanmod", "potionium_chestplate"), new Item(new FabricItemSettings()));

		final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("tinmanmod", "potionium"))
				.icon(() -> new ItemStack(POTIONIUM))
				.build();

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
			content.add(POTIONIUM);
			content.add(RAW_POTIONIUM);
			content.add(POTIONIUM_CHESTPLATE);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
			content.addAfter(Items.DIAMOND, POTIONIUM);
			content.addAfter(Items.RAW_GOLD, RAW_POTIONIUM);
			content.addAfter(Items.TURTLE_HELMET, POTIONIUM_CHESTPLATE);
		});
	}
}
