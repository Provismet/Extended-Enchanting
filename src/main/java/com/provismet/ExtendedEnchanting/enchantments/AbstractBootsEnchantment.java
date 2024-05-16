package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.Enchantment;

public abstract class AbstractBootsEnchantment extends Enchantment {
    protected AbstractBootsEnchantment (Properties properties) {
        super(properties);
    }

    @Override
    protected boolean canAccept (Enchantment other) {
        return super.canAccept(other) && !(other instanceof AbstractBootsEnchantment);
    }
}
