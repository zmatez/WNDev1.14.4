package com.matez.wildnature.entity.render;


import com.matez.wildnature.entity.type.monster.GoblinEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
    public static void registryEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(GoblinEntity.class,new GoblinRender.RenderFactory());
    }
}
