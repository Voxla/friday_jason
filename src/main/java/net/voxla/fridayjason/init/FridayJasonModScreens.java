
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.client.gui.JasonConfigGuiScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FridayJasonModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(FridayJasonModMenus.JASON_CONFIG_GUI.get(), JasonConfigGuiScreen::new);
		});
	}
}
