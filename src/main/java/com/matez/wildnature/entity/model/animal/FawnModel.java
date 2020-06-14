package com.matez.wildnature.entity.model.animal;// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import com.matez.wildnature.entity.type.animal.deer.AbstractDeerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class FawnModel extends EntityModel<AbstractDeerEntity> {
	private final RendererModel Body;
	private final RendererModel TorsoMiddle;
	private final RendererModel TorsoBack;
	private final RendererModel Tail;
	private final RendererModel TorsoFront;
	private final RendererModel Neck;
	private final RendererModel LowerNeck;
	private final RendererModel UpperNeck;
	private final RendererModel Head;
	private final RendererModel Nose;
	private final RendererModel Jaw;
	private final RendererModel LeftEar;
	private final RendererModel RightEar;
	private final RendererModel LeftThigh;
	private final RendererModel LeftBackLeg;
	private final RendererModel LeftBackLowerLeg;
	private final RendererModel LeftBackHoof;
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

	public FawnModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);

		TorsoMiddle = new RendererModel(this);
		TorsoMiddle.setRotationPoint(0.0F, -12.0F, -1.0F);
		setRotationAngle(TorsoMiddle, 0.0873F, 0.0F, 0.0F);
		Body.addChild(TorsoMiddle);
		TorsoMiddle.cubeList.add(new ModelBox(TorsoMiddle, 0, 28, -3.75F, -4.1096F, -3.0F, 5, 6, 5, 0.0F, false));

		TorsoBack = new RendererModel(this);
		TorsoBack.setRotationPoint(0.0F, -12.0F, 8.0F);
		setRotationAngle(TorsoBack, -0.0873F, 0.0F, 0.0F);
		Body.addChild(TorsoBack);
		TorsoBack.cubeList.add(new ModelBox(TorsoBack, 18, 7, -3.5F, -3.6101F, -7.7098F, 5, 6, 6, 0.0F, false));

		Tail = new RendererModel(this);
		Tail.setRotationPoint(-1.0F, -20.7577F, 9.25F);
		setRotationAngle(Tail, 0.2618F, 0.0F, 0.0F);
		Body.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 32, 33, -1.5F, 4.1586F, -4.846F, 3, 3, 1, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 0, 0, -0.5F, 7.1586F, -4.846F, 1, 1, 1, 0.0F, false));

		TorsoFront = new RendererModel(this);
		TorsoFront.setRotationPoint(-0.5F, -12.0F, -4.0F);
		setRotationAngle(TorsoFront, -0.0873F, 0.0F, 0.0F);
		Body.addChild(TorsoFront);
		TorsoFront.cubeList.add(new ModelBox(TorsoFront, 0, 0, -3.5F, -4.0304F, -5.3028F, 6, 7, 6, 0.0F, false));

		Neck = new RendererModel(this);
		Neck.setRotationPoint(0.0F, -13.0F, -8.0F);
		Body.addChild(Neck);

		LowerNeck = new RendererModel(this);
		LowerNeck.setRotationPoint(0.5F, -10.5F, -1.75F);
		setRotationAngle(LowerNeck, 0.4363F, 0.0F, 0.0F);
		Neck.addChild(LowerNeck);
		LowerNeck.cubeList.add(new ModelBox(LowerNeck, 19, 20, -4.0F, 4.7729F, -5.7259F, 5, 8, 5, 0.0F, false));

		UpperNeck = new RendererModel(this);
		UpperNeck.setRotationPoint(0.0F, -11.9159F, -3.7801F);
		setRotationAngle(UpperNeck, -0.2618F, 0.0F, 0.0F);
		Neck.addChild(UpperNeck);
		UpperNeck.cubeList.add(new ModelBox(UpperNeck, 20, 33, -3.0F, 4.1791F, 1.009F, 4, 4, 4, 0.0F, false));

		Head = new RendererModel(this);
		Head.setRotationPoint(-1.7565F, -6.3159F, -0.9848F);
		setRotationAngle(Head, 0.1745F, 0.0F, 0.0F);
		Neck.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 13, -2.2435F, -5.8574F, -4.2817F, 6, 6, 6, 0.0F, false));

		Nose = new RendererModel(this);
		Nose.setRotationPoint(0.5F, -4.961F, -7.6883F);
		setRotationAngle(Nose, 0.2618F, 0.0F, 0.0F);
		Head.addChild(Nose);
		Nose.cubeList.add(new ModelBox(Nose, 24, 0, -1.7435F, 1.6895F, -0.5553F, 4, 2, 5, 0.0F, false));

		Jaw = new RendererModel(this);
		Jaw.setRotationPoint(1.0F, -4.1213F, -5.8055F);
		Head.addChild(Jaw);
		Jaw.cubeList.add(new ModelBox(Jaw, 34, 7, -1.7435F, 1.2189F, -1.0988F, 3, 2, 4, 0.0F, false));

		LeftEar = new RendererModel(this);
		LeftEar.setRotationPoint(3.5F, -8.1217F, 1.7292F);
		setRotationAngle(LeftEar, -0.4363F, -0.3491F, -0.0873F);
		Head.addChild(LeftEar);
		LeftEar.cubeList.add(new ModelBox(LeftEar, 46, 46, -0.8852F, 1.8544F, 0.2074F, 4, 3, 1, 0.0F, false));

		RightEar = new RendererModel(this);
		RightEar.setRotationPoint(-2.5F, -8.1217F, 1.7292F);
		setRotationAngle(RightEar, -0.4363F, 0.3491F, 0.0F);
		Head.addChild(RightEar);
		RightEar.cubeList.add(new ModelBox(RightEar, 44, 33, -2.8155F, 1.8749F, 0.3372F, 4, 3, 1, 0.0F, false));

		LeftThigh = new RendererModel(this);
		LeftThigh.setRotationPoint(0.5F, -13.25F, 5.0F);
		setRotationAngle(LeftThigh, -0.0873F, 0.0F, 0.0F);
		Body.addChild(LeftThigh);
		LeftThigh.cubeList.add(new ModelBox(LeftThigh, 36, 15, -0.5F, -1.75F, -3.3699F, 2, 5, 4, 0.0F, false));

		LeftBackLeg = new RendererModel(this);
		LeftBackLeg.setRotationPoint(1.5F, -12.0F, 4.0F);
		setRotationAngle(LeftBackLeg, 0.2618F, 0.0F, 0.0F);
		Body.addChild(LeftBackLeg);
		LeftBackLeg.cubeList.add(new ModelBox(LeftBackLeg, 10, 39, -1.25F, -1.5765F, -1.5761F, 2, 7, 3, 0.0F, false));

		LeftBackLowerLeg = new RendererModel(this);
		LeftBackLowerLeg.setRotationPoint(0.0F, 4.8F, 0.0F);
		setRotationAngle(LeftBackLowerLeg, -0.2618F, 0.0F, 0.0F);
		LeftBackLeg.addChild(LeftBackLowerLeg);
		LeftBackLowerLeg.cubeList.add(new ModelBox(LeftBackLowerLeg, 40, 45, -1.0F, -0.006F, -1.2087F, 1, 7, 2, 0.0F, false));

		LeftBackHoof = new RendererModel(this);
		LeftBackHoof.setRotationPoint(-1.25F, 7.3121F, -6.5477F);
		LeftBackLowerLeg.addChild(LeftBackHoof);
		LeftBackHoof.cubeList.add(new ModelBox(LeftBackHoof, 44, 13, 0.0F, -1.0121F, 4.4647F, 2, 1, 3, 0.0F, false));

		RightThigh = new RendererModel(this);
		RightThigh.setRotationPoint(-3.5F, -13.25F, 5.0F);
		setRotationAngle(RightThigh, -0.0873F, 0.0F, 0.0F);
		Body.addChild(RightThigh);
		RightThigh.cubeList.add(new ModelBox(RightThigh, 36, 36, -0.5F, -1.75F, -3.3699F, 2, 5, 4, 0.0F, false));

		RightBackLeg = new RendererModel(this);
		RightBackLeg.setRotationPoint(-3.0F, -12.0F, 4.0F);
		setRotationAngle(RightBackLeg, 0.2618F, 0.0F, 0.0F);
		Body.addChild(RightBackLeg);
		RightBackLeg.cubeList.add(new ModelBox(RightBackLeg, 0, 39, -1.25F, -1.6027F, -1.6067F, 2, 7, 3, 0.0F, false));

		RightBackLowerLeg = new RendererModel(this);
		RightBackLowerLeg.setRotationPoint(0.0F, 4.7838F, 0.0076F);
		setRotationAngle(RightBackLowerLeg, -0.2618F, 0.0F, 0.0F);
		RightBackLeg.addChild(RightBackLowerLeg);
		RightBackLowerLeg.cubeList.add(new ModelBox(RightBackLowerLeg, 44, 0, -1.0F, -0.0244F, -1.1764F, 1, 7, 2, 0.0F, false));

		RightBackHoof = new RendererModel(this);
		RightBackHoof.setRotationPoint(-1.25F, 6.0F, -5.65F);
		RightBackLowerLeg.addChild(RightBackHoof);
		RightBackHoof.cubeList.add(new ModelBox(RightBackHoof, 18, 0, 0.0F, 0.3162F, 3.5594F, 2, 1, 3, 0.0F, false));

		LeftFrontLeg = new RendererModel(this);
		LeftFrontLeg.setRotationPoint(2.5F, -11.0F, -7.0F);
		setRotationAngle(LeftFrontLeg, -0.1745F, 0.0F, 0.0F);
		Body.addChild(LeftFrontLeg);
		LeftFrontLeg.cubeList.add(new ModelBox(LeftFrontLeg, 20, 41, -2.0F, -2.0304F, -1.1527F, 2, 7, 2, 0.0F, false));

		LeftFrontLowerLeg = new RendererModel(this);
		LeftFrontLowerLeg.setRotationPoint(-0.65F, 4.7713F, 0.0874F);
		setRotationAngle(LeftFrontLowerLeg, 0.1745F, 0.0F, 0.0F);
		LeftFrontLeg.addChild(LeftFrontLowerLeg);
		LeftFrontLowerLeg.cubeList.add(new ModelBox(LeftFrontLowerLeg, 34, 45, -1.1F, -0.7713F, -0.7914F, 1, 7, 2, 0.0F, false));

		LeftFrontHoof = new RendererModel(this);
		LeftFrontHoof.setRotationPoint(0.1F, -1.5532F, -6.1667F);
		LeftFrontLowerLeg.addChild(LeftFrontHoof);
		LeftFrontHoof.cubeList.add(new ModelBox(LeftFrontHoof, 8, 25, -1.45F, 6.7819F, 4.7253F, 2, 1, 2, 0.0F, false));

		RightFrontLeg = new RendererModel(this);
		RightFrontLeg.setRotationPoint(-2.5F, -11.0F, -7.0F);
		setRotationAngle(RightFrontLeg, -0.1745F, 0.0F, 0.0F);
		Body.addChild(RightFrontLeg);
		RightFrontLeg.cubeList.add(new ModelBox(RightFrontLeg, 39, 24, -2.0F, -2.0304F, -1.1527F, 2, 7, 2, 0.0F, false));

		RightFrontLowerLeg = new RendererModel(this);
		RightFrontLowerLeg.setRotationPoint(-0.65F, 4.7713F, 0.0874F);
		setRotationAngle(RightFrontLowerLeg, 0.1745F, 0.0F, 0.0F);
		RightFrontLeg.addChild(RightFrontLowerLeg);
		RightFrontLowerLeg.cubeList.add(new ModelBox(RightFrontLowerLeg, 28, 41, -1.1F, -0.7713F, -0.7914F, 1, 7, 2, 0.0F, false));

		RightFrontHoof = new RendererModel(this);
		RightFrontHoof.setRotationPoint(0.1F, -1.5532F, -6.1667F);
		RightFrontLowerLeg.addChild(RightFrontHoof);
		RightFrontHoof.cubeList.add(new ModelBox(RightFrontHoof, 0, 25, -1.45F, 6.7819F, 4.7253F, 2, 1, 2, 0.0F, false));
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
		this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}