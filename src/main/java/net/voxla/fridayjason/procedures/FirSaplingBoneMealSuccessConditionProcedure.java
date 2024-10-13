package net.voxla.fridayjason.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class FirSaplingBoneMealSuccessConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() > 0.6) {
			if (world.getBlockState(new BlockPos(x, y - 1, z)).canOcclude()) {
				return true;
			}
		}
		return false;
	}
}
