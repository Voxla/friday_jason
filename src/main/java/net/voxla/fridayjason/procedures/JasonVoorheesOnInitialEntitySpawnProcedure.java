package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class JasonVoorheesOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof JasonVoorheesEntity _datEntSetI)
			_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_BaseAiSpawnGen, Mth.nextInt(RandomSource.create(), 0, 1));
		if (entity instanceof Mob _entity)
			_entity.getNavigation().stop();
		if (entity instanceof JasonVoorheesEntity _datEntSetI)
			_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_GrabPlayerCooldown, 200);
	}
}
