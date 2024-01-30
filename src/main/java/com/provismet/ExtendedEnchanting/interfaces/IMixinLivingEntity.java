package com.provismet.ExtendedEnchanting.interfaces;

import net.minecraft.util.math.Vec3d;

public interface IMixinLivingEntity {
    public abstract void applyStatic (int amount);
    
    public abstract Vec3d getPreviousGroundPos ();
    public abstract void setPreviousGroundPos (Vec3d position);
}
