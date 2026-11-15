package com.provismet.extendedenchanting.datagen;

import java.util.concurrent.CompletableFuture;

import com.provismet.extendedenchanting.utility.tags.EEEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypeIds;
import net.minecraft.world.entity.EntityTypes;

public class EntityTypeTagGenerator extends FabricTagsProvider.EntityTypeTagsProvider {
    public EntityTypeTagGenerator (FabricPackOutput output, CompletableFuture<Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags (Provider wrapper) {
        this.builder(EEEntityTypeTags.NO_LAUNCH)
            .addOptionalTag(ConventionalEntityTypeTags.BOSSES)
            .add(EntityTypeIds.RAVAGER)
            .add(EntityTypeIds.HOGLIN)
            .add(EntityTypeIds.ZOGLIN)
            .add(EntityTypeIds.SNIFFER)
            .add(EntityTypeIds.WARDEN);

        // Empty in vanilla.
        this.builder(EEEntityTypeTags.HAS_WEAPON);
    }
    
}
