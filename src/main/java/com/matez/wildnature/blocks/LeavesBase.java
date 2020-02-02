package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;

public class LeavesBase extends LeavesBlock {
    private Item item;

    private static Properties Properties(Properties properties){
        properties.sound(SoundType.PLANT);
        properties.hardnessAndResistance(0.2F);
        return properties;
    }



    public LeavesBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(Properties(properties));
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);

        WNBlocks.LEAVES.add(this);
        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }



    @Override
    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        if(worldIn.getBlockState(pos.up()).getBlock()instanceof LeavesBase){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && Utilities.rint(0,12)==0){
            list.add(new ItemStack(Main.getItemByID(item.getRegistryName().toString().replace("leaves","sapling"))));
        }


        return list;
    }

    public static void leafContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT);
    }



}
