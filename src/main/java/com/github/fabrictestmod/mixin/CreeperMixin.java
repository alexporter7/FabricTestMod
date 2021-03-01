package com.github.fabrictestmod.mixin;

import com.github.fabrictestmod.FabricTestMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(CreeperEntity.class)
public class CreeperMixin extends HostileEntity {


    public CreeperMixin(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("TAIL"), method = "explode")
    public void explode(CallbackInfo info) {

        if (!this.world.isClient && this.hasCustomName()
                && this.getCustomName().equals(new LiteralText("Ghost Creeper"))) {
            if(new Random().nextBoolean()) {
                this.dropItem(new ItemConvertible() {
                    @Override
                    public Item asItem() {
                        return FabricTestMod.CREEPER_SOUL;
                    }
                });
            }
            this.dead = true;
            this.remove();
            this.playSound(SoundEvents.BLOCK_LODESTONE_BREAK, 1.0F, 0.5F);

        }

    }

}
