package com.github.fabrictestmod.blocks;

import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class SoulRechargerBlock extends BlockWithEntity {

    public SoulRechargerBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new SoulRechargerBlockEntity();
    }
}
