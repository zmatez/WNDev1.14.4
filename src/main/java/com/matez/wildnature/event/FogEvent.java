package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FogEvent {

    @SubscribeEvent
    public void fogEvent(EntityViewRenderEvent.FogDensity event){
        BlockPos pos = event.getInfo().getBlockPos();
        World world = event.getInfo().getRenderViewEntity().getEntityWorld();
        Biome currentBiome = world.getBiome(pos);

        if(currentBiome== Main.getBiomeByID("wildnature:mangrove_bayou")){
            event.setCanceled(true);
            event.setDensity(1F);

        }
    }


    public static class FogBiomeConfig{
        public FogBiomeConfig(Biome b, float density){

        }
    }
}
