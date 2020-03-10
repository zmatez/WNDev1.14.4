package com.matez.wildnature.world.gen.feature;

import com.matez.wildnature.lists.WNBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class CaveVineFeature extends Feature<NoFeatureConfig> {
   public CaveVineFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51438_1_) {
      super(p_i51438_1_);
   }
    private static final Direction[] DIRECTIONS = Direction.values();

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
       if(!worldIn.getDimension().isSurfaceWorld()){
           return false;
       }
       if(worldIn.getBlockState(pos).isAir()) {
           for(Direction direction : DIRECTIONS) {
               if (direction != Direction.DOWN && VineBlock.canAttachTo(worldIn, pos, direction)) {
                   worldIn.setBlockState(pos, WNBlocks.GLOW_VINE.getDefaultState().with(VineBlock.getPropertyFor(direction), Boolean.valueOf(true)), 2);
                   break;
               }
           }

           return true;
       }
       return false;

   }
}