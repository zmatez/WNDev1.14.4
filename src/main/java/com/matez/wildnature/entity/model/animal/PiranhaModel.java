package com.matez.wildnature.entity.model.animal;// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import com.matez.wildnature.entity.type.animal.fish.PiranhaEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class PiranhaModel<T extends PiranhaEntity> extends EntityModel<PiranhaEntity> {
	private final RendererModel Body;
	private final RendererModel Head;
	private final RendererModel Jaw;
	private final RendererModel Tail;
	private final RendererModel bone;
	private final RendererModel TailFin;
	private final RendererModel BackSmallFin;
	private final RendererModel TopFins;
	private final RendererModel BottomFins;
	private final RendererModel LeftFin;
	private final RendererModel RightFin;

	public PiranhaModel() {
		textureWidth = 32;
		textureHeight = 32;

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -2.0F, -7.0F, -4.0F, 3, 5, 6, 0.0F, false));

		Head = new RendererModel(this);
		Head.setRotationPoint(-0.25F, 19.0F, -2.5F);
		setRotationAngle(Head, 0.1745F, 0.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 10, 11, -1.5F, -1.75F, -3.6642F, 2, 2, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 12, 1, 0.85F, 0.25F, -3.5F, 0, 1, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 0, -1.35F, 0.25F, -3.5F, 0, 1, 2, 0.0F, false));

		Jaw = new RendererModel(this);
		Jaw.setRotationPoint(-0.25F, 1.5F, -1.0F);
		setRotationAngle(Jaw, 0.4363F, 0.0F, 0.0F);
		Head.addChild(Jaw);
		Jaw.cubeList.add(new ModelBox(Jaw, 12, 0, -1.0F, -0.5F, -2.4674F, 2, 1, 2, 0.0F, false));
		Jaw.cubeList.add(new ModelBox(Jaw, 2, 0, -0.9F, -1.5F, -2.4F, 0, 1, 1, 0.0F, false));
		Jaw.cubeList.add(new ModelBox(Jaw, 0, 0, 0.9F, -1.5F, -2.4F, 0, 1, 1, 0.0F, false));
		Jaw.cubeList.add(new ModelBox(Jaw, 0, 0, -0.75F, -1.5F, -2.3F, 1, 1, 0, 0.0F, false));

		Tail = new RendererModel(this);
		Tail.setRotationPoint(-0.375F, 19.5F, 1.0F);
		Tail.cubeList.add(new ModelBox(Tail, 0, 11, -1.125F, -2.0F, 0.0F, 2, 4, 3, 0.0F, false));

		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 0.0F, 2.5F);
		Tail.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 17, 17, -0.625F, -1.5F, 0.5F, 1, 3, 1, 0.0F, false));

		TailFin = new RendererModel(this);
		TailFin.setRotationPoint(-0.125F, 0.0F, 1.5F);
		bone.addChild(TailFin);
		TailFin.cubeList.add(new ModelBox(TailFin, 0, 15, 0.0F, -2.5F, 0.0F, 0, 5, 3, 0.0F, false));

		BackSmallFin = new RendererModel(this);
		BackSmallFin.setRotationPoint(-0.125F, -1.5F, 0.0F);
		setRotationAngle(BackSmallFin, -1.0472F, 0.0F, 0.0F);
		Tail.addChild(BackSmallFin);
		BackSmallFin.cubeList.add(new ModelBox(BackSmallFin, 4, 0, 0.0F, -3.5F, 0.5F, 0, 2, 1, 0.0F, false));

		TopFins = new RendererModel(this);
		TopFins.setRotationPoint(-0.5F, 18.0F, 1.0F);
		setRotationAngle(TopFins, -1.0472F, 0.0F, 0.0F);
		TopFins.cubeList.add(new ModelBox(TopFins, 6, 16, 0.0F, -3.0F, -1.8F, 0, 4, 2, 0.0F, false));

		BottomFins = new RendererModel(this);
		BottomFins.setRotationPoint(-0.5F, 21.0F, 2.2F);
		setRotationAngle(BottomFins, 0.3491F, 0.0F, 0.0F);
		BottomFins.cubeList.add(new ModelBox(BottomFins, 10, 12, 0.0F, 0.0F, -2.0F, 0, 2, 4, 0.0F, false));

		LeftFin = new RendererModel(this);
		LeftFin.setRotationPoint(1.0F, 20.5F, -3.0F);
		setRotationAngle(LeftFin, 0.0F, 0.2618F, 0.0F);
		LeftFin.cubeList.add(new ModelBox(LeftFin, 7, 8, 0.0F, -1.5F, 0.0F, 0, 3, 3, 0.0F, false));

		RightFin = new RendererModel(this);
		RightFin.setRotationPoint(-2.0F, 20.5F, -3.0F);
		setRotationAngle(RightFin, 0.0F, -0.2618F, 0.0F);
		RightFin.cubeList.add(new ModelBox(RightFin, 0, 0, 0.0F, -1.5F, 0.0F, 0, 3, 3, 0.0F, false));
	}

	@Override
	public void render(PiranhaEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(entity, f, f1, f2, f3, f4, f5);

		Body.render(f5);
		Head.render(f5);
		Tail.render(f5);
		TopFins.render(f5);
		BottomFins.render(f5);
		LeftFin.render(f5);
		RightFin.render(f5);
	}
	public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
		RendererModel.rotateAngleX = x;
		RendererModel.rotateAngleY = y;
		RendererModel.rotateAngleZ = z;
	}

	public void setRotationAngles(PiranhaEntity piranha, float p_212844_2_, float p_212844_3_, float p_212844_4_, float p_212844_5_, float p_212844_6_, float p_212844_7_) {
		float lvt_8_1_ = 1.0F;
		float lvt_9_1_ = 1.0F;
		if (!piranha.isInWater()) {
			lvt_8_1_ = 1.3F;
			lvt_9_1_ = 1.7F;
		}
		if(piranha.isAngry()){
			Jaw.rotateAngleX = 0.4363F;
		}else{
			Jaw.rotateAngleX = 0f;
		}

		Tail.rotateAngleY = -lvt_8_1_ * 0.25F * MathHelper.sin(lvt_9_1_ * 0.6F * p_212844_4_);
	}
}