package com.blue.projbyz.util;

import com.blue.projbyz.core.registry.ModelRegisterer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

public final class LocationUtils {

    private LocationUtils() {
    }

    /**
     * Generates the {@link ModelResourceLocation ModelResourceLocation} of inventory variant.
     *
     * @param modelRegisterer modelRegisterer
     * @return {@link ModelResourceLocation ModelResourceLocation} of inventory variant.
     */
    public static ModelResourceLocation newInventoryVariant(ModelRegisterer modelRegisterer) {
        return newInventoryVariant(modelRegisterer.getRegistryName());
    }

    /**
     * Generates the {@link ModelResourceLocation ModelResourceLocation} of inventory variant.
     *
     * @param location base location
     * @return {@link ModelResourceLocation ModelResourceLocation} of inventory variant.
     */
    public static ModelResourceLocation newInventoryVariant(ResourceLocation location) {
        return new ModelResourceLocation(location, "inventory");
    }
}
