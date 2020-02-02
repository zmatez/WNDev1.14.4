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

public class BorealSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public BorealSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (noise > 2D) {

        }else if (noise > 1.5D) {

        }else if (noise > 1D) {

        }else if (noise > 0.5D) {

        }else if (noise > 0D) {

        }else if (noise > -0.5D) {

        }else if (noise > -1D) {

        }else if (noise > -1.5D) {
            chunkIn.setBlockState(new BlockPos(x,startHeight-1,z),Blocks.WATER.getDefaultState(),false);
            new PodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize).buildSurface(random, chunkIn, biomeIn, x, z, startHeight-2, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
            return;
        }else {

        }
        new PodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize).buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);

    }
}
