package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;
import net.voxla.fridayjason.entity.JasonArmEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.Comparator;

@Mod.EventBusSubscriber
public class HeartbeatPlayerProcProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatSoundTimer > 0) {
			if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatSoundTimer == 10) {
				if (world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.player.heartbeat_slow")), SoundSource.PLAYERS, (float) 0.3, 1);
						} else {
							_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.player.heartbeat_slow")), SoundSource.PLAYERS, (float) 0.3, 1, false);
						}
					}
				}
				{
					double _setval = 6;
					entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HeartbeatOverlayTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatSoundTimer == 4) {
				{
					double _setval = 6;
					entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HeartbeatOverlayTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				double _setval = (entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatSoundTimer - 1;
				entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HeartbeatSoundTimer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatFastSoundTimer > 0) {
			if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatFastSoundTimer == 6) {
				if (world.isClientSide()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.player.heartbeat_fast")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.player.heartbeat_fast")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
				{
					double _setval = 6;
					entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HeartbeatOverlayTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatFastSoundTimer == 2) {
				{
					double _setval = 6;
					entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HeartbeatOverlayTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				double _setval = (entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatFastSoundTimer - 1;
				entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HeartbeatFastSoundTimer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatOverlayTimer > 0) {
			{
				double _setval = (entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).HeartbeatOverlayTimer - 1;
				entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HeartbeatOverlayTimer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (!world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if ((((Entity) world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonVoorheesEntity _datEntL6 && _datEntL6.getEntityData().get(JasonVoorheesEntity.DATA_HasGrabbedPlayer)) == false
					&& (entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).PlayerBeingGrabbed == true) {
				{
					boolean _setval = false;
					entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerBeingGrabbed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (!(!world.getEntitiesOfClass(JasonVoorheesEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())
				&& (entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).PlayerBeingGrabbed == true) {
			{
				boolean _setval = false;
				entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerBeingGrabbed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (!world.getEntitiesOfClass(JasonArmEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			if ((((Entity) world.getEntitiesOfClass(JasonArmEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof JasonArmEntity _datEntL10 && _datEntL10.getEntityData().get(JasonArmEntity.DATA_HasGrabbedPlayer)) == false
					&& (entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).JasonArmGrabbingPlayer == true) {
				{
					boolean _setval = false;
					entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.JasonArmGrabbingPlayer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (!(!world.getEntitiesOfClass(JasonArmEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())
				&& (entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FridayJasonModVariables.PlayerVariables())).JasonArmGrabbingPlayer == true) {
			{
				boolean _setval = false;
				entity.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.JasonArmGrabbingPlayer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
