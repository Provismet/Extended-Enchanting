package com.provismet.ExtendedEnchanting.registries;

import com.provismet.CombatPlusCore.enchantment.effect.doubleEntity.ApplyKnockbackEffect;
import com.provismet.CombatPlusCore.enchantment.effect.doubleEntity.ApplyToTargetEntityEffect;
import com.provismet.CombatPlusCore.enchantment.effect.doubleEntity.ApplyToUserEntityEffect;
import com.provismet.CombatPlusCore.enchantment.effect.doubleEntity.CodeExecutionDoubleEntityEffect;
import com.provismet.CombatPlusCore.enchantment.effect.doubleEntity.InvertedEntityEffect;
import com.provismet.CombatPlusCore.enchantment.effect.singleEntity.ApplyVelocityEffect;
import com.provismet.CombatPlusCore.enchantment.effect.singleEntity.CodeExecutionSingleEntityEffect;
import com.provismet.CombatPlusCore.enchantment.effect.singleEntity.DamageEquipmentEffect;
import com.provismet.CombatPlusCore.enchantment.effect.singleEntity.FreezeEffect;
import com.provismet.CombatPlusCore.enchantment.effect.singleEntity.HealEffect;
import com.provismet.CombatPlusCore.enchantment.loot.condition.doubleEntity.ApplyToTargetCondition;
import com.provismet.CombatPlusCore.enchantment.loot.condition.item.ItemLambdaCondition;
import com.provismet.CombatPlusCore.enchantment.loot.condition.singleEntity.ApplyToAttackerCondition;
import com.provismet.CombatPlusCore.enchantment.loot.condition.singleEntity.ApplyToItemCondition;
import com.provismet.CombatPlusCore.enchantment.loot.condition.singleEntity.DimensionCondition;
import com.provismet.CombatPlusCore.enchantment.loot.condition.singleEntity.ExposedToMoonCondition;
import com.provismet.CombatPlusCore.enchantment.loot.condition.singleEntity.ExposedToSunCondition;
import com.provismet.CombatPlusCore.enchantment.loot.condition.singleEntity.RelativeHealthCondition;
import com.provismet.CombatPlusCore.enchantment.loot.condition.singleEntity.TickModuloCondition;
import com.provismet.CombatPlusCore.enchantment.loot.context.CPCLootContext;
import com.provismet.CombatPlusCore.registries.CPCEnchantmentComponentTypes;
import com.provismet.CombatPlusCore.utility.tag.CPCEnchantmentTags;
import com.provismet.CombatPlusCore.utility.tag.CPCItemTags;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;

import com.provismet.ExtendedEnchanting.enchantment.effect.singleEntity.ShockEnchantmentEffect;
import com.provismet.ExtendedEnchanting.utility.tags.EEDamageTypeTags;
import com.provismet.ExtendedEnchanting.utility.tags.EEEnchantmentTags;
import com.provismet.ExtendedEnchanting.utility.tags.EEEntityTypeTags;
import com.provismet.ExtendedEnchanting.utility.tags.EEItemTags;
import com.provismet.lilylib.container.EnchantmentContainer;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.AllOfEnchantmentEffects;
import net.minecraft.enchantment.effect.AttributeEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.entity.ApplyMobEffectEnchantmentEffect;
import net.minecraft.enchantment.effect.entity.IgniteEnchantmentEffect;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.loot.condition.AllOfLootCondition;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.DamageSourcePropertiesLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.TagPredicate;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;

public class EEEnchantments {
    public static final EnchantmentContainer LEECHING_ASPECT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("leeching_aspect"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.ASPECT_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.ASPECT_PRIMARY_ENCHANTABLE),
                3,
                2,
                Enchantment.leveledCost(10, 20),
                Enchantment.leveledCost(50, 20),
                6,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.POST_CRITICAL_ATTACK,
            new ApplyToUserEntityEffect(
                new HealEffect(EnchantmentLevelBasedValue.linear(1))
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(CPCEnchantmentTags.ASPECT_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer FROST_ASPECT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("frost_aspect"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.ASPECT_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.ASPECT_PRIMARY_ENCHANTABLE),
                5,
                2,
                Enchantment.leveledCost(10, 20),
                Enchantment.leveledCost(25, 20),
                4,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new ApplyToTargetEntityEffect(
                new FreezeEffect(EnchantmentLevelBasedValue.linear(2.25f))
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(CPCEnchantmentTags.ASPECT_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer LIGHTNING_ASPECT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("lightning_aspect"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.ASPECT_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.ASPECT_PRIMARY_ENCHANTABLE),
                3,
                2,
                Enchantment.leveledCost(20, 10),
                Enchantment.leveledCost(70, 10),
                4,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new ApplyToTargetEntityEffect(
                new ShockEnchantmentEffect(EnchantmentLevelBasedValue.linear(22))
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(CPCEnchantmentTags.ASPECT_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer INITIATIVE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("initiative"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.DAMAGE_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.DAMAGE_PRIMARY_ENCHANTABLE),
                5,
                5,
                Enchantment.leveledCost(10, 5),
                Enchantment.leveledCost(50, 5),
                3,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.GAMERULE_DAMAGE,
            new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(2.2f)),
            RelativeHealthCondition.builder(CPCLootContext.Comparison.GREATER_THAN_OR_EQUAL_TO, EnchantmentLevelBasedValue.constant(1))
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(CPCEnchantmentTags.ADDITION_DAMAGE_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer GLASS = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("glass"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.DAMAGE_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.DAMAGE_PRIMARY_ENCHANTABLE),
                5,
                5,
                Enchantment.leveledCost(10, 5),
                Enchantment.leveledCost(50, 5),
                3,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.GAMERULE_DAMAGE,
            new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(1.8f)),
            ApplyToAttackerCondition.builder(
                RelativeHealthCondition.builder(
                    CPCLootContext.Comparison.GREATER_THAN_OR_EQUAL_TO,
                    EnchantmentLevelBasedValue.constant(1)
                )
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(CPCEnchantmentTags.ADDITION_DAMAGE_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer SOLITUDE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("solitude"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.DAMAGE_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.DAMAGE_PRIMARY_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(35),
                Enchantment.constantCost(75),
                8,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.GAMERULE_DAMAGE,
            new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(15)),
            ApplyToAttackerCondition.builder(
                ApplyToItemCondition.builder(
                    ItemLambdaCondition.builder(ExtendedEnchantingMain.identifier("one_enchantment"))
                )
            )
        )
    );

    public static final EnchantmentContainer DUAL_STRIKE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("dual_strike"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.WEAPON_UTILITY_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.WEAPON_UTILITY_PRIMARY_ENCHANTABLE),
                5,
                3,
                Enchantment.leveledCost(10, 5),
                Enchantment.leveledCost(20, 10),
                4,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new CodeExecutionDoubleEntityEffect(ExtendedEnchantingMain.identifier("dual_strike"))
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(CPCEnchantmentTags.WEAPON_UTILITY_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer FEINT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("feint"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.WEAPON_UTILITY_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.WEAPON_UTILITY_PRIMARY_ENCHANTABLE),
                2,
                2,
                Enchantment.leveledCost(10, 10),
                Enchantment.leveledCost(50, 10),
                4,
                AttributeModifierSlot.MAINHAND, AttributeModifierSlot.OFFHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new InvertedEntityEffect(
                new ApplyKnockbackEffect(
                    EnchantmentLevelBasedValue.linear(1, 0.5f),
                    false
                )
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(CPCEnchantmentTags.WEAPON_UTILITY_OFFHAND_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer RAMPAGE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("rampage"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(CPCItemTags.WEAPON_UTILITY_ENCHANTABLE),
                itemLookup.getOrThrow(CPCItemTags.WEAPON_UTILITY_PRIMARY_ENCHANTABLE),
                5,
                3,
                Enchantment.leveledCost(5, 10),
                Enchantment.leveledCost(55, 10),
                3,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.POST_KILL,
            new ApplyToUserEntityEffect(
                AllOfEnchantmentEffects.allOf(
                    new ApplyMobEffectEnchantmentEffect(
                        RegistryEntryList.of(StatusEffects.STRENGTH),
                        EnchantmentLevelBasedValue.linear(1.25f),
                        EnchantmentLevelBasedValue.linear(1.25f),
                        EnchantmentLevelBasedValue.constant(0),
                        EnchantmentLevelBasedValue.constant(0)
                    ),
                    new ApplyMobEffectEnchantmentEffect(
                        RegistryEntryList.of(StatusEffects.SPEED),
                        EnchantmentLevelBasedValue.linear(1.25f),
                        EnchantmentLevelBasedValue.linear(1.25f),
                        EnchantmentLevelBasedValue.constant(0),
                        EnchantmentLevelBasedValue.constant(0)
                    )
                )
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(CPCEnchantmentTags.WEAPON_UTILITY_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer LAUNCH = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("launch"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                5,
                2,
                Enchantment.leveledCost(5, 20),
                Enchantment.leveledCost(50, 20),
                2,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            CPCEnchantmentComponentTypes.POST_CHARGED_ATTACK,
            new ApplyToTargetEntityEffect(
                new ApplyVelocityEffect(
                    0, 0.15, 0,
                    EnchantmentLevelBasedValue.linear(1),
                    true
                )
            ),
            ApplyToTargetCondition.builder(
                EntityPropertiesLootCondition.builder(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.create().type(EEEntityTypeTags.NO_LAUNCH).build()
                ).invert()
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.LAUNCH_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer WEAPON_PROTECTION = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("weapon_protection"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                1,
                4,
                Enchantment.leveledCost(10, 5),
                Enchantment.leveledCost(20, 5),
                4,
                AttributeModifierSlot.ARMOR
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.DAMAGE_PROTECTION,
            new AddEnchantmentEffect(
                EnchantmentLevelBasedValue.linear(1.5f)
            ),
            AnyOfLootCondition.builder(
                DamageSourcePropertiesLootCondition.builder(
                    DamageSourcePredicate.Builder.create()
                        .tag(TagPredicate.expected(EEDamageTypeTags.MELEE_STRIKE))
                        .isDirect(true)
                ),
                DamageSourcePropertiesLootCondition.builder(
                    DamageSourcePredicate.Builder.create()
                        .directEntity(
                            EntityPredicate.Builder.create().equipment(
                                EntityEquipmentPredicate.Builder.create().mainhand(
                                    ItemPredicate.Builder.create().tag(CPCItemTags.MELEE_WEAPON)
                                )
                            )
                        )
                        .isDirect(true)
                ),
                DamageSourcePropertiesLootCondition.builder(
                    DamageSourcePredicate.Builder.create()
                        .directEntity(
                            EntityPredicate.Builder.create().type(EEEntityTypeTags.HAS_WEAPON)
                        )
                        .isDirect(true)
                )
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE_SET)
        )
    );
    public static final EnchantmentContainer COMBUSTION_PROTECTION = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("combustion_protection"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                1,
                4,
                Enchantment.leveledCost(10, 5),
                Enchantment.leveledCost(20, 5),
                4,
                AttributeModifierSlot.ARMOR
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.DAMAGE_PROTECTION,
            new AddEnchantmentEffect(
                EnchantmentLevelBasedValue.linear(1.35f)
            ),
            DamageSourcePropertiesLootCondition.builder(
                DamageSourcePredicate.Builder.create()
                    .tag(TagPredicate.expected(EEDamageTypeTags.COMBUSTION))
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE_SET)
        )
    );

    public static final EnchantmentContainer SUN_HEART = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("sun_heart"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(50),
                Enchantment.constantCost(75),
                8,
                AttributeModifierSlot.CHEST
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.TICK,
            AllOfEnchantmentEffects.allOf(
                new HealEffect(
                    EnchantmentLevelBasedValue.constant(2)
                ),
                new DamageEquipmentEffect(
                    List.of(EquipmentSlot.CHEST),
                    EnchantmentLevelBasedValue.constant(10)
                )
            ),
            AllOfLootCondition.builder(
                TickModuloCondition.builder(EnchantmentLevelBasedValue.constant(40)),
                ExposedToSunCondition.builder(),
                RelativeHealthCondition.builder(CPCLootContext.Comparison.LESS_THAN, EnchantmentLevelBasedValue.constant(1))
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.POST_ATTACK,
            EnchantmentEffectTarget.VICTIM,
            EnchantmentEffectTarget.ATTACKER,
            new IgniteEnchantmentEffect(EnchantmentLevelBasedValue.constant(3)),
            AllOfLootCondition.builder(
                ExposedToSunCondition.builder(),
                DamageSourcePropertiesLootCondition.builder(
                    DamageSourcePredicate.Builder.create().isDirect(true)
                )
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.POST_ATTACK,
            EnchantmentEffectTarget.VICTIM,
            EnchantmentEffectTarget.VICTIM,
            new DamageEquipmentEffect(
                List.of(EquipmentSlot.CHEST),
                EnchantmentLevelBasedValue.constant(2)
            ),
            AllOfLootCondition.builder(
                ExposedToSunCondition.builder(),
                DamageSourcePropertiesLootCondition.builder(
                    DamageSourcePredicate.Builder.create().isDirect(true)
                )
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.HEART_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer MOON_HEART = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("moon_heart"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(50),
                Enchantment.constantCost(75),
                8,
                AttributeModifierSlot.CHEST
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.POST_ATTACK,
            EnchantmentEffectTarget.VICTIM,
            EnchantmentEffectTarget.ATTACKER,
            new ApplyMobEffectEnchantmentEffect(
                RegistryEntryList.of(StatusEffects.SLOWNESS),
                EnchantmentLevelBasedValue.constant(1),
                EnchantmentLevelBasedValue.constant(1),
                EnchantmentLevelBasedValue.constant(0),
                EnchantmentLevelBasedValue.constant(0)
            ),
            AllOfLootCondition.builder(
                ExposedToMoonCondition.builder(),
                DamageSourcePropertiesLootCondition.builder(
                    DamageSourcePredicate.Builder.create().isDirect(true)
                )
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.POST_ATTACK,
            EnchantmentEffectTarget.VICTIM,
            EnchantmentEffectTarget.VICTIM,
            new DamageEquipmentEffect(
                List.of(EquipmentSlot.CHEST),
                EnchantmentLevelBasedValue.constant(5)
            ),
            AllOfLootCondition.builder(
                ExposedToMoonCondition.builder(),
                DamageSourcePropertiesLootCondition.builder(
                    DamageSourcePredicate.Builder.create().isDirect(true)
                )
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.TICK,
            new CodeExecutionSingleEntityEffect(ExtendedEnchantingMain.identifier("reset_insomnia")),
            ExposedToMoonCondition.builder()
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.HEART_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer BRIMSTONE_HEART = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("brimstone_heart"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(50),
                Enchantment.constantCost(75),
                8,
                AttributeModifierSlot.CHEST
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.LOCATION_CHANGED,
            new AttributeEnchantmentEffect(
                ExtendedEnchantingMain.identifier("lava_speed"),
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                EnchantmentLevelBasedValue.constant(0.03f),
                EntityAttributeModifier.Operation.ADD_VALUE
            ),
            AllOfLootCondition.builder(
                DimensionCondition.builder(Identifier.ofVanilla("the_nether")),
                EntityPropertiesLootCondition.builder(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true))
                )
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.TICK,
            AllOfEnchantmentEffects.allOf(
                new HealEffect(EnchantmentLevelBasedValue.constant(4)),
                new DamageEquipmentEffect(List.of(EquipmentSlot.CHEST), EnchantmentLevelBasedValue.constant(2))
            ),
            AllOfLootCondition.builder(
                TickModuloCondition.builder(EnchantmentLevelBasedValue.constant(20)),
                DimensionCondition.builder(Identifier.ofVanilla("the_nether")),
                EntityPropertiesLootCondition.builder(
                    LootContext.EntityTarget.THIS,
                    EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true))
                ),
                RelativeHealthCondition.builder(CPCLootContext.Comparison.LESS_THAN, EnchantmentLevelBasedValue.constant(1))
            )
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.HEART_EXCLUSIVE)
        )
    );
    public static final EnchantmentContainer VOID_HEART = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("void_heart"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(50),
                Enchantment.constantCost(75),
                8,
                AttributeModifierSlot.CHEST
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.TICK,
            new CodeExecutionSingleEntityEffect(ExtendedEnchantingMain.identifier("void_heart"))
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(EEEnchantmentTags.HEART_EXCLUSIVE)
        )
    );

    public static final EnchantmentContainer REPLANT = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("replanting"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(EEItemTags.HOE_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(20),
                Enchantment.constantCost(75),
                8,
                AttributeModifierSlot.MAINHAND
            )
        ).addEffect(
            EEEnchantmentComponentTypes.REPLANT
        )
    );
    public static final EnchantmentContainer SOIL_WALKER = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("soil_walker"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                2,
                1,
                Enchantment.constantCost(15),
                Enchantment.constantCost(50),
                8,
                AttributeModifierSlot.FEET
            )
        ).addEffect(
            EEEnchantmentComponentTypes.SOIL_STEP
        ).exclusiveSet(
            enchantmentLookup.getOrThrow(EnchantmentTags.BOOTS_EXCLUSIVE_SET)
        )
    );

    public static final EnchantmentContainer CHORUS_CURSE = new EnchantmentContainer(
        ExtendedEnchantingMain.identifier("chorus_curse"),
        (itemLookup, enchantmentLookup, damageLookup, blockLookup) -> Enchantment.builder(
            Enchantment.definition(
                itemLookup.getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                2,
                1,
                Enchantment.constantCost(25),
                Enchantment.constantCost(75),
                4,
                AttributeModifierSlot.CHEST
            )
        ).addEffect(
            EnchantmentEffectComponentTypes.POST_ATTACK,
            EnchantmentEffectTarget.VICTIM,
            EnchantmentEffectTarget.VICTIM,
            new CodeExecutionSingleEntityEffect(ExtendedEnchantingMain.identifier("chorus_teleport"))
        )
    );

    public static void bootstrap (Registerable<Enchantment> registerable) {
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

    private static void register (Registerable<Enchantment> registry, EnchantmentContainer container) {
        registry.register(container.getKey(), container.getBuilder(registry).build(container.getKey().getValue()));
    }
}
