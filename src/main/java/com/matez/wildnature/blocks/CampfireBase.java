package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class CampfireBase extends CampfireBlock {
    public Item item;
    public CampfireBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);

    }
}
