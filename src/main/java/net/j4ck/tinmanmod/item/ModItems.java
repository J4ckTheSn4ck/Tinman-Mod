package net.j4ck.tinmanmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.j4ck.tinmanmod.TinmanMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_TANZANITE = new Item(new FabricItemSettings());
    public static final Item TANZANITE = new Item(new FabricItemSettings());


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TinmanMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TinmanMod.LOGGER.debug("Registering Mod Items for " + TinmanMod.MOD_ID);
    }
}