package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.blocks.CornPlant;
import com.matez.wildnature.blocks.GreenBeansBush;
import com.matez.wildnature.other.BlockWeighList;
import com.matez.wildnature.world.gen.feature.FeatureRegistry;
import com.matez.wildnature.world.gen.feature.configs.BlockWeightListConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class WNBushFeature extends Feature<BushConfig> {
   public WNBushFeature(Function<Dynamic<?>, ? extends BushConfig> p_i49908_1_) {
      super(p_i49908_1_);
      setRegistryName("wildnature","wn_bush_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BushConfig config) {
      int i = 0;
      BlockState blockstate = config.state;

      if(config.state.getBlock() instanceof GreenBeansBush){
         return FeatureRegistry.GREEN_BEAN_FEATURE.place(worldIn,generator,rand,pos,new NoFeatureConfig());
      }
      else if(config.state.getBlock() instanceof CornPlant){
         return FeatureRegistry.CORN_FEATURE.place(worldIn,generator,rand,pos,new NoFeatureConfig());
      }else if(config.state.getBlock() instanceof DoublePlantBlock){
         BlockWeighList l = new BlockWeighList();
         l.add(config.state,1);
         return FeatureRegistry.PLANT_FEATURE.place(worldIn,generator,rand,pos,new BlockWeightListConfig(l));
      }else {
         for (int j = 0; j < 64; ++j) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (worldIn.isAirBlock(blockpos) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getDimension().getHeight()) && blockstate.isValidPosition(worldIn, blockpos)) {
               worldIn.setBlockState(blockpos, blockstate, 2);
               ++i;
            }
         }


         return i > 0;
      }
   }
}