package com.matez.wildnature.entity.model.monster;

import com.matez.wildnature.entity.type.monster.GoblinEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GoblinModel extends EntityModel<GoblinEntity> {
    private final RendererModel root;
    private final RendererModel Body;
    private final RendererModel Underbody;
    private final RendererModel Left_upperleg;
    private final RendererModel Left_Lowerleg;
    private final RendererModel left_foot;
    private final RendererModel Right_upperleg;
    private final RendererModel Right_Lowerleg;
    private final RendererModel Right_foot;
    private final RendererModel Left_upperarm;
    private final RendererModel Left_underarm;
    private final RendererModel Right_upperarm;
    private final RendererModel Right_underarm;
    private final RendererModel Head;
    private final RendererModel leftear;
    private final RendererModel rightear;
    private final RendererModel Nose;

    public GoblinModel() {
        textureWidth = 64;
        textureHeight = 64;

        root = new RendererModel(this);
        root.setRotationPoint(0.0F, 0.0F, 0.0F);

        Body = new RendererModel(this);
        Body.setRotationPoint(0.0F, 2.0F, 0.0F);
        setRotationAngle(Body, 0.4363F, 0.0F, 0.0F);
        root.addChild(Body);
        Body.cubeList.add(new ModelBox(Body, 0, 0, -3.0F, 0.0F, -2.0F, 6, 6, 4, 0.0F, true));

        Underbody = new RendererModel(this);
        Underbody.setRotationPoint(0.0F, 6.0F, 0.0F);
        setRotationAngle(Underbody, -0.6109F, 0.0F, 0.0F);
        Body.addChild(Underbody);
        Underbody.cubeList.add(new ModelBox(Underbody, 20, 0, -2.0F, -1.3F, -2.0F, 4, 8, 4, 0.0F, true));

        Left_upperleg = new RendererModel(this);
        Left_upperleg.setRotationPoint(-2.4F, 5.5F, -1.0F);
        setRotationAngle(Left_upperleg, -0.4363F, 0.0F, 0.0F);
        Underbody.addChild(Left_upperleg);
        Left_upperleg.cubeList.add(new ModelBox(Left_upperleg, 20, 13, -1.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F, true));

        Left_Lowerleg = new RendererModel(this);
        Left_Lowerleg.setRotationPoint(1.0F, 6.0F, 1.0F);
        setRotationAngle(Left_Lowerleg, 1.1345F, 0.0F, 0.0F);
        Left_upperleg.addChild(Left_Lowerleg);
        Left_Lowerleg.cubeList.add(new ModelBox(Left_Lowerleg, 20, 21, -2.0F, -2.0F, -1.0F, 2, 8, 2, 0.0F, true));

        left_foot = new RendererModel(this);
        left_foot.setRotationPoint(0.0F, 5.9F, 0.0F);
        setRotationAngle(left_foot, -0.5236F, 0.0F, 0.0F);
        Left_Lowerleg.addChild(left_foot);
        left_foot.cubeList.add(new ModelBox(left_foot, 20, 31, -2.0F, 0.0F, -3.0F, 2, 1, 4, 0.0F, true));

        Right_upperleg = new RendererModel(this);
        Right_upperleg.setRotationPoint(2.4F, 5.5F, -1.0F);
        setRotationAngle(Right_upperleg, -0.4363F, 0.0F, 0.0F);
        Underbody.addChild(Right_upperleg);
        Right_upperleg.cubeList.add(new ModelBox(Right_upperleg, 33, 13, -1.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F, true));

        Right_Lowerleg = new RendererModel(this);
        Right_Lowerleg.setRotationPoint(1.0F, 6.0F, 1.0F);
        setRotationAngle(Right_Lowerleg, 1.1345F, 0.0F, 0.0F);
        Right_upperleg.addChild(Right_Lowerleg);
        Right_Lowerleg.cubeList.add(new ModelBox(Right_Lowerleg, 33, 21, -2.0F, -2.0F, -1.0F, 2, 8, 2, 0.0F, true));

        Right_foot = new RendererModel(this);
        Right_foot.setRotationPoint(0.0F, 5.9F, 0.0F);
        setRotationAngle(Right_foot, -0.5236F, 0.0F, 0.0F);
        Right_Lowerleg.addChild(Right_foot);
        Right_foot.cubeList.add(new ModelBox(Right_foot, 33, 31, -2.0F, 0.0F, -3.0F, 2, 1, 4, 0.0F, true));

        Left_upperarm = new RendererModel(this);
        Left_upperarm.setRotationPoint(-3.0F, 0.2F, 0.0F);
        setRotationAngle(Left_upperarm, -0.1745F, 0.0F, -0.1396F);
        Body.addChild(Left_upperarm);
        Left_upperarm.cubeList.add(new ModelBox(Left_upperarm, 0, 11, -2.0F, -0.2F, -0.8F, 2, 6, 2, 0.0F, true));

        Left_underarm = new RendererModel(this);
        Left_underarm.setRotationPoint(-1.0F, 5.5F, 0.0F);
        setRotationAngle(Left_underarm, -1.5708F, -0.1745F, 0.0F);
        Left_upperarm.addChild(Left_underarm);
        Left_underarm.cubeList.add(new ModelBox(Left_underarm, 0, 20, -1.0F, -2.0F, 0.0F, 2, 8, 2, 0.0F, true));

        Right_upperarm = new RendererModel(this);
        Right_upperarm.setRotationPoint(3.0F, 0.2F, 0.0F);
        setRotationAngle(Right_upperarm, -0.1745F, 0.0F, 0.1396F);
        Body.addChild(Right_upperarm);
        Right_upperarm.cubeList.add(new ModelBox(Right_upperarm, 10, 11, 0.0F, -0.2F, -0.8F, 2, 6, 2, 0.0F, true));

        Right_underarm = new RendererModel(this);
        Right_underarm.setRotationPoint(1.0F, 5.5F, 0.0F);
        setRotationAngle(Right_underarm, -1.5708F, 0.1745F, 0.0F);
        Right_upperarm.addChild(Right_underarm);
        Right_underarm.cubeList.add(new ModelBox(Right_underarm, 11, 20, -1.0F, -2.0F, 0.0F, 2, 8, 2, 0.0F, true));

        Head = new RendererModel(this);
        Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Head, -0.4253F, 0.0F, 0.0F);
        Body.addChild(Head);
        Head.cubeList.add(new ModelBox(Head, 0, 30, -2.0F, -3.5F, -3.6F, 4, 4, 6, 0.0F, true));

        leftear = new RendererModel(this);
        leftear.setRotationPoint(-2.0F, -1.5F, -1.5F);
        setRotationAngle(leftear, 0.5236F, -0.384F, 0.0F);
        Head.addChild(leftear);
        leftear.cubeList.add(new ModelBox(leftear, 0, 40, -0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F, true));

        rightear = new RendererModel(this);
        rightear.setRotationPoint(2.0F, -1.5F, -1.5F);
        setRotationAngle(rightear, 0.5236F, 0.384F, 0.0F);
        Head.addChild(rightear);
        rightear.cubeList.add(new ModelBox(rightear, 8, 40, -0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F, true));

        Nose = new RendererModel(this);
        Nose.setRotationPoint(0.5F, -1.5F, -4.3F);
        Head.addChild(Nose);
        Nose.cubeList.add(new ModelBox(Nose, 16, 40, -1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, true));
    }

    public void render(GoblinEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        root.render(scale);
    }


    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
