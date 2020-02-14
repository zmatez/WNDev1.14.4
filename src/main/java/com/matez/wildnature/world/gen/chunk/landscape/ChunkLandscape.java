package com.matez.wildnature.world.gen.chunk.landscape;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Random;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.chunk.SmoothChunkGenerator;
import com.matez.wildnature.world.gen.noise.OctaveNoiseSampler;
import com.matez.wildnature.world.gen.noise.OpenSimplexNoise;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

public class ChunkLandscape 
{
	public static HashMap<String, Class<? extends ChunkLandscape>> landscapeCache = new HashMap<String, Class<? extends ChunkLandscape>>();
	
	protected int x;
	protected int z;
	
	protected IChunk chunk;
	protected Biome biome;
	protected Random random;


	/**
	 * --- DEPTH REFERENCE ---
	 * depth - biome ground elevation
	 * 0 - flat terrain (plains biome)
	 * 1 - sharp terrain (mountains biome)
	 * -1 - reverse of sharp terrain (ocean biome)
	 */
	protected float depth;

	/**
	 * --- SCALE REFERENCE ---
	 * scale - biome height
	 * 0 - sea level(63)
	 * 1 - medium mountains
	 * 2 - high mountain
	 * -0.6 - rivers
	 * -1.4 - oceans
	 */
	protected float scale;


	protected int octaves = 11;

	protected int seaLevel;
	
	protected OctaveNoiseSampler<OpenSimplexNoise> heightNoise;
	protected OctaveNoiseSampler<OpenSimplexNoise> scaleNoise;
	
	public ChunkLandscape(int x, int z, Long seed, int seaLevel, Biome biome, IChunk chunkIn)
	{
		this.x = x;
		this.z = z;
		this.seaLevel=seaLevel;
		this.biome = biome;
		
		this.chunk = chunkIn;
		
		this.depth = biome.getDepth();
		this.scale = biome.getScale();
		this.random = new Random(seed);
		
		double amplitude = Math.pow(2, octaves);
		
		this.heightNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, this.random, this.octaves, 0.75 * amplitude, amplitude, amplitude);
		this.scaleNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, this.random, 2, Math.pow(2, 10), 0.2, 0.09);
	}
	
	public static void addLandscape(Biome biome, Class<? extends ChunkLandscape> landscape)
	{
		ChunkLandscape.landscapeCache.put(biome.getRegistryName().getPath(), landscape);
	}

	private int size = 4;
	public double generateHeightmap()
	{
		int xLow = ((x >> 2) << 2);
		int zLow = ((z >> 2) << 2);
		int xUpper = xLow + size;
		int zUpper = zLow + size;
		
		double xProgress = (double)(x - xLow) * 0.25;
		double zProgress = (double)(z - zLow) * 0.25;
		
		xProgress = xProgress * xProgress * (3 - (xProgress * 2));
		zProgress = zProgress * zProgress * (3 - (zProgress * 2));
		
		// Start of sample
		final double[] samples = new double[4];
		samples[0] = sampleArea(xLow, zLow);
		samples[1] = sampleArea(xUpper, zLow);
		samples[2] = sampleArea(xLow, zUpper);
		samples[3] = sampleArea(xUpper, zUpper);
		
		double sample = MathHelper.lerp(zProgress,
						MathHelper.lerp(xProgress, samples[0], samples[1]),
						MathHelper.lerp(xProgress, samples[2], samples[3]));
		
		double height =  256 / (Math.exp(8 / 3f - sample / 48) + 1);

		return height;
	}
	
	private double sampleArea(int x, int z)
	{
		double noise = sampleNoise(x, z);
		noise += sampleNoise(x + size, z);
		noise += sampleNoise(x - size, z);
		noise += sampleNoise(x, z + size);
		noise += sampleNoise(x, z - size);
		noise *= 0.2;
		
		noise += 100;
		
		return noise;
	}
	
	private double sampleNoise(int x, int z)
	{
		double frequency = this.scaleNoise.sample(x, z);
		return this.heightNoise.sampleCustom(x, z, 1, frequency, frequency, octaves);
	}

	// I removed all mentions of this, so feel free to delete this and try to apply biome depth and scale yourself... unfortunately I didn't have much luck today, and can't find any references that would
	// actually be useful ;-;
	public double applyBiomeData(Biome biome, double sample)
	{
		double noise = sample;

		float depth = biome.getDepth();
		float scale = biome.getScale();
		float count = 0;

		noise = Math.max(noise, (float)seaLevel + 10 * depth);
		for (int j = -2; j <= 2; j++)
		{
			for (int i = -2; i <= 2; i++)
			{
				float data = SmoothChunkGenerator.biomeData[j + 2 + (i + 2) * 5] / (depth + 2.0F);
				count += (data > depth ? data / 6 : data) * scale;
			}
		}

		noise /= count;
		return noise;
	}
	
	public ChunkLandscape applyValues(int x, int z, Long seed, Biome biome, IChunk chunkIn)
	{
		this.x = x;
		this.z = z;
		this.random.setSeed(seed);
		
		this.biome = biome;
		this.chunk = chunkIn;
		
		return this;
	}

	
	// This way, if we have a biome that would require different terrain we can create a class that extends ChunkLandscape and add it by calling "ChunkLandscape.addLandscape(WNBiomes.THE_BIOME, THE_CHUNK_LANDSCAPE.class);"
	public static ChunkLandscape getOrCreate(int x, int z, Long seed, int seaLevel, Biome biome, IChunk chunkIn)
	{
		Class<? extends ChunkLandscape> landscape = landscapeCache.get(biome.getRegistryName().getPath());
		if (landscape != null)
		{
			try
			{
				return landscape.getDeclaredConstructor(int.class, int.class, Long.class, int.class, Biome.class, IChunk.class).newInstance(x, z, seed, seaLevel, biome, chunkIn);
			}
			catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
			{
				e.printStackTrace();
			}
		}
		
		return new ChunkLandscape(x, z, seed, seaLevel, biome, chunkIn);
	}
}
