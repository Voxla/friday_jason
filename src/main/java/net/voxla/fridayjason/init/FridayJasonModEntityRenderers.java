
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.client.renderer.ThrownMacheteRenderer;
import net.voxla.fridayjason.client.renderer.JasonVoorheesRenderer;
import net.voxla.fridayjason.client.renderer.JasonArmRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FridayJasonModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(FridayJasonModEntities.JASON_VOORHEES.get(), JasonVoorheesRenderer::new);
		event.registerEntityRenderer(FridayJasonModEntities.JASON_ARM.get(), JasonArmRenderer::new);
		event.registerEntityRenderer(FridayJasonModEntities.THROWN_MACHETE.get(), ThrownMacheteRenderer::new);
	}
}
