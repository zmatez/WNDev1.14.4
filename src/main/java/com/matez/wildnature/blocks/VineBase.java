package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.VineBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class VineBase extends VineBlock {

    public Item item;
    public VineBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }
}
