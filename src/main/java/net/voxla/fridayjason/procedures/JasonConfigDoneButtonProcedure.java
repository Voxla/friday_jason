package net.voxla.fridayjason.procedures;

import org.checkerframework.checker.units.qual.s;

import net.voxla.fridayjason.world.inventory.JasonConfigGuiMenu;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;

import java.util.HashMap;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class JasonConfigDoneButtonProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
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
				if ((guistate.containsKey("text:jason_spawn_time_input") ? ((EditBox) guistate.get("text:jason_spawn_time_input")).getValue() : "").equals("")) {
					jasonconfigobj.addProperty("jason_spawn_time", 3);
				} else {
					jasonconfigobj.addProperty("jason_spawn_time", new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:jason_spawn_time_input") ? ((EditBox) guistate.get("text:jason_spawn_time_input")).getValue() : ""));
				}
				jasonconfigobj.addProperty("spawn time can be set from 1 to 5, 1 being the lowest 5 being the highest", "");
				if ((guistate.containsKey("text:jason_killed_cooldown_input") ? ((EditBox) guistate.get("text:jason_killed_cooldown_input")).getValue() : "").equals("")) {
					jasonconfigobj.addProperty("jason_killed_cooldown", 3);
				} else {
					jasonconfigobj.addProperty("jason_killed_cooldown", new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:jason_spawn_time_input") ? ((EditBox) guistate.get("text:jason_spawn_time_input")).getValue() : ""));
				}
				jasonconfigobj.addProperty("the killed cooldown can go from 1 to 5, 1 being the lowest 5 being the highest. The kill cooldown happens when you kill jason", "");
				jasonconfigobj.addProperty("the default is 3, which is 3 days in game so 2 would be 2 days etc", "");
				if (guistate.containsKey("checkbox:jason_music_check") ? ((Checkbox) guistate.get("checkbox:jason_music_check")).selected() : false) {
					jasonconfigobj.addProperty("jason_music", true);
				} else {
					jasonconfigobj.addProperty("jason_music", false);
				}
				jasonconfigobj.addProperty("the jason music just toggles on and off the music for when jason is chasing/searching for you", "");
				if (guistate.containsKey("checkbox:does_jason_get_faster_at_bloodstage_3_check") ? ((Checkbox) guistate.get("checkbox:does_jason_get_faster_at_bloodstage_3_check")).selected() : false) {
					jasonconfigobj.addProperty("does_jason_get_faster_at_blood_stage_3", true);
				} else {
					jasonconfigobj.addProperty("does_jason_get_faster_at_blood_stage_3", false);
				}
				if (guistate.containsKey("checkbox:does_jason_get_stronger_with_each_blood_stage_check") ? ((Checkbox) guistate.get("checkbox:does_jason_get_stronger_with_each_blood_stage_check")).selected() : false) {
					jasonconfigobj.addProperty("does_jason_get_stronger_with_each_blood_stage", true);
				} else {
					jasonconfigobj.addProperty("does_jason_get_stronger_with_each_blood_stage", false);
				}
				jasonconfigobj.addProperty("jasons bloodstage goes up everytime he hits the player 3 times", "");
				jasonconfigobj.addProperty("the max bloodstage jason can go to is 3", "");
				if (guistate.containsKey("checkbox:jason_spawn_during_day_check") ? ((Checkbox) guistate.get("checkbox:jason_spawn_during_day_check")).selected() : false) {
					jasonconfigobj.addProperty("jason_spawn_during_day", true);
				} else {
					jasonconfigobj.addProperty("jason_spawn_during_day", false);
				}
				jasonconfigobj.addProperty("the spawning during day toggles whether jason can spawn during the day or not", "");
				if (guistate.containsKey("checkbox:ft13th_game_music_check") ? ((Checkbox) guistate.get("checkbox:ft13th_game_music_check")).selected() : false) {
					jasonconfigobj.addProperty("ft13th_game_music", true);
				} else {
					jasonconfigobj.addProperty("ft13th_game_music", false);
				}
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
