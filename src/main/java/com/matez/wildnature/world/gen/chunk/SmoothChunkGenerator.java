package com.matez.wildnature.world.gen.chunk;

import java.util.HashMap;
import java.util.Random;

import com.matez.wildnature.world.gen.biomes.setup.WNGenSettings;
import com.matez.wildnature.world.gen.noise.OctaveNoiseSampler;
import com.matez.wildnature.world.gen.noise.OpenSimplexNoise;
import com.matez.wildnature.world.gen.noise.Sampler;
import com.matez.wildnature.world.gen.noise.SuperSimplexNoise;
import com.matez.wildnature.world.gen.noise.bukkit.SimplexOctaveGenerator;

import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.OctavesNoiseGenerator;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.jigsaw.JigsawJunction;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.StructureStart;

public class SmoothChunkGenerator extends ChunkGenerator<WNGenSettings> 
{
	private static final float[] biomeData = Util.make(new float[25], (data) -> {
        for(int i = -2; i <= 2; ++i) {
            for(int j = -2; j <= 2; ++j) {
                float f = 10.0F / MathHelper.sqrt((float)(i * i + j * j) + 0.2F);
                data[i + 2 + (j + 2) * 5] = f;
            }
        }

    });
	
	private final OctaveNoiseSampler heightNoise;
	private final OctaveNoiseSampler scaleNoise;
	
	private WNGenSettings settings;
	private final Random random;
	
	private final OctavesNoiseGenerator surfaceDepthNoise;
	private Sampler noiseSampler;
	
	private boolean amplified;
	
	protected HashMap<Long, int[]> noiseCache = new HashMap<>();
	private SharedSeedRandom randomSeed;
	
	public SmoothChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, WNGenSettings generationSettingsIn) 
	{
		super(worldIn, biomeProviderIn, generationSettingsIn);
		
		this.random = new Random(world.getSeed());
		double amplitude = Math.pow(2, 11);
		
		this.heightNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, this.random, 11, 0.75 * amplitude, amplitude, amplitude);
		this.scaleNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, this.random, 2, Math.pow(2, 10), 0.2, 0.09);
		
		this.settings = generationSettingsIn;
		
		this.randomSeed = new SharedSeedRandom(this.seed);
		
		this.surfaceDepthNoise = new OctavesNoiseGenerator(this.randomSeed, 4);
		
		this.noiseSampler = new Sampler(this.scaleNoise, this.heightNoise);
		
		this.amplified = worldIn.getWorldInfo().getGenerator() == WorldType.AMPLIFIED;
	}

	@Override
	public void generateSurface(IChunk chunkIn) 
	{
		ChunkPos chunkpos = chunkIn.getPos();
        int i = chunkpos.x;
        int j = chunkpos.z;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
        sharedseedrandom.setBaseChunkSeed(i, j);
        ChunkPos chunkpos1 = chunkIn.getPos();
        int k = chunkpos1.getXStart();
        int l = chunkpos1.getZStart();
        double noise = 0.0625D;
        Biome[] abiome = chunkIn.getBiomes();

        for(int i1 = 0; i1 < 16; ++i1) {
            for(int j1 = 0; j1 < 16; ++j1) {
                int k1 = k + i1;
                int l1 = l + j1;
                int i2 = chunkIn.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, i1, j1) + 1;
                double d1 = this.surfaceDepthNoise.func_215460_a((double)k1 * 0.0625D, (double)l1 * 0.0625D, 0.0625D, (double)i1 * 0.0625D);
                abiome[j1 * 16 + i1].buildSurface(sharedseedrandom, chunkIn, k1, l1, i2, d1, this.getSettings().getDefaultBlock(), this.getSettings().getDefaultFluid(), this.getSeaLevel(), this.world.getSeed());
            }
        }

        this.makeBedrock(chunkIn, sharedseedrandom);
	}
	
	protected void makeBedrock(IChunk chunkIn, Random rand) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        int i = chunkIn.getPos().getXStart();
        int j = chunkIn.getPos().getZStart();
        WNGenSettings t = this.getSettings();
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

	@Override
	public int getGroundHeight() 
	{
		return this.getSeaLevel() + 1;
	}

	@Override
	public void makeBase(IWorld worldIn, IChunk chunkIn) 
	{
		int i = this.getSeaLevel();
        ObjectList<AbstractVillagePiece> objectlist = new ObjectArrayList<>(10);
        ObjectList<JigsawJunction> objectlist1 = new ObjectArrayList<>(32);
        ChunkPos chunkpos = chunkIn.getPos();
        int x = chunkpos.x;
        int z = chunkpos.z;
        int l = x << 4;
        int i1 = z << 4;

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
        
        this.generateTerrain(chunkIn, this.getHeightsInChunk(chunkpos));
	}
	
	public void generateTerrain(IChunk chunk, int[] noise)
	{
		for(int x = 0; x < 16; x++)
        {
        	for(int z = 0; z < 16; z++)
        	{
        		int height = (int) noise[(x * 16) + z];
        		
        		for(int y = 0; y < 256; y++)
        		{
        			BlockPos pos = new BlockPos(x, y, z);
        			if (y > height)
        			{
        				if (y < this.getSeaLevel())
        				{
        					chunk.setBlockState(pos, this.settings.getDefaultFluid(), false);
        				}
        			}
        			else
        			{
        				chunk.setBlockState(pos, this.settings.getDefaultBlock(), false);
        			}
        		}
        	}
        }
	}
	
	protected int[] getHeightsInChunk(ChunkPos pos)
	{
		int[] res = noiseCache.get(pos.asLong());
		if (res != null) return res;
		
		int[] vals = new int[256];
		
		useNoise(vals, pos, 0, 16);
		
		noiseCache.put(pos.asLong(), vals);
		
		return vals;
	}
	
	public void useNoise(int[] noise, ChunkPos pos, int start, int size)
	{
		for(int x = start; x < start + size; x++)
		{
			for(int z = 0; z < 16; z++)
			{
				noise[(x * 16) + z] = getHeight((pos.x * 16) + x, (pos.z * 16) + z);
			}
		}
	}
	
	private double sigmoid(double val)
	{
		return 256 / (Math.exp(8/3f - val/48) + 1);
	}
	
	public int getHeight(int x, int z)
	{
		int xLow = ((x >> 2) << 2);
		int zLow = ((z >> 2) << 2);
		int xUpper = xLow + 4;
		int zUpper = zLow + 4;
		
		double xProgress = (double)(x - xLow) * 0.25;
		double zProgress = (double)(z - zLow) * 0.25;
		
		xProgress = xProgress * xProgress * (3 - (xProgress * 2));
		zProgress = zProgress * zProgress * (3 - (zProgress * 2));
		
		// Start of sample
		final double[] samples = new double[4];
		samples[0] = sampleNoise(xLow, zLow);
		samples[1] = sampleNoise(xUpper, zLow);
		samples[2] = sampleNoise(xLow, zUpper);
		samples[3] = sampleNoise(xUpper, zUpper);
		
		double sample = MathHelper.lerp(zProgress,
						MathHelper.lerp(xProgress, samples[0], samples[1]),
						MathHelper.lerp(xProgress, samples[2], samples[3]));
		
		sample = applyBiomeData(x, z, sample);
		
		return (int)(sigmoid(sample));
	}
	
	private double sampleNoise(int x, int z)
	{
		double noise = sampleNoiseBase(x, z);
		noise += sampleNoiseBase(x + 4, z);
		noise += sampleNoiseBase(x - 4, z);
		noise += sampleNoiseBase(x, z + 4);
		noise += sampleNoiseBase(x, z - 4);
		noise *= 0.2;
		
		noise += 100;
		
		return noise;
	}
	
	private double sampleNoiseBase(int x, int z)
	{
		double amplitudeSample = this.noiseSampler.sample(x, z) + 0.09;
		double noise = this.noiseSampler.sampleCustom(x, z, 1, amplitudeSample, 11);
		
		return noise;
	}
	
	private double applyBiomeData(int x, int z, double sample)
	{
		double noise = sample;
		Biome biome = this.biomeProvider.func_222366_b(x, z);
		
		float depth = biome.getDepth();
		float scale = biome.getScale();
		float seaLevel = (float) this.getSeaLevel();
		float count = 0;
		
		noise = Math.max(noise, seaLevel + 10 * depth);
		for (int j = -2; j <= 2; j++)
		{
			for (int i = -2; i <= 2; i++)
			{
				float data = biomeData[j + 2 + (i + 2) * 5] / (depth + 2.0F);
				count += (data > depth ? data / 6 : data) * scale;
			}
		}
		
		noise /= count;
		return noise;
	}

	@Override
	public int func_222529_a(int x, int z, Type p_222529_3_)
	{
		return getHeight(x, z);
	}
}
