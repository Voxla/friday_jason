package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class PlayerCanSeeJasonProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean entity_found = false;
		double raytrace_distance = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					raytrace_distance = 0;
					for (int index0 = 0; index0 < 30; index0++) {
						if (!world.getEntitiesOfClass(JasonVoorheesEntity.class,
								AABB.ofSize(new Vec3(
										(entityiterator.level.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER,
												ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getX()),
										(entityiterator.level.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER,
												ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getY()),
										(entityiterator.level.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER,
												ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getZ())),
										1, 1, 1),
								e -> true).isEmpty()) {
							entity_found = true;
						} else {
							entity_found = false;
							raytrace_distance = raytrace_distance + 1;
						}
					}
					if (entity_found || !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
						if ((entity instanceof JasonVoorheesEntity _datEntL6 && _datEntL6.getEntityData().get(JasonVoorheesEntity.DATA_IsSeen)) == true
								&& (entity instanceof JasonVoorheesEntity _datEntL7 && _datEntL7.getEntityData().get(JasonVoorheesEntity.DATA_HasPlayerFoundThisJason)) == false) {
							if (entity instanceof JasonVoorheesEntity _datEntSetL)
								_datEntSetL.getEntityData().set(JasonVoorheesEntity.DATA_HasPlayerFoundThisJason, true);
						}
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(70 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					if ((entity.getDirection()) == Direction.SOUTH && (entityiterator.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.NORTH && (entityiterator.getDirection()) == Direction.SOUTH
							|| (entity.getDirection()) == Direction.EAST && (entityiterator.getDirection()) == Direction.WEST || (entity.getDirection()) == Direction.WEST && (entityiterator.getDirection()) == Direction.EAST
							|| !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
						if ((entity instanceof JasonVoorheesEntity _datEntL28 && _datEntL28.getEntityData().get(JasonVoorheesEntity.DATA_IsSeen)) == false) {
							if (entity instanceof JasonVoorheesEntity _datEntSetL)
								_datEntSetL.getEntityData().set(JasonVoorheesEntity.DATA_IsSeen, true);
						}
					} else {
						if ((entity instanceof JasonVoorheesEntity _datEntL30 && _datEntL30.getEntityData().get(JasonVoorheesEntity.DATA_IsSeen)) == true) {
							if (entity instanceof JasonVoorheesEntity _datEntSetL)
								_datEntSetL.getEntityData().set(JasonVoorheesEntity.DATA_IsSeen, false);
						}
					}
				}
			}
		}
	}
}
