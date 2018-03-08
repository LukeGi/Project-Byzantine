package com.blue.projbyz.core;

import com.blue.projbyz.ProjByz.Info;
import com.blue.projbyz.core.registry.ModelRegisterer;
import com.blue.projbyz.util.ModelUtils;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nullable;

public abstract class BlockByz extends net.minecraft.block.Block implements ModelRegisterer {

    protected BlockByz(Material material, String name, CreativeTabs tab) {
        super(material);
        this.setRegistryName(Info.MOD_PREFIX + name);
        this.setUnlocalizedName(Info.MOD_PREFIX + name);
        this.setCreativeTab(tab);
    }

    @Override
    public void registerModels() {
        ModelUtils.registerBasicModel(this);
        ModelLoader.registerItemVariants(getItem(), getVariants());
    }

    public ItemBlock createItemBlock() {
        return new ItemBlockByz(this, getName());
    }

    protected abstract String getName();

    public abstract static class TileBlockByz<T extends TileByz> extends BlockByz implements ITileEntityProvider {

        public TileBlockByz(Material material, String name, CreativeTabs tab) {
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

        public abstract T newTileEntity(World world, int meta);

        public abstract Class<T> getTileClass();
    }

    public static class ItemBlockByz extends ItemBlock implements ModelRegisterer {

        public ItemBlockByz(Block block, String name) {
            super(block);
            setRegistryName(Info.MOD_PREFIX + name);
        }

        @Override
        public net.minecraft.item.Item getItem() {
            return this;
        }
    }
}
