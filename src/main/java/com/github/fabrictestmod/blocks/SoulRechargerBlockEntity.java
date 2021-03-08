package com.github.fabrictestmod.blocks;

import com.github.fabrictestmod.FabricTestMod;
import com.github.fabrictestmod.client.screen.SoulRechargerScreenHandler;
import com.github.fabrictestmod.machine.SoulMachineEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

public class SoulRechargerBlockEntity extends SoulMachineEntity
                                        implements NamedScreenHandlerFactory, Tickable {

    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return soulPower;
        }

        @Override
        public void set(int index, int value) {
            soulPower = value;
        }

        @Override
        public int size() {
            return 1;
        }
    };

    public SoulRechargerBlockEntity() {
        super(FabricTestMod.SOUL_RECHARGER_BLOCK_ENTITY);
    }

    public SoulRechargerBlockEntity(BlockEntityType<?> type, String name, int soulPower) {
        super(FabricTestMod.SOUL_RECHARGER_BLOCK_ENTITY, name, soulPower);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new SoulRechargerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public BlockEntityType<?> getType() {
        return FabricTestMod.SOUL_RECHARGER_BLOCK_ENTITY;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        return super.toTag(tag);
    }

    @Override
    public void tick() {
        if(!world.isClient())
            System.out.println("tick");
    }
}
