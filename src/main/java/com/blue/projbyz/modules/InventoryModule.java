package com.blue.projbyz.modules;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class InventoryModule extends ItemStackHandler implements Module {

    private static final String NAME = "[INVENTORY_MODULE]";

    public InventoryModule() {
    }

    public InventoryModule(int size) {
        super(size);
    }

    public InventoryModule(NonNullList<ItemStack> stacks) {
        super(stacks);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability);
    }

    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return hasCapability(capability, facing) ? CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(this) : null;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
