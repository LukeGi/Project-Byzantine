package com.blue.projbyz.core.registry;

import com.blue.projbyz.util.LocationUtils;
import com.blue.projbyz.util.ModelUtils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public interface ModelRegisterer {

    default void registerModels() {
        ModelUtils.registerBasicModel(this);
    }

    default ModelResourceLocation[] getVariants() {
        return new ModelResourceLocation[]{LocationUtils.newInventoryVariant(this)};
    }

    ResourceLocation getRegistryName();

    Item getItem();
}
