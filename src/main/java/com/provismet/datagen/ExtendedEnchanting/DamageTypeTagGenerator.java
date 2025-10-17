package com.provismet.datagen.ExtendedEnchanting;

import com.provismet.ExtendedEnchanting.utility.EEDamageTypes;
import com.provismet.ExtendedEnchanting.utility.tags.EEDamageTypeTags;
import com.provismet.lilylib.datagen.tag.LilyTagProviders;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

public class DamageTypeTagGenerator extends LilyTagProviders.LilyDamageTypeTagProvider {
    public DamageTypeTagGenerator (FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure (RegistryWrapper.WrapperLookup wrapperLookup) {
        this.builder(EEDamageTypeTags.COMBUSTION)
            .addOptionalTag(DamageTypeTags.IS_FIRE)
            .addOptionalTag(DamageTypeTags.IS_EXPLOSION);

        this.builder(EEDamageTypeTags.MELEE_STRIKE)
            .add(DamageTypes.TRIDENT);

        this.builder(DamageTypeTags.BYPASSES_ARMOR)
            .add(EEDamageTypes.STATIC.getKey());

        this.builder(DamageTypeTags.BYPASSES_COOLDOWN)
            .add(EEDamageTypes.STATIC.getKey());

        this.builder(DamageTypeTags.IS_LIGHTNING)
            .add(EEDamageTypes.STATIC.getKey());
    }
}
