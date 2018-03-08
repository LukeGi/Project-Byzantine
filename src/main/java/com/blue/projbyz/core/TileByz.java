package com.blue.projbyz.core;

import com.blue.projbyz.modules.Module;
import com.blue.projbyz.util.NBTUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class TileByz extends TileEntity {

    private Set<Module> moduleSet;

    public TileByz() {
        moduleSet = new HashSet<>();
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        for (Module module : getModules()) {
            if (module.hasCapability(capability, facing)) return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        for (Module module : getModules()) {
            T cap = module.getCapability(capability, facing);
            if (cap != null) return cap;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        for (Module module : getModules())
            module.deserializeNBT(NBTUtils.getTag(nbt, module.getName()));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        for (Module module : getModules())
            nbt.setTag(module.getName(), module.serializeNBT());
        return super.writeToNBT(nbt);
    }

    public void addModules(Module... modules) {
        Collections.addAll(moduleSet, modules);
    }

    public Set<Module> getModules() {
        return moduleSet;
    }
}
