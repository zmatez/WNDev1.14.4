package com.matez.wildnature.entity.model.animal;// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import com.matez.wildnature.entity.type.animal.boar.BoarEntity;
import com.matez.wildnature.entity.type.animal.deer.AbstractDeerEntity;
import com.matez.wildnature.entity.type.animal.duck.AbstractDuckEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class BuckModel extends EntityModel<AbstractDeerEntity> {
	private final RendererModel Body;
	private final RendererModel TorsoMiddle;
	private final RendererModel TorsoBack;
	private final RendererModel Tail;
	private final RendererModel TorsoFront;
	private final RendererModel Neck_Head;
	private final RendererModel LowerNeck;
	private final RendererModel UpperNeck;
	private final RendererModel Head;
	private final RendererModel Nose;
	private final RendererModel Jaw;
	private final RendererModel LeftEar;
	private final RendererModel RightEar;
	private final RendererModel LeftAntler;
	private final RendererModel LAntlerBone;
	private final RendererModel antlerpart1;
	private final RendererModel antlerpart2;
	private final RendererModel antlerpart3;
	private final RendererModel antlerpart4;
	private final RendererModel antlerpart5;
	private final RendererModel RightAntler;
	private final RendererModel RAntlerBone;
	private final RendererModel antlerpart6;
	private final RendererModel antlerpart7;
	private final RendererModel antlerpart8;
	private final RendererModel antlerpart9;
	private final RendererModel antlerpart10;
	private final RendererModel LeftBackLeg;
	private final RendererModel LeftBackLowerLeg;
	private final RendererModel LeftBackHoof;
	private final RendererModel LeftThigh;
	private final RendererModel RightThigh;
	private final RendererModel RightBackLeg;
	private final RendererModel RightBackLowerLeg;
	private final RendererModel RightBackHoof;
	private final RendererModel LeftFrontLeg;
	private final RendererModel LeftFrontLowerLeg;
	private final RendererModel LeftFrontHoof;
	private final RendererModel RightFrontLeg;
	private final RendererModel RightFrontLowerLeg;
	private final RendererModel RightFrontHoof;

	public BuckModel() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);

		TorsoMiddle = new RendererModel(this);
		TorsoMiddle.setRotationPoint(0.0F, -12.0F, -1.0F);
		setRotationAngle(TorsoMiddle, 0.0873F, 0.0F, 0.0F);
		Body.addChild(TorsoMiddle);
		TorsoMiddle.cubeList.add(new ModelBox(TorsoMiddle, 0, 0, -4.0F, -11.9772F, -3.9771F, 8, 10, 9, 0.0F, false));

		TorsoBack = new RendererModel(this);
		TorsoBack.setRotationPoint(0.0F, -12.0F, 8.0F);
		setRotationAngle(TorsoBack, -0.0873F, 0.0F, 0.0F);
		Body.addChild(TorsoBack);
		TorsoBack.cubeList.add(new ModelBox(TorsoBack, 23, 28, -3.5F, -11.0908F, -5.9499F, 7, 9, 9, 0.0F, false));

		Tail = new RendererModel(this);
		Tail.setRotationPoint(-1.0F, -20.7577F, 12.25F);
		setRotationAngle(Tail, 0.2618F, 0.0F, 0.0F);
		Body.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 35, 18, -1.5F, -1.9701F, -0.4324F, 5, 4, 1, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 25, 5, -0.5F, 2.8484F, -0.4324F, 3, 2, 1, 0.0F, false));

		TorsoFront = new RendererModel(this);
		TorsoFront.setRotationPoint(-0.5F, -12.0F, -4.0F);
		setRotationAngle(TorsoFront, -0.0873F, 0.0F, 0.0F);
		Body.addChild(TorsoFront);
		TorsoFront.cubeList.add(new ModelBox(TorsoFront, 0, 19, -4.0F, -11.9772F, -6.5229F, 9, 11, 7, 0.0F, false));

		Neck_Head = new RendererModel(this);
		Neck_Head.setRotationPoint(0.0F, -19.0F, -8.0F);
		Body.addChild(Neck_Head);

		LowerNeck = new RendererModel(this);
		LowerNeck.setRotationPoint(0.0F, 3.5F, -1.75F);
		setRotationAngle(LowerNeck, 0.4363F, 0.0F, 0.0F);
		Neck_Head.addChild(LowerNeck);
		LowerNeck.cubeList.add(new ModelBox(LowerNeck, 34, 0, -3.5F, -9.9378F, -1.2143F, 7, 11, 7, 0.0F, false));

		UpperNeck = new RendererModel(this);
		UpperNeck.setRotationPoint(0.0F, -2.9159F, -3.7801F);
		setRotationAngle(UpperNeck, -0.2618F, 0.0F, 0.0F);
		Neck_Head.addChild(UpperNeck);
		UpperNeck.cubeList.add(new ModelBox(UpperNeck, 30, 46, -3.0F, -8.1604F, -3.6967F, 6, 7, 6, 0.0F, false));

		Head = new RendererModel(this);
		Head.setRotationPoint(-0.7565F, -9.9159F, -2.4848F);
		setRotationAngle(Head, 0.1745F, 0.0F, 0.0F);
		Neck_Head.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 38, -3.0F, -6.3248F, -4.2081F, 7, 7, 8, 0.0F, false));

		Nose = new RendererModel(this);
		Nose.setRotationPoint(0.5F, 3.039F, -7.6883F);
		setRotationAngle(Nose, 0.2618F, 0.0F, 0.0F);
		Head.addChild(Nose);
		Nose.cubeList.add(new ModelBox(Nose, 49, 54, -2.5F, -6.5882F, -0.0383F, 5, 3, 5, 0.0F, false));

		Jaw = new RendererModel(this);
		Jaw.setRotationPoint(1.0F, 3.8787F, -5.8055F);
		Head.addChild(Jaw);
		Jaw.cubeList.add(new ModelBox(Jaw, 49, 40, -2.5F, -6.0395F, -2.4699F, 4, 2, 6, 0.0F, false));

		LeftEar = new RendererModel(this);
		LeftEar.setRotationPoint(3.5F, -0.1217F, 1.7292F);
		setRotationAngle(LeftEar, -0.4363F, -0.3491F, -0.0873F);
		Head.addChild(LeftEar);
		LeftEar.cubeList.add(new ModelBox(LeftEar, 54, 48, 0.7695F, -6.6146F, -1.9361F, 5, 4, 1, 0.0F, false));

		RightEar = new RendererModel(this);
		RightEar.setRotationPoint(-2.5F, -0.1217F, 1.7292F);
		setRotationAngle(RightEar, -0.4363F, 0.3491F, 0.0F);
		Head.addChild(RightEar);
		RightEar.cubeList.add(new ModelBox(RightEar, 46, 31, -5.2459F, -6.6776F, -1.7553F, 5, 4, 1, 0.0F, false));

		LeftAntler = new RendererModel(this);
		LeftAntler.setRotationPoint(3.5F, -3.5841F, 0.5267F);
		setRotationAngle(LeftAntler, 0.0F, 0.0F, 0.8727F);
		Head.addChild(LeftAntler);
		LeftAntler.cubeList.add(new ModelBox(LeftAntler, 0, 37, -2.6204F, -4.5502F, -0.5578F, 2, 5, 2, 0.0F, false));

		LAntlerBone = new RendererModel(this);
		LAntlerBone.setRotationPoint(-0.4667F, -3.9753F, 0.605F);
		setRotationAngle(LAntlerBone, -0.3491F, 0.2618F, -0.4363F);
		LeftAntler.addChild(LAntlerBone);
		LAntlerBone.cubeList.add(new ModelBox(LAntlerBone, 16, 66, -1.4723F, -8.8357F, -1.5154F, 1, 8, 1, 0.0F, false));

		antlerpart1 = new RendererModel(this);
		antlerpart1.setRotationPoint(0.0F, -7.0F, -1.0F);
		setRotationAngle(antlerpart1, 0.7854F, 0.0F, -0.1745F);
		LAntlerBone.addChild(antlerpart1);
		antlerpart1.cubeList.add(new ModelBox(antlerpart1, 55, 0, -1.0693F, -6.4583F, 0.8346F, 1, 6, 1, 0.0F, false));

		antlerpart2 = new RendererModel(this);
		antlerpart2.setRotationPoint(0.5319F, -2.9112F, -0.251F);
		setRotationAngle(antlerpart2, 1.3963F, 0.0F, -0.1745F);
		LAntlerBone.addChild(antlerpart2);
		antlerpart2.cubeList.add(new ModelBox(antlerpart2, 47, 18, -1.3518F, -4.3345F, 1.3747F, 1, 4, 1, 0.0F, false));

		antlerpart3 = new RendererModel(this);
		antlerpart3.setRotationPoint(-5.1598F, -5.685F, 1.1313F);
		setRotationAngle(antlerpart3, -0.4363F, 0.0F, 0.0F);
		antlerpart2.addChild(antlerpart3);
		antlerpart3.cubeList.add(new ModelBox(antlerpart3, 25, 0, 3.808F, -2.585F, 0.4621F, 1, 3, 1, 0.0F, false));

		antlerpart4 = new RendererModel(this);
		antlerpart4.setRotationPoint(0.5319F, -2.9112F, -0.251F);
		setRotationAngle(antlerpart4, 1.3963F, 0.0F, -0.1745F);
		LAntlerBone.addChild(antlerpart4);
		antlerpart4.cubeList.add(new ModelBox(antlerpart4, 39, 23, -1.3518F, -5.017F, 2.3747F, 1, 1, 2, 0.0F, false));

		antlerpart5 = new RendererModel(this);
		antlerpart5.setRotationPoint(-1.7114F, -1.2284F, 0.4171F);
		LeftAntler.addChild(antlerpart5);
		antlerpart5.cubeList.add(new ModelBox(antlerpart5, 25, 24, -3.7974F, -1.9178F, -0.1776F, 2, 1, 1, 0.0F, false));

		RightAntler = new RendererModel(this);
		RightAntler.setRotationPoint(-2.5F, -3.5841F, 0.5267F);
		setRotationAngle(RightAntler, 0.0F, 0.0F, -0.8727F);
		Head.addChild(RightAntler);
		RightAntler.cubeList.add(new ModelBox(RightAntler, 0, 0, 0.6472F, -4.5502F, -0.5578F, 2, 5, 2, 0.0F, false));

		RAntlerBone = new RendererModel(this);
		RAntlerBone.setRotationPoint(0.4667F, -3.9753F, 0.605F);
		setRotationAngle(RAntlerBone, -0.3491F, -0.2618F, 0.3491F);
		RightAntler.addChild(RAntlerBone);
		RAntlerBone.cubeList.add(new ModelBox(RAntlerBone, 58, 31, 0.1463F, -8.7476F, -1.5253F, 1, 8, 1, 0.0F, false));

		antlerpart6 = new RendererModel(this);
		antlerpart6.setRotationPoint(-0.0333F, -6.9721F, -1.0F);
		setRotationAngle(antlerpart6, 0.7854F, 0.0F, 0.1745F);
		RAntlerBone.addChild(antlerpart6);
		antlerpart6.cubeList.add(new ModelBox(antlerpart6, 0, 19, 0.0529F, -6.4309F, 0.7994F, 1, 6, 1, 0.0F, false));

		antlerpart7 = new RendererModel(this);
		antlerpart7.setRotationPoint(-2.0029F, -3.5288F, -0.4859F);
		setRotationAngle(antlerpart7, 1.3963F, 0.0F, 0.1745F);
		RAntlerBone.addChild(antlerpart7);
		antlerpart7.cubeList.add(new ModelBox(antlerpart7, 30, 46, 2.0326F, -3.9311F, 0.9617F, 1, 4, 1, 0.0F, false));

		antlerpart8 = new RendererModel(this);
		antlerpart8.setRotationPoint(2.4415F, -5.0674F, 1.3662F);
		setRotationAngle(antlerpart8, -0.4363F, 0.0F, 0.0F);
		antlerpart7.addChild(antlerpart8);
		antlerpart8.cubeList.add(new ModelBox(antlerpart8, 25, 19, -0.4089F, -2.3112F, -0.1251F, 1, 3, 1, 0.0F, false));

		antlerpart9 = new RendererModel(this);
		antlerpart9.setRotationPoint(-2.0029F, -3.5288F, -0.4859F);
		setRotationAngle(antlerpart9, 1.3963F, 0.0F, 0.1745F);
		RAntlerBone.addChild(antlerpart9);
		antlerpart9.cubeList.add(new ModelBox(antlerpart9, 35, 0, 2.0326F, -4.3985F, 1.9617F, 1, 1, 2, 0.0F, false));

		antlerpart10 = new RendererModel(this);
		antlerpart10.setRotationPoint(1.4942F, -1.3955F, 0.0127F);
		RightAntler.addChild(antlerpart10);
		antlerpart10.cubeList.add(new ModelBox(antlerpart10, 0, 7, 1.0146F, -1.5975F, 0.2267F, 2, 1, 1, 0.0F, false));

		LeftBackLeg = new RendererModel(this);
		LeftBackLeg.setRotationPoint(3.25F, -16.0F, 9.0F);
		setRotationAngle(LeftBackLeg, 0.2618F, 0.0F, 0.0F);
		Body.addChild(LeftBackLeg);
		LeftBackLeg.cubeList.add(new ModelBox(LeftBackLeg, 34, 59, -1.5F, -1.8296F, -2.0F, 3, 9, 4, 0.0F, false));

		LeftBackLowerLeg = new RendererModel(this);
		LeftBackLowerLeg.setRotationPoint(0.0F, 6.4227F, -0.3409F);
		setRotationAngle(LeftBackLowerLeg, -0.2618F, 0.0F, 0.0F);
		LeftBackLeg.addChild(LeftBackLowerLeg);
		LeftBackLowerLeg.cubeList.add(new ModelBox(LeftBackLowerLeg, 63, 28, -1.0F, -0.3709F, -1.2955F, 2, 10, 3, 0.0F, false));

		LeftBackHoof = new RendererModel(this);
		LeftBackHoof.setRotationPoint(-3.25F, 10.0F, -10.0477F);
		LeftBackLowerLeg.addChild(LeftBackHoof);
		LeftBackHoof.cubeList.add(new ModelBox(LeftBackHoof, 25, 19, 1.75F, -1.3709F, 8.0F, 3, 1, 4, 0.0F, false));

		LeftThigh = new RendererModel(this);
		LeftThigh.setRotationPoint(2.5F, -17.0F, 8.35F);
		setRotationAngle(LeftThigh, -0.0873F, 0.0F, 0.0F);
		Body.addChild(LeftThigh);
		LeftThigh.cubeList.add(new ModelBox(LeftThigh, 0, 53, -3.25F, -5.4943F, -2.8807F, 5, 8, 5, 0.0F, false));

		RightThigh = new RendererModel(this);
		RightThigh.setRotationPoint(-2.5F, -17.0F, 8.35F);
		setRotationAngle(RightThigh, -0.0873F, 0.0F, 0.0F);
		Body.addChild(RightThigh);
		RightThigh.cubeList.add(new ModelBox(RightThigh, 46, 18, -1.75F, -5.4943F, -2.8807F, 5, 8, 5, 0.0F, false));

		RightBackLeg = new RendererModel(this);
		RightBackLeg.setRotationPoint(-1.75F, -16.0F, 9.0F);
		setRotationAngle(RightBackLeg, 0.2618F, 0.0F, 0.0F);
		Body.addChild(RightBackLeg);
		RightBackLeg.cubeList.add(new ModelBox(RightBackLeg, 20, 55, -3.0F, -1.8296F, -2.0F, 3, 9, 4, 0.0F, false));

		RightBackLowerLeg = new RendererModel(this);
		RightBackLowerLeg.setRotationPoint(-1.0F, 6.4227F, -0.3409F);
		setRotationAngle(RightBackLowerLeg, -0.2618F, 0.0F, 0.0F);
		RightBackLeg.addChild(RightBackLowerLeg);
		RightBackLowerLeg.cubeList.add(new ModelBox(RightBackLowerLeg, 62, 0, -1.5F, -0.9151F, -1.2955F, 2, 10, 3, 0.0F, false));

		RightBackHoof = new RendererModel(this);
		RightBackHoof.setRotationPoint(-2.25F, 9.6894F, -10.2068F);
		RightBackLowerLeg.addChild(RightBackHoof);
		RightBackHoof.cubeList.add(new ModelBox(RightBackHoof, 25, 0, 0.25F, -0.9121F, 8.1591F, 3, 1, 4, 0.0F, false));

		LeftFrontLeg = new RendererModel(this);
		LeftFrontLeg.setRotationPoint(4.25F, -16.0F, -6.0F);
		setRotationAngle(LeftFrontLeg, -0.1745F, 0.0F, 0.0F);
		Body.addChild(LeftFrontLeg);
		LeftFrontLeg.cubeList.add(new ModelBox(LeftFrontLeg, 60, 62, -2.25F, -2.7748F, -2.2709F, 3, 10, 3, 0.0F, false));

		LeftFrontLowerLeg = new RendererModel(this);
		LeftFrontLowerLeg.setRotationPoint(-0.65F, 7.0616F, -0.7997F);
		setRotationAngle(LeftFrontLowerLeg, 0.1745F, 0.0F, 0.0F);
		LeftFrontLeg.addChild(LeftFrontLowerLeg);
		LeftFrontLowerLeg.cubeList.add(new ModelBox(LeftFrontLowerLeg, 8, 66, -1.35F, -1.0008F, -1.0449F, 2, 10, 2, 0.0F, false));

		LeftFrontHoof = new RendererModel(this);
		LeftFrontHoof.setRotationPoint(0.1F, 8.4468F, -0.1667F);
		LeftFrontLowerLeg.addChild(LeftFrontHoof);
		LeftFrontHoof.cubeList.add(new ModelBox(LeftFrontHoof, 61, 15, -1.7F, -0.2976F, -1.5F, 2, 1, 3, 0.0F, false));

		RightFrontLeg = new RendererModel(this);
		RightFrontLeg.setRotationPoint(-3.25F, -16.0F, -6.0F);
		setRotationAngle(RightFrontLeg, -0.1745F, 0.0F, 0.0F);
		Body.addChild(RightFrontLeg);
		RightFrontLeg.cubeList.add(new ModelBox(RightFrontLeg, 48, 62, -1.75F, -2.7748F, -2.2709F, 3, 10, 3, 0.0F, false));

		RightFrontLowerLeg = new RendererModel(this);
		RightFrontLowerLeg.setRotationPoint(-0.65F, 7.0616F, -0.4551F);
		setRotationAngle(RightFrontLowerLeg, 0.1745F, 0.0F, 0.0F);
		RightFrontLeg.addChild(RightFrontLowerLeg);
		RightFrontLowerLeg.cubeList.add(new ModelBox(RightFrontLowerLeg, 0, 66, -0.85F, -1.0616F, -1.3896F, 2, 10, 2, 0.0F, false));

		RightFrontHoof = new RendererModel(this);
		RightFrontHoof.setRotationPoint(0.1F, 8.386F, -0.7667F);
		RightFrontLowerLeg.addChild(RightFrontHoof);
		RightFrontHoof.cubeList.add(new ModelBox(RightFrontHoof, 32, 24, -1.2F, -0.2976F, -1.2447F, 2, 1, 3, 0.0F, false));
	}

	@Override
	public void render(AbstractDeerEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
	}
	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}

	public void setRotationAngles(AbstractDeerEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		this.Neck_Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.Neck_Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}