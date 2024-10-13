package net.voxla.fridayjason.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.voxla.fridayjason.entity.JasonArmEntity;

import net.minecraft.resources.ResourceLocation;

public class JasonArmModel extends AnimatedGeoModel<JasonArmEntity> {
	@Override
	public ResourceLocation getAnimationResource(JasonArmEntity entity) {
		return new ResourceLocation("friday_jason", "animations/jasonarm.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JasonArmEntity entity) {
		return new ResourceLocation("friday_jason", "geo/jasonarm.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JasonArmEntity entity) {
		return new ResourceLocation("friday_jason", "textures/entities/" + entity.getTexture() + ".png");
	}

}
