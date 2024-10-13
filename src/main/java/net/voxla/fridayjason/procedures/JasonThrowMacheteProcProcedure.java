package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.init.FridayJasonModEntities;
import net.voxla.fridayjason.entity.ThrownMacheteEntity;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class JasonThrowMacheteProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double fromZ = 0;
		double magnitude = 0;
		double fromX = 0;
		double theta = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					if (entity.getDeltaMovement().x() == 0 && entity.getDeltaMovement().z() == 0 && (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_HasPlayerBeenAboveJasonForTooLong) : 0) < 400
							&& entityiterator.getY() > entity.getY() + 2) {
						if (entity instanceof JasonVoorheesEntity _datEntSetI)
							_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_HasPlayerBeenAboveJasonForTooLong,
									(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_HasPlayerBeenAboveJasonForTooLong) : 0) + 1));
					}
				}
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_HasPlayerBeenAboveJasonForTooLong) : 0) >= 400) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_ThrowMacheteCooldownTimer) : 0) < 80) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_ThrowMacheteCooldownTimer,
							(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_ThrowMacheteCooldownTimer) : 0) + 1));
			}
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_ThrowMacheteCooldownTimer) : 0) >= 80) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_ThrowMacheteCooldownTimer, 0);
			}
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_ThrowMacheteCooldownTimer) : 0) == 79) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
				}
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.HOSTILE, 1, (float) 0.6);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.HOSTILE, 1, (float) 0.6, false);
						}
					}
				}
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new ThrownMacheteEntity(FridayJasonModEntities.THROWN_MACHETE.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 2, 1);
					_entityToSpawn.setPos(x, (y + 2.1), z);
					_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 4, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
	}
}
