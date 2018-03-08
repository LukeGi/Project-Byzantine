package com.blue.projbyz.blocks;

import com.blue.projbyz.ByzObjects;
import com.blue.projbyz.blocks.CobbleCreator.Tile;
import com.blue.projbyz.core.BlockByz.TileBlockByz;
import com.blue.projbyz.core.CreativeTabsByz;
import com.blue.projbyz.core.TileByz;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class CobbleCreator extends TileBlockByz<Tile> {

    public static final String NAME = "cobble_creator";

    public CobbleCreator() {
        super(Material.ROCK, NAME, CreativeTabsByz.TAB_BYZ_MACHINES);
    }

    @Override
    public net.minecraft.item.Item getItem() {
        return ByzObjects.COBBLE_CREATOR_ITEM;
    }

    @Override
    public Tile newTileEntity(World world, int meta) {
        return new Tile();
    }

    @Override
    public Class<Tile> getTileClass() {
        return Tile.class;
    }

    @Override
    protected String getName() {
        return NAME;
    }

    public static class Tile extends TileByz {

    }
}
