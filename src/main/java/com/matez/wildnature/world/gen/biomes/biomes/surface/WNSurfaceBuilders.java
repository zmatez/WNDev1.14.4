package com.matez.wildnature.world.gen.biomes.biomes.surface;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class WNSurfaceBuilders {
    public static SurfaceBuilderConfig BROWN_CONFIG = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:brown_grass_block").getDefaultState(), Main.getBlockByID("wildnature:brown_dirt").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig MOLD_CONFIG = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:mold_grass_block").getDefaultState(), Main.getBlockByID("wildnature:mold_dirt").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig TROPICAL_CONFIG =  new SurfaceBuilderConfig(Main.getBlockByID("wildnature:tropical_grass_block").getDefaultState(), Main.getBlockByID("wildnature:tropical_dirt").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig DRIED_CONFIG =  new SurfaceBuilderConfig(Main.getBlockByID("wildnature:dried_grass_block").getDefaultState(), Main.getBlockByID("wildnature:dried_dirt").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig DESERT_CONFIG =  new SurfaceBuilderConfig(Main.getBlockByID("wildnature:desert_grass_block").getDefaultState(), Main.getBlockByID("wildnature:desert_dirt").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig OVERGROWN_STONE_CONFIG =  new SurfaceBuilderConfig(Main.getBlockByID("wildnature:overgrown_stone").getDefaultState(), Main.getBlockByID("minecraft:stone").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig BROWN_PODZOL_CONFIG = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:brown_podzol").getDefaultState(), Main.getBlockByID("wildnature:brown_dirt").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig POLAR_CONFIG = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:brown_grass_block").getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.PACKED_ICE.getDefaultState());
    public static SurfaceBuilderConfig SNOW_CONFIG = new SurfaceBuilderConfig(Blocks.SNOW.getDefaultState().with(SnowBlock.LAYERS, Utilities.rint(1, 3, new Random())), Blocks.SNOW_BLOCK.getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState());

    public static SurfaceBuilderConfig FARMLANDS_CONFIG = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:mold_grass_block").getDefaultState(), Main.getBlockByID("wildnature:mold_dirt").getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState());

    public static SurfaceBuilder<SurfaceBuilderConfig> BROWN_PODZOL_GRAVEL = new CustomSurfaceBuilder(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_CONFIG,17), new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_PODZOL_CONFIG,6), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRAVEL_CONFIG,1));

}
