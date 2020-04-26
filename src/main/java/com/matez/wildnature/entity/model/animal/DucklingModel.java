package com.matez.wildnature.entity.model.animal;

import com.matez.wildnature.entity.type.animal.duck.AbstractDuckEntity;
import com.matez.wildnature.entity.type.animal.duck.DucklingEntity;
import com.matez.wildnature.entity.type.monster.GoblinEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelDuckBaby - TechneToTabulaImporter
 * Created using Tabula 7.0.0
 */
public class DucklingModel extends EntityModel<AbstractDuckEntity> {
    public RendererModel neck;
    public RendererModel body;
    public RendererModel body2;
    public RendererModel wing1;
    public RendererModel wing2;
    public RendererModel RightLeg;
    public RendererModel LeftLeg;
    public RendererModel head;
    public RendererModel beak;
    public RendererModel beak2;
    public RendererModel body3;
    public RendererModel RightFoot;
    public RendererModel LeftFoot;

    public DucklingModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.neck = new RendererModel(this, 18, 9);
        this.neck.setRotationPoint(0.0F, 20.8F, -1.0F);
        this.neck.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(neck, -1.1390018698514994F, -0.0F, 0.0F);
        this.head = new RendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, -2.0F, -4.3F);
        this.head.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(head, 1.1693705988362009F, 0.0F, 0.0F);
        this.LeftLeg = new RendererModel(this, 0, 16);
        this.LeftLeg.setRotationPoint(0.5F, 22.0F, 0.0F);
        this.LeftLeg.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.body3 = new RendererModel(this, 16, 19);
        this.body3.setRotationPoint(0.5F, 2.4F, -0.1F);
        this.body3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(body3, 0.6981317007977318F, 0.0F, 0.0F);
        this.RightFoot = new RendererModel(this, 1, 23);
        this.RightFoot.setRotationPoint(-0.5F, 1.9F, -0.8F);
        this.RightFoot.addBox(0.0F, 0.0F, 0.0F, 2, 0, 2, 0.0F);
        this.body2 = new RendererModel(this, 30, 19);
        this.body2.setRotationPoint(-1.5F, 18.9F, 1.3F);
        this.body2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(body2, -0.008726646259971648F, -0.0F, 0.0F);
        this.RightLeg = new RendererModel(this, 0, 16);
        this.RightLeg.setRotationPoint(-1.5F, 22.0F, 0.0F);
        this.RightLeg.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.beak2 = new RendererModel(this, 26, 0);
        this.beak2.setRotationPoint(1.0F, 0.7F, -1.1F);
        this.beak2.addBox(-1.5F, 0.0F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(beak2, 0.4166100924510465F, 0.0F, 0.0F);
        this.wing2 = new RendererModel(this, 28, 25);
        this.wing2.mirror = true;
        this.wing2.setRotationPoint(1.0F, 18.5F, -1.0F);
        this.wing2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(wing2, 0.0F, 0.5235987901687622F, 0.0F);
        this.beak = new RendererModel(this, 35, 0);
        this.beak.setRotationPoint(0.5F, 1.9F, -1.5F);
        this.beak.addBox(-1.5F, 0.0F, -3.0F, 2, 1, 3, 0.0F);
        this.body = new RendererModel(this, 30, 9);
        this.body.setRotationPoint(-2.0F, 18.0F, -1.5F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(body, -0.17907698452472687F, -0.0F, 0.0F);
        this.wing1 = new RendererModel(this, 28, 25);
        this.wing1.setRotationPoint(-2.0F, 18.399999618530273F, -1.399999976158142F);
        this.wing1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(wing1, 0.0F, -0.471238911151886F, 0.0F);
        this.LeftFoot = new RendererModel(this, 1, 23);
        this.LeftFoot.setRotationPoint(-0.5F, 1.9F, -0.8F);
        this.LeftFoot.addBox(0.0F, 0.0F, 0.0F, 2, 0, 2, 0.0F);
        this.neck.addChild(this.head);
        this.body2.addChild(this.body3);
        this.RightLeg.addChild(this.RightFoot);
        this.head.addChild(this.beak2);
        this.head.addChild(this.beak);
        this.LeftLeg.addChild(this.LeftFoot);
    }

    public void render(AbstractDuckEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

        this.neck.render(scale);
        this.LeftLeg.render(scale);
        this.body2.render(scale);
        this.RightLeg.render(scale);
        this.wing2.render(scale);
        this.body.render(scale);
        this.wing1.render(scale);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }

    int stateFlap = 0;

    @Override
    public void setRotationAngles(AbstractDuckEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        float flap = ageInTicks*2;
        this.body2.rotateAngleX = headPitch * 0.017453292F-0.8F;
        this.body2.rotateAngleY = netHeadYaw * 0.017453292F;

        if(((AbstractDuckEntity) entityIn).onGround){
            this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.wing1.rotateAngleZ = 0;
            this.wing2.rotateAngleZ = 0;
        }else{
            this.RightLeg.rotateAngleX = 20;
            this.LeftLeg.rotateAngleX = 20;
            if(stateFlap==0){
                this.wing1.rotateAngleZ = -0.0873F - -flap;
                this.wing2.rotateAngleZ = 0.0873F + -flap;

            }else{
                this.wing1.rotateAngleZ = -0.0873F - flap;
                this.wing2.rotateAngleZ = 0.0873F + flap;
                if(this.wing2.rotateAngleZ>=60){
                    stateFlap=0;
                }
            }


        }
    }



}
