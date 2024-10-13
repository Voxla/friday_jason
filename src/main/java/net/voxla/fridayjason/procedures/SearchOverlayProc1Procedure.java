package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class SearchOverlayProc1Procedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 75, 75, 75), e -> true).isEmpty()) {
			if ((((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 75, 75, 75), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_SearchTimer) : 0) < 690
					&& (((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 75, 75, 75), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_SearchTimer) : 0) >= 580) {
				return true;
			}
		}
		return false;
	}
}
