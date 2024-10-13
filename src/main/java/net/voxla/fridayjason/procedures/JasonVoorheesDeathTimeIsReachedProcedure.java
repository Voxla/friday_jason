package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.init.FridayJasonModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

public class JasonVoorheesDeathTimeIsReachedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY() + 1.5), (entity.getZ()), 20, 0.4, 1.4, 0.4, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (FridayJasonModParticleTypes.BLOOD_POOF.get()), (entity.getX()), (entity.getY() + 1.5), (entity.getZ()), 15, 0.4, 1.4, 0.4, 0.01);
	}
}
