package com.matez.wildnature.world.gen.feature;

import com.matez.wildnature.blocks.GeyserBlock;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;

import java.util.Random;
import java.util.function.Function;

public class CropFeature extends Feature<NoFeatureConfig> {
    private BlockState cropState;
   public CropFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51438_1_, BlockState crop) {
      super(p_i51438_1_);
      cropState=crop;
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
       if(worldIn.getBlockState(pos).canSustainPlant(worldIn,pos.down(), Direction.UP,(IPlantable)Blocks.OAK_SAPLING)) {
            BlockPos waterPos = water(pos.down(),worldIn,rand);
            if(waterPos==null){
                return false;
            }
            worldIn.setBlockState(waterPos,Blocks.WATER.getDefaultState(),2);
            worldIn.setBlockState(pos.down(),Blocks.FARMLAND.getDefaultState().with(FarmlandBlock.MOISTURE,7),2);
            worldIn.setBlockState(pos,cropState,2);

           return true;
       }
       return false;

   }

   private BlockPos water(BlockPos pos, IWorld world, Random rand){
       BlockPos waterPos = pos;
       switch (Utilities.rint(1,4,rand)){
           case 1:
               waterPos=pos.east();
               break;
           case 2:
               waterPos=pos.west();
               break;
           case 3:
               waterPos=pos.south();
               break;
           case 4:
               waterPos=pos.north();
               break;
       }

       if(world.getBlockState(waterPos.down()).isSolid()){
           if(world.getBlockState(waterPos.north()).isSolid()){
               if(world.getBlockState(waterPos.south()).isSolid()){
                   if(world.getBlockState(waterPos.east()).isSolid()){
                       if(world.getBlockState(waterPos.west()).isSolid()){
                            return waterPos;
                       }
                   }
               }
           }
       }
       return null;
   }
}