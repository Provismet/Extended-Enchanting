package com.provismet.ExtendedEnchanting.interfaces;

import net.minecraft.util.math.Vec3d;

public interface IMixinLivingEntity {
    void extended_Enchanting$applyStatic (int amount);
    
    Vec3d extended_Enchanting$getPreviousGroundPos ();
    void extended_Enchanting$setPreviousGroundPos (Vec3d position);
}
