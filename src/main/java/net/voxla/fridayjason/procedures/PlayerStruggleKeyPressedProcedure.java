package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;
import net.voxla.fridayjason.entity.JasonArmEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class PlayerStruggleKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).PlayerBeingGrabbed == true) {
			if (!world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty()) {
				if ((((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_PlayerStruggleAmount) : 0) < 10) {
					if (((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonVoorheesEntity _datEntSetI)
						_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_PlayerStruggleAmount,
								(int) ((((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_PlayerStruggleAmount) : 0) + 1));
					if (!world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.leash_knot.break")), SoundSource.PLAYERS, 1, (float) 0.5);
							} else {
								_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.leash_knot.break")), SoundSource.PLAYERS, 1, (float) 0.5, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), SoundSource.PLAYERS, 1, (float) 0.7);
							} else {
								_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), SoundSource.PLAYERS, 1, (float) 0.7, false);
							}
						}
					}
				}
			}
		}
		if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).JasonArmGrabbingPlayer == true) {
			if (!world.getEntitiesOfClass(JasonArmEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty()) {
				if ((((Entity) world.getEntitiesOfClass(JasonArmEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonArmEntity _datEntI ? _datEntI.getEntityData().get(JasonArmEntity.DATA_PlayerStruggleAmount) : 0) < 15) {
					if (((Entity) world.getEntitiesOfClass(JasonArmEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonArmEntity _datEntSetI)
						_datEntSetI.getEntityData().set(JasonArmEntity.DATA_PlayerStruggleAmount,
								(int) ((((Entity) world.getEntitiesOfClass(JasonArmEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonArmEntity _datEntI ? _datEntI.getEntityData().get(JasonArmEntity.DATA_PlayerStruggleAmount) : 0) + 1));
					if (!world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.leash_knot.break")), SoundSource.PLAYERS, 1, (float) 0.5);
							} else {
								_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.leash_knot.break")), SoundSource.PLAYERS, 1, (float) 0.5, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), SoundSource.PLAYERS, 1, (float) 0.7);
							} else {
								_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather")), SoundSource.PLAYERS, 1, (float) 0.7, false);
							}
						}
					}
				}
			}
		}
	}
}
