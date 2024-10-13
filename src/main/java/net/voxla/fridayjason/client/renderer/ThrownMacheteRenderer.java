package net.voxla.fridayjason.client.renderer;

import net.voxla.fridayjason.entity.ThrownMacheteEntity;
import net.voxla.fridayjason.client.model.Modelthrownmachete;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.math.Vector3f;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ThrownMacheteRenderer extends EntityRenderer<ThrownMacheteEntity> {
	private static final ResourceLocation texture = new ResourceLocation("friday_jason:textures/entities/macheteprojectile.png");
	private final Modelthrownmachete model;

	public ThrownMacheteRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelthrownmachete(context.bakeLayer(Modelthrownmachete.LAYER_LOCATION));
	}

	@Override
	public void render(ThrownMacheteEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(ThrownMacheteEntity entity) {
		return texture;
	}
}
