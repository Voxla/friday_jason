
package net.voxla.fridayjason.network;

import net.voxla.fridayjason.world.inventory.JasonConfigGuiMenu;
import net.voxla.fridayjason.procedures.JasonConfigResetButtonProcedure;
import net.voxla.fridayjason.procedures.JasonConfigDoneButtonProcedure;
import net.voxla.fridayjason.procedures.JasonConfigCancelButtonProcedure;
import net.voxla.fridayjason.FridayJasonMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JasonConfigGuiButtonMessage {
	private final int buttonID, x, y, z;

	public JasonConfigGuiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public JasonConfigGuiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(JasonConfigGuiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(JasonConfigGuiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = JasonConfigGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			JasonConfigDoneButtonProcedure.execute(entity, guistate);
		}
		if (buttonID == 1) {

			JasonConfigResetButtonProcedure.execute(entity);
		}
		if (buttonID == 2) {

			JasonConfigCancelButtonProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		FridayJasonMod.addNetworkMessage(JasonConfigGuiButtonMessage.class, JasonConfigGuiButtonMessage::buffer, JasonConfigGuiButtonMessage::new, JasonConfigGuiButtonMessage::handler);
	}
}
