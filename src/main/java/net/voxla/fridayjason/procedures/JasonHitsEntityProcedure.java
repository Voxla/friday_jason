package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.init.FridayJasonModMobEffects;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class JasonHitsEntityProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		com.google.gson.JsonObject jasonconfigobj = new com.google.gson.JsonObject();
		File jasonconfig = new File("");
		if (sourceentity instanceof JasonVoorheesEntity && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.isBlocking())) {
			if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_TimesJasonHasHitPlayer) : 0) < 3) {
				if (sourceentity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_TimesJasonHasHitPlayer,
							(int) ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_TimesJasonHasHitPlayer) : 0) + 1));
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
					if (jasonconfigobj.get("does_jason_get_stronger_with_each_blood_stage").getAsBoolean() == true) {
						if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_TimesJasonHasHitPlayer) : 0) == 2
								&& (sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) < 3) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(FridayJasonModMobEffects.INJURY.get(), 400, 0));
							if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 0) {
								entity.hurt(DamageSource.MAGIC, 1);
							} else if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 1) {
								entity.hurt(DamageSource.MAGIC, 2);
							} else if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 2) {
								entity.hurt(DamageSource.MAGIC, 3);
							} else if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 3) {
								entity.hurt(DamageSource.MAGIC, 4);
							}
						}
						if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) >= 3) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(FridayJasonModMobEffects.INJURY.get(), 400, 0));
							if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 0) {
								entity.hurt(DamageSource.MAGIC, 1);
							} else if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 1) {
								entity.hurt(DamageSource.MAGIC, 2);
							} else if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 2) {
								entity.hurt(DamageSource.MAGIC, 3);
							} else if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) == 3) {
								entity.hurt(DamageSource.MAGIC, 4);
							}
						}
					} else if (jasonconfigobj.get("does_jason_get_stronger_with_each_blood_stage").getAsBoolean() == false) {
						if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_TimesJasonHasHitPlayer) : 0) == 2
								&& (sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) < 3) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(FridayJasonModMobEffects.INJURY.get(), 400, 0));
							entity.hurt(DamageSource.MAGIC, 2);
						}
						if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) >= 3) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(FridayJasonModMobEffects.INJURY.get(), 400, 0));
							entity.hurt(DamageSource.MAGIC, 2);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (sourceentity instanceof JasonVoorheesEntity && entity instanceof LivingEntity _livEnt49 && _livEnt49.isBlocking()) {
			if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BashPlayersShieldCounter) : 0) < 5) {
				if (sourceentity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_BashPlayersShieldCounter,
							(int) ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BashPlayersShieldCounter) : 0) + 1));
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.PLAYERS, (float) 0.7, (float) 1.6);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.PLAYERS, (float) 0.7, (float) 1.6, false);
						}
					}
				}
			}
			if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BashPlayersShieldCounter) : 0) >= 5) {
				if (sourceentity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_BashPlayersShieldCounter, 0);
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 150);
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 150);
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.PLAYERS, (float) 0.7, (float) 1.4);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.PLAYERS, (float) 0.7, (float) 1.4, false);
						}
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(3, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
					if (_ist.hurt(3, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		}
		if (sourceentity instanceof JasonVoorheesEntity && (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) > 50) {
			entity.hurt(DamageSource.MAGIC, 50);
		}
	}
}
