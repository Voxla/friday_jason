package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.init.FridayJasonModParticleTypes;
import net.voxla.fridayjason.init.FridayJasonModMobEffects;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class InjuryOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(FridayJasonModMobEffects.INJURY.get()) ? _livEnt.getEffect(FridayJasonModMobEffects.INJURY.get()).getAmplifier() : 0) == 0) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() / 2), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() / 2)));
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(FridayJasonModMobEffects.INJURY.get()) ? _livEnt.getEffect(FridayJasonModMobEffects.INJURY.get()).getAmplifier() : 0) == 1) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() / 3), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() / 3)));
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(FridayJasonModMobEffects.INJURY.get()) ? _livEnt.getEffect(FridayJasonModMobEffects.INJURY.get()).getAmplifier() : 0) == 2) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() / 4), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() / 4)));
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(FridayJasonModMobEffects.INJURY.get()) ? _livEnt.getEffect(FridayJasonModMobEffects.INJURY.get()).getAmplifier() : 0) == 3) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() / 5), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() / 5)));
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(FridayJasonModMobEffects.INJURY.get()) ? _livEnt.getEffect(FridayJasonModMobEffects.INJURY.get()).getAmplifier() : 0) == 4) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() / 6), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() / 6)));
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(FridayJasonModMobEffects.INJURY.get()) ? _livEnt.getEffect(FridayJasonModMobEffects.INJURY.get()).getAmplifier() : 0) == 5) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() / 7), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() / 7)));
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(FridayJasonModMobEffects.INJURY.get()) ? _livEnt.getEffect(FridayJasonModMobEffects.INJURY.get()).getAmplifier() : 0) >= 6) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() / 8), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() / 8)));
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (FridayJasonModParticleTypes.BLOOD_DRIP.get()), x, y, z, 2, 0.3, 0.8, 0.3, 0.1);
	}
}
