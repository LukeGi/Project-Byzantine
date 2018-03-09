package com.blue.projbyz.core;

import com.blue.projbyz.modules.Module;
import com.blue.projbyz.util.NBTUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import scala.actors.threadpool.Arrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class TileByz extends TileEntity {

    private Set<Module> moduleSet;

    public TileByz() {
        moduleSet = new HashSet<>();
    }

    public void addModules(Module... modules) {
        Collections.addAll(moduleSet, modules);
    }@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TileByz)) return false;

        TileByz tileByz = (TileByz) o;

        return Arrays.deepEquals(moduleSet.toArray(new Module[0]), tileByz.moduleSet.toArray(new Module[0]));
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(moduleSet.toArray(new Module[0]));
    }

    @Override
    public String toString() {
        return "TileByz{" +
                "moduleSet=" + Arrays.deepToString(moduleSet.toArray(new Module[0])) +
                ", world=" + world +
                ", pos=" + pos +
                ", tileEntityInvalid=" + tileEntityInvalid +
                ", blockType=" + blockType +
                '}';
    }

    public Set<Module> getModules() {
        return moduleSet;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        if (nbt.hasKey("id"))
            super.readFromNBT(nbt);
        for (Module module : getModules())
            module.deserializeNBT(NBTUtils.getTag(nbt, module.getName()));
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        if (!nbt.hasKey("id"))
            super.writeToNBT(nbt);
        for (Module module : getModules())
            nbt.setTag(module.getName(), module.serializeNBT());
        return nbt;
    }


    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, -1, this.getUpdateTag());
    }

    @Nonnull
    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound nbt = super.getUpdateTag();
        this.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }

    @Override
    public void handleUpdateTag(@Nonnull NBTTagCompound nbt) {
        this.readFromNBT(nbt);
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        for (Module module : getModules()) {
            if (module.hasCapability(capability, facing)) return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        for (Module module : getModules()) {
            T cap = module.getCapability(capability, facing);
            if (cap != null) return cap;
        }
        return super.getCapability(capability, facing);
    }


}
