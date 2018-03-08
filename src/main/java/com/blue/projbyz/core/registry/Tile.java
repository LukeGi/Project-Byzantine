package com.blue.projbyz.core.registry;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;

public interface Tile extends ITileEntityProvider, Block {
    Class<? extends TileEntity> getTileClass();
}
