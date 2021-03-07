package com.github.fabrictestmod.client.screen;

import com.github.fabrictestmod.FabricTestMod;
import com.github.fabrictestmod.util.SoulSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class SoulRechargerScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    public SoulRechargerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(2));
    }

    public SoulRechargerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(FabricTestMod.SOUL_RECHARGER_SCREEN_HANDLER, syncId);

        checkSize(inventory, 2);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        //Add Custom Slots
        this.addSlot(new SoulSlot(inventory, 0, 25, 30, SoulSlot.SoulSlotType.INPUT));
        this.addSlot(new SoulSlot(inventory, 1, 133, 30, SoulSlot.SoulSlotType.OUTPUT));



        //Add the Player Inventory
        addPlayerInventory(playerInventory);


    }

    public void addPlayerInventory(PlayerInventory playerInventory) {

        int slotOffsetY = 0;
        int slotOffsetX = 0;

        //Add the Player Inventory
        for(slotOffsetY = 0; slotOffsetY < 3; ++slotOffsetY) {
            for(slotOffsetX = 0; slotOffsetX < 9; ++slotOffsetX) {
                this.addSlot(new Slot(
                                playerInventory, slotOffsetX + slotOffsetY * 9 + 9,
                                8 + slotOffsetX * 18,
                                84 + slotOffsetY * 18));
            }
        }

        //Add the Player Hotbar
        for(slotOffsetX = 0; slotOffsetX < 9; ++slotOffsetX) {
            this.addSlot(new Slot(
                    playerInventory, slotOffsetX,
                    8 + slotOffsetX * 18,
                    142));
        }

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
