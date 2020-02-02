package com.matez.wildnature.blocks;

import java.util.List;
import java.util.Random;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.storage.loot.LootContext;

public class GrassBase extends GrassBlock {
    private Item item;
    private String dirt;
    public GrassBase(Properties properties, Item.Properties builder, ResourceLocation regName,String dirt) {
        super(properties);
        this.dirt=dirt;
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }




    /**
     * Whether this IGrowable can grow
     */
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Block.nudgeEntitiesWithNewState(this.getDefaultState(), Registry.BLOCK.getOrDefault(new ResourceLocation(dirt)).getDefaultState(), context.getWorld(), context.getPos()) : super.getStateForPlacement(context);
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.offset(facing));
        net.minecraftforge.common.PlantType type = plantable.getPlantType(world, pos.offset(facing));

        if (plant.getBlock() == Blocks.CACTUS)
            return this.getBlock() == Blocks.CACTUS || this.getBlock() == Blocks.SAND || this.getBlock() == Blocks.RED_SAND;

        if (plant.getBlock() == Blocks.SUGAR_CANE && this == Blocks.SUGAR_CANE)
            return true;

        if (plantable instanceof BushBlock && (!(plantable instanceof CropsBlock) || plantable instanceof QuincePlant || plantable instanceof WildStrawberryPlant || plantable instanceof CurrantPlant))
            return true;

        switch (type) {
            case Desert: return this.getBlock() == Blocks.SAND || this.getBlock() == Blocks.TERRACOTTA || this.getBlock() instanceof GlazedTerracottaBlock;
            case Nether: return this.getBlock() == Blocks.SOUL_SAND;
            case Crop:   return this.getBlock() == Blocks.FARMLAND;
            case Cave:   return Block.hasSolidSide(state, world, pos, Direction.UP);
            case Plains: return this.getBlock() == Blocks.GRASS_BLOCK || Block.isDirt(this) || this.getBlock() == Blocks.FARMLAND;
            case Water:  return state.getMaterial() == Material.WATER; //&& state.getValue(BlockLiquidWrapper)
            case Beach:
                boolean isBeach = this.getBlock() == Blocks.GRASS_BLOCK || Block.isDirt(this) || this.getBlock() == Blocks.SAND;
                boolean hasWater = (world.getBlockState(pos.east()).getMaterial() == Material.WATER ||
                        world.getBlockState(pos.west()).getMaterial() == Material.WATER ||
                        world.getBlockState(pos.north()).getMaterial() == Material.WATER ||
                        world.getBlockState(pos.south()).getMaterial() == Material.WATER);
                return isBeach && hasWater;
        }
        return false;
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.up();
        int chance = Utilities.rint(0,15);
        BlockState blockstate = Blocks.GRASS.getDefaultState();
        if(chance>7 && chance<12){
            blockstate = Main.getBlockByID("wildnature:medium_grass").getDefaultState();
        }else{
            blockstate = Main.getBlockByID("wildnature:small_grass").getDefaultState();
        }

        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while(true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = worldIn.getBlockState(blockpos1);
                    if (blockstate2.getBlock() == blockstate.getBlock() && rand.nextInt(10) == 0 && blockstate.getBlock() instanceof IGrowable) {
                        ((IGrowable)blockstate.getBlock()).grow(worldIn, rand, blockpos1, blockstate2);
                    }

                    if (!blockstate2.isAir()) {
                        break;
                    }

                    BlockState blockstate1;
                    if (rand.nextInt(8) == 0) {
                        List<ConfiguredFeature<?>> list = worldIn.getBiome(blockpos1).getFlowers();
                        if (list.isEmpty()) {
                            break;
                        }

                        blockstate1 = ((FlowersFeature)((DecoratedFeatureConfig)(list.get(0)).config).feature.feature).getRandomFlower(rand, blockpos1);
                    } else {
                        blockstate1 = blockstate;
                    }

                    if (blockstate1.isValidPosition(worldIn, blockpos1)) {
                        worldIn.setBlockState(blockpos1, blockstate1, 3);
                    }
                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (worldIn.getBlockState(blockpos1.down()).getBlock() != this || worldIn.getBlockState(blockpos1).func_224756_o(worldIn, blockpos1)) {
                    break;
                }

                ++j;
            }
        }

    }

    public boolean isSolid(BlockState state) {
        return true;
    }

    /**
     * Gets the render layer this block will render on. SOLID for solid blocks, CUTOUT or CUTOUT_MIPPED for on-off
     * transparency (glass, reeds), TRANSLUCENT for fully blended transparency (stained glass)
     */
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch){
            list.add(new ItemStack(Item.getItemFromBlock(Main.getBlockByID(dirt)), 1));
        }

        return list;
    }


}