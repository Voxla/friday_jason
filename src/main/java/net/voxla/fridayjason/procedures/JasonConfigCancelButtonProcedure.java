package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.world.inventory.JasonConfigGuiMenu;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.io.File;

public class JasonConfigCancelButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject jasonconfigobj = new com.google.gson.JsonObject();
		File jasonconfig = new File("");
		if (entity instanceof Player _plr ? _plr.containerMenu instanceof JasonConfigGuiMenu : false) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
