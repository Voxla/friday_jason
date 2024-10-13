package net.voxla.fridayjason.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class FirSaplingBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(new BlockPos(x, y - 1, z)).canOcclude() && (world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:dirt")))) {
			return true;
		}
		return false;
	}
}
