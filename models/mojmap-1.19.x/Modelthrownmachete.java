// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelthrownmachete<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "thrownmachete"), "main");
	private final ModelPart machete;

	public Modelthrownmachete(ModelPart root) {
		this.machete = root.getChild("machete");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition machete = partdefinition.addOrReplaceChild("machete",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-0.5F, -7.931F, -7.4052F, 1.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, -6.931F, 3.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, -7.931F, 4.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, -6.931F, 2.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, -5.931F, 1.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, -4.931F, 0.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, -3.931F, -0.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, -2.931F, -1.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, -1.931F, -2.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, -0.931F, -3.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, 0.069F, -4.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 16)
						.addBox(-0.5F, 1.069F, -3.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(12, 27)
						.addBox(-0.5F, 2.069F, -3.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(12, 27)
						.addBox(-0.5F, 3.069F, -4.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(12, 27)
						.addBox(-0.5F, 4.069F, -5.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(12, 27)
						.addBox(-0.5F, 5.069F, -6.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(11, 29)
						.addBox(-0.5F, 7.069F, -5.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(11, 29)
						.addBox(-0.5F, 6.069F, -4.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(11, 29)
						.addBox(-0.5F, 5.069F, -3.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(11, 29)
						.addBox(-0.5F, 4.069F, -2.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, 3.069F, -0.4052F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, 2.069F, 0.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, 1.069F, 1.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, 0.069F, 2.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, -0.931F, 3.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, -1.931F, 4.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, -2.931F, 5.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, -3.931F, 6.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, -4.931F, 7.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(7, 26)
						.addBox(-0.5F, -3.931F, 6.5948F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, -5.931F, 1.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, -4.931F, 0.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, -3.931F, -0.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, -2.931F, -1.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, -1.931F, -2.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, -0.931F, -3.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, 0.069F, -4.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 19)
						.addBox(-0.5F, 1.069F, -4.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 27)
						.addBox(-0.5F, 3.069F, -4.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 27)
						.addBox(-0.5F, 4.069F, -5.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 27)
						.addBox(-0.5F, 5.069F, -6.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 27)
						.addBox(-0.5F, 6.069F, -7.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 29)
						.addBox(-0.5F, 7.069F, -5.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 29)
						.addBox(-0.5F, 6.069F, -4.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 29)
						.addBox(-0.5F, 5.069F, -3.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 29)
						.addBox(-0.5F, 4.069F, -2.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, 4.069F, -1.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, 3.069F, -0.4052F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, 2.069F, 0.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, 1.069F, 1.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, 0.069F, 2.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, -0.931F, 3.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, -1.931F, 4.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, -2.931F, 5.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, -3.931F, 6.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 26)
						.addBox(-0.5F, -4.931F, 7.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, -6.931F, 2.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(23, 19)
						.addBox(-0.5F, -6.931F, 3.5948F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 20.431F, -0.5948F, 2.2253F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 48, 48);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		machete.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}