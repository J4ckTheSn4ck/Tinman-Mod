package net.j4ck.tinmanmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TinmanMod implements ModInitializer {
	public static final String MOD_ID = "tinmanmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item POTIONIUM = new Item(new FabricItemSettings());
	public static final Item RAW_POTIONIUM = new Item(new FabricItemSettings());

	public static final Block POTIONIUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f));

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("tinmanmod", "potionium"), POTIONIUM);
		Registry.register(Registries.ITEM, new Identifier("tinmanmod", "raw_potionium"), RAW_POTIONIUM);

		Registry.register(Registries.BLOCK, new Identifier("tinmanmod", "potionium_ore"), POTIONIUM_ORE);
		Registry.register(Registries.ITEM, new Identifier("tinmanmod", "potionium_ore"), new BlockItem(POTIONIUM_ORE, new FabricItemSettings()));

		final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("tinmanmod", "potionium"))
				.icon(() -> new ItemStack(POTIONIUM))
				.build();

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
			content.add(POTIONIUM);
			content.add(RAW_POTIONIUM);
			content.add(POTIONIUM_ORE);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
			content.addAfter(Items.DIAMOND, POTIONIUM);
			content.addAfter(Items.RAW_GOLD, RAW_POTIONIUM);
		});
	}
}
