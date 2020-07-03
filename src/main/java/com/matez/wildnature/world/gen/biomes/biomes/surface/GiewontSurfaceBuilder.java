package com.matez.wildnature.world.gen.biomes.biomes.surface;

import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class GiewontSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
   private int halfSnowed = 100, fullySnowed = 160;
   private int snowRange = 2;
   public GiewontSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
      super(p_i51312_1_);
   }

   public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
      int y = startHeight;
      int xhalfsnowed = Utilities.rint(halfSnowed-snowRange,halfSnowed+snowRange,random);
      int xfullysnowed = Utilities.rint(fullySnowed-snowRange,fullySnowed+snowRange,random);
      if(y<xhalfsnowed){
         if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, WNSurfaceBuilders.OVERGROWN_STONE_CONFIG);
         } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, WNSurfaceBuilders.OVERGROWN_STONE_CONFIG);
         } else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, WNSurfaceBuilders.OVERGROWN_STONE_CONFIG);
         }
      }else if(y>=xhalfsnowed&&y<xfullysnowed){
         if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(STONE,STONE,STONE));
         } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, WNSurfaceBuilders.OVERGROWN_STONE_CONFIG);
         } else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, WNSurfaceBuilders.OVERGROWN_STONE_CONFIG);
         }
      }else {
         if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(STONE,STONE,STONE));

         } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(STONE,STONE,STONE));

         } else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(STONE,STONE,STONE));

         }
      }

   }
}