
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import org.lwjgl.glfw.GLFW;

import net.voxla.fridayjason.network.PlayerStruggleKey7Message;
import net.voxla.fridayjason.network.PlayerStruggleKey6Message;
import net.voxla.fridayjason.network.PlayerStruggleKey5Message;
import net.voxla.fridayjason.network.PlayerStruggleKey4Message;
import net.voxla.fridayjason.network.PlayerStruggleKey3Message;
import net.voxla.fridayjason.network.PlayerStruggleKey2Message;
import net.voxla.fridayjason.network.PlayerStruggleKey1Message;
import net.voxla.fridayjason.FridayJasonMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class FridayJasonModKeyMappings {
	public static final KeyMapping PLAYER_STRUGGLE_KEY_1 = new KeyMapping("key.friday_jason.player_struggle_key_1", GLFW.GLFW_KEY_W, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new PlayerStruggleKey1Message(0, 0));
				PlayerStruggleKey1Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PLAYER_STRUGGLE_KEY_2 = new KeyMapping("key.friday_jason.player_struggle_key_2", GLFW.GLFW_KEY_A, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new PlayerStruggleKey2Message(0, 0));
				PlayerStruggleKey2Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PLAYER_STRUGGLE_KEY_3 = new KeyMapping("key.friday_jason.player_struggle_key_3", GLFW.GLFW_KEY_S, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new PlayerStruggleKey3Message(0, 0));
				PlayerStruggleKey3Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PLAYER_STRUGGLE_KEY_4 = new KeyMapping("key.friday_jason.player_struggle_key_4", GLFW.GLFW_KEY_D, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new PlayerStruggleKey4Message(0, 0));
				PlayerStruggleKey4Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PLAYER_STRUGGLE_KEY_5 = new KeyMapping("key.friday_jason.player_struggle_key_5", GLFW.GLFW_KEY_SPACE, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new PlayerStruggleKey5Message(0, 0));
				PlayerStruggleKey5Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PLAYER_STRUGGLE_KEY_6 = new KeyMapping("key.friday_jason.player_struggle_key_6", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new PlayerStruggleKey6Message(0, 0));
				PlayerStruggleKey6Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PLAYER_STRUGGLE_KEY_7 = new KeyMapping("key.friday_jason.player_struggle_key_7", GLFW.GLFW_KEY_LEFT_CONTROL, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new PlayerStruggleKey7Message(0, 0));
				PlayerStruggleKey7Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(PLAYER_STRUGGLE_KEY_1);
		event.register(PLAYER_STRUGGLE_KEY_2);
		event.register(PLAYER_STRUGGLE_KEY_3);
		event.register(PLAYER_STRUGGLE_KEY_4);
		event.register(PLAYER_STRUGGLE_KEY_5);
		event.register(PLAYER_STRUGGLE_KEY_6);
		event.register(PLAYER_STRUGGLE_KEY_7);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				PLAYER_STRUGGLE_KEY_1.consumeClick();
				PLAYER_STRUGGLE_KEY_2.consumeClick();
				PLAYER_STRUGGLE_KEY_3.consumeClick();
				PLAYER_STRUGGLE_KEY_4.consumeClick();
				PLAYER_STRUGGLE_KEY_5.consumeClick();
				PLAYER_STRUGGLE_KEY_6.consumeClick();
				PLAYER_STRUGGLE_KEY_7.consumeClick();
			}
		}
	}
}
