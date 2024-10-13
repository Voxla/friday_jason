package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Iterator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class JasonVoorheesEntityDiesProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		com.google.gson.JsonObject jasonconfigobj = new com.google.gson.JsonObject();
		File jasonconfig = new File("");
		if (sourceentity instanceof Player) {
			jasonconfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "jasonconfig.json");
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jasonconfig));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					jasonconfigobj = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (jasonconfigobj.get("jason_killed_cooldown").getAsDouble() == 1) {
						FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn = 24000;
						FridayJasonModVariables.WorldVariables.get(world).syncData(world);
					} else if (jasonconfigobj.get("jason_killed_cooldown").getAsDouble() == 2) {
						FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn = 48000;
						FridayJasonModVariables.WorldVariables.get(world).syncData(world);
					} else if (jasonconfigobj.get("jason_killed_cooldown").getAsDouble() == 3) {
						FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn = 72000;
						FridayJasonModVariables.WorldVariables.get(world).syncData(world);
					} else if (jasonconfigobj.get("jason_killed_cooldown").getAsDouble() == 4) {
						FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn = 96000;
						FridayJasonModVariables.WorldVariables.get(world).syncData(world);
					} else if (jasonconfigobj.get("jason_killed_cooldown").getAsDouble() == 5) {
						FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn = 120000;
						FridayJasonModVariables.WorldVariables.get(world).syncData(world);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (!(sourceentity instanceof ServerPlayer _plr9 && _plr9.level instanceof ServerLevel
					&& _plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("friday_jason:back_to_hell"))).isDone())) {
				if (sourceentity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("friday_jason:back_to_hell"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemainingCriteria().iterator();
						while (_iterator.hasNext())
							_player.getAdvancements().award(_adv, (String) _iterator.next());
					}
				}
			}
		}
	}
}
