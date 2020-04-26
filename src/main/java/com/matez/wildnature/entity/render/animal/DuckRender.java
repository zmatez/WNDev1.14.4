package com.matez.wildnature.entity.render.animal;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.model.animal.DrakeModel;
import com.matez.wildnature.entity.model.animal.DuckModel;
import com.matez.wildnature.entity.type.animal.duck.AbstractDuckEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DuckRender extends MobRenderer<AbstractDuckEntity, DuckModel> {
    public DuckRender(EntityRendererManager manager) {
        super(manager, new DuckModel(), 0.3F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(AbstractDuckEntity entity) {
        return Main.RegistryEvents.location("textures/entity/duck_female.png");
    }


    public static class RenderFactory implements IRenderFactory<AbstractDuckEntity>{
        @Override
        public EntityRenderer<? super AbstractDuckEntity> createRenderFor(EntityRendererManager manager) {
            return new DuckRender(manager);
        }
    }
}
