
package net.voxla.fridayjason.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.voxla.fridayjason.procedures.SearchOverlayProc6Procedure;
import net.voxla.fridayjason.procedures.SearchOverlayProc5Procedure;
import net.voxla.fridayjason.procedures.SearchOverlayProc4Procedure;
import net.voxla.fridayjason.procedures.SearchOverlayProc3Procedure;
import net.voxla.fridayjason.procedures.SearchOverlayProc2Procedure;
import net.voxla.fridayjason.procedures.SearchOverlayProc1Procedure;
import net.voxla.fridayjason.procedures.SearchOverlayProc0Procedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SearchMeterOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (SearchOverlayProc0Procedure.execute(world, x, y, z)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("friday_jason:textures/screens/searchmeter0.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), w / 2 + -28, h - 68, 0, 0, 56, 15, 56, 15);
			}
			if (SearchOverlayProc1Procedure.execute(world, x, y, z)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("friday_jason:textures/screens/searchmeter1.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), w / 2 + -28, h - 68, 0, 0, 56, 15, 56, 15);
			}
			if (SearchOverlayProc2Procedure.execute(world, x, y, z)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("friday_jason:textures/screens/searchmeter2.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), w / 2 + -28, h - 68, 0, 0, 56, 15, 56, 15);
			}
			if (SearchOverlayProc3Procedure.execute(world, x, y, z)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("friday_jason:textures/screens/searchmeter3.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), w / 2 + -28, h - 68, 0, 0, 56, 15, 56, 15);
			}
			if (SearchOverlayProc4Procedure.execute(world, x, y, z)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("friday_jason:textures/screens/searchmeter4.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), w / 2 + -28, h - 68, 0, 0, 56, 15, 56, 15);
			}
			if (SearchOverlayProc5Procedure.execute(world, x, y, z)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("friday_jason:textures/screens/searchmeter5.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), w / 2 + -28, h - 68, 0, 0, 56, 15, 56, 15);
			}
			if (SearchOverlayProc6Procedure.execute(world, x, y, z)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("friday_jason:textures/screens/searchmeter6.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), w / 2 + -28, h - 68, 0, 0, 56, 15, 56, 15);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
