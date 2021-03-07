package com.github.fabrictestmod;

import com.github.fabrictestmod.client.screen.SoulRechargerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class FabricTestModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ScreenRegistry.register(FabricTestMod.SOUL_RECHARGER_SCREEN_HANDLER, SoulRechargerScreen::new);

    }

}
