package com.blue.projbyz.core.registry;

import com.blue.projbyz.ProjByz.Info;
import com.blue.projbyz.blocks.CobbleCreator;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@ObjectHolder(value = Info.MOD_ID)
public enum Registry {
    INSTANCE;

    public static final net.minecraft.block.Block COBBLE_CREATOR = null;
    @ObjectHolder(CobbleCreator.NAME)
    public static final net.minecraft.item.Item COBBLE_CREATOR_ITEM = null;

    public void register(RegistryObject registryObject) {
        registry.add(registryObject);
    }

    private Set<RegistryObject> registry = new HashSet<>();

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<net.minecraft.block.Block> event) {
        Consumer<Block> registerBlock = block -> event.getRegistry().register(block.getBlock());
        Consumer<Tile> registerTile = tile -> TileEntity.register(tile.getName(), tile.getTileClass());

        for (RegistryObject object : INSTANCE.registry) {
            if (object instanceof Tile) {
                Tile tile = (Tile) object;
                registerTile.andThen(registerBlock).accept(tile);
            } else if (object instanceof Block) {
                Block block = (Block) object;
                registerBlock.accept(block);
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<net.minecraft.item.Item> event) {
        Consumer<Item> registerItem = item -> event.getRegistry().register(item.getItem());

        for (RegistryObject registryObject : INSTANCE.registry) {
            if (registryObject instanceof Item) {
                Item item = (Item) registryObject;
                registerItem.accept(item);
            }
        }
    }

    @SubscribeEvent
    public static void onRegsiterModels(ModelRegistryEvent event) {
        Consumer<ModelRegisterer> registerModel = ModelRegisterer::registerModels;

        for (RegistryObject registryObject : INSTANCE.registry) {
            if (registryObject instanceof ModelRegisterer) {
                ModelRegisterer modelRegisterer = (ModelRegisterer) registryObject;
                registerModel.accept(modelRegisterer);
            }
        }
    }
}
