package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraft.world.entity.Entity;

public class CanJasonMoveAndLookAroundProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof JasonVoorheesEntity _datEntL0 && _datEntL0.getEntityData().get(JasonVoorheesEntity.DATA_HasGrabbedPlayer)) == false) {
			return true;
		}
		return false;
	}
}
