package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class JasonSneakProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getBlockState(new BlockPos(x, y + 0, z)).canOcclude() && !world.getBlockState(new BlockPos(x, y + 1, z)).canOcclude()
				&& (world.getBlockState(new BlockPos(x, y + 2, z)).canOcclude() || (world.getBlockState(new BlockPos(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves"))))) {
			if (entity.isShiftKeyDown() == false) {
				entity.setShiftKeyDown(true);
			}
			if (entity.isShiftKeyDown()) {
				if (entity.getDeltaMovement().x() != 0 || entity.getDeltaMovement().z() != 0) {
					if (entity instanceof JasonVoorheesEntity) {
						((JasonVoorheesEntity) entity).setAnimation("animation.jason.walksneak");
					}
				} else if (entity.getDeltaMovement().x() == 0 && entity.getDeltaMovement().z() == 0) {
					if ((((JasonVoorheesEntity) entity).animationprocedure).equals("animation.jason.walksneak")) {
						if (entity instanceof JasonVoorheesEntity) {
							((JasonVoorheesEntity) entity).setAnimation("empty");
						}
					}
				}
			}
		} else {
			if (entity.isShiftKeyDown() == true) {
				entity.setShiftKeyDown(false);
			}
			if ((((JasonVoorheesEntity) entity).animationprocedure).equals("animation.jason.walksneak")) {
				if (entity instanceof JasonVoorheesEntity) {
					((JasonVoorheesEntity) entity).setAnimation("empty");
				}
			}
		}
	}
}
