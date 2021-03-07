package com.github.fabrictestmod.blocks;

import com.github.fabrictestmod.FabricTestMod;
import com.github.fabrictestmod.client.screen.SoulRechargerScreenHandler;
import com.github.fabrictestmod.machine.SoulMachineEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

public class SoulRechargerBlockEntity extends SoulMachineEntity
                                        implements NamedScreenHandlerFactory {

    public SoulRechargerBlockEntity() {
        super(FabricTestMod.SOUL_RECHARGER_BLOCK_ENTITY);
    }

    public SoulRechargerBlockEntity(BlockEntityType<?> type, String name, int soulPower) {
        super(type, name, soulPower);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }


    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new SoulRechargerScreenHandler(syncId, playerInventory, this);
    }
}
