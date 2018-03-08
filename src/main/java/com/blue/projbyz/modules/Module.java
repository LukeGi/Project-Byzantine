package com.blue.projbyz.modules;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;

public interface Module extends INBTSerializable<NBTTagCompound> {

    boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing);

    @Nullable
    <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing);

    String getName();
}
