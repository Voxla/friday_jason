package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;
import net.voxla.fridayjason.init.FridayJasonModParticleTypes;
import net.voxla.fridayjason.entity.JasonArmEntity;

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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class JasonArmOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()) {
			if (entity instanceof JasonArmEntity animatable)
				animatable.setTexture("jasonarm1");
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 9, 9, 9), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty())) {
			if (entity instanceof JasonArmEntity animatable)
				animatable.setTexture("jasonarm2");
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 9, 9, 9), e -> true).isEmpty())) {
			if (entity instanceof JasonArmEntity animatable)
				animatable.setTexture("jasonarm3");
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty())) {
			if (entity instanceof JasonArmEntity animatable)
				animatable.setTexture("jasonarm4");
		} else if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 18, 18, 18), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty())) {
			if (entity instanceof JasonArmEntity animatable)
				animatable.setTexture("jasonarm5");
		} else if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 18, 18, 18), e -> true).isEmpty())) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 3, 0, false, false));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).isEmpty()
				&& (entity instanceof JasonArmEntity _datEntL17 && _datEntL17.getEntityData().get(JasonArmEntity.DATA_DisappearWhenNotGrabbing)) == false) {
			if (entity instanceof JasonArmEntity _datEntSetL)
				_datEntSetL.getEntityData().set(JasonArmEntity.DATA_HasGrabbedPlayer, true);
			if (entity instanceof JasonArmEntity _datEntSetL)
				_datEntSetL.getEntityData().set(JasonArmEntity.DATA_DisappearWhenNotGrabbing, true);
		}
		if ((entity instanceof JasonArmEntity _datEntL20 && _datEntL20.getEntityData().get(JasonArmEntity.DATA_HasGrabbedPlayer)) == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 200, false, false));
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0, 0));
				entity.setDeltaMovement(new Vec3(0, (-0.2), 0));
				if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).isPassenger()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).stopRiding();
				}
				{
					Entity _ent = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null));
					_ent.teleportTo((entity.getX()), (entity.getY() + 0.8), (entity.getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 0.8), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
				}
				{
					boolean _setval = true;
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.JasonArmGrabbingPlayer = _setval;
						capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)));
					});
				}
			}
		}
		if ((entity instanceof JasonArmEntity _datEntI ? _datEntI.getEntityData().get(JasonArmEntity.DATA_PlayerStruggleAmount) : 0) >= 15) {
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
			if ((entity instanceof JasonArmEntity _datEntL40 && _datEntL40.getEntityData().get(JasonArmEntity.DATA_HasGrabbedPlayer)) == true) {
				if (entity instanceof JasonArmEntity _datEntSetL)
					_datEntSetL.getEntityData().set(JasonArmEntity.DATA_HasGrabbedPlayer, false);
			}
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty()) {
				{
					boolean _setval = false;
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.JasonArmGrabbingPlayer = _setval;
						capability.syncPlayerVariables(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)));
					});
				}
			}
			if (entity instanceof JasonArmEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonArmEntity.DATA_PlayerStruggleAmount, 0);
		}
		if ((entity instanceof JasonArmEntity _datEntL45 && _datEntL45.getEntityData().get(JasonArmEntity.DATA_HasGrabbedPlayer)) == false
				&& (entity instanceof JasonArmEntity _datEntL46 && _datEntL46.getEntityData().get(JasonArmEntity.DATA_DisappearWhenNotGrabbing)) == true) {
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y + 0.5, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.jason_arm.disappear")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, (y + 0.5), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.jason_arm.disappear")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY() + 0.1), (entity.getZ()), 10, 0.1, 0.2, 0.1, 0.01);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (FridayJasonModParticleTypes.BLOOD_POOF.get()), (entity.getX()), (entity.getY() + 0.1), (entity.getZ()), 5, 0.1, 0.2, 0.1, 0.01);
			if (!entity.level.isClientSide())
				entity.discard();
		}
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
	}
}
