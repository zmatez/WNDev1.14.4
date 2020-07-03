package com.matez.wildnature.entity.render;


import com.matez.wildnature.entity.render.animal.*;
import com.matez.wildnature.entity.render.monster.GoblinRender;
import com.matez.wildnature.entity.type.animal.bird.SparrowEntity;
import com.matez.wildnature.entity.type.animal.boar.BoarEntity;
import com.matez.wildnature.entity.type.animal.deer.BuckEntity;
import com.matez.wildnature.entity.type.animal.deer.DoeEntity;
import com.matez.wildnature.entity.type.animal.deer.FawnEntity;
import com.matez.wildnature.entity.type.animal.duck.DrakeEntity;
import com.matez.wildnature.entity.type.animal.duck.DuckEntity;
import com.matez.wildnature.entity.type.animal.duck.DucklingEntity;
import com.matez.wildnature.entity.type.animal.fish.PiranhaEntity;
import com.matez.wildnature.entity.type.animal.insect.DragonflyEntity;
import com.matez.wildnature.entity.type.monster.GoblinEntity;
import com.matez.wildnature.gui.tileEntities.seat.SeatEntity;
import com.matez.wildnature.gui.tileEntities.seat.SeatEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
    public static void registryEntityRenders(){
        RenderingRegistry.registerEntityRenderingHandler(GoblinEntity.class,new GoblinRender.RenderFactory());
        //animals
        RenderingRegistry.registerEntityRenderingHandler(DrakeEntity.class,new DrakeRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(DuckEntity.class,new DuckRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(DucklingEntity.class,new DucklingRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(BoarEntity.class,new BoarRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(PiranhaEntity.class,new PiranhaRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(DragonflyEntity.class,new DragonflyRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(SparrowEntity.class,new SparrowMaleRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(BuckEntity.class,new BuckRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(DoeEntity.class,new DoeRender.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(FawnEntity.class,new FawnRender.RenderFactory());

        //tiles
        RenderingRegistry.registerEntityRenderingHandler(SeatEntity.class,new SeatEntityRenderer.RenderFactory());

    }
}
