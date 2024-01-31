package com.provismet.ExtendedEnchanting.utility;

import com.provismet.CombatPlusCore.utility.CombatGameRules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule;
import net.minecraft.world.GameRules;

public class EEGameRules {
    public static final GameRules.Key<DoubleRule> PLAYER_SPECIAL_DAMAGE_MOD = GameRuleRegistry.register("additionalDamageEnchantmentPvpEffectiveness", CombatGameRules.CATEGORY, GameRuleFactory.createDoubleRule(0.5, 0.0));

    public static void register () {
        // Just loads the class.
    }
}
