package net.voxla.fridayjason.entity.model;

import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

public class JasonVoorheesModel extends AnimatedGeoModel<JasonVoorheesEntity> {
	@Override
	public ResourceLocation getAnimationResource(JasonVoorheesEntity entity) {
		return new ResourceLocation("friday_jason", "animations/jason.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JasonVoorheesEntity entity) {
		return new ResourceLocation("friday_jason", "geo/jason.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JasonVoorheesEntity entity) {
		return new ResourceLocation("friday_jason", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(JasonVoorheesEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("head");
		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
		int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.shouldPlayWhilePaused ? 1 : 0;
		head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F) * unpausedMultiplier);
		head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F) * unpausedMultiplier);
	}
}
