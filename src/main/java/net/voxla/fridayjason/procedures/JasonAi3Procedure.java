package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.init.FridayJasonModParticleTypes;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.Comparator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class JasonAi3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String BlockN = "";
		double sx = 0;
		double sy = 0;
		double sz = 0;
		com.google.gson.JsonObject jasonconfigobj = new com.google.gson.JsonObject();
		File jasonconfig = new File("");
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 3) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGen) : 0) == 1) {
				if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty())) {
					if ((entity instanceof JasonVoorheesEntity _datEntL3 && _datEntL3.getEntityData().get(JasonVoorheesEntity.DATA_IsSeen)) == false) {
						if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, false, false));
					}
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
						if (entity instanceof Mob _entity)
							_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 1);
					}
				}
			} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGen) : 0) == 2) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 1);
				}
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).isEmpty()) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 200, false, false));
				}
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty()) {
					if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage3Stage1Timer) : 0) < 800) {
						if (entity instanceof JasonVoorheesEntity _datEntSetI)
							_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_AiStage3Stage1Timer, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage3Stage1Timer) : 0) + 1));
					}
				}
			} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGen) : 0) == 3) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 1);
				}
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
					sx = -1;
					for (int index0 = 0; index0 < 3; index0++) {
						sy = 0;
						for (int index1 = 0; index1 < 3; index1++) {
							sz = -1;
							for (int index2 = 0; index2 < 3; index2++) {
								if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("friday_jason:glass_blocks")))
										|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("friday_jason:glass_panes")))) {
									JasonBreakGlassProcProcedure.execute(world, x, y, z);
									JasonBreakGlassPaneProcProcedure.execute(world, x, y, z);
									if (entity instanceof JasonVoorheesEntity _datEntSetL)
										_datEntSetL.getEntityData().set(JasonVoorheesEntity.DATA_HasGrabbedPlayer, true);
									if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.INVISIBILITY) : false) {
										if (!world.isClientSide()) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.thunder")), SoundSource.HOSTILE, 2, (float) 0.7);
												} else {
													_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.thunder")), SoundSource.HOSTILE, 2, (float) 0.7, false);
												}
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.HOSTILE, 2, (float) 0.1);
												} else {
													_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.HOSTILE, 2, (float) 0.1, false);
												}
											}
										}
										if (world instanceof ServerLevel _level)
											_level.sendParticles((SimpleParticleType) (FridayJasonModParticleTypes.BLOOD_DRIP.get()), x, y, z, 300, 0.4, 1.3, 0.4, 0.1);
										if (entity instanceof LivingEntity _entity)
											_entity.removeEffect(MobEffects.INVISIBILITY);
									}
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
				}
			} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGen) : 0) == 4) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 1);
				}
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty()) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 200, false, false));
				}
				if ((entity instanceof JasonVoorheesEntity _datEntL60 && _datEntL60.getEntityData().get(JasonVoorheesEntity.DATA_IsSeen)) == true && !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.INVISIBILITY) : false)) {
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
						((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY() + 1.8), (entity.getZ())));
					}
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
							if (jasonconfigobj.get("ft13th_game_music").getAsBoolean() == false) {
								if (!world.isClientSide()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.player.jumpscare.jason")), SoundSource.RECORDS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.player.jumpscare.jason")), SoundSource.RECORDS, 1, 1, false);
										}
									}
								}
							} else if (jasonconfigobj.get("ft13th_game_music").getAsBoolean() == true) {
								if (!world.isClientSide()) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.player.jumpscare.jason_ftgame")), SoundSource.RECORDS, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.player.jumpscare.jason_ftgame")), SoundSource.RECORDS, 1, 1, false);
										}
									}
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_Stage3AiGenRandFor3) : 0) == 2) {
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
							if (entity instanceof JasonVoorheesEntity _datEntSetL)
								_datEntSetL.getEntityData().set(JasonVoorheesEntity.DATA_HasGrabbedPlayer, true);
						}
					}
				}
			}
		}
	}
}
