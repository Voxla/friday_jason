package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class JasonMusicPlayerProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject jasonconfigobj = new com.google.gson.JsonObject();
		File jasonconfig = new File("");
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
				if (jasonconfigobj.get("jason_music").getAsBoolean() == true) {
					if (jasonconfigobj.get("ft13th_game_music").getAsBoolean() == false) {
						if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 4) {
							if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonChaseMusic) : 0) > 0) {
								if (entity instanceof JasonVoorheesEntity _datEntSetI)
									_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonChaseMusic, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonChaseMusic) : 0) - 1));
							}
							if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonChaseMusic) : 0) == 0) {
								if (entity instanceof JasonVoorheesEntity _datEntSetI)
									_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonChaseMusic, 60);
								if (!world.isClientSide()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:music.jason.chasing")), SoundSource.RECORDS, 3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:music.jason.chasing")), SoundSource.RECORDS, 3, 1, false);
										}
									}
								}
							}
						}
						if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 5) {
							if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonSearchMusic) : 0) > 0) {
								if (entity instanceof JasonVoorheesEntity _datEntSetI)
									_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonSearchMusic,
											(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonSearchMusic) : 0) - 1));
							}
							if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonSearchMusic) : 0) == 0) {
								if (entity instanceof JasonVoorheesEntity _datEntSetI)
									_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonSearchMusic, 110);
								if (!world.isClientSide()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:music.jason.searching")), SoundSource.RECORDS, 3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:music.jason.searching")), SoundSource.RECORDS, 3, 1, false);
										}
									}
								}
							}
						}
					} else if (jasonconfigobj.get("ft13th_game_music").getAsBoolean() == true) {
						if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 4) {
							if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonChaseMusic) : 0) > 0) {
								if (entity instanceof JasonVoorheesEntity _datEntSetI)
									_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonChaseMusic, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonChaseMusic) : 0) - 1));
							}
							if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonChaseMusic) : 0) == 0) {
								if (entity instanceof JasonVoorheesEntity _datEntSetI)
									_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonChaseMusic, 320);
								if (!world.isClientSide()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:music.jason.chasing_ftgame")), SoundSource.RECORDS, 3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:music.jason.chasing_ftgame")), SoundSource.RECORDS, 3, 1, false);
										}
									}
								}
							}
						}
						if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 5) {
							if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonSearchMusic) : 0) > 0) {
								if (entity instanceof JasonVoorheesEntity _datEntSetI)
									_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonSearchMusic,
											(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonSearchMusic) : 0) - 1));
							}
							if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonSearchMusic) : 0) == 0) {
								if (entity instanceof JasonVoorheesEntity _datEntSetI)
									_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonSearchMusic, 290);
								if (!world.isClientSide()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:music.jason.searching_ftgame")), SoundSource.RECORDS, 3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:music.jason.searching_ftgame")), SoundSource.RECORDS, 3, 1, false);
										}
									}
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) != 5
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonSearchMusic) : 0) > 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonSearchMusic, 0);
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) != 4
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonChaseMusic) : 0) > 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonChaseMusic, 0);
		}
	}
}
