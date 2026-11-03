package com.provismet.extendedenchanting.registries;

import com.provismet.combatplus.api.enchantment.effect.doubleEntity.ApplyKnockbackEffect;
import com.provismet.combatplus.api.enchantment.effect.doubleEntity.ApplyToTargetEntityEffect;
import com.provismet.combatplus.api.enchantment.effect.doubleEntity.ApplyToUserEntityEffect;
import com.provismet.combatplus.api.enchantment.effect.doubleEntity.CodeExecutionDoubleEntityEffect;
import com.provismet.combatplus.api.enchantment.effect.doubleEntity.InvertedEntityEffect;
import com.provismet.combatplus.api.enchantment.effect.singleEntity.ApplyVelocityEffect;
import com.provismet.combatplus.api.enchantment.effect.singleEntity.CodeExecutionSingleEntityEffect;
import com.provismet.combatplus.api.enchantment.effect.singleEntity.DamageEquipmentEffect;
import com.provismet.combatplus.api.enchantment.effect.singleEntity.FreezeEffect;
import com.provismet.combatplus.api.enchantment.effect.singleEntity.HealEffect;
import com.provismet.combatplus.api.loot.condition.doubleEntity.ApplyToTargetCondition;
import com.provismet.combatplus.api.loot.condition.item.ItemLambdaCondition;
import com.provismet.combatplus.api.loot.condition.singleEntity.ApplyToAttackerCondition;
import com.provismet.combatplus.api.loot.condition.singleEntity.ApplyToItemCondition;
import com.provismet.combatplus.api.loot.condition.singleEntity.DimensionCondition;
import com.provismet.combatplus.api.loot.condition.singleEntity.ExposedToMoonCondition;
import com.provismet.combatplus.api.loot.condition.singleEntity.ExposedToSunCondition;
import com.provismet.combatplus.api.loot.condition.singleEntity.RelativeHealthCondition;
import com.provismet.combatplus.api.loot.condition.singleEntity.TickModuloCondition;
import com.provismet.combatplus.api.loot.context.CombatPlusLootContext;
import com.provismet.combatplus.api.tag.CombatPlusEnchantmentTags;
import com.provismet.combatplus.api.tag.CombatPlusItemTags;
import com.provismet.combatplus.registries.CombatPlusEnchantmentComponentTypes;
import com.provismet.extendedenchanting.ExtendedEnchantingMain;
import com.provismet.extendedenchanting.enchantment.effect.singleEntity.ShockEnchantmentEffect;
import com.provismet.extendedenchanting.utility.tags.EEDamageTypeTags;
import com.provismet.extendedenchanting.utility.tags.EEEnchantmentTags;
import com.provismet.extendedenchanting.utility.tags.EEEntityTypeTags;
import com.provismet.extendedenchanting.utility.tags.EEItemTags;
import com.provismet.lilylib.container.EnchantmentContainer;
import net.minecraft.advancements.criterion.DamageSourcePredicate;
import net.minecraft.advancements.criterion.EntityEquipmentPredicate;
import net.minecraft.advancements.criterion.EntityFlagsPredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.EntityTypePredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.TagPredicate;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.AddValue;
import net.minecraft.world.item.enchantment.effects.AllOf;
import net.minecraft.world.item.enchantment.effects.ApplyMobEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;
import net.minecraft.world.item.enchantment.effects.Ignite;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.AllOfCondition;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.DamageSourceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;

import java.util.List;

public class EEEnchantments {
    public static final EnchantmentContainer LEECHING_ASPECT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("leeching_aspect"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.ASPECT_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.ASPECT_PRIMARY_ENCHANTABLE),
                3,
                2,
                Enchantment.dynamicCost(10, 20),
                Enchantment.dynamicCost(50, 20),
                6,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.POST_CRITICAL_ATTACK,
            new ApplyToUserEntityEffect(
                new HealEffect(LevelBasedValue.perLevel(1))
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(CombatPlusEnchantmentTags.ASPECT_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer FROST_ASPECT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("frost_aspect"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.ASPECT_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.ASPECT_PRIMARY_ENCHANTABLE),
                5,
                2,
                Enchantment.dynamicCost(10, 20),
                Enchantment.dynamicCost(25, 20),
                4,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new ApplyToTargetEntityEffect(
                new FreezeEffect(LevelBasedValue.perLevel(2.25f))
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(CombatPlusEnchantmentTags.ASPECT_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer LIGHTNING_ASPECT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("lightning_aspect"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.ASPECT_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.ASPECT_PRIMARY_ENCHANTABLE),
                3,
                2,
                Enchantment.dynamicCost(20, 10),
                Enchantment.dynamicCost(70, 10),
                4,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new ApplyToTargetEntityEffect(
                new ShockEnchantmentEffect(LevelBasedValue.perLevel(22))
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(CombatPlusEnchantmentTags.ASPECT_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer INITIATIVE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("initiative"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.DAMAGE_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.DAMAGE_PRIMARY_ENCHANTABLE),
                5,
                5,
                Enchantment.dynamicCost(10, 5),
                Enchantment.dynamicCost(50, 5),
                3,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.GAMERULE_DAMAGE,
            new AddValue(LevelBasedValue.perLevel(2.2f)),
            RelativeHealthCondition.builder(CombatPlusLootContext.Comparison.GREATER_THAN_OR_EQUAL_TO, LevelBasedValue.constant(1))
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(CombatPlusEnchantmentTags.ADDITION_DAMAGE_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer GLASS = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("glass"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.DAMAGE_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.DAMAGE_PRIMARY_ENCHANTABLE),
                5,
                5,
                Enchantment.dynamicCost(10, 5),
                Enchantment.dynamicCost(50, 5),
                3,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.GAMERULE_DAMAGE,
            new AddValue(LevelBasedValue.perLevel(1.8f)),
            ApplyToAttackerCondition.builder(
                RelativeHealthCondition.builder(
                    CombatPlusLootContext.Comparison.GREATER_THAN_OR_EQUAL_TO,
                    LevelBasedValue.constant(1)
                )
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(CombatPlusEnchantmentTags.ADDITION_DAMAGE_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer SOLITUDE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("solitude"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.DAMAGE_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.DAMAGE_PRIMARY_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(35),
                Enchantment.constantCost(75),
                8,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.GAMERULE_DAMAGE,
            new AddValue(LevelBasedValue.perLevel(15)),
            ApplyToAttackerCondition.builder(
                ApplyToItemCondition.builder(
                    ItemLambdaCondition.builder(ExtendedEnchantingMain.identifier("one_enchantment"))
                )
            )
        )
    );

    public static final EnchantmentContainer DUAL_STRIKE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("dual_strike"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.WEAPON_UTILITY_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.WEAPON_UTILITY_PRIMARY_ENCHANTABLE),
                5,
                3,
                Enchantment.dynamicCost(10, 5),
                Enchantment.dynamicCost(20, 10),
                4,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new CodeExecutionDoubleEntityEffect(ExtendedEnchantingMain.identifier("dual_strike"))
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(CombatPlusEnchantmentTags.WEAPON_UTILITY_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer FEINT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("feint"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.WEAPON_UTILITY_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.WEAPON_UTILITY_PRIMARY_ENCHANTABLE),
                2,
                2,
                Enchantment.dynamicCost(10, 10),
                Enchantment.dynamicCost(50, 10),
                4,
                EquipmentSlotGroup.MAINHAND, EquipmentSlotGroup.OFFHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new InvertedEntityEffect(
                new ApplyKnockbackEffect(
                    LevelBasedValue.perLevel(1, 0.5f),
                    false
                )
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(CombatPlusEnchantmentTags.WEAPON_UTILITY_OFFHAND_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer RAMPAGE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("rampage"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(CombatPlusItemTags.WEAPON_UTILITY_ENCHANTABLE),
                itemLookup.getOrThrow(CombatPlusItemTags.WEAPON_UTILITY_PRIMARY_ENCHANTABLE),
                5,
                3,
                Enchantment.dynamicCost(5, 10),
                Enchantment.dynamicCost(55, 10),
                3,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.POST_KILL,
            new ApplyToUserEntityEffect(
                AllOf.entityEffects(
                    new ApplyMobEffect(
                        HolderSet.direct(MobEffects.STRENGTH),
                        LevelBasedValue.perLevel(1.25f),
                        LevelBasedValue.perLevel(1.25f),
                        LevelBasedValue.constant(0),
                        LevelBasedValue.constant(0)
                    ),
                    new ApplyMobEffect(
                        HolderSet.direct(MobEffects.SPEED),
                        LevelBasedValue.perLevel(1.25f),
                        LevelBasedValue.perLevel(1.25f),
                        LevelBasedValue.constant(0),
                        LevelBasedValue.constant(0)
                    )
                )
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(CombatPlusEnchantmentTags.WEAPON_UTILITY_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer LAUNCH = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("launch"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                5,
                2,
                Enchantment.dynamicCost(5, 20),
                Enchantment.dynamicCost(50, 20),
                2,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            CombatPlusEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new ApplyToTargetEntityEffect(
                new ApplyVelocityEffect(
                    0, 0.15, 0,
                    LevelBasedValue.perLevel(1),
                    true
                )
            ),
            ApplyToTargetCondition.builder(
                LootItemEntityPropertyCondition.hasProperties(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityLookup, EEEntityTypeTags.NO_LAUNCH)).build()
                ).invert()
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.LAUNCH_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer WEAPON_PROTECTION = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("weapon_protection"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                1,
                4,
                Enchantment.dynamicCost(10, 5),
                Enchantment.dynamicCost(20, 5),
                4,
                EquipmentSlotGroup.ARMOR
            )
        ).withEffect(
            EnchantmentEffectComponents.DAMAGE_PROTECTION,
            new AddValue(
                LevelBasedValue.perLevel(1.5f)
            ),
            AnyOfCondition.anyOf(
                DamageSourceCondition.hasDamageSource(
                    DamageSourcePredicate.Builder.damageType()
                        .tag(TagPredicate.is(EEDamageTypeTags.MELEE_STRIKE))
                        .isDirect(true)
                ),
                DamageSourceCondition.hasDamageSource(
                    DamageSourcePredicate.Builder.damageType()
                        .direct(
                            EntityPredicate.Builder.entity().equipment(
                                EntityEquipmentPredicate.Builder.equipment().mainhand(
                                    ItemPredicate.Builder.item().of(itemLookup, CombatPlusItemTags.MELEE_WEAPON)
                                )
                            )
                        )
                        .isDirect(true)
                ),
                DamageSourceCondition.hasDamageSource(
                    DamageSourcePredicate.Builder.damageType()
                        .direct(
                            EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(entityLookup, EEEntityTypeTags.HAS_WEAPON))
                        )
                        .isDirect(true)
                )
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer COMBUSTION_PROTECTION = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("combustion_protection"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                1,
                4,
                Enchantment.dynamicCost(10, 5),
                Enchantment.dynamicCost(20, 5),
                4,
                EquipmentSlotGroup.ARMOR
            )
        ).withEffect(
            EnchantmentEffectComponents.DAMAGE_PROTECTION,
            new AddValue(
                LevelBasedValue.perLevel(1.35f)
            ),
            DamageSourceCondition.hasDamageSource(
                DamageSourcePredicate.Builder.damageType()
                    .tag(TagPredicate.is(EEDamageTypeTags.COMBUSTION))
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer SUN_HEART = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("sun_heart"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(50),
                Enchantment.constantCost(75),
                8,
                EquipmentSlotGroup.CHEST
            )
        ).withEffect(
            EnchantmentEffectComponents.TICK,
            AllOf.entityEffects(
                new HealEffect(
                    LevelBasedValue.constant(2)
                ),
                new DamageEquipmentEffect(
                    List.of(EquipmentSlot.CHEST),
                    LevelBasedValue.constant(10)
                )
            ),
            AllOfCondition.allOf(
                TickModuloCondition.builder(LevelBasedValue.constant(40)),
                ExposedToSunCondition.builder(),
                RelativeHealthCondition.builder(CombatPlusLootContext.Comparison.LESS_THAN, LevelBasedValue.constant(1))
            )
        ).withEffect(
            EnchantmentEffectComponents.POST_ATTACK,
            EnchantmentTarget.VICTIM,
            EnchantmentTarget.ATTACKER,
            new Ignite(LevelBasedValue.constant(3)),
            AllOfCondition.allOf(
                ExposedToSunCondition.builder(),
                DamageSourceCondition.hasDamageSource(
                    DamageSourcePredicate.Builder.damageType().isDirect(true)
                )
            )
        ).withEffect(
            EnchantmentEffectComponents.POST_ATTACK,
            EnchantmentTarget.VICTIM,
            EnchantmentTarget.VICTIM,
            new DamageEquipmentEffect(
                List.of(EquipmentSlot.CHEST),
                LevelBasedValue.constant(2)
            ),
            AllOfCondition.allOf(
                ExposedToSunCondition.builder(),
                DamageSourceCondition.hasDamageSource(
                    DamageSourcePredicate.Builder.damageType().isDirect(true)
                )
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.HEART_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer MOON_HEART = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("moon_heart"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(50),
                Enchantment.constantCost(75),
                8,
                EquipmentSlotGroup.CHEST
            )
        ).withEffect(
            EnchantmentEffectComponents.POST_ATTACK,
            EnchantmentTarget.VICTIM,
            EnchantmentTarget.ATTACKER,
            new ApplyMobEffect(
                HolderSet.direct(MobEffects.SLOWNESS),
                LevelBasedValue.constant(1),
                LevelBasedValue.constant(1),
                LevelBasedValue.constant(0),
                LevelBasedValue.constant(0)
            ),
            AllOfCondition.allOf(
                ExposedToMoonCondition.builder(),
                DamageSourceCondition.hasDamageSource(
                    DamageSourcePredicate.Builder.damageType().isDirect(true)
                )
            )
        ).withEffect(
            EnchantmentEffectComponents.POST_ATTACK,
            EnchantmentTarget.VICTIM,
            EnchantmentTarget.VICTIM,
            new DamageEquipmentEffect(
                List.of(EquipmentSlot.CHEST),
                LevelBasedValue.constant(5)
            ),
            AllOfCondition.allOf(
                ExposedToMoonCondition.builder(),
                DamageSourceCondition.hasDamageSource(
                    DamageSourcePredicate.Builder.damageType().isDirect(true)
                )
            )
        ).withEffect(
            EnchantmentEffectComponents.TICK,
            new CodeExecutionSingleEntityEffect(ExtendedEnchantingMain.identifier("reset_insomnia")),
            ExposedToMoonCondition.builder()
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.HEART_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer BRIMSTONE_HEART = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("brimstone_heart"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(50),
                Enchantment.constantCost(75),
                8,
                EquipmentSlotGroup.CHEST
            )
        ).withEffect(
            EnchantmentEffectComponents.LOCATION_CHANGED,
            new EnchantmentAttributeEffect(
                ExtendedEnchantingMain.identifier("lava_speed"),
                Attributes.MOVEMENT_SPEED,
                LevelBasedValue.constant(0.03f),
                AttributeModifier.Operation.ADD_VALUE
            ),
            AllOfCondition.allOf(
                DimensionCondition.builder(Identifier.withDefaultNamespace("the_nether")),
                LootItemEntityPropertyCondition.hasProperties(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true))
                )
            )
        ).withEffect(
            EnchantmentEffectComponents.TICK,
            AllOf.entityEffects(
                new HealEffect(LevelBasedValue.constant(4)),
                new DamageEquipmentEffect(List.of(EquipmentSlot.CHEST), LevelBasedValue.constant(2))
            ),
            AllOfCondition.allOf(
                TickModuloCondition.builder(LevelBasedValue.constant(20)),
                DimensionCondition.builder(Identifier.withDefaultNamespace("the_nether")),
                LootItemEntityPropertyCondition.hasProperties(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true))
                ),
                RelativeHealthCondition.builder(CombatPlusLootContext.Comparison.LESS_THAN, LevelBasedValue.constant(1))
            )
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.HEART_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer VOID_HEART = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("void_heart"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(50),
                Enchantment.constantCost(75),
                8,
                EquipmentSlotGroup.CHEST
            )
        ).withEffect(
            EnchantmentEffectComponents.TICK,
            new CodeExecutionSingleEntityEffect(ExtendedEnchantingMain.identifier("void_heart"))
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.HEART_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer REPLANT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("replanting"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(EEItemTags.HOE_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(20),
                Enchantment.constantCost(75),
                8,
                EquipmentSlotGroup.MAINHAND
            )
        ).withEffect(
            EEEnchantmentComponentTypes.REPLANT
        )
    );
    public static final EnchantmentContainer SOIL_WALKER = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("soil_walker"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                2,
                1,
                Enchantment.constantCost(15),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.FEET
            )
        ).withEffect(
            EEEnchantmentComponentTypes.SOIL_STEP
        ).exclusiveWith(
            enchantmentLookup.getOrThrow(EnchantmentTags.BOOTS_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer CHORUS_CURSE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("chorus_curse"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup, entityLookup) -> Enchantment.enchantment(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                2,
                1,
                Enchantment.constantCost(25),
                Enchantment.constantCost(75),
                4,
                EquipmentSlotGroup.CHEST
            )
        ).withEffect(
            EnchantmentEffectComponents.POST_ATTACK,
            EnchantmentTarget.VICTIM,
            EnchantmentTarget.VICTIM,
            new CodeExecutionSingleEntityEffect(ExtendedEnchantingMain.identifier("chorus_teleport"))
        )
    );

    public static void bootstrap (BootstrapContext<Enchantment> registerable) {
        register(registerable, LEECHING_ASPECT);
        register(registerable, FROST_ASPECT);
        register(registerable, LIGHTNING_ASPECT);
        register(registerable, INITIATIVE);
        register(registerable, GLASS);
        register(registerable, SOLITUDE);
        register(registerable, DUAL_STRIKE);
        register(registerable, FEINT);
        register(registerable, RAMPAGE);
        register(registerable, LAUNCH);
        register(registerable, WEAPON_PROTECTION);
        register(registerable, COMBUSTION_PROTECTION);
        register(registerable, SUN_HEART);
        register(registerable, MOON_HEART);
        register(registerable, BRIMSTONE_HEART);
        register(registerable, VOID_HEART);
        register(registerable, REPLANT);
        register(registerable, SOIL_WALKER);
        register(registerable, CHORUS_CURSE);
    }

    private static void register (BootstrapContext<Enchantment> registry, EnchantmentContainer container) {
        registry.register(container.getKey(), container.getBuilder(registry).build(container.getKey().identifier()));
    }
}
