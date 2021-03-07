package com.github.fabrictestmod.util;

import com.github.fabrictestmod.FabricTestMod;
import com.github.fabrictestmod.client.screen.SoulRechargerScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class SoulSlot extends Slot {

    public SoulSlotType slotType;

    public SoulSlot(Inventory inventory, int index, int x, int y, SoulSlotType type) {
        super(inventory, index, x, y);
        slotType = type;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return isValidInputItem(stack) || isValidOutputItem(stack);
    }

    public boolean isValidInputItem(ItemStack itemStack) {
        return itemStack.isItemEqual(FabricTestMod.CREEPER_SOUL_ESSENCE.getDefaultStack()) && slotType == SoulSlotType.INPUT;
    }

    public boolean isValidOutputItem(ItemStack itemStack) {
        return itemStack.isItemEqualIgnoreDamage(FabricTestMod.CREEPER_SOUL.getDefaultStack()) && slotType == SoulSlotType.OUTPUT;
    }

    public enum SoulSlotType {
        INPUT,
        OUTPUT
    }

}
