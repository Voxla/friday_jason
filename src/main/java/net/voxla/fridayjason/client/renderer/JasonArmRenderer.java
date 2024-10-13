
package net.voxla.fridayjason.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.voxla.fridayjason.entity.model.JasonArmModel;
import net.voxla.fridayjason.entity.JasonArmEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JasonArmRenderer extends GeoEntityRenderer<JasonArmEntity> {
	public JasonArmRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new JasonArmModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(JasonArmEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
