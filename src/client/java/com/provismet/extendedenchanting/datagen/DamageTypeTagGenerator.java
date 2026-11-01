package com.provismet.extendedenchanting.datagen;

import com.provismet.extendedenchanting.utility.EEDamageTypes;
import com.provismet.extendedenchanting.utility.tags.EEDamageTypeTags;
import com.provismet.lilylib.datagen.tag.LilyTagProviders;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageTypes;
import java.util.concurrent.CompletableFuture;

public class DamageTypeTagGenerator extends LilyTagProviders.LilyDamageTypeTagProvider {
    public DamageTypeTagGenerator (FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags (HolderLookup.Provider wrapperLookup) {
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
