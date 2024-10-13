
package net.voxla.fridayjason.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.voxla.fridayjason.entity.model.JasonVoorheesModel;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JasonVoorheesRenderer extends GeoEntityRenderer<JasonVoorheesEntity> {
	public JasonVoorheesRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new JasonVoorheesModel());
		this.shadowRadius = 0.7f;
	}

	@Override
	public RenderType getRenderType(JasonVoorheesEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
