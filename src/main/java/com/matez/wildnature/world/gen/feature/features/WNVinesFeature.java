package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.function.Function;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class WNVinesFeature extends Feature<BushConfig> {
   private static final Direction[] DIRECTIONS = Direction.values();

   public WNVinesFeature(Function<Dynamic<?>, ? extends BushConfig> p_i51418_1_) {
      super(p_i51418_1_);
      setRegistryName("wildnature","vines_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BushConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      if(!(config.state.getBlock() instanceof VineBlock)){
         return false;
      }
      BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos(pos);
      BlockPos.MutableBlockPos vinePos = new BlockPos.MutableBlockPos(pos);
      for(int i = pos.getY(); i > 2; i--) {
         mutable.setPos(pos);
         mutable.move(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
         mutable.setY(i);
         if (worldIn.isAirBlock(mutable)) {
            for (Direction direction : DIRECTIONS) {
               if (direction != Direction.DOWN && direction != Direction.UP) {
                  if (worldIn.getBlockState(mutable.offset(direction)).isSolid()) {

                     worldIn.setBlockState(mutable, config.state.with(VineBlock.getPropertyFor(direction), Boolean.valueOf(true)), 2);
                     vinePos.setPos(mutable);
                     break;
                  }
               }
            }
         }
      }
      for(int i = vinePos.getY(); i > Utilities.rint(1,15,rand); i--) {
         vinePos.setY(i);
         if(worldIn.isAirBlock(vinePos.down())) {
            if (worldIn.getBlockState(vinePos).getBlock() == config.state.getBlock()){
               BlockState s = worldIn.getBlockState(vinePos);
               worldIn.setBlockState(vinePos.down(), config.state.with(VineBlock.UP,false)
                       .with(VineBlock.EAST,s.get(VineBlock.EAST))
                       .with(VineBlock.WEST,s.get(VineBlock.WEST))
                       .with(VineBlock.NORTH,s.get(VineBlock.NORTH))
                       .with(VineBlock.SOUTH,s.get(VineBlock.SOUTH)), 2);
            }
         }
      }

      return true;
   }
}