package com.matez.wildnature.world.gen.carvers;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.event.RegistryEvent;

public class CarverRegistry {

    public static WorldCarver<ProbabilityConfig> CAVE_CARVER;

    public static void registerAll(final RegistryEvent.Register<WorldCarver<?>> event){
        event.getRegistry().registerAll(
                CAVE_CARVER = new WNCaveCarver(ProbabilityConfig::deserialize, 256)
        );
    }

}
