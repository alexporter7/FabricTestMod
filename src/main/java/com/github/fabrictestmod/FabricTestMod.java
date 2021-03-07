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
			new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1).maxDamage(10));
	public static final Item CREEPER_SOUL_ESSENCE = new CreeperSoulEssence(
			new Item.Settings().group(ItemGroup.MATERIALS).maxCount(64));

	//Define Mod Blocks
	public static final Block SOUL_RECHARGER_BLOCK = new SoulRechargerBlock(
			FabricBlockSettings.of(Material.METAL).strength(4.0f));

	//Define Block Entities
	public static BlockEntityType<SoulRechargerBlockEntity> SOUL_RECHARGER_BLOCK_ENTITY;

//	public static ScreenHandlerType<SoulRechargerGuiDescription> SOUL_RECHARGER_SCREEN_TYPE;

	//Define Identifiers
	public static final Identifier SOUL_RECHARGER_ID = new Identifier(MOD_ID, "soul_recharger_block");

	public static final ScreenHandlerType<SoulRechargerScreenHandler> SOUL_RECHARGER_SCREEN_HANDLER;

	static {
		SOUL_RECHARGER_SCREEN_HANDLER = ScreenHandlerRegistry
											.registerSimple(SOUL_RECHARGER_ID, SoulRechargerScreenHandler::new);
	}

	@Override
	public void onInitialize() {

		//Register Screens
//		SOUL_RECHARGER_SCREEN_TYPE = ScreenHandlerRegistry.registerSimple(SoulRechargerBlock.ID,
//				(syncId, inventory) -> new SoulRechargerGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));

		//Register Mod Items
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "creeper_soul"), CREEPER_SOUL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "creeper_soul_essence"), CREEPER_SOUL_ESSENCE);

		//Register Blocks
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "soul_recharger_block"), SOUL_RECHARGER_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "soul_recharger_block"),
				new BlockItem(SOUL_RECHARGER_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

		//Register Block Entities
		Registry.register(Registry.BLOCK_ENTITY_TYPE,
				String.format("%s:soul_recharger_block_entity", MOD_ID),
				BlockEntityType.Builder.create(SoulRechargerBlockEntity::new).build(null));

		System.out.println("FTM has been initialized");
	}


}
