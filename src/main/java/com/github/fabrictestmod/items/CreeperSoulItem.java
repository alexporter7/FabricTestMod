package com.github.fabrictestmod.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;

public class CreeperSoulItem extends Item {

    public CreeperSoulItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(!context.getWorld().isClient() && canSpawn(context)) {
            CreeperEntity creeperSpawn = new CreeperEntity(EntityType.CREEPER, context.getWorld());
            //Set Positional Arguments
            creeperSpawn.setPos(
                    context.getHitPos().x, context.getHitPos().y, context.getHitPos().z);
            creeperSpawn.updatePositionAndAngles(
                    context.getHitPos().x, context.getHitPos().y, context.getHitPos().z,
                    0f, 0f);
            //Set Custom Name and visibility
            creeperSpawn.setCustomName(new LiteralText("Ghost Creeper"));
            creeperSpawn.setCustomNameVisible(true);
            //Spawn Entity
            context.getWorld().spawnEntity(creeperSpawn);

            ItemStack creeperSoulItemStack = context.getPlayer().getStackInHand(context.getHand());
            creeperSoulItemStack.damage(50, context.getPlayer(),
                    p -> { p.sendToolBreakStatus(context.getHand()); });
        }

        return super.useOnBlock(context);
    }

    public boolean canSpawn(ItemUsageContext context) {
        return context.getPlayer().getStackInHand(context.getHand()).getDamage() < 350;
    }

}
