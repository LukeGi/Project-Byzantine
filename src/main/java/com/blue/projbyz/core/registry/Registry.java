package com.blue.projbyz.core.registry;

import com.blue.projbyz.ProjByz.Info;
import com.blue.projbyz.blocks.CobbleCreator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import static com.blue.projbyz.ByzObjects.COBBLE_CREATOR;

@SuppressWarnings("ConstantConditions")
@ObjectHolder(value = Info.MOD_ID)
public enum Registry {
    INSTANCE;

    @SubscribeEvent
    public void onRegisterBlocks(Register<Block> event) {
        event.getRegistry().registerAll(
                new CobbleCreator()
        );
    }

    @SubscribeEvent
    public void onRegisterItems(Register<Item> event) {
        event.getRegistry().registerAll(
                COBBLE_CREATOR.createItemBlock()
        );
    }

    @SubscribeEvent
    public void onRegisterModels(ModelRegistryEvent event) {
        COBBLE_CREATOR.registerModels();
    }
}
