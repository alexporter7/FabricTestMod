package com.github.fabrictestmod;

import com.github.fabrictestmod.blocks.SoulRechargerBlock;
import com.github.fabrictestmod.blocks.SoulRechargerBlockEntity;
import com.github.fabrictestmod.client.screen.SoulRechargerScreenHandler;
import com.github.fabrictestmod.items.CreeperSoulEssence;
import com.github.fabrictestmod.items.CreeperSoulItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricTestMod implements ModInitializer {

	//Static Fields
	public static final String MOD_ID = "ftm";

	//Define Mod Items
	public static final Item CREEPER_SOUL = new CreeperSoulItem(
			new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1).maxDamage(400));
	public static final Item CREEPER_SOUL_ESSENCE = new CreeperSoulEssence(
			new Item.Settings().group(ItemGroup.MATERIALS).maxCount(64));

	//Define Mod Blocks
	public static final Block SOUL_RECHARGER_BLOCK;
	public static final BlockItem SOUL_RECHARGER_BLOCK_ITEM;

	//Define Block Entities
	public static final BlockEntityType<SoulRechargerBlockEntity> SOUL_RECHARGER_BLOCK_ENTITY;

	static {
		SOUL_RECHARGER_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "soul_recharger_block"),
				new SoulRechargerBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f)));
		SOUL_RECHARGER_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "soul_recharger_block"),
				new BlockItem(SOUL_RECHARGER_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
		SOUL_RECHARGER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
										String.format("%s:soul_recharger_block", MOD_ID),
										BlockEntityType.Builder.create(SoulRechargerBlockEntity::new).build(null));
	}

	//Define Identifiers
	public static final Identifier SOUL_RECHARGER_ID = new Identifier(MOD_ID, "soul_recharger_block");

	//Define Screen Handler Types
	public static final ScreenHandlerType<SoulRechargerScreenHandler> SOUL_RECHARGER_SCREEN_HANDLER;

	static {
		SOUL_RECHARGER_SCREEN_HANDLER = ScreenHandlerRegistry
											.registerSimple(SOUL_RECHARGER_ID, SoulRechargerScreenHandler::new);
	}

	@Override
	public void onInitialize() {

		//Register Mod Items
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "creeper_soul"), CREEPER_SOUL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "creeper_soul_essence"), CREEPER_SOUL_ESSENCE);

		System.out.println("FTM has been initialized");
	}


}
