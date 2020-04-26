package com.matez.wildnature.entity.model.animal;// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import com.matez.wildnature.entity.type.animal.bird.SparrowEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class SparrowModel extends EntityModel<SparrowEntity> {
    private final RendererModel Body;
    private final RendererModel Head;
    private final RendererModel Beak;
    private final RendererModel Tail;
    private final RendererModel TailEnd;
    private final RendererModel RightWing;
    private final RendererModel LeftWing;
    private final RendererModel LeftLeg;
    private final RendererModel RightLeg;

    public SparrowModel() {
        textureWidth = 32;
        textureHeight = 32;

        Body = new RendererModel(this);
        Body.setRotationPoint(0.0F, 20.0F, 0.0F);
        setRotationAngle(Body, -0.5236F, 0.0F, 0.0F);
        Body.cubeList.add(new ModelBox(Body, 0, 8, -2.0F, -1.134F, -1.5F, 3, 3, 4, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 0, 0, -1.5F, -1.634F, -0.5F, 2, 3, 5, 0.0F, false));

        Head = new RendererModel(this);
        Head.setRotationPoint(-0.5F, 17.0F, 0.0F);
        Head.cubeList.add(new ModelBox(Head, 0, 15, -1.25F, 1.0F, -2.0F, 2, 3, 3, 0.0F, false));
        Head.cubeList.add(new ModelBox(Head, 16, 10, -1.0F, 0.0F, -3.0F, 2, 2, 3, 0.0F, false));
        Head.cubeList.add(new ModelBox(Head, 9, 0, -0.5F, -0.25F, -2.5F, 1, 2, 2, 0.0F, false));

        Beak = new RendererModel(this);
        Beak.setRotationPoint(0.5F, 7.0F, 0.0F);
        setRotationAngle(Beak, 0.2618F, 0.0F, 0.0F);
        Head.addChild(Beak);
        Beak.cubeList.add(new ModelBox(Beak, 16, 17, -1.0F, -7.0341F, -2.2588F, 1, 1, 2, 0.0F, false));

        Tail = new RendererModel(this);
        Tail.setRotationPoint(-1.0F, 20.0F, 4.0F);
        setRotationAngle(Tail, -0.3491F, 0.0F, 0.0F);
        Tail.cubeList.add(new ModelBox(Tail, 10, 17, -0.25F, 0.9397F, 0.342F, 1, 1, 2, 0.0F, false));

        TailEnd = new RendererModel(this);
        TailEnd.setRotationPoint(0.0F, 24.0F, 0.0F);
        TailEnd.cubeList.add(new ModelBox(TailEnd, 15, 0, -1.0F, -2.5F, 5.0F, 1, 1, 2, 0.0F, false));

        RightWing = new RendererModel(this);
        RightWing.setRotationPoint(-2.0F, 18.0F, -1.0F);
        setRotationAngle(RightWing, -0.5236F, 0.0F, 0.0F);
        RightWing.cubeList.add(new ModelBox(RightWing, 10, 3, -0.5F, -0.134F, 0.5F, 1, 2, 5, 0.0F, false));

        LeftWing = new RendererModel(this);
        LeftWing.setRotationPoint(1.0F, 18.0F, -1.0F);
        setRotationAngle(LeftWing, -0.5236F, 0.0F, 0.0F);
        LeftWing.cubeList.add(new ModelBox(LeftWing, 9, 10, -0.5F, -0.134F, 0.5F, 1, 2, 5, 0.0F, false));

        LeftLeg = new RendererModel(this);
        LeftLeg.setRotationPoint(0.0F, 22.0F, 0.0F);
        LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 0, -0.25F, 0.0F, 0.0F, 1, 2, 1, 0.0F, false));
        LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 2, 0.0F, 2.0F, -1.0F, 1, 0, 2, 0.0F, false));

        RightLeg = new RendererModel(this);
        RightLeg.setRotationPoint(-1.0F, 22.0F, 0.0F);
        RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 0, -0.75F, 0.0F, 0.0F, 1, 2, 1, 0.0F, false));
        RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 0, -1.0F, 2.0F, -1.0F, 1, 0, 2, 0.0F, false));
    }

    @Override
    public void render(SparrowEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Body.render(f5);
        Head.render(f5);
        Tail.render(f5);
        TailEnd.render(f5);
        RightWing.render(f5);
        LeftWing.render(f5);
        LeftLeg.render(f5);
        RightLeg.render(f5);
    }
    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}