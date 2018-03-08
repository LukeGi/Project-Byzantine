package com.blue.projbyz.core;

import com.blue.projbyz.ProjByz.Info;
import com.blue.projbyz.core.registry.Item;
import com.blue.projbyz.core.registry.Registry;
import net.minecraftforge.client.model.ModelLoader;

public abstract class ItemImpl extends net.minecraft.item.Item implements Item {

    public ItemImpl(String name) {
        this.setRegistryName(Info.MOD_PREFIX + name);
        this.setUnlocalizedName(Info.MOD_PREFIX + name);

        Registry.INSTANCE.register(this);
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
