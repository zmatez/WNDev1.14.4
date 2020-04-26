package com.matez.wildnature.registry.advanced;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.client.model.BlockStateLoader;

public class AdvancedBeamsRegistry {
    public static void register(){
        Registry.BLOCK.forEach(block -> {
            if(block.getDefaultState().isSolid()){
                ResourceLocation r = new ResourceLocation("wildnature:"+block.getRegistryName().getNamespace()+"_beams");
            }
        });
    }
}
