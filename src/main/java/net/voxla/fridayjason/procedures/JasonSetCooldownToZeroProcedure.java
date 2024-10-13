package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;

import net.minecraft.world.level.LevelAccessor;

public class JasonSetCooldownToZeroProcedure {
	public static void execute(LevelAccessor world) {
		FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn = 0;
		FridayJasonModVariables.WorldVariables.get(world).syncData(world);
	}
}
