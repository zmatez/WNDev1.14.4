package com.matez.wildnature.blocks;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class CropBase extends CropsBlock {

    private Item item;
    public CropBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);

        this.setRegistryName(regName);
        if(builder!=null) {
            item = new BlockItem(this, builder).setRegistryName(regName);
            WNBlocks.ITEMBLOCKS.add(item);
        }

        WNBlocks.BLOCKS.add(this);
    }

    public IntegerProperty getAge(){
        return AGE;
    }

    @Override
    public boolean ticksRandomly(BlockState p_149653_1_) {
        return true;
    }
}
