package com.matez.wildnature.world.gen.provider;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.biome.provider.BiomeProviderType;

import java.util.function.Function;
import java.util.function.Supplier;

public class WNBiomeProviderType { ;
    public static BiomeProviderType<OverworldBiomeProviderSettings, WildNatureBiomeProvider> WILDNATURE;

    public WNBiomeProviderType(){
        WILDNATURE = register("wildnature", WildNatureBiomeProvider::new, OverworldBiomeProviderSettings::new);
    }

    private static <C extends IBiomeProviderSettings, T extends BiomeProvider> BiomeProviderType<C, T> register(String key, Function<C, T> p_212581_1_, Supplier<C> p_212581_2_) {
        return Registry.register(Registry.BIOME_SOURCE_TYPE, key,new BiomeProviderType<>(p_212581_1_, p_212581_2_));
    }
}
