package com.provismet.datagen.ExtendedEnchanting;

import java.util.concurrent.CompletableFuture;

import com.provismet.ExtendedEnchanting.utility.tags.EEEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.entity.EntityType;

public class EntityTypeTagGenerator extends FabricTagsProvider.EntityTypeTagsProvider {
    public EntityTypeTagGenerator (FabricPackOutput output, CompletableFuture<Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags (Provider wrapper) {
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
