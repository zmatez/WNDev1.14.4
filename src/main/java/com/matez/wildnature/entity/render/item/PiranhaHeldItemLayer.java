package com.matez.wildnature.entity.render.item;

import com.matez.wildnature.entity.model.animal.PiranhaModel;
import com.matez.wildnature.entity.type.animal.fish.PiranhaEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PiranhaHeldItemLayer extends LayerRenderer<PiranhaEntity, PiranhaModel<PiranhaEntity>> {
    public PiranhaHeldItemLayer(IEntityRenderer<PiranhaEntity, PiranhaModel<PiranhaEntity>> p_i50938_1_) {
        super(p_i50938_1_);
    }

    public void render(PiranhaEntity p_212842_1_, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
        ItemStack lvt_9_1_ = p_212842_1_.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
        if (!lvt_9_1_.isEmpty()) {
            boolean lvt_10_1_ = p_212842_1_.isSleeping();
            boolean lvt_11_1_ = p_212842_1_.isChild();
            GlStateManager.pushMatrix();
            float lvt_12_2_;
            if (lvt_11_1_) {
                lvt_12_2_ = 0.75F;
                GlStateManager.scalef(0.75F, 0.75F, 0.75F);
                GlStateManager.translatef(0.0F, 8.0F * p_212842_8_, 3.35F * p_212842_8_);
            }

            //GlStateManager.translatef(((PiranhaModel)this.getEntityModel()).field_217115_a.rotationPointX / 16.0F, ((PiranhaModel)this.getEntityModel()).field_217115_a.rotationPointY / 16.0F, ((PiranhaModel)this.getEntityModel()).field_217115_a.rotationPointZ / 16.0F);
            //vt_12_2_ = p_212842_1_.func_213475_v(p_212842_4_) * 57.295776F;
            //GlStateManager.rotatef(lvt_12_2_, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotatef(p_212842_6_, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotatef(p_212842_7_, 1.0F, 0.0F, 0.0F);
            if (p_212842_1_.isChild()) {
                if (lvt_10_1_) {
                    GlStateManager.translatef(0.4F, 0.26F, 0.15F);
                } else {
                    GlStateManager.translatef(0.06F, 0.26F, -0.5F);
                }
            } else if (lvt_10_1_) {
                GlStateManager.translatef(0.46F, 0.26F, 0.22F);
            } else {
                GlStateManager.translatef(0.06F, 0.27F, -0.5F);
            }

            GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
            if (lvt_10_1_) {
                GlStateManager.rotatef(90.0F, 0.0F, 0.0F, 1.0F);
            }

            Minecraft.getInstance().getItemRenderer().renderItem(lvt_9_1_, p_212842_1_, ItemCameraTransforms.TransformType.GROUND, false);
            GlStateManager.popMatrix();
        }
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}