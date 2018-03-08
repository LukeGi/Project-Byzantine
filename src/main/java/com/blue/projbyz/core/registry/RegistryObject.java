package com.blue.projbyz.core.registry;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public interface RegistryObject {

    @Nonnull
    ResourceLocation getRegistryName();

    default String getName() {
        return getRegistryName().toString();
    }
}
