package com.provismet.ExtendedEnchanting.interfaces;

import net.minecraft.util.math.Vec3d;

public interface IMixinLivingEntity {
    public abstract void extended_Enchanting$applyStatic (int amount);
    
    public abstract Vec3d extended_Enchanting$getPreviousGroundPos ();
    public abstract void extended_Enchanting$setPreviousGroundPos (Vec3d position);
}
