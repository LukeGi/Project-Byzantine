package com.blue.projbyz.core.registry;

public interface Block extends RegistryObject, ModelRegisterer {
    net.minecraft.block.Block getBlock();
}
