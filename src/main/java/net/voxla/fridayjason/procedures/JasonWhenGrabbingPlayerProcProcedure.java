package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.Comparator;

public class JasonWhenGrabbingPlayerProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof JasonVoorheesEntity _datEntL0 && _datEntL0.getEntityData().get(JasonVoorheesEntity.DATA_HasGrabbedPlayer)) == true) {
			if (entity instanceof JasonVoorheesEntity) {
				((JasonVoorheesEntity) entity).setAnimation("animation.jason.holdplayer");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 200, false, false));
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0, 0));
				entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y()), 0));
				{
					Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null));
					_ent.teleportTo((entity.getX() + entity.getLookAngle().x * 0.8), (entity.getY() + 0.8), (entity.getZ() + entity.getLookAngle().z * 0.8));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getX() + entity.getLookAngle().x * 0.8), (entity.getY() + 0.8), (entity.getZ() + entity.getLookAngle().z * 0.8), _ent.getYRot(), _ent.getXRot());
				}
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getX()), (entity.getY() + 1.8), (entity.getZ())));
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_GrabPlayerCooldown, 2400);
				{
					boolean _setval = true;
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerBeingGrabbed = _setval;
						capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)));
					});
				}
			}
		} else if ((entity instanceof JasonVoorheesEntity _datEntL22 && _datEntL22.getEntityData().get(JasonVoorheesEntity.DATA_HasGrabbedPlayer)) == false) {
			if ((((JasonVoorheesEntity) entity).animationprocedure).equals("animation.jason.holdplayer")) {
				if (entity instanceof JasonVoorheesEntity) {
					((JasonVoorheesEntity) entity).setAnimation("empty");
				}
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_PlayerStruggleAmount) : 0) >= 10) {
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.leash_knot.break")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.leash_knot.break")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
			if ((entity instanceof JasonVoorheesEntity _datEntL29 && _datEntL29.getEntityData().get(JasonVoorheesEntity.DATA_HasGrabbedPlayer)) == true) {
				if (entity instanceof JasonVoorheesEntity _datEntSetL)
					_datEntSetL.getEntityData().set(JasonVoorheesEntity.DATA_HasGrabbedPlayer, false);
			}
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_PlayerStruggleAmount, 0);
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty()) {
				{
					boolean _setval = false;
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerBeingGrabbed = _setval;
						capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)));
					});
				}
			}
		}
	}
}
