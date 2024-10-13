package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;

import net.minecraft.world.entity.Entity;

public class HeatbeatOverlayProc1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatOverlayTimer == 1) {
			return true;
		}
		return false;
	}
}
