package net.voxla.fridayjason.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class JasonVoorheesBoundingBoxScaleProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getBlockState(new BlockPos(x + 1, y + 0, z)).canOcclude() && !world.getBlockState(new BlockPos(x + 1, y + 1, z)).canOcclude()
				&& (world.getBlockState(new BlockPos(x + 1, y + 2, z)).canOcclude() || (world.getBlockState(new BlockPos(x + 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(new BlockPos(x, y + 0, z)).canOcclude() && !world.getBlockState(new BlockPos(x, y + 1, z)).canOcclude()
						&& (world.getBlockState(new BlockPos(x, y + 2, z)).canOcclude() || (world.getBlockState(new BlockPos(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(new BlockPos(x + 1, y + 2, z)).canOcclude() && !world.getBlockState(new BlockPos(x + 1, y + 1, z)).canOcclude()
						&& (world.getBlockState(new BlockPos(x + 1, y + 0, z)).canOcclude() && world.getBlockState(new BlockPos(x + 1, y + 3, z)).canOcclude()
								|| (world.getBlockState(new BlockPos(x + 1, y + 0, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
										&& (world.getBlockState(new BlockPos(x + 1, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.75;
		} else if (!world.getBlockState(new BlockPos(x - 1, y + 0, z)).canOcclude() && !world.getBlockState(new BlockPos(x - 1, y + 1, z)).canOcclude()
				&& (world.getBlockState(new BlockPos(x - 1, y + 2, z)).canOcclude() || (world.getBlockState(new BlockPos(x - 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(new BlockPos(x, y + 0, z)).canOcclude() && !world.getBlockState(new BlockPos(x, y + 1, z)).canOcclude()
						&& (world.getBlockState(new BlockPos(x, y + 2, z)).canOcclude() || (world.getBlockState(new BlockPos(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(new BlockPos(x - 1, y + 2, z)).canOcclude() && !world.getBlockState(new BlockPos(x - 1, y + 1, z)).canOcclude()
						&& (world.getBlockState(new BlockPos(x - 1, y + 0, z)).canOcclude() && world.getBlockState(new BlockPos(x - 1, y + 3, z)).canOcclude()
								|| (world.getBlockState(new BlockPos(x - 1, y + 0, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
										&& (world.getBlockState(new BlockPos(x - 1, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.75;
		} else if (!world.getBlockState(new BlockPos(x, y + 0, z + 1)).canOcclude() && !world.getBlockState(new BlockPos(x, y + 1, z + 1)).canOcclude()
				&& (world.getBlockState(new BlockPos(x, y + 2, z + 1)).canOcclude() || (world.getBlockState(new BlockPos(x, y + 2, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(new BlockPos(x, y + 0, z)).canOcclude() && !world.getBlockState(new BlockPos(x, y + 1, z)).canOcclude()
						&& (world.getBlockState(new BlockPos(x, y + 2, z)).canOcclude() || (world.getBlockState(new BlockPos(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(new BlockPos(x, y + 2, z + 1)).canOcclude() && !world.getBlockState(new BlockPos(x, y + 1, z + 1)).canOcclude()
						&& (world.getBlockState(new BlockPos(x, y + 0, z + 1)).canOcclude() && world.getBlockState(new BlockPos(x, y + 3, z + 1)).canOcclude()
								|| (world.getBlockState(new BlockPos(x, y + 0, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
										&& (world.getBlockState(new BlockPos(x, y + 3, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.75;
		} else if (!world.getBlockState(new BlockPos(x, y + 0, z - 1)).canOcclude() && !world.getBlockState(new BlockPos(x, y + 1, z - 1)).canOcclude()
				&& (world.getBlockState(new BlockPos(x, y + 2, z - 1)).canOcclude() || (world.getBlockState(new BlockPos(x, y + 2, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(new BlockPos(x, y + 0, z)).canOcclude() && !world.getBlockState(new BlockPos(x, y + 1, z)).canOcclude()
						&& (world.getBlockState(new BlockPos(x, y + 2, z)).canOcclude() || (world.getBlockState(new BlockPos(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))
				|| !world.getBlockState(new BlockPos(x, y + 2, z - 1)).canOcclude() && !world.getBlockState(new BlockPos(x, y + 1, z - 1)).canOcclude()
						&& (world.getBlockState(new BlockPos(x, y + 0, z - 1)).canOcclude() && world.getBlockState(new BlockPos(x, y + 3, z - 1)).canOcclude()
								|| (world.getBlockState(new BlockPos(x, y + 0, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))
										&& (world.getBlockState(new BlockPos(x, y + 3, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			return 0.75;
		}
		return 1;
	}
}
