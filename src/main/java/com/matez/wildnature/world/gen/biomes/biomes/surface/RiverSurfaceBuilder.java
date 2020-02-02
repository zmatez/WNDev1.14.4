package com.matez.wildnature.world.gen.biomes.biomes.surface;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class RiverSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
   public RiverSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
      super(p_i51312_1_);
   }

   public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
      SurfaceBuilderConfig riverConfig = SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG;
      int riverDepth = 7;
      if (noise > -1.25D) {
         SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
      } else {

         for(int i = startHeight; i>(seaLevel-riverDepth); i--){
            if(i>=seaLevel){
               chunkIn.setBlockState(new BlockPos(x,i,z),AIR,false);
            }else{
               chunkIn.setBlockState(new BlockPos(x,i,z),Blocks.WATER.getDefaultState(),false);
               SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, i, noise, defaultBlock, defaultFluid, seaLevel, seed, riverConfig);
            }
         }
         SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, seaLevel-riverDepth-1, noise, defaultBlock, defaultFluid, seaLevel, seed, riverConfig);

      }

   }
}