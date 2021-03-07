package com.github.fabrictestmod.machine;

import com.github.fabrictestmod.util.MachineImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;

public abstract class SoulMachineEntity extends BlockEntity
                                            implements MachineImplementedInventory {

    public final String NBT_NAME_TAG = "name";
    public final String NBT_SOUL_POWER_TAG = "soul_power";

    public final DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public String name;
    public int soulPower;

    public SoulMachineEntity(BlockEntityType<?> type, String name) {

        super(type);
        this.name = name;
        this.soulPower = 0;

    }

    public SoulMachineEntity(BlockEntityType<?> type, String name, int soulPower) {

        super(type);
        this.name = name;
        this.soulPower = soulPower;

    }

    public SoulMachineEntity(BlockEntityType<?> type) {
        super(type);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);

        Inventories.fromTag(tag, this.items);
        this.soulPower = tag.getInt(NBT_SOUL_POWER_TAG);
        this.name = tag.getString(NBT_NAME_TAG);

    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {

        Inventories.toTag(tag, this.items);
        tag.putInt(NBT_SOUL_POWER_TAG, this.soulPower);
        tag.putString(NBT_NAME_TAG, this.name);

        return super.toTag(tag);
    }
}
