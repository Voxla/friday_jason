package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.world.inventory.JasonConfigGuiMenu;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class JasonConfigResetButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject jasonconfigobj = new com.google.gson.JsonObject();
		File jasonconfig = new File("");
		if (entity instanceof Player _plr ? _plr.containerMenu instanceof JasonConfigGuiMenu : false) {
			jasonconfig = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "jasonconfig.json");
			if (jasonconfig.exists()) {
				try {
					jasonconfig.getParentFile().mkdirs();
					jasonconfig.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				jasonconfigobj.addProperty("jason_spawn_time", 3);
				jasonconfigobj.addProperty("spawn time can be set from 1 to 5, 1 being the lowest 5 being the highest", "");
				jasonconfigobj.addProperty("jason_killed_cooldown", 3);
				jasonconfigobj.addProperty("the killed cooldown can go from 1 to 5, 1 being the lowest 5 being the highest. The kill cooldown happens when you kill jason", "");
				jasonconfigobj.addProperty("the default is 3, which is 3 days in game so 2 would be 2 days etc", "");
				jasonconfigobj.addProperty("jason_music", true);
				jasonconfigobj.addProperty("the jason music just toggles on and off the music for when jason is chasing/searching for you", "");
				jasonconfigobj.addProperty("does_jason_get_faster_at_blood_stage_3", true);
				jasonconfigobj.addProperty("does_jason_get_stronger_with_each_blood_stage", true);
				jasonconfigobj.addProperty("jasons bloodstage goes up everytime he hits the player 3 times", "");
				jasonconfigobj.addProperty("the max bloodstage jason can go to is 3", "");
				jasonconfigobj.addProperty("jason_spawn_during_day", false);
				jasonconfigobj.addProperty("the spawning during day toggles whether jason can spawn during the day or not", "");
				jasonconfigobj.addProperty("ft13th_game_music", false);
				jasonconfigobj.addProperty("if ft13th game music is toggled/set to \"true\" than music from the Friday the 13th game will play instead of the custom music the mod comes with", "");
				{
					Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(jasonconfig);
						fileWriter.write(mainGSONBuilderVariable.toJson(jasonconfigobj));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
