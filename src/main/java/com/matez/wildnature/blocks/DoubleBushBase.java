package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.List;

public class DoubleBushBase extends TallFlowerBlock {
    private Item item;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);


    private static Properties Properties(Properties properties){
        return properties.doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH);

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public DoubleBushBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(Properties(properties));

        this.setRegistryName(regName);
        if(builder!=null) {
            item = new BlockItem(this, builder).setRegistryName(regName);
            WNBlocks.ITEMBLOCKS.add(item);
        }


        WNBlocks.BLOCKS.add(this);


    }

    public Item getItem() {
        return item;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

        //System.out.println("biome: " + BiomeColors.getGrassColor(worldIn, pos) + " foliage: " + GrassColors.get(0.5,0.5));


    }



    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch){
            list.add(new ItemStack(item, 1));
        }

        return list;
    }
}
