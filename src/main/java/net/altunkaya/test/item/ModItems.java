package net.altunkaya.test.item;

import net.altunkaya.test.TestMod;
import net.altunkaya.test.item.custom.ChiselItem;
import net.altunkaya.test.item.custom.LuckyStoneItem;
import net.altunkaya.test.item.custom.MagicTorchItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item LUCKY_STONE = registerItem("lucky_stone", new LuckyStoneItem(new Item.Settings()));
    public static final Item MAGIC_TORCH = registerItem("magic_torch", new MagicTorchItem(new Item.Settings().maxDamage(64)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);


    }
}
