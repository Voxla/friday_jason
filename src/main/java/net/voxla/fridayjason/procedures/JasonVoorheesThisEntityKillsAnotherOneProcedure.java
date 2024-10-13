package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.init.FridayJasonModParticleTypes;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class JasonVoorheesThisEntityKillsAnotherOneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) >= 3) {
			if (((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_BloodCounter, 0);
			if (((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 30, false, false));
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
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:ambient.jason.near")), SoundSource.HOSTILE, 2, (float) 0.7);
					} else {
						_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:ambient.jason.near")), SoundSource.HOSTILE, 2, (float) 0.7, false);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (FridayJasonModParticleTypes.BLOOD_DRIP.get()), x, y, z, 300, 0.4, 1.3, 0.4, 0.1);
		}
		if ((sourceentity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) >= 3) {
			if (sourceentity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_BloodCounter, 0);
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 30, false, false));
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
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:ambient.jason.near")), SoundSource.HOSTILE, 2, (float) 0.7);
					} else {
						_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:ambient.jason.near")), SoundSource.HOSTILE, 2, (float) 0.7, false);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (FridayJasonModParticleTypes.BLOOD_DRIP.get()), x, y, z, 300, 0.4, 1.3, 0.4, 0.1);
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_BloodCounter) : 0) >= 3) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_BloodCounter, 0);
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 30, false, false));
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
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:ambient.jason.near")), SoundSource.HOSTILE, 2, (float) 0.7);
					} else {
						_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:ambient.jason.near")), SoundSource.HOSTILE, 2, (float) 0.7, false);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (FridayJasonModParticleTypes.BLOOD_DRIP.get()), x, y, z, 300, 0.4, 1.3, 0.4, 0.1);
		}
	}
}
