package com.blue.projbyz.core;

import com.blue.projbyz.ByzObjects;
import com.blue.projbyz.ProjByz.Info;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class CreativeTabsByz {

    public static final CreativeTabs TAB_BYZ_MACHINES = new CreativeTabs(Info.MOD_PREFIX + "machines") {
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ByzObjects.COBBLE_CREATOR_ITEM);
        }
    };

    private CreativeTabsByz() {
    }
}
