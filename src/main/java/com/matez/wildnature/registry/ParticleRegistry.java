package com.matez.wildnature.registry;

import net.minecraft.client.particle.PortalParticle;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.registry.Registry;

public class ParticleRegistry {

    public static final BasicParticleType DUNGEON_HEART = register("wildnature:dungeon_heart", false);
    public static final BasicParticleType CRYSTAL_SPARK = register("wildnature:crystal_spark", false);
    public static final BasicParticleType GEYSER = register("wildnature:geyser", false);
    public static final BasicParticleType STEAM = register("wildnature:steam", false);

    private static BasicParticleType register(String key, boolean alwaysShow) {
        System.out.println("Registering particle: " + key);
        return (BasicParticleType) Registry.<ParticleType<? extends IParticleData>>register(Registry.PARTICLE_TYPE, key, new BasicParticleType(alwaysShow));
    }

    private static <T extends IParticleData> ParticleType<T> register(String key, IParticleData.IDeserializer<T> deserializer) {
        return Registry.register(Registry.PARTICLE_TYPE, key, new ParticleType<>(false, deserializer));
    }
}
