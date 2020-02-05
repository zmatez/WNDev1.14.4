package com.matez.wildnature.world.gen.noise;

import java.util.HashMap;

import com.matez.wildnature.Main;

import net.minecraft.util.math.BlockPos;

public class Sampler 
{
	protected HashMap<Long, Double> cache = new HashMap<>();
	protected HashMap<Long, Double> customCache = new HashMap<>();
	
	protected final SuperSimplexNoise sampler;
	protected final OctaveNoiseSampler customSampler;
	
	public Sampler(SuperSimplexNoise sampler, OctaveNoiseSampler customSampler)
	{
		this.sampler = sampler;
		this.customSampler = customSampler;
	}
	
	public double sample(int x, int z)
	{
		Double val = cache.get(BlockPos.pack(x, 0, z));
		if (val != null) return val;
		
		// Not in cache
		val = sampler.noise2(x, z);
		cache.put(BlockPos.pack(x, 0, z), val);
		return val;
	}
	
	public double sampleCustom(int x, int z, double samplingFrequency, double amplitude, int octaves)
	{
		Double val = customCache.get(BlockPos.pack(x, 0, z));
		if (val != null) return val;
		
		Main.LOGGER.debug("Custom sampling...");
		
		// Not in cache
		val = customSampler.sampleCustom(x, z, samplingFrequency, amplitude, amplitude, octaves);
		customCache.put(BlockPos.pack(x, 0, z), val);
		return val;
	}
}
