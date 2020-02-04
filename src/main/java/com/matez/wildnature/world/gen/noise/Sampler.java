package com.matez.wildnature.world.gen.noise;

import java.util.HashMap;

import net.minecraft.util.math.BlockPos;

public class Sampler 
{
	protected HashMap<Long, Double> cache = new HashMap<>();
	protected final SuperSimplexNoise sampler;
	
	public Sampler(SuperSimplexNoise sampler)
	{
		this.sampler = sampler;
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
}
