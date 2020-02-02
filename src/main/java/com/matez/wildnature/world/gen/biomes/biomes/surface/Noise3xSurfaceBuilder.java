package com.matez.wildnature.world.gen.biomes.biomes.surface;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class Noise3xSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
   private SurfaceBuilderConfig config1,config2,config3;
   public Noise3xSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_, SurfaceBuilderConfig firstConfig, SurfaceBuilderConfig secondConfig,SurfaceBuilderConfig thirdConfig) {
      super(p_i51312_1_);
      this.config1=firstConfig;
      this.config2=secondConfig;
      this.config3=thirdConfig;
   }


   public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
      if (noise > 1.75D) {
         SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config1);

      } else if (noise > -0.95D) {
         SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config2);

      }

      SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config3);


   }
}