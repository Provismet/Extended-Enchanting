package com.provismet.ExtendedEnchanting;

import com.provismet.ExtendedEnchanting.registries.EEParticleFactories;

import net.fabricmc.api.ClientModInitializer;

public class ExtendedEnchantingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient () {
        EEParticleFactories.register();
    }
}
