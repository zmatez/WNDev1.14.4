package com.matez.wildnature.sounds;

import com.matez.wildnature.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundRegistry {
    public static SoundEvent PISTON_2s_OPEN = registerSound("block.piston.2s_open");
    public static SoundEvent PISTON_3s_OPEN = registerSound("block.piston.3s_open");
    public static SoundEvent PISTON_2s_CLOSE = registerSound("block.piston.2s_close");
    public static SoundEvent PISTON_3s_CLOSE = registerSound("block.piston.3s_close");
    public static SoundEvent STEAM_GENERATOR = registerSound("block.steam_generator");

    //AMBIENT
    /*
    public static SoundEvent DENSEFOREST_DAY_0 = registerSound("ambient.denseforest_day_0");
    public static SoundEvent DENSEFOREST_DAY_1 = registerSound("ambient.denseforest_day_1");
    public static SoundEvent DENSEFOREST_DAY_2 = registerSound("ambient.denseforest_day_2");
    public static SoundEvent DENSEFOREST_DAY_3 = registerSound("ambient.denseforest_day_3");
    public static SoundEvent DENSEFOREST_DAY_4 = registerSound("ambient.denseforest_day_4");
    public static SoundEvent DENSEFOREST_NIGHT_0 = registerSound("ambient.denseforest_night_0");
    public static SoundEvent DENSEFOREST_OPENFIELD_DAY_0 = registerSound("ambient.denseforest_openfield_day_0");
    public static SoundEvent DENSEFOREST_OPENFIELD_DAY_1 = registerSound("ambient.denseforest_openfield_day_1");
    public static SoundEvent MOUNTAINS_0 = registerSound("ambient.denseforest_mountains_0");
    public static SoundEvent PLAINS_0 = registerSound("ambient.denseforest_plains_0");
    public static SoundEvent PLAINS_1 = registerSound("ambient.denseforest_plains_1");
    public static SoundEvent REDWOODFOREST_DAY_0 = registerSound("ambient.redwoodforest_day_0");*/

    public static SoundEvent[] register(){
        return new SoundEvent[]{
                PISTON_2s_OPEN,
                PISTON_3s_OPEN,
                PISTON_2s_CLOSE,
                PISTON_3s_CLOSE,
                STEAM_GENERATOR
                /*DENSEFOREST_DAY_0,
                DENSEFOREST_DAY_1,
                DENSEFOREST_DAY_2,
                DENSEFOREST_DAY_3,
                DENSEFOREST_DAY_4,
                DENSEFOREST_NIGHT_0,
                DENSEFOREST_OPENFIELD_DAY_0,
                DENSEFOREST_OPENFIELD_DAY_1,
                MOUNTAINS_0,
                PLAINS_0,
                PLAINS_1,
                REDWOODFOREST_DAY_0*/


        };
    }

    private static SoundEvent registerSound(String soundName)
    {
        //soundID;//SoundEvent soundID = IRegistry.field_212633_v.func_212608_b(new ResourceLocation(soundName));
        final ResourceLocation soundID = Main.RegistryEvents.location(soundName);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }
}
