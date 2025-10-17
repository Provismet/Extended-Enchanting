package com.provismet.datagen.ExtendedEnchanting;

import java.util.concurrent.CompletableFuture;

import com.provismet.ExtendedEnchanting.utility.tags.EEEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.EntityTypeTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class EntityTypeTagGenerator extends EntityTypeTagProvider {
    public EntityTypeTagGenerator (FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure (WrapperLookup wrapper) {
        this.valueLookupBuilder(EEEntityTypeTags.NO_LAUNCH)
            .addOptionalTag(ConventionalEntityTypeTags.BOSSES)
            .add(EntityType.RAVAGER)
            .add(EntityType.HOGLIN)
            .add(EntityType.ZOGLIN)
            .add(EntityType.SNIFFER)
            .add(EntityType.WARDEN);

        // Empty in vanilla.
        this.valueLookupBuilder(EEEntityTypeTags.HAS_WEAPON);
    }
    
}
