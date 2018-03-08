package com.blue.projbyz.util;

import com.blue.projbyz.core.registry.ModelRegisterer;
import net.minecraftforge.client.model.ModelLoader;

public class ModelUtils {

    public static void registerBasicModel(ModelRegisterer modelRegisterer) {
        ModelLoader.registerItemVariants(modelRegisterer.getItem(), modelRegisterer.getVariants());
    }
}
