package com.matez.wildnature.entity.model.animal;// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import com.matez.wildnature.entity.type.animal.insect.DragonflyEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class DragonflyModel extends EntityModel<DragonflyEntity> {
	private final RendererModel Body;
	private final RendererModel Tail;
	private final RendererModel TailEnd;
	private final RendererModel Head;
	private final RendererModel LeftFrontWings;
	private final RendererModel LeftBackWing;
	private final RendererModel RightFrontWings;
	private final RendererModel RightBackWings;
	private final RendererModel FrontRightLeg;
	private final RendererModel bone;
	private final RendererModel MiddleRightLeg;
	private final RendererModel bone2;
	private final RendererModel BackRightLeg;
	private final RendererModel bone3;
	private final RendererModel FrontLeftLeg;
	private final RendererModel bone4;
	private final RendererModel MiddleLeftLeg;
	private final RendererModel bone5;
	private final RendererModel BackLeftLeg;
	private final RendererModel bone6;

	public DragonflyModel() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 10, -1.125F, -3.0F, -2.0F, 1, 1, 2, 0.0F, false));

		Tail = new RendererModel(this);
		Tail.setRotationPoint(-0.5F, -2.5F, 0.0F);
		setRotationAngle(Tail, -0.2618F, 0.0F, 0.0F);
		Body.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 5, 7, -0.5625F, -0.5F, -0.5F, 1, 1, 3, 0.0F, false));

		TailEnd = new RendererModel(this);
		TailEnd.setRotationPoint(-0.5F, -2.5F, 0.0F);
		Body.addChild(TailEnd);
		TailEnd.cubeList.add(new ModelBox(TailEnd, 0, 6, -0.5F, 0.0F, 2.0F, 1, 1, 3, 0.0F, false));

		Head = new RendererModel(this);
		Head.setRotationPoint(-0.5F, 21.5F, -1.5F);
		setRotationAngle(Head, 0.8727F, 0.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 10, 6, -0.75F, -1.0F, -1.5F, 1, 1, 1, 0.0F, false));

		LeftFrontWings = new RendererModel(this);
		LeftFrontWings.setRotationPoint(-0.5F, 21.0F, -1.0F);
		setRotationAngle(LeftFrontWings, 0.0F, 0.1745F, 0.0F);
		LeftFrontWings.cubeList.add(new ModelBox(LeftFrontWings, 0, 1, 0.0F, 0.0F, -0.5F, 6, 0, 1, 0.0F, false));
		LeftFrontWings.cubeList.add(new ModelBox(LeftFrontWings, 0, 4, 0.0F, 0.0F, 0.5F, 5, 0, 1, 0.0F, false));

		LeftBackWing = new RendererModel(this);
		LeftBackWing.setRotationPoint(-0.5F, 21.0F, 0.0F);
		setRotationAngle(LeftBackWing, -0.2618F, -0.3491F, 0.0F);
		LeftBackWing.cubeList.add(new ModelBox(LeftBackWing, 0, 5, 0.0F, 0.0F, -0.5F, 5, 0, 1, 0.0F, false));
		LeftBackWing.cubeList.add(new ModelBox(LeftBackWing, 9, 9, 0.0F, 0.0F, 0.5F, 3, 0, 1, 0.0F, false));

		RightFrontWings = new RendererModel(this);
		RightFrontWings.setRotationPoint(-0.5F, 21.0F, -1.0F);
		setRotationAngle(RightFrontWings, 0.0F, -0.1745F, 0.0F);
		RightFrontWings.cubeList.add(new ModelBox(RightFrontWings, 0, 0, -6.0F, 0.0F, -0.5F, 6, 0, 1, 0.0F, false));
		RightFrontWings.cubeList.add(new ModelBox(RightFrontWings, 0, 3, -5.0F, 0.0F, 0.5F, 5, 0, 1, 0.0F, false));

		RightBackWings = new RendererModel(this);
		RightBackWings.setRotationPoint(-0.5F, 21.0F, 0.0F);
		setRotationAngle(RightBackWings, -0.2618F, 0.3491F, 0.0F);
		RightBackWings.cubeList.add(new ModelBox(RightBackWings, 0, 2, -5.0F, 0.0F, -0.5F, 5, 0, 1, 0.0F, false));
		RightBackWings.cubeList.add(new ModelBox(RightBackWings, 4, 6, -3.0F, 0.0F, 0.5F, 3, 0, 1, 0.0F, false));

		FrontRightLeg = new RendererModel(this);
		FrontRightLeg.setRotationPoint(-1.0F, 22.0F, -1.5F);
		setRotationAngle(FrontRightLeg, -0.4363F, 0.0F, 0.5236F);
		FrontRightLeg.cubeList.add(new ModelBox(FrontRightLeg, 6, 11, -0.75F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		bone = new RendererModel(this);
		bone.setRotationPoint(-0.5F, 1.0F, 0.0F);
		setRotationAngle(bone, 1.0472F, 0.0F, 0.0F);
		FrontRightLeg.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 4, 11, -0.25F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		MiddleRightLeg = new RendererModel(this);
		MiddleRightLeg.setRotationPoint(-1.0F, 22.0F, -0.5F);
		setRotationAngle(MiddleRightLeg, 0.0F, 0.0F, 0.4363F);
		MiddleRightLeg.cubeList.add(new ModelBox(MiddleRightLeg, 10, 11, -0.75F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		bone2 = new RendererModel(this);
		bone2.setRotationPoint(-0.5F, 1.0F, 0.0F);
		setRotationAngle(bone2, 1.1345F, 0.0F, 0.0F);
		MiddleRightLeg.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 11, -0.25F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		BackRightLeg = new RendererModel(this);
		BackRightLeg.setRotationPoint(-1.0F, 22.0F, 0.0F);
		setRotationAngle(BackRightLeg, 0.3491F, 0.0F, 0.3491F);
		BackRightLeg.cubeList.add(new ModelBox(BackRightLeg, 8, 11, -0.75F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		bone3 = new RendererModel(this);
		bone3.setRotationPoint(-0.5F, 1.0F, 0.0F);
		setRotationAngle(bone3, 0.9599F, 0.0F, 0.0F);
		BackRightLeg.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 10, 8, -0.25F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		FrontLeftLeg = new RendererModel(this);
		FrontLeftLeg.setRotationPoint(0.0F, 22.0F, -1.5F);
		setRotationAngle(FrontLeftLeg, -0.4363F, 0.0F, -0.5236F);
		FrontLeftLeg.cubeList.add(new ModelBox(FrontLeftLeg, 0, 10, -0.25F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		bone4 = new RendererModel(this);
		bone4.setRotationPoint(0.5F, 1.0F, 0.0F);
		setRotationAngle(bone4, 1.0472F, 0.0F, 0.0F);
		FrontLeftLeg.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 5, 8, -0.75F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		MiddleLeftLeg = new RendererModel(this);
		MiddleLeftLeg.setRotationPoint(0.0F, 22.0F, -0.5F);
		setRotationAngle(MiddleLeftLeg, 0.0F, 0.0F, -0.4363F);
		MiddleLeftLeg.cubeList.add(new ModelBox(MiddleLeftLeg, 0, 8, -0.25F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		bone5 = new RendererModel(this);
		bone5.setRotationPoint(0.5F, 1.0F, 0.0F);
		setRotationAngle(bone5, 1.1345F, 0.0F, 0.0F);
		MiddleLeftLeg.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 5, 7, -0.75F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		BackLeftLeg = new RendererModel(this);
		BackLeftLeg.setRotationPoint(0.0F, 22.0F, 0.0F);
		setRotationAngle(BackLeftLeg, 0.3491F, 0.0F, -0.3491F);
		BackLeftLeg.cubeList.add(new ModelBox(BackLeftLeg, 0, 7, -0.25F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));

		bone6 = new RendererModel(this);
		bone6.setRotationPoint(0.5F, 1.0F, 0.0F);
		setRotationAngle(bone6, 0.9599F, 0.0F, 0.0F);
		BackLeftLeg.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 0, 6, -0.75F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));
	}

	@Override
	public void render(DragonflyEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		Head.render(f5);
		LeftFrontWings.render(f5);
		LeftBackWing.render(f5);
		RightFrontWings.render(f5);
		RightBackWings.render(f5);
		FrontRightLeg.render(f5);
		MiddleRightLeg.render(f5);
		BackRightLeg.render(f5);
		FrontLeftLeg.render(f5);
		MiddleLeftLeg.render(f5);
		BackLeftLeg.render(f5);
		setRotationAngles(entity,f,f1,f2,f3,f4,f5);
	}
	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(DragonflyEntity p_212844_1_, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		RightFrontWings.rotateAngleZ = -0.0873F - netHeadYaw;
		RightBackWings.rotateAngleZ = -0.0873F - netHeadYaw;

		LeftFrontWings.rotateAngleZ = 0.0873F + netHeadYaw;
		LeftBackWing.rotateAngleZ = 0.0873F + netHeadYaw;

	}
}