package com.github.fabrictestmod.client.screen;

import com.github.fabrictestmod.util.ScreenUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SoulRechargerScreen extends HandledScreen<ScreenHandler> {

    private static final Identifier TEXTURE =
            new Identifier("ftm", "textures/gui/soul_recharger_container.png");

    SoulRechargerScreenHandler soulRechargerScreenHandler;

    public SoulRechargerScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        soulRechargerScreenHandler = (SoulRechargerScreenHandler) handler;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);

        assert client != null;
        client.getTextureManager().bindTexture(TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        //super.drawForeground(matrices, mouseX, mouseY);
        this.textRenderer.draw(matrices, new LiteralText("Stored Soul Power: " + soulRechargerScreenHandler.getSoulPower()),
                ScreenUtil.X_OFFSET, ScreenUtil.YOffsetLine.LINE1.getOffset(), 16777215);
        this.textRenderer.draw(matrices, new LiteralText("Soul Power: " + soulRechargerScreenHandler.getItemSoulPower()),
                ScreenUtil.X_OFFSET, ScreenUtil.YOffsetLine.LINE2.getOffset(), 16777215);
    }

    @Override
    public Text getTitle() {
        return super.getTitle();
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
