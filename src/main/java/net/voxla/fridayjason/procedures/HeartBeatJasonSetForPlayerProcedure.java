package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class HeartBeatJasonSetForPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 4) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerChase) : 0) < 10) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerChase,
							(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerChase) : 0) + 1));
			}
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerChase) : 0) >= 10) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerChase, 0);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							{
								double _setval = 7;
								entityiterator.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.HeartbeatFastSoundTimer = _setval;
									capability.syncPlayerVariables(entityiterator);
								});
							}
						}
					}
				}
			}
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 5) {
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerSearch) : 0) < 20) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerSearch,
							(int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerSearch) : 0) + 1));
			}
			if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerSearch) : 0) >= 20) {
				if (entity instanceof JasonVoorheesEntity _datEntSetI)
					_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_SetPlayerHeartBeatTimerSearch, 0);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(75 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							{
								double _setval = 11;
								entityiterator.getCapability(FridayJasonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.HeartbeatSoundTimer = _setval;
									capability.syncPlayerVariables(entityiterator);
								});
							}
						}
					}
				}
			}
		}
	}
}
