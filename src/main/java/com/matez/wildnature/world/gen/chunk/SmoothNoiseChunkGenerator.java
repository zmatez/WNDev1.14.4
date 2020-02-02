package com.matez.wildnature.world.gen.chunk;

import com.matez.wildnature.world.gen.noise.OpenSimplexNoise;
import com.matez.wildnature.world.gen.noise.SimplexOctavesGenerator;
import com.matez.wildnature.world.gen.noise.another.OctaveNoise;
import com.matez.wildnature.world.gen.noise.bukkit.SimplexOctaveGenerator;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.jigsaw.JigsawJunction;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.StructureStart;


public abstract class SmoothNoiseChunkGenerator<T extends GenerationSettings> extends ChunkGenerator<T> {
    private static final float[] field_222561_h = Util.make(new float[13824], (p_222557_0_) -> {
        for(int i = 0; i < 24; ++i) {
            for(int j = 0; j < 24; ++j) {
                for(int k = 0; k < 24; ++k) {
                    p_222557_0_[i * 24 * 24 + j * 24 + k] = (float)func_222554_b(j - 12, k - 12, i - 12);
                }
            }
        }

    });
    private static final BlockState AIR = Blocks.AIR.getDefaultState();
    private final int verticalNoiseGranularity;
    private final int horizontalNoiseGranularity;
    private final int verticalSmooth;
    private final int horizontalSmooth;
    private final int noiseSizeX;
    private final int noiseSizeY;
    private final int noiseSizeZ;
    protected final SharedSeedRandom randomSeed;
    private final SimplexOctaveGenerator simplex1;
    private final OpenSimplexNoise openSimplex;
    private final OctaveNoise octaveNoise;
    private final OpenSimplexNoise surfaceDepthNoise;
    protected final BlockState defaultBlock;
    protected final BlockState defaultFluid;

    public SmoothNoiseChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, int horizontalNoiseGranularity, int verticalNoiseGranularity, int p_i49931_5_, T p_i49931_6_, boolean usePerlin) {
        super(worldIn, biomeProviderIn, p_i49931_6_);
        this.verticalNoiseGranularity = verticalNoiseGranularity;
        this.horizontalNoiseGranularity = horizontalNoiseGranularity;
        this.verticalSmooth=verticalNoiseGranularity;
        this.horizontalSmooth=horizontalNoiseGranularity;
        this.defaultBlock = p_i49931_6_.getDefaultBlock();
        this.defaultFluid = p_i49931_6_.getDefaultFluid();
        this.noiseSizeX = 16 / horizontalNoiseGranularity;
        this.noiseSizeY = p_i49931_5_ / this.verticalNoiseGranularity;
        this.noiseSizeZ = 16 / horizontalNoiseGranularity;
        this.randomSeed = new SharedSeedRandom(this.seed);
        this.simplex1 = new SimplexOctaveGenerator(this.randomSeed,8);
        this.simplex1.setScale(1/512.0);
        this.openSimplex = new OpenSimplexNoise(worldIn.getSeed());
        this.octaveNoise = new OctaveNoise(worldIn.getRandom(),1/64,16,0.5,0.5);
        this.surfaceDepthNoise = new OpenSimplexNoise(worldIn.getSeed());
    }

    private double linearInterpolate3d(double xm_ym_zm, double xp_ym_zm, double xm_yp_zm, double xp_yp_zm,
                                       double xm_ym_zp, double xp_ym_zp, double xm_yp_zp, double xp_yp_zp,
                                       double x, double y, double z) {
        return (xm_ym_zm * (1 - x) * (1 - y) * (1 - z)) + (xp_ym_zm * x * (1 - y) * (1 - z)) + (xm_yp_zm * (1 - x) * y * (1 - z)) + (xp_yp_zm * x * y * (1 - z)) +
                (xm_ym_zp * (1 - x) * (1 - y) * z) + (xp_ym_zp * x * (1 - y) * z) + (xm_yp_zp * (1 - x) * y * z) + (xp_yp_zp * x * y * z);
    }

    //generating surface

    /**
     *
     * @param chunkX same
     * @param chunkY same
     * @param chunkZ same
     * @param coordinateScale sharpness - below flat mountains, above sharp mountains
     * @param heightScale below - rounded mountains, above - flat areas
     * @param depthSize 25 - base height is 200, 1 - base height is 8
     * @param unk1
     * @param b biome unused
     * @return good question
     */
    private double useNoises(int chunkX, int chunkY, int chunkZ, double coordinateScale, double heightScale, double depthSize, double unk1, Biome b) {
        double d0 = 0.0D;
        double d1 = 0.0D;
        double noiseY = 0.0D;
        double modifier = 1D;


        for (int i = 0; i < 16; ++i) {
            double d4 = SimplexOctavesGenerator.maintainPrecision((double) chunkX * coordinateScale * modifier);
            double d5 = SimplexOctavesGenerator.maintainPrecision((double) 0.5*chunkY * heightScale * modifier);
            double d6 = SimplexOctavesGenerator.maintainPrecision((double) chunkZ * coordinateScale * modifier);
            d0 += this.openSimplex.eval(d4, d5, d6) * modifier;
            d1 += this.openSimplex.eval(d4, d5, d6) * modifier;
            noiseY += this.openSimplex.eval(SimplexOctavesGenerator.maintainPrecision((double) chunkX * depthSize*modifier), SimplexOctavesGenerator.maintainPrecision((double) chunkY * unk1*modifier), SimplexOctavesGenerator.maintainPrecision((double) chunkZ * depthSize)*modifier) * modifier;

            if (i < 8) {
            }

            modifier /= 8.0D;

        }

        double lowerLimitScale = 512.0D;
        double upperLimitScale = 512.0D;
        double slide = 1D;

        double result = MathHelper.clampedLerp(d0 / lowerLimitScale, d1 / upperLimitScale, (noiseY) * slide);


        return result;


        /*for(int i = 0; i< WNWorldType.biomeTerrain.getTerrain().size(); i++){
            BiomeTerrain.Config c = WNWorldType.biomeTerrain.getTerrain().get(i);
            if(c.getBiome()==b){
                break;
            }
        }*/

        ///7245440588135230305 & -107 90 488 dune sea

        /*double d4 = SimplexOctavesGenerator.maintainPrecision((double) chunkX * coordinateScale * modifier);
        double d5 = SimplexOctavesGenerator.maintainPrecision((double) chunkY * heightScale * modifier);
        double d6 = SimplexOctavesGenerator.maintainPrecision((double) chunkZ * coordinateScale * modifier);
        d0 += this.openSimplex.eval(d4, d5, d6) * modifier;
        d1 += this.openSimplex.eval(d4, d5, d6) * modifier;
        noiseY += this.openSimplex.eval(SimplexOctavesGenerator.maintainPrecision((double) chunkX * depthSize), SimplexOctavesGenerator.maintainPrecision((double) chunkY * unk1), SimplexOctavesGenerator.maintainPrecision((double) chunkZ * depthSize)) * modifier;
*/

        /*
        double d4 = SimplexOctavesGenerator.maintainPrecision((double) chunkX * coordinateScale * modifier);
        double d5 = SimplexOctavesGenerator.maintainPrecision((double) chunkY * heightScale * modifier);
        double d6 = SimplexOctavesGenerator.maintainPrecision((double) chunkZ * coordinateScale * modifier);
        d0+=octaveNoise.getValue(d4,d6);
        d1+=octaveNoise.getValue(d4,d6);
        noiseY+=octaveNoise.getValue(SimplexOctavesGenerator.maintainPrecision((double) chunkX * depthSize),SimplexOctavesGenerator.maintainPrecision((double) chunkZ * depthSize));
         */

        /*
        for(int i = 0; i < 16; ++i) {
            double d4 = SimplexOctavesGenerator.maintainPrecision((double) p_222552_1_ * p_222552_4_ * d3);
            double d5 = SimplexOctavesGenerator.maintainPrecision((double) p_222552_2_ * p_222552_6_ * d3);
            double d6 = SimplexOctavesGenerator.maintainPrecision((double) p_222552_3_ * p_222552_4_ * d3);
            double d7 = p_222552_6_ * 1;
            d0 += this.openSimplex.eval(d4, d5, d6) / d3;
            d1 += this.openSimplex.eval(d4, d5, d6) / d3;
            if (i < 8) {
                d2 += this.openSimplex.eval(SimplexOctavesGenerator.maintainPrecision((double) p_222552_1_ * p_222552_8_ * d3), SimplexOctavesGenerator.maintainPrecision((double) p_222552_2_ * p_222552_10_ * d3), SimplexOctavesGenerator.maintainPrecision((double) p_222552_3_ * p_222552_8_ * d3)) / d3;
            }

            d3 /= 2.0D;

        }
         */

        /*for(int i = 0; i < 16; ++i) {
            double d4 = SimplexOctavesGenerator.maintainPrecision((double) p_222552_1_ * p_222552_4_ * d3);
            double d5 = SimplexOctavesGenerator.maintainPrecision((double) p_222552_2_ * p_222552_6_ * d3);
            double d6 = SimplexOctavesGenerator.maintainPrecision((double) p_222552_3_ * p_222552_4_ * d3);
            double d7 = p_222552_6_ * 1;
            d0 += this.simplex1.noise(d4, d5, d6,frequency,amplitude) / d3;
            d1 += this.simplex1.noise(d4, d5, d6,frequency,amplitude) / d3;
            if (i < 8) {
                d2 += this.simplex1.noise(SimplexOctavesGenerator.maintainPrecision((double) p_222552_1_ * p_222552_8_ * d3), SimplexOctavesGenerator.maintainPrecision((double) p_222552_2_ * p_222552_10_ * d3), SimplexOctavesGenerator.maintainPrecision((double) p_222552_3_ * p_222552_8_ * d3),frequency,amplitude) / d3;
            }

            d3 /= 2.0D;

        }

         */



    }

    protected double[] func_222547_b(int p_222547_1_, int p_222547_2_,Biome b) {
        double[] adouble = new double[this.noiseSizeY + 1];
        this.func_222548_a(adouble, p_222547_1_, p_222547_2_,b);
        return adouble;
    }

    protected void func_222546_a(double[] adoub, int chunkX, int chunkZ, double coordinateScale, double heightScale, double depthSize, double unk1, int unk2, int unk3, Biome b) {
        double[] adouble = this.func_222549_a(chunkX, chunkZ);
        double d0 = adouble[0];
        double d1 = adouble[1];
        double d2 = this.func_222551_g();
        double d3 = this.func_222553_h();

        for(int i = 0; i < this.getY(); ++i) {
            double d4 = this.useNoises(chunkX, i, chunkZ, coordinateScale, heightScale, depthSize, unk1,b);
            d4 = d4 - this.func_222545_a(d0, d1, i);
            if ((double)i > d2) {
                d4 = MathHelper.clampedLerp(d4, (double)unk3, ((double)i - d2) / (double)unk2);
            } else if ((double)i < d3) {
                d4 = MathHelper.clampedLerp(d4, -30.0D, (d3 - (double)i) / (d3 - 1.0D));
            }

            adoub[i] = d4;
        }

    }

    protected abstract double[] func_222549_a(int chunkX, int chunkZ);

    protected abstract double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_);

    protected double func_222551_g() {
        return (double)(this.getY() - 4);
    }

    protected double func_222553_h() {
        return 0.0D;
    }

    public int func_222529_a(int p_222529_1_, int p_222529_2_, Heightmap.Type p_222529_3_,Biome b) {
        int horiz = horizontalSmooth;
        int i = Math.floorDiv(p_222529_1_, horiz);
        int j = Math.floorDiv(p_222529_2_, horiz);
        int k = Math.floorMod(p_222529_1_, horiz);
        int l = Math.floorMod(p_222529_2_, horiz);
        double d0 = (double)k / (double)horiz;
        double d1 = (double)l / (double)horiz;
        double[][] adouble = new double[][]{this.func_222547_b(i, j,b), this.func_222547_b(i, j + 1,b), this.func_222547_b(i + 1, j,b), this.func_222547_b(i + 1, j + 1,b)};
        int i1 = this.getSeaLevel();

        for(int j1 = this.noiseSizeY - 1; j1 >= 0; --j1) {
            double d2 = adouble[0][j1];
            double d3 = adouble[1][j1];
            double d4 = adouble[2][j1];
            double d5 = adouble[3][j1];
            double d6 = adouble[0][j1 + 1];
            double d7 = adouble[1][j1 + 1];
            double d8 = adouble[2][j1 + 1];
            double d9 = adouble[3][j1 + 1];

            for(int k1 = this.verticalNoiseGranularity - 1; k1 >= 0; --k1) {
                double d10 = (double)k1 / (double)this.verticalNoiseGranularity;
                double d11 = MathHelper.lerp3(d10, d0, d1, d2, d6, d4, d8, d3, d7, d5, d9);


                int l1 = j1 * this.verticalNoiseGranularity + k1;
                if (d11 > 0.0D || l1 < i1) {
                    BlockState blockstate;
                    if (d11 > 0.0D) {
                        blockstate = this.defaultBlock;
                    } else {
                        blockstate = this.defaultFluid;
                    }

                    if (p_222529_3_.func_222684_d().test(blockstate)) {
                        return l1 + 1;
                    }
                }
            }
        }

        return 0;
    }

    protected abstract void func_222548_a(double[] adouble, int chunkX, int chunkZ,Biome b);

    public int getY() {
        return this.noiseSizeY + 1;
    }

    public void generateSurface(IChunk chunkIn) {
        ChunkPos chunkpos = chunkIn.getPos();
        int i = chunkpos.x;
        int j = chunkpos.z;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
        sharedseedrandom.setBaseChunkSeed(i, j);
        ChunkPos chunkpos1 = chunkIn.getPos();
        int k = chunkpos1.getXStart();
        int l = chunkpos1.getZStart();
        double d0 = 0.0625D;
        Biome[] abiome = chunkIn.getBiomes();

        for(int i1 = 0; i1 < 16; ++i1) {
            for(int j1 = 0; j1 < 16; ++j1) {
                int k1 = k + i1;
                int l1 = l + j1;
                int i2 = chunkIn.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, i1, j1) + 1;
                double multiplier = 0.0625D;
                double d1 = this.surfaceDepthNoise.eval((double)k1 * multiplier, (double)l1 * multiplier);




                abiome[j1 * 16 + i1].buildSurface(sharedseedrandom, chunkIn, k1, l1, i2, d1, this.getSettings().getDefaultBlock(), this.getSettings().getDefaultFluid(), this.getSeaLevel(), this.world.getSeed());
            }
        }

        this.makeBedrock(chunkIn, sharedseedrandom);
    }

    protected void makeBedrock(IChunk chunkIn, Random rand) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        int i = chunkIn.getPos().getXStart();
        int j = chunkIn.getPos().getZStart();
        T t = this.getSettings();
        int k = t.getBedrockFloorHeight();
        int l = t.getBedrockRoofHeight();

        for(BlockPos blockpos : BlockPos.getAllInBoxMutable(i, 0, j, i + 15, 0, j + 15)) {
            if (l > 0) {
                for(int i1 = l; i1 >= l - 4; --i1) {
                    if (i1 >= l - rand.nextInt(5)) {
                        chunkIn.setBlockState(blockpos$mutableblockpos.setPos(blockpos.getX(), i1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
                    }
                }
            }

            if (k < 256) {
                for(int j1 = k + 4; j1 >= k; --j1) {
                    if (j1 <= k + rand.nextInt(5)) {
                        chunkIn.setBlockState(blockpos$mutableblockpos.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
                    }
                }
            }
        }

    }

    public void makeBase(IWorld worldIn, IChunk chunkIn) {
        int i = this.getSeaLevel();
        ObjectList<AbstractVillagePiece> objectlist = new ObjectArrayList<>(10);
        ObjectList<JigsawJunction> objectlist1 = new ObjectArrayList<>(32);
        ChunkPos chunkpos = chunkIn.getPos();
        int j = chunkpos.x;
        int k = chunkpos.z;
        int l = j << 4;
        int i1 = k << 4;

        for(Structure<?> structure : Feature.field_214488_aQ) {
            String s = structure.getStructureName();
            LongIterator longiterator = chunkIn.getStructureReferences(s).iterator();

            while(longiterator.hasNext()) {
                long j1 = longiterator.nextLong();
                ChunkPos chunkpos1 = new ChunkPos(j1);
                IChunk ichunk = worldIn.getChunk(chunkpos1.x, chunkpos1.z);
                StructureStart structurestart = ichunk.getStructureStart(s);
                if (structurestart != null && structurestart.isValid()) {
                    for(StructurePiece structurepiece : structurestart.getComponents()) {
                        if (structurepiece.func_214810_a(chunkpos, 12) && structurepiece instanceof AbstractVillagePiece) {
                            AbstractVillagePiece abstractvillagepiece = (AbstractVillagePiece)structurepiece;
                            JigsawPattern.PlacementBehaviour jigsawpattern$placementbehaviour = abstractvillagepiece.func_214826_b().getPlacementBehaviour();
                            if (jigsawpattern$placementbehaviour == JigsawPattern.PlacementBehaviour.RIGID) {
                                objectlist.add(abstractvillagepiece);
                            }

                            for(JigsawJunction jigsawjunction : abstractvillagepiece.getJunctions()) {
                                int k1 = jigsawjunction.getSourceX();
                                int l1 = jigsawjunction.getSourceZ();
                                if (k1 > l - 12 && l1 > i1 - 12 && k1 < l + 15 + 12 && l1 < i1 + 15 + 12) {
                                    objectlist1.add(jigsawjunction);
                                }
                            }
                        }
                    }
                }
            }
        }

        double[][][] noiseMap = new double[2][this.noiseSizeZ + 1][this.noiseSizeY + 1];

        for(int j5 = 0; j5 < this.noiseSizeZ + 1; ++j5) {
            noiseMap[0][j5] = new double[this.noiseSizeY + 1];
            this.func_222548_a(noiseMap[0][j5], j * this.noiseSizeX, k * this.noiseSizeZ + j5,null);
            noiseMap[1][j5] = new double[this.noiseSizeY + 1];
        }

        ChunkPrimer chunkprimer = (ChunkPrimer)chunkIn;
        Heightmap heightmap = chunkprimer.func_217303_b(Heightmap.Type.OCEAN_FLOOR_WG);
        Heightmap heightmap1 = chunkprimer.func_217303_b(Heightmap.Type.WORLD_SURFACE_WG);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        ObjectListIterator<AbstractVillagePiece> objectlistiterator = objectlist.iterator();
        ObjectListIterator<JigsawJunction> objectlistiterator1 = objectlist1.iterator();

        for(int k5 = 0; k5 < this.noiseSizeX; ++k5) {
            for(int l5 = 0; l5 < this.noiseSizeZ + 1; ++l5) {
                this.func_222548_a(noiseMap[1][l5], j * this.noiseSizeX + k5 + 1, k * this.noiseSizeZ + l5,null);
            }

            for(int i6 = 0; i6 < this.noiseSizeZ; ++i6) {
                ChunkSection chunksection = chunkprimer.func_217332_a(15);
                chunksection.lock();

                for(int j6 = this.noiseSizeY - 1; j6 >= 0; --j6) {
                    double d16 = noiseMap[0][i6][j6];
                    double d17 = noiseMap[0][i6 + 1][j6];
                    double d18 = noiseMap[1][i6][j6];
                    double d0 = noiseMap[1][i6 + 1][j6];
                    double d1 = noiseMap[0][i6][j6 + 1];
                    double d2 = noiseMap[0][i6 + 1][j6 + 1];
                    double d3 = noiseMap[1][i6][j6 + 1];
                    double d4 = noiseMap[1][i6 + 1][j6 + 1];

                    for(int i2 = this.verticalNoiseGranularity - 1; i2 >= 0; --i2) {
                        int j2 = j6 * this.verticalNoiseGranularity + i2;
                        int k2 = j2 & 15;
                        int l2 = j2 >> 4;
                        if (chunksection.getYLocation() >> 4 != l2) {
                            chunksection.unlock();
                            chunksection = chunkprimer.func_217332_a(l2);
                            chunksection.lock();
                        }

                        double d5 = (double)i2 / (double)this.verticalNoiseGranularity;
                        double d6 = MathHelper.lerp(d5, d16, d1);
                        double d7 = MathHelper.lerp(d5, d18, d3);
                        double d8 = MathHelper.lerp(d5, d17, d2);
                        double d9 = MathHelper.lerp(d5, d0, d4);

                        for(int i3 = 0; i3 < this.horizontalNoiseGranularity; ++i3) {
                            int j3 = l + k5 * this.horizontalNoiseGranularity + i3;
                            int k3 = j3 & 15;
                            double d10 = (double)i3 / (double)this.horizontalNoiseGranularity;
                            double d11 = MathHelper.lerp(d10, d6, d7);
                            double d12 = MathHelper.lerp(d10, d8, d9);

                            for(int l3 = 0; l3 < this.horizontalNoiseGranularity; ++l3) {
                                int i4 = i1 + i6 * this.horizontalNoiseGranularity + l3;
                                int j4 = i4 & 15;
                                double d13 = (double)l3 / (double)this.horizontalNoiseGranularity;
                                double d14 = MathHelper.lerp(d13, d11, d12);
                                double d15 = MathHelper.clamp(d14 / 200.0D, -1.0D, 1.0D);

                                int k4;
                                int l4;
                                int i5;
                                for(d15 = d15 / 2.0D - d15 * d15 * d15 / 24.0D; objectlistiterator.hasNext(); d15 += func_222556_a(k4, l4, i5) * 0.8D) {
                                    AbstractVillagePiece abstractvillagepiece1 = objectlistiterator.next();
                                    MutableBoundingBox mutableboundingbox = abstractvillagepiece1.getBoundingBox();
                                    k4 = Math.max(0, Math.max(mutableboundingbox.minX - j3, j3 - mutableboundingbox.maxX));
                                    l4 = j2 - (mutableboundingbox.minY + abstractvillagepiece1.getGroundLevelDelta());
                                    i5 = Math.max(0, Math.max(mutableboundingbox.minZ - i4, i4 - mutableboundingbox.maxZ));
                                }

                                objectlistiterator.back(objectlist.size());

                                while(objectlistiterator1.hasNext()) {
                                    JigsawJunction jigsawjunction1 = objectlistiterator1.next();
                                    int k6 = j3 - jigsawjunction1.getSourceX();
                                    k4 = j2 - jigsawjunction1.getSourceGroundY();
                                    l4 = i4 - jigsawjunction1.getSourceZ();
                                    d15 += func_222556_a(k6, k4, l4) * 0.4D;
                                }

                                objectlistiterator1.back(objectlist1.size());

                                /*int HorizontalNoiseResolutionDivisor = 4;
                                int VerticalNoiseResolutionDivisor = 8;

                                int x2 = (k3 / HorizontalNoiseResolutionDivisor) + 1;
                                int y2 = (j2 / VerticalNoiseResolutionDivisor) + 1;
                                int z2 = (j4 / HorizontalNoiseResolutionDivisor) + 1;

                                double value = linearInterpolate3d(noiseMap[x2][y2][z2], noiseMap[x2 + 1][y2][z2],
                                        noiseMap[x2][y2 + 1][z2], noiseMap[x2 + 1][y2 + 1][z2],
                                        noiseMap[x2][y2][z2 + 1], noiseMap[x2 + 1][y2][z2 + 1],
                                        noiseMap[x2][y2 + 1][z2 + 1], noiseMap[x2 + 1][y2 + 1][z2 + 1],
                                        (k3 % HorizontalNoiseResolutionDivisor) / (double) HorizontalNoiseResolutionDivisor,
                                        (j2 % VerticalNoiseResolutionDivisor) / (double) VerticalNoiseResolutionDivisor,
                                        (j4 % HorizontalNoiseResolutionDivisor) / (double) HorizontalNoiseResolutionDivisor);*/


                                BlockState blockstate;
                                if (d15 > 0.0D) {
                                    blockstate = this.defaultBlock;
                                } else if (j2 < i) {
                                    blockstate = this.defaultFluid;
                                } else {
                                    blockstate = AIR;
                                }

                                if (blockstate != AIR) {
                                    if (blockstate.getLightValue() != 0) {
                                        blockpos$mutableblockpos.setPos(j3, j2, i4);
                                        chunkprimer.addLightPosition(blockpos$mutableblockpos);
                                    }

                                    chunksection.setBlockState(k3, k2, j4, blockstate, false);
                                    heightmap.update(k3, j2, j4, blockstate);
                                    heightmap1.update(k3, j2, j4, blockstate);
                                }
                            }
                        }
                    }
                }

                chunksection.unlock();
            }

            double[][] adouble1 = noiseMap[0];
            noiseMap[0] = noiseMap[1];
            noiseMap[1] = adouble1;
        }

    }

    private static double func_222556_a(int p_222556_0_, int p_222556_1_, int p_222556_2_) {
        int i = p_222556_0_ + 12;
        int j = p_222556_1_ + 12;
        int k = p_222556_2_ + 12;
        if (i >= 0 && i < 24) {
            if (j >= 0 && j < 24) {
                return k >= 0 && k < 24 ? (double)field_222561_h[k * 24 * 24 + i * 24 + j] : 0.0D;
            } else {
                return 0.0D;
            }
        } else {
            return 0.0D;
        }
    }

    private static double func_222554_b(int p_222554_0_, int p_222554_1_, int p_222554_2_) {
        double d0 = (double)(p_222554_0_ * p_222554_0_ + p_222554_2_ * p_222554_2_);
        double d1 = (double)p_222554_1_ + 0.5D;
        double d2 = d1 * d1;
        double d3 = Math.pow(Math.E, -(d2 / 16.0D + d0 / 16.0D));
        double d4 = -d1 * MathHelper.fastInvSqrt(d2 / 2.0D + d0 / 2.0D) / 2.0D;
        return d4 * d3;
    }
}