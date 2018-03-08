package com.blue.projbyz.core.registry;

public interface Item extends RegistryObject, ModelRegisterer {
    net.minecraft.item.Item getItem();
}
