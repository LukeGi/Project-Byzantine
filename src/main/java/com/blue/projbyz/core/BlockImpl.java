package com.blue.projbyz.core;

import com.blue.projbyz.ProjByz.Info;
import com.blue.projbyz.core.registry.*;
import com.blue.projbyz.util.ModelUtils;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nullable;

public abstract class BlockImpl extends net.minecraft.block.Block implements Block {

    protected BlockImpl(Material material, String name, CreativeTabs tab) {
        super(material);
        this.setRegistryName(Info.MOD_PREFIX + name);
        this.setUnlocalizedName(Info.MOD_PREFIX + name);
        this.setCreativeTab(tab);

        Registry.INSTANCE.register(this);
    }

    @Override
    public void registerModels() {
        ModelUtils.registerBasicModel(this);
        ModelLoader.registerItemVariants(getItem(), getVariants());
    }

    @Override
    public abstract net.minecraft.item.Item getItem();

    @Override
    public net.minecraft.block.Block getBlock() {
        return this;
    }

    // FIXME: Change to use custom tile entity.
    public static abstract class TileBlockImpl<T extends TileEntity> extends BlockImpl implements Tile {

        public TileBlockImpl(Material material, String name, CreativeTabs tab) {
            super(material, name, tab);
        }

        /**
         * Returns a new instance of a block's tile entity class. Called on placing the block.
         */
        @Nullable
        @Override
        public T createNewTileEntity(World world, int meta) {
            return newTileEntity(world, meta);
        }

        protected abstract T newTileEntity(World world, int meta);
    }

    public static class ItemBlock extends net.minecraft.item.ItemBlock implements com.blue.projbyz.core.registry.Item {

        public ItemBlock(net.minecraft.block.Block block, String name) {
            super(block);
            setRegistryName(Info.MOD_PREFIX + name);

            Registry.INSTANCE.register(this);
        }

        @Override
        public net.minecraft.item.Item getItem() {
            return this;
        }
    }
}
