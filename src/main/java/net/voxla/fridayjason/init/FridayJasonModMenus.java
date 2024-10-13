
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.world.inventory.JasonConfigGuiMenu;
import net.voxla.fridayjason.FridayJasonMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class FridayJasonModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FridayJasonMod.MODID);
	public static final RegistryObject<MenuType<JasonConfigGuiMenu>> JASON_CONFIG_GUI = REGISTRY.register("jason_config_gui", () -> IForgeMenuType.create(JasonConfigGuiMenu::new));
}
