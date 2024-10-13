package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class JasonSpawnerProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		File jasonconfig = new File("");
		com.google.gson.JsonObject jasonconfigobj = new com.google.gson.JsonObject();
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				if (world.dayTime() > 24000 && FridayJasonModVariables.MapVariables.get(world).HasOneDayPassed == false) {
					FridayJasonModVariables.MapVariables.get(world).HasOneDayPassed = true;
					FridayJasonModVariables.MapVariables.get(world).syncData(world);
				}
				if (FridayJasonModVariables.MapVariables.get(world).HasOneDayPassed == true && FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn <= 0) {
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
							if (jasonconfigobj.get("jason_spawn_during_day").getAsBoolean() == true) {
								if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer > 0) {
									FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer - 1;
									FridayJasonModVariables.WorldVariables.get(world).syncData(world);
								}
								if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 1) {
									if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
										if (Math.random() >= 0 && Math.random() <= 0.25) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 1000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 5000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 9000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.75 && Math.random() <= 1) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 13000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										}
									}
								} else if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 2) {
									if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
										if (Math.random() >= 0 && Math.random() <= 0.25) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 6000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 10000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 14000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.75 && Math.random() <= 1) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 18000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										}
									}
								} else if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 3) {
									if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
										if (Math.random() >= 0 && Math.random() <= 0.25) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 12000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 16000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 20000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.75 && Math.random() <= 1) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 24000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										}
									}
								} else if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 4) {
									if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
										if (Math.random() >= 0 && Math.random() <= 0.25) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 16000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 20000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 24000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.75 && Math.random() <= 1) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 28000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										}
									}
								} else if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 5) {
									if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
										if (Math.random() >= 0 && Math.random() <= 0.25) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 24000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 28000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 32000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										} else if (Math.random() > 0.75 && Math.random() <= 1) {
											FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 36000;
											FridayJasonModVariables.WorldVariables.get(world).syncData(world);
										}
									}
								}
							} else if (jasonconfigobj.get("jason_spawn_during_day").getAsBoolean() == false) {
								if ((world instanceof Level _lvl10 && _lvl10.isDay()) == false) {
									if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer > 0) {
										FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer - 1;
										FridayJasonModVariables.WorldVariables.get(world).syncData(world);
									}
									if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 1) {
										if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
											if (Math.random() >= 0 && Math.random() <= 0.25) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 1600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 2600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 3600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.75 && Math.random() <= 1) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 4600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											}
										}
									} else if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 2) {
										if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
											if (Math.random() >= 0 && Math.random() <= 0.25) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 2600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 3600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 4600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.75 && Math.random() <= 1) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 5600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											}
										}
									} else if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 3) {
										if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
											if (Math.random() >= 0 && Math.random() <= 0.25) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 3600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 4600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 5600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.75 && Math.random() <= 1) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 6600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											}
										}
									} else if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 4) {
										if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
											if (Math.random() >= 0 && Math.random() <= 0.25) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 4600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 5600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 6600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.75 && Math.random() <= 1) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 7600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											}
										}
									} else if (jasonconfigobj.get("jason_spawn_time").getAsDouble() == 5) {
										if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 0) {
											if (Math.random() >= 0 && Math.random() <= 0.25) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 5600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.25 && Math.random() <= 0.5) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 6600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.5 && Math.random() <= 0.75) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 7600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											} else if (Math.random() > 0.75 && Math.random() <= 1) {
												FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer = 8600;
												FridayJasonModVariables.WorldVariables.get(world).syncData(world);
											}
										}
									}
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			world = _worldorig;
		}
	}
}
