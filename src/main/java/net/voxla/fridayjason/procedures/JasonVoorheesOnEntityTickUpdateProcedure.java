package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.Minecraft;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class JasonVoorheesOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject jasonconfigobj = new com.google.gson.JsonObject();
		File jasonconfig = new File("");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		JasonSneakProcProcedure.execute(world, x, y, z, entity);
		JasonAiSwitcherProcedure.execute(world, x, y, z, entity);
		PlayerCanSeeJasonProcProcedure.execute(world, x, y, z, entity);
		PlayJasonNearSoundProcedureProcedure.execute(world, x, y, z, entity);
		JasonDespawnProcProcedure.execute(world, x, y, z, entity);
		HeartBeatJasonSetForPlayerProcedure.execute(world, x, y, z, entity);
		JasonMusicPlayerProcProcedure.execute(world, x, y, z, entity);
		JasonWhenGrabbingPlayerProcProcedure.execute(world, x, y, z, entity);
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 1) {
			JasonAi1Procedure.execute(world, x, y, z, entity);
		} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 2) {
			JasonAi2Procedure.execute(world, x, y, z, entity);
		} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 3) {
			JasonAi3Procedure.execute(world, x, y, z, entity);
		} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 4) {
			JasonAi4Procedure.execute(world, x, y, z, entity);
		} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 5) {
			JasonAi5Procedure.execute(world, entity);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) < 3 && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entityiterator)) && !(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
							} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
							}
							return false;
						}
					}.checkGamemode(entityiterator))) {
						if (entity instanceof JasonVoorheesEntity _datEntSetI)
							_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_AiStage, 4);
					}
				}
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 0
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BaseAiSpawnGen) : 0) == 0
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_WaitBeforeTryingToPathToPlayer) : 0) < 800
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_WaitBeforeTryingToPathToPlayer,
						(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_WaitBeforeTryingToPathToPlayer) : 0) + 1));
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BaseAiSpawnGen) : 0) == 1
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) != 4
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_AiStage, 4);
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_BaseAiSpawnGen, 0);
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) != 5
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_SearchTimer) : 0) != 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_SearchTimer, 0);
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) != 0
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_WaitBeforeTryingToPathToPlayer) : 0) != 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_WaitBeforeTryingToPathToPlayer, 0);
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 3) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGen) : 0) == 0) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_Stage3AiGen, Mth.nextInt(RandomSource.create(), 1, 5));
			}
		} else {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGen) : 0) != 0) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_Stage3AiGen, 0);
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 3
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGen) : 0) == 3
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGenRandFor3) : 0) == 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_Stage3AiGenRandFor3, Mth.nextInt(RandomSource.create(), 1, 2));
		} else {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGenRandFor3) : 0) != 0) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_Stage3AiGenRandFor3, 0);
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_TimesJasonHasHitPlayer) : 0) >= 3) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_TimesJasonHasHitPlayer, 0);
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) < 3) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_BloodCounter, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) + 1));
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 0) {
			if ((entity instanceof JasonVoorheesEntity _datEntL47 && _datEntL47.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == true) {
				if (entity instanceof JasonVoorheesEntity animatable)
					animatable.setTexture("jason");
			} else if ((entity instanceof JasonVoorheesEntity _datEntL49 && _datEntL49.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == false) {
				if (entity instanceof JasonVoorheesEntity animatable)
					animatable.setTexture("jasonnoeyes");
			}
		} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 1) {
			if ((entity instanceof JasonVoorheesEntity _datEntL52 && _datEntL52.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == true) {
				if (entity instanceof JasonVoorheesEntity animatable)
					animatable.setTexture("jasonbloody1");
			} else if ((entity instanceof JasonVoorheesEntity _datEntL54 && _datEntL54.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == false) {
				if (entity instanceof JasonVoorheesEntity animatable)
					animatable.setTexture("jasonbloody1noeyes");
			}
		} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 2) {
			if ((entity instanceof JasonVoorheesEntity _datEntL57 && _datEntL57.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == true) {
				if (entity instanceof JasonVoorheesEntity animatable)
					animatable.setTexture("jasonbloody2");
			} else if ((entity instanceof JasonVoorheesEntity _datEntL59 && _datEntL59.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == false) {
				if (entity instanceof JasonVoorheesEntity animatable)
					animatable.setTexture("jasonbloody2noeyes");
			}
		} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 3) {
			if (entity.isShiftKeyDown() == false) {
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
						if (jasonconfigobj.get("does_jason_get_faster_at_blood_stage_3").getAsBoolean() == true) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 0, false, false));
							if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) == 1) {
								if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false));
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if ((entity instanceof JasonVoorheesEntity _datEntL70 && _datEntL70.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == true) {
					if (entity instanceof JasonVoorheesEntity animatable)
						animatable.setTexture("jasonbloody3");
				} else if ((entity instanceof JasonVoorheesEntity _datEntL72 && _datEntL72.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == false) {
					if (entity instanceof JasonVoorheesEntity animatable)
						animatable.setTexture("jasonbloody3noeyes");
				}
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntL74 && _datEntL74.getEntityData().get(JasonVoorheesEntity.DATA_IsSeen)) == true && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.INVISIBILITY) : false)
				&& (entity instanceof JasonVoorheesEntity _datEntL76 && _datEntL76.getEntityData().get(JasonVoorheesEntity.DATA_HasGrabbedPlayer)) == false) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 3, 0, false, false));
		}
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_IsTargettingEntity) : 0) > 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_IsTargettingEntity, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_IsTargettingEntity) : 0) - 1));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_IsTargettingEntity) : 0) < 6) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_IsTargettingEntity, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_IsTargettingEntity) : 0) + 10));
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_IsTargettingEntity) : 0) > 0
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 4) {
			if (entity.getDeltaMovement().x() != 0 || entity.getDeltaMovement().z() != 0) {
				if (entity.isShiftKeyDown() == false) {
					if (entity instanceof JasonVoorheesEntity) {
						((JasonVoorheesEntity) entity).setAnimation("animation.jason.powerwalk");
					}
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 1, false, false));
				}
			} else if (entity.getDeltaMovement().x() == 0 && entity.getDeltaMovement().z() == 0) {
				if ((((JasonVoorheesEntity) entity).animationprocedure).equals("animation.jason.powerwalk")) {
					if (entity instanceof JasonVoorheesEntity) {
						((JasonVoorheesEntity) entity).setAnimation("empty");
					}
				}
			}
		} else {
			if ((((JasonVoorheesEntity) entity).animationprocedure).equals("animation.jason.powerwalk")) {
				if (entity instanceof JasonVoorheesEntity) {
					((JasonVoorheesEntity) entity).setAnimation("empty");
				}
			}
		}
		entity.maxUpStep = (float) 1.2;
		((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(4);
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.INVISIBILITY) : false) && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty()) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 200, false, false));
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_GrabPlayerCooldown) : 0) > 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_GrabPlayerCooldown, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_GrabPlayerCooldown) : 0) - 1));
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				if ((world instanceof Level _lvl109 && _lvl109.isDay()) == true && (entity instanceof JasonVoorheesEntity _datEntL110 && _datEntL110.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == false) {
					if (entity instanceof JasonVoorheesEntity _datEntSetL)
						_datEntSetL.getEntityData().set(JasonVoorheesEntity.DATA_IsDay, true);
				} else if ((world instanceof Level _lvl112 && _lvl112.isDay()) == false && (entity instanceof JasonVoorheesEntity _datEntL113 && _datEntL113.getEntityData().get(JasonVoorheesEntity.DATA_IsDay)) == true) {
					if (entity instanceof JasonVoorheesEntity _datEntSetL)
						_datEntSetL.getEntityData().set(JasonVoorheesEntity.DATA_IsDay, false);
				}
			}
			world = _worldorig;
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_HasPlayerBeenAboveJasonForTooLong) : 0) > 0 && entityiterator.getY() <= entity.getY() + 2) {
						if (entity instanceof JasonVoorheesEntity _datEntSetI)
							_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_HasPlayerBeenAboveJasonForTooLong,
									(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_HasPlayerBeenAboveJasonForTooLong) : 0) - 1));
					}
				}
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) != 3
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage3Stage1Timer) : 0) != 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_AiStage3Stage1Timer, 0);
		}
	}
}
