package com.provismet.extendedenchanting.interfaces;

import net.minecraft.world.phys.Vec3;

public interface IMixinLivingEntity {
    void extended_Enchanting$applyStatic (int amount);
    
    Vec3 extended_Enchanting$getPreviousGroundPos ();
    void extended_Enchanting$setPreviousGroundPos (Vec3 position);
}
