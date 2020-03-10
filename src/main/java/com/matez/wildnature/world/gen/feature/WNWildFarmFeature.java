package com.matez.wildnature.world.gen.feature;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.CropBase;
import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.TaigaBiome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class WNWildFarmFeature extends Feature<NoFeatureConfig> {
    private BlockState cropState;

   public WNWildFarmFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51438_1_, BlockState crop) {
      super(p_i51438_1_);
      cropState=crop;
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
       if(!worldIn.getDimension().isSurfaceWorld()){
           return false;
       }
       if(worldIn.getBlockState(pos).canSustainPlant(worldIn,pos.down(), Direction.UP,(IPlantable)Blocks.OAK_SAPLING)) {
            WNBlobFeature feature = new WNBlobFeature(WNBlobConfig::deserialize);
            feature.place(worldIn,generator,rand,pos,new WNBlobConfig(Blocks.FARMLAND.getDefaultState().with(FarmlandBlock.MOISTURE,7),Utilities.rint(1,2),true,false));

            feature.getFilledBlocks().forEach(blockPos -> {
                if(!worldIn.getBlockState(blockPos.up()).isSolid()){
                    worldIn.setBlockState(blockPos.up(),Blocks.AIR.getDefaultState(),2);
                }
            });

            BlockState crop = null;
           if(cropState.getBlock() instanceof CropBase) {
               crop = cropState.with(((CropBase) cropState.getBlock()).getAgeProperty(), Utilities.rint(((CropBase) cropState.getBlock()).getMaxAge() - 1, ((CropBase) cropState.getBlock()).getMaxAge()));
           }else{
               crop = cropState;
           }

           int water = 0;
           int fence = 2;
           for(int j = 0; j < 256; ++j) {
               BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
               if (worldIn.isAirBlock(blockpos) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getDimension().getHeight())) {
                   if(crop.isValidPosition(worldIn, blockpos) && worldIn.getBlockState(blockpos.down()).getBlock()==Blocks.FARMLAND) {
                       if(!worldIn.getBlockState(blockpos).isSolid() && !(worldIn.getBlockState(blockpos).getBlock() instanceof CropsBlock)){
                           worldIn.setBlockState(blockpos,Blocks.AIR.getDefaultState(),2);
                       }

                       if (Utilities.rint(0, water) == 0 && !Utilities.isBlockNear(worldIn,blockpos.down(),Blocks.AIR)) {
                           water++;
                           worldIn.setBlockState(blockpos.down(), Blocks.WATER.getDefaultState(), 2);
                       } else {
                           if(cropState.getBlock() instanceof CropBase) {
                               crop = cropState.with(((CropBase) cropState.getBlock()).getAgeProperty(), Utilities.rint(((CropBase) cropState.getBlock()).getMaxAge() - 1, ((CropBase) cropState.getBlock()).getMaxAge()));
                           }else{
                               crop = cropState;
                           }
                           worldIn.setBlockState(blockpos, crop, 2);
                       }
                   }else if(worldIn.getBlockState(blockpos.down()).getBlock() instanceof GrassBlock && Utilities.isBlockNear(worldIn,blockpos.down(),Blocks.FARMLAND)){
                       if (Utilities.rint(0, (int)fence/2) == 0) {
                           fence++;
                           worldIn.setBlockState(blockpos, Blocks.OAK_FENCE.getDefaultState(), 2);
                           if(Utilities.rint(0,1)==0){
                               worldIn.setBlockState(blockpos.up(), Blocks.TORCH.getDefaultState(), 2);
                           }
                       }
                   }
               }
           }


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