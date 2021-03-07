package com.github.fabrictestmod.client.screen;

import com.github.fabrictestmod.FabricTestMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class SoulRechargerScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    public SoulRechargerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9));
    }

    public SoulRechargerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(FabricTestMod.SOUL_RECHARGER_SCREEN_HANDLER, syncId);

        checkSize(inventory, 9);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        //TODO
        return super.transferSlot(player, index);
    }
}
