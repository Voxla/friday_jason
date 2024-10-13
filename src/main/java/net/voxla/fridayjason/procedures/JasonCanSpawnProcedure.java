package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;
import net.voxla.fridayjason.init.FridayJasonModEntities;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;
import net.voxla.fridayjason.entity.JasonArmEntity;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class JasonCanSpawnProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double spawnx = 0;
		double spawnz = 0;
		com.google.gson.JsonObject jasonconfigobj = new com.google.gson.JsonObject();
		File jasonconfig = new File("");
		if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))) {
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
						if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 1 && !(!world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 12000, 12000, 12000), e -> true).isEmpty())
								&& FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn == 0 && FridayJasonModVariables.MapVariables.get(world).HasOneDayPassed == true
								&& world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_forest")))) {
							if (!(!world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 12000, 12000, 12000), e -> true).isEmpty())) {
								spawnx = Mth.nextInt(RandomSource.create(), -170, 170);
								spawnz = Mth.nextInt(RandomSource.create(), -170, 170);
							}
							sx = -20;
							found = false;
							for (int index0 = 0; index0 < 41; index0++) {
								sy = -20;
								for (int index1 = 0; index1 < 41; index1++) {
									sz = -20;
									for (int index2 = 0; index2 < 41; index2++) {
										if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.CHEST || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.BARREL
												|| world.getBiome(new BlockPos(x + sx, y + sy, z + sz)).is(new ResourceLocation("friday_jason:fir_forest"))) {
											found = true;
										}
										sz = sz + 1;
									}
									sy = sy + 1;
								}
								sx = sx + 1;
							}
							if (found == true) {
								if (Math.random() > 0.6) {
									if (!world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 0, spawnz)).canOcclude()
											&& !world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 1, spawnz)).canOcclude()
											&& !world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 2, spawnz)).canOcclude()
											&& world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) - 1, spawnz)).canOcclude()) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new JasonVoorheesEntity(FridayJasonModEntities.JASON_VOORHEES.get(), _level);
											entityToSpawn.moveTo(spawnx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz)), spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											world.addFreshEntity(entityToSpawn);
										}
									}
								}
							} else {
								if (Math.random() > 0.8) {
									if (!world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 0, spawnz)).canOcclude()
											&& !world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 1, spawnz)).canOcclude()
											&& !world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 2, spawnz)).canOcclude()
											&& world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) - 1, spawnz)).canOcclude()) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new JasonVoorheesEntity(FridayJasonModEntities.JASON_VOORHEES.get(), _level);
											entityToSpawn.moveTo(spawnx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz)), spawnz, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											world.addFreshEntity(entityToSpawn);
										}
									}
								}
							}
						}
					} else if (jasonconfigobj.get("jason_spawn_during_day").getAsBoolean() == false) {
						if (world instanceof ServerLevel _origLevel) {
							LevelAccessor _worldorig = world;
							world = _origLevel.getServer().getLevel(Level.OVERWORLD);
							if (world != null) {
								if ((world instanceof Level _lvl39 && _lvl39.isDay()) == false) {
									if (FridayJasonModVariables.WorldVariables.get(world).JasonSpawnTimer == 1 && !(!world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 12000, 12000, 12000), e -> true).isEmpty())
											&& FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn == 0 && FridayJasonModVariables.MapVariables.get(world).HasOneDayPassed == true
											&& world.getBiome(new BlockPos(x, y, z)).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_forest")))) {
										if (!(!world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 12000, 12000, 12000), e -> true).isEmpty())) {
											spawnx = Mth.nextInt(RandomSource.create(), -170, 170);
											spawnz = Mth.nextInt(RandomSource.create(), -170, 170);
										}
										sx = -20;
										found = false;
										for (int index3 = 0; index3 < 41; index3++) {
											sy = -20;
											for (int index4 = 0; index4 < 41; index4++) {
												sz = -20;
												for (int index5 = 0; index5 < 41; index5++) {
													if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.CHEST || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.BARREL
															|| world.getBiome(new BlockPos(x + sx, y + sy, z + sz)).is(new ResourceLocation("friday_jason:fir_forest"))) {
														found = true;
													}
													sz = sz + 1;
												}
												sy = sy + 1;
											}
											sx = sx + 1;
										}
										if (found == true) {
											if (Math.random() > 0.6) {
												if (!world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 0, spawnz)).canOcclude()
														&& !world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 1, spawnz)).canOcclude()
														&& !world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 2, spawnz)).canOcclude()
														&& world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) - 1, spawnz)).canOcclude()) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = new JasonVoorheesEntity(FridayJasonModEntities.JASON_VOORHEES.get(), _level);
														entityToSpawn.moveTo(spawnx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz)), spawnz, 0, 0);
														entityToSpawn.setYBodyRot(0);
														entityToSpawn.setYHeadRot(0);
														entityToSpawn.setDeltaMovement(0, 0, 0);
														if (entityToSpawn instanceof Mob _mobToSpawn)
															_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
														world.addFreshEntity(entityToSpawn);
													}
												}
											}
										} else {
											if (Math.random() > 0.8) {
												if (!world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 0, spawnz)).canOcclude()
														&& !world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 1, spawnz)).canOcclude()
														&& !world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) + 2, spawnz)).canOcclude()
														&& world.getBlockState(new BlockPos(spawnx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz) - 1, spawnz)).canOcclude()) {
													if (world instanceof ServerLevel _level) {
														Entity entityToSpawn = new JasonVoorheesEntity(FridayJasonModEntities.JASON_VOORHEES.get(), _level);
														entityToSpawn.moveTo(spawnx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnx, (int) spawnz)), spawnz, 0, 0);
														entityToSpawn.setYBodyRot(0);
														entityToSpawn.setYHeadRot(0);
														entityToSpawn.setDeltaMovement(0, 0, 0);
														if (entityToSpawn instanceof Mob _mobToSpawn)
															_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
														world.addFreshEntity(entityToSpawn);
													}
												}
											}
										}
									}
								}
							}
							world = _worldorig;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.WATER)
					&& !(!world.getEntitiesOfClass(JasonArmEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty()) && FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn == 0
					&& FridayJasonModVariables.MapVariables.get(world).HasOneDayPassed == true) {
				if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).JasonArmSpawnTimer == 0) {
					{
						double _setval = Mth.nextInt(RandomSource.create(), 1200, 4800);
						entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.JasonArmSpawnTimer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).JasonArmSpawnTimer > 0) {
					if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).JasonArmSpawnTimer == 1 && Math.random() > 0.6
							&& !world.getBlockState(new BlockPos(x, world.getHeight(Heightmap.Types.OCEAN_FLOOR, (int) x, (int) z) + 4, z)).canOcclude()) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new JasonArmEntity(FridayJasonModEntities.JASON_ARM.get(), _level);
							entityToSpawn.moveTo(x, (world.getHeight(Heightmap.Types.OCEAN_FLOOR, (int) x, (int) z) + 4), z, 0, 0);
							entityToSpawn.setYBodyRot(0);
							entityToSpawn.setYHeadRot(0);
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					}
					{
						double _setval = (entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).JasonArmSpawnTimer - 1;
						entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.JasonArmSpawnTimer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
