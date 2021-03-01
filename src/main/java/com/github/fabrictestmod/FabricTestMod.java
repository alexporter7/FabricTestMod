package com.github.fabrictestmod;

import com.github.fabrictestmod.items.CreeperSoulItem;
import com.github.fabrictestmod.items.CreeperSoulEssence;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricTestMod implements ModInitializer {

	//Static Fields
	public static final String MOD_ID = "ftm";

	//Define Mod Items
	public static final Item CREEPER_SOUL = new CreeperSoulItem(
			new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1).maxDamage(10));
	public static final Item CREEPER_SOUL_ESSENCE = new CreeperSoulEssence(
			new Item.Settings().group(ItemGroup.MATERIALS).maxCount(64));

	@Override
	public void onInitialize() {

		//Register Mod Items
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "creeper_soul"), CREEPER_SOUL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "creeper_soul_essence"), CREEPER_SOUL_ESSENCE);

		System.out.println("FTM has been initialized");
	}
}
