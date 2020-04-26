package com.matez.wildnature.world.gen.biomes.biomes.surface;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
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

public class BialowiezaSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    private int waterChance = 16;
    public BialowiezaSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_, int waterChance) {
        super(p_i51312_1_);
        this.waterChance=waterChance;
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int i = Utilities.rint(0,waterChance,random);
        if(i==0) {
            if(!Utilities.isBlockNear(chunkIn.getWorldForge(),new BlockPos(x,startHeight,z), Blocks.AIR)) {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Main.getBlockByID("minecraft:water").getDefaultState(), Main.getBlockByID("wildnature:brown_dirt").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState()));
            }else{
                chunkIn.setBlockState(new BlockPos(x,startHeight,z),Blocks.AIR.getDefaultState(),false);
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight-1, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Main.getBlockByID("minecraft:water").getDefaultState(), Main.getBlockByID("wildnature:brown_dirt").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState()));
                //SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, WNSurfaceBuilders.BROWN_CONFIG);

            }
        }else{
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, WNSurfaceBuilders.BROWN_CONFIG);

        }

    }
}
