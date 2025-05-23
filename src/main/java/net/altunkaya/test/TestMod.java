package net.altunkaya.test;

import net.altunkaya.test.block.ModBlocks;
import net.altunkaya.test.item.ModItemGroups;
import net.altunkaya.test.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();


		ModItemGroups.registerItemGroups();

	}
}