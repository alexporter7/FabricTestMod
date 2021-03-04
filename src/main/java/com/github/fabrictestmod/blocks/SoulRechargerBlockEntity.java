package com.github.fabrictestmod.blocks;

import com.github.fabrictestmod.FabricTestMod;
import com.github.fabrictestmod.machine.SoulMachineEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class SoulRechargerBlockEntity extends SoulMachineEntity {

    //TODO
    //Figure out bugs with the thing

    public SoulRechargerBlockEntity() {
        super(FabricTestMod.SOUL_RECHARGER_BLOCK_ENTITY);
    }

    public SoulRechargerBlockEntity(BlockEntityType<?> type, String name, int soulPower) {
        super(type, name, soulPower);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }

}
