package com.blue.projbyz.blocks;

import com.blue.projbyz.blocks.CobbleCreator.Tile;
import com.blue.projbyz.core.BlockImpl.TileBlockImpl;
import com.blue.projbyz.core.TileImpl;
import com.blue.projbyz.core.registry.Registry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CobbleCreator extends TileBlockImpl<Tile> {

    public static final String NAME = "cobble_creator";

    public CobbleCreator(Material material, String name, CreativeTabs tab) {
        super(material, name, tab);
    }

    @Override
    public net.minecraft.item.Item getItem() {
        return Registry.COBBLE_CREATOR_ITEM;
    }

    @Override
    protected Tile newTileEntity(World world, int meta) {
        return new Tile();
    }

    @Override
    public Class<? extends TileEntity> getTileClass() {
        return Tile.class;
    }

    @Override
    public String getName() {
        return NAME;
    }

    class Item extends ItemBlock {

        public Item() {
            super(Registry.COBBLE_CREATOR, NAME);
        }
    }

    class Tile extends TileImpl {

    }
}
