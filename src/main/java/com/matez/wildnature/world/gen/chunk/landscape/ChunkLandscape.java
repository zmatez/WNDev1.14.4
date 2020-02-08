package com.matez.wildnature.world.gen.chunk.landscape;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Random;

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
	
	protected float depth;
	protected float scale;
	
	protected OctaveNoiseSampler sampler;
	
	public ChunkLandscape(int x, int z, Long seed, Biome biome, IChunk chunkIn)
	{
		this.x = x;
		this.z = z;
		this.biome = biome;
		
		this.chunk = chunkIn;
		
		this.depth = biome.getDepth();
		this.scale = biome.getScale();
		this.random = new Random(seed);
		
		double amplitude = Math.pow(2, 11);
		// You can modify how this is set too, since I am pretty sure the sampler is good spot to change how terrain is generated
		this.sampler = new OctaveNoiseSampler<>(OpenSimplexNoise.class, this.random, 11, 0.75 * amplitude, amplitude, amplitude);
	}
	
	public static void addLandscape(Biome biome, Class<? extends ChunkLandscape> landscape)
	{
		ChunkLandscape.landscapeCache.put(biome.getRegistryName().getPath(), landscape);
	}
	
	// Feel free to mess with this, sampleArea, and this.sampler's creation, this is the key to getting terrain to listen to depth and scale. The old functions are still in SmoothChunkGenerator for reference
	public double generateHeightmap()
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
		samples[0] = sampleArea(xLow, zLow);
		samples[1] = sampleArea(xUpper, zLow);
		samples[2] = sampleArea(xLow, zUpper);
		samples[3] = sampleArea(xUpper, zUpper);
		
		double sample = MathHelper.lerp(zProgress,
						MathHelper.lerp(xProgress, samples[0] * this.depth, samples[1]) * this.depth,
						MathHelper.lerp(xProgress, samples[2], samples[3]));
		
		return 256 / (Math.exp(8 / 3f - sample / 48) + 1);
	}
	
	private double sampleArea(int x, int z)
	{
		double frequency = this.sampler.sample(x, z) * this.scale;
		return this.sampler.sampleCustom(x, z, frequency, this.scale, (this.scale / this.depth), 11);
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
	
	// This way, if we have a biome that would require different terrain we can create a class that extends ChunkLandscape and add it by calling "ChunkLandscape.add(WNBiomes.THE_BIOME, THE_CHUNK_LANDSCAPE.class);"
	public static ChunkLandscape getOrCreate(int x, int z, Long seed, Biome biome, IChunk chunkIn)
	{
		Class<? extends ChunkLandscape> landscape = landscapeCache.get(biome.getRegistryName().getPath());
		if (landscape != null)
		{
			try
			{
				return landscape.getDeclaredConstructor(int.class, int.class, Long.class, Biome.class, IChunk.class).newInstance(x, z, seed, biome, chunkIn);
			}
			catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
			{
				e.printStackTrace();
			}
		}
		
		return new ChunkLandscape(x, z, seed, biome, chunkIn);
	}
}
