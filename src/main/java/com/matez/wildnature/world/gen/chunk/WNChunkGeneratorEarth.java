package com.matez.wildnature.world.gen.chunk;

import java.util.List;

import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNGenSettings;
import com.matez.wildnature.world.gen.noise.bukkit.SimplexOctaveGenerator;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.VillageSiege;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.CatSpawner;
import net.minecraft.world.spawner.PatrolSpawner;
import net.minecraft.world.spawner.PhantomSpawner;
import net.minecraft.world.spawner.WorldEntitySpawner;

public class WNChunkGeneratorEarth extends SimplexChunks<WNGenSettings> {
    private static final float[] biomeWeights = Util.make(new float[25], (p_222575_0_) -> {
        for(int i = -2; i <= 2; ++i) {
            for(int j = -2; j <= 2; ++j) {
                float f = 10.0F / MathHelper.sqrt((float)(i * i + j * j) + 0.2F);
                p_222575_0_[i + 2 + (j + 2) * 5] = f;
            }
        }

    });
    private final SimplexOctaveGenerator depthNoise;
    private final boolean isAmplified;
    private final PhantomSpawner phantomSpawner = new PhantomSpawner();
    private final PatrolSpawner patrolSpawner = new PatrolSpawner();
    private final CatSpawner catSpawner = new CatSpawner();
    private final VillageSiege field_225495_n = new VillageSiege();

    public WNChunkGeneratorEarth(IWorld worldIn, BiomeProvider provider, WNGenSettings settingsIn) {
        super(worldIn, provider, 4, 8, 256, settingsIn, true);
        this.randomSeed.skip(2620);
        this.depthNoise = new SimplexOctaveGenerator(this.randomSeed, 16);
        this.isAmplified = worldIn.getWorldInfo().getGenerator() == WorldType.AMPLIFIED;
    }

    public void spawnMobs(WorldGenRegion region) {
        int i = region.getMainChunkX();
        int j = region.getMainChunkZ();
        Biome biome = region.getChunk(i, j).getBiomes()[0];
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
        sharedseedrandom.setDecorationSeed(region.getSeed(), i << 4, j << 4);
        WorldEntitySpawner.performWorldGenSpawning(region, biome, i, j, sharedseedrandom);
    }

    protected void func_222548_a(double[] adouble, int chunkX, int chunkZ) {
        double coordinateScale = (double)684.412F;
        double heightScale = (double)1F;
        double depthSize = 8.555149841308594D;
        double unk1 = 4.277574920654297D;
        int unk3 = -10;
        int unk2 = 3;
        this.func_222546_a(adouble, chunkX, chunkZ, coordinateScale, heightScale, depthSize, unk1, unk2, unk3);
    }

    protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
        double d0 = 8.5D;
        double d1 = ((double)p_222545_5_ - (8.5D + p_222545_1_ * 8.5D / 8.0D * 4.0D)) * 12.0D * 128.0D / 256.0D / p_222545_3_;
        if (d1 < 0.0D) {
            d1 *= 4.0D;
        }

        return d1;
    }

    protected double[] func_222549_a(int chunkX, int chunkZ) {
        double[] adouble = new double[2];
        float f = 0.0F;
        float f1 = 0.0F;
        float f2 = 0.0F;
        int i = 2;
        float depth = this.biomeProvider.func_222366_b(chunkX, chunkZ).getDepth();

        for(int j = -2; j <= 2; ++j) {
            for(int k = -2; k <= 2; ++k) {
                Biome biome = this.biomeProvider.func_222366_b(chunkX + j, chunkZ + k);
                float biomeDepth = biome.getDepth();
                float biomeScale = biome.getScale();
                float biomeHeightVariation = 0F;
                if(biome instanceof WNBiome){
                    if(((WNBiome) biome).wnBiomeBuilder.getHeightVariation()!=null){
                        biomeHeightVariation = ((WNBiome) biome).wnBiomeBuilder.getHeightVariation();
                    }
                }

                if (this.isAmplified && biomeDepth > 0.0F) {
                    biomeDepth = 1.0F + biomeDepth * 2.0F;
                    biomeScale = 1.0F + biomeScale * 4.0F;
                }

                float f6 = biomeWeights[j + 2 + (k + 2) * 5] / (biomeDepth + 2.0F);
                if (biome.getDepth() > depth) {
                    f6 /= 2.0F;
                }

                f += biomeScale * f6;
                f1 += biomeDepth * f6;
                f2 += f6;
            }
        }

        f = f / f2;
        f1 = f1 / f2;
        f = f * 0.9F + 0.1F;
        f1 = (f1 * 4.0F - 1.0F) / 8.0F;
        adouble[0] = (double)f1 + this.getDepthNoise(chunkX, chunkZ);
        adouble[1] = (double)f;
        return adouble;
    }

    private double getDepthNoise(int p_222574_1_, int p_222574_2_) {
        depthNoise.setScale(1/8000);
        double d0 = depthNoise.noise((double)(p_222574_1_ * 200), 10.0D, (double)(p_222574_2_ * 200), 1.0D, 0.0D, true);
        if (d0 < 0.0D) {
            d0 = -d0 * 0.3D;
        }

        d0 = d0 * 3.0D - 2.0D;
        if (d0 < 0.0D) {
            d0 = d0 / 28.0D;
        } else {
            if (d0 > 1.0D) {
                d0 = 1.0D;
            }

            d0 = d0 / 40.0D;
        }

        return d0;
    }

    public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
        if (Feature.SWAMP_HUT.func_202383_b(this.world, pos)) {
            if (creatureType == EntityClassification.MONSTER) {
                return Feature.SWAMP_HUT.getSpawnList();
            }

            if (creatureType == EntityClassification.CREATURE) {
                return Feature.SWAMP_HUT.getCreatureSpawnList();
            }
        } else if (creatureType == EntityClassification.MONSTER) {
            if (Feature.PILLAGER_OUTPOST.isPositionInStructure(this.world, pos)) {
                return Feature.PILLAGER_OUTPOST.getSpawnList();
            }

            if (Feature.OCEAN_MONUMENT.isPositionInStructure(this.world, pos)) {
                return Feature.OCEAN_MONUMENT.getSpawnList();
            }
        }

        return super.getPossibleCreatures(creatureType, pos);
    }

    public void spawnMobs(ServerWorld worldIn, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {
        this.phantomSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
        this.patrolSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
        this.catSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
        this.field_225495_n.func_225477_a(worldIn, spawnHostileMobs, spawnPeacefulMobs);
    }

    public int getGroundHeight() {
        return this.world.getSeaLevel() + 1;
    }

    public int getSeaLevel() {
        return 63;
    }

    @Override
    public int func_222529_a(int p_222529_1_, int p_222529_2_, Heightmap.Type p_222529_3_) {
        return 0;
    }


}