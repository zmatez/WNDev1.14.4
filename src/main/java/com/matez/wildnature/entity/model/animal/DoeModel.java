package com.matez.wildnature.entity.model.animal;// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import com.matez.wildnature.entity.type.animal.deer.AbstractDeerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class DoeModel extends EntityModel<AbstractDeerEntity> {
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

	public DoeModel() {
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
		this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount /2;
		this.LeftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount /2;
		this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount /2;
		this.RightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount /2;
	}
}