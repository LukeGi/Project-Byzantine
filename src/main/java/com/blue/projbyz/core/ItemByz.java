package com.blue.projbyz.core;

import com.blue.projbyz.ProjByz.Info;
import com.blue.projbyz.core.registry.ModelRegisterer;
import net.minecraftforge.client.model.ModelLoader;

public abstract class ItemByz extends net.minecraft.item.Item implements ModelRegisterer {

    public ItemByz(String name) {
        this.setRegistryName(Info.MOD_PREFIX + name);
        this.setUnlocalizedName(Info.MOD_PREFIX + name);
    }

    @Override
    public void registerModels() {
        ModelLoader.registerItemVariants(this, this.getVariants());
    }

    @Override
    public net.minecraft.item.Item getItem() {
        return this;
    }
}
