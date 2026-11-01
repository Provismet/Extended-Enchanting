package com.provismet.extendedenchanting;

import com.provismet.extendedenchanting.registries.EEParticleFactories;

import net.fabricmc.api.ClientModInitializer;

public class ExtendedEnchantingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient () {
        EEParticleFactories.register();
    }
}
