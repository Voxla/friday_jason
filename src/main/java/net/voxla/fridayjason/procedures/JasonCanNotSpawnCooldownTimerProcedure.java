package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.network.FridayJasonModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JasonCanNotSpawnCooldownTimerProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn > 0) {
			FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn = FridayJasonModVariables.WorldVariables.get(world).JasonCannotSpawn - 1;
			FridayJasonModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
