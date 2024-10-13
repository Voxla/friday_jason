package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;

import net.minecraft.world.level.LevelAccessor;

public class ForSpawnProcedure {
	public static void execute(LevelAccessor world) {
		FridayJasonModVariables.MapVariables.get(world).HasOneDayPassed = true;
		FridayJasonModVariables.MapVariables.get(world).syncData(world);
	}
}
