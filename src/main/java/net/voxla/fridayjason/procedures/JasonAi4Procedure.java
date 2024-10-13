package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class JasonAi4Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		JasonBreakGlassProcProcedure.execute(world, x, y, z);
		JasonBreakGlassPaneProcProcedure.execute(world, x, y, z);
		JasonThrowMacheteProcProcedure.execute(world, x, y, z, entity);
		if ((world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:doors"))) && !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.IRON_DOOR)) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) < 2
					&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) == 0
					&& ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp7 && (world.getBlockState(new BlockPos(x, y, z - 1))).getValue(_getbp7)) == false) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmount, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) + 1));
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashTime, 140);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmountResetTime, 600);
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
				}
			} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) == 2
					&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) == 0
					&& ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp17 && (world.getBlockState(new BlockPos(x, y, z - 1))).getValue(_getbp17)) == false) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmount, 0);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashTime, 140);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmountResetTime, 600);
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp25 && (world.getBlockState(new BlockPos(x + 1, y, z))).getValue(_getbp25)) == false) {
						{
							BlockPos _pos = new BlockPos(x + 1, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x + 1, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound((x + 1), y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					}
				}
			}
		} else if ((world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:doors"))) && !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.IRON_DOOR)) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) < 2
					&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) == 0
					&& ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp35 && (world.getBlockState(new BlockPos(x, y, z - 1))).getValue(_getbp35)) == false) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmount, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) + 1));
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashTime, 140);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmountResetTime, 600);
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
				}
			} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) == 2
					&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) == 0
					&& ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp45 && (world.getBlockState(new BlockPos(x, y, z - 1))).getValue(_getbp45)) == false) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmount, 0);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashTime, 140);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmountResetTime, 600);
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp53 && (world.getBlockState(new BlockPos(x - 1, y, z))).getValue(_getbp53)) == false) {
						{
							BlockPos _pos = new BlockPos(x - 1, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x - 1, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound((x - 1), y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					}
				}
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:doors"))) && !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.IRON_DOOR)) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) < 2
					&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) == 0
					&& ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp63 && (world.getBlockState(new BlockPos(x, y, z - 1))).getValue(_getbp63)) == false) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmount, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) + 1));
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashTime, 140);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmountResetTime, 600);
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
				}
			} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) == 2
					&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) == 0
					&& ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp73 && (world.getBlockState(new BlockPos(x, y, z - 1))).getValue(_getbp73)) == false) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmount, 0);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashTime, 140);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmountResetTime, 600);
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp81 && (world.getBlockState(new BlockPos(x, y, z + 1))).getValue(_getbp81)) == false) {
						{
							BlockPos _pos = new BlockPos(x, y, z + 1);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z + 1), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, (z + 1), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
					}
				}
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:doors"))) && !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.IRON_DOOR)) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) < 2
					&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) == 0
					&& ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp91 && (world.getBlockState(new BlockPos(x, y, z - 1))).getValue(_getbp91)) == false) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmount, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) + 1));
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashTime, 140);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmountResetTime, 600);
				if (!world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
				}
			} else if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) == 2
					&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) == 0
					&& ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp101 && (world.getBlockState(new BlockPos(x, y, z - 1))).getValue(_getbp101)) == false) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmount, 0);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashTime, 140);
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmountResetTime, 600);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp108 && (world.getBlockState(new BlockPos(x, y, z - 1))).getValue(_getbp108)) == false) {
					{
						BlockPos _pos = new BlockPos(x, y, z - 1);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z - 1), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, (z - 1), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wooden_door.open")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) > 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashTime, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashTime) : 0) - 1));
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) > 0
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmountResetTime) : 0) > 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmountResetTime, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmountResetTime) : 0) - 1));
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmount) : 0) > 0
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_DoorBashAmountResetTime) : 0) == 1) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_DoorBashAmount, 0);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(70 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
					if (entity instanceof JasonVoorheesEntity _datEntSetI)
						_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonStoredPlayerCoordX, (int) entityiterator.getX());
					if (entity instanceof JasonVoorheesEntity _datEntSetI)
						_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonStoredPlayerCoordZ, (int) entityiterator.getZ());
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).isEmpty() && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonStoredPlayerCoordX, (int) ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX());
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonStoredPlayerCoordZ, (int) ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ());
		} else if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).isEmpty())) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonStoredPlayerCoordX,
						(int) ((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX());
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonStoredPlayerCoordZ,
						(int) ((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ());
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_IsTargettingEntity) : 0) == 0) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_AiStage, 5);
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonSearchCoordX,
						(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonStoredPlayerCoordX) : 0) + Mth.nextInt(RandomSource.create(), -30, 30)));
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_JasonSearchCoordZ,
						(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_JasonStoredPlayerCoordZ) : 0) + Mth.nextInt(RandomSource.create(), -30, 30)));
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 6, 6, 6), e -> true).isEmpty()
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_GrabPlayerCooldown) : 0) <= 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator) {
							if (entity instanceof JasonVoorheesEntity _datEntSetL)
								_datEntSetL.getEntityData().set(JasonVoorheesEntity.DATA_HasGrabbedPlayer, true);
						}
					}
				}
			}
		}
	}
}
