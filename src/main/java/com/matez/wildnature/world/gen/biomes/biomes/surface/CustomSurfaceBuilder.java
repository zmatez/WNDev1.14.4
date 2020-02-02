package com.matez.wildnature.world.gen.biomes.biomes.surface;

import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CustomSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    private ArrayList<BlockCfg> cfgs;
    public CustomSurfaceBuilder(BlockCfg... cfg) {
        super(SurfaceBuilderConfig::deserialize);
        cfgs = new ArrayList<>(Arrays.asList(cfg));
    }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, getConfig(random));

    }

    private SurfaceBuilderConfig getConfig(Random rand){
        ArrayList<SurfaceBuilderConfig> states = new ArrayList<>();
        int x = 0;
        while(x<cfgs.size()){
            int a = cfgs.get(x).chance;
            int z = 0;
            while(z<a){
                states.add(cfgs.get(x).config);
                z++;
            }
            x++;
        }

        if(!(states.size()==0)){
            int block = Utilities.rint(0,states.size()-1,rand);

            return states.get(block);


        }


        return GRASS_DIRT_GRAVEL_CONFIG;
    }

    public static class BlockCfg{

        private int chance;
        private SurfaceBuilderConfig config;
        public BlockCfg(SurfaceBuilderConfig config, int chance){
            this.chance=chance;
            this.config=config;
        }

        public int getChance() {
            return chance;
        }

        public SurfaceBuilderConfig getConfig() {
            return config;
        }
    }
}
