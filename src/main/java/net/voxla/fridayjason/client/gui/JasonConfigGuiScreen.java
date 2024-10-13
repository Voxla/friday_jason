package net.voxla.fridayjason.client.gui;

import net.voxla.fridayjason.world.inventory.JasonConfigGuiMenu;
import net.voxla.fridayjason.network.JasonConfigGuiButtonMessage;
import net.voxla.fridayjason.FridayJasonMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class JasonConfigGuiScreen extends AbstractContainerScreen<JasonConfigGuiMenu> {
	private final static HashMap<String, Object> guistate = JasonConfigGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox jason_spawn_time_input;
	EditBox jason_killed_cooldown_input;
	Checkbox does_jason_get_faster_at_bloodstage_3_check;
	Checkbox does_jason_get_stronger_with_each_blood_stage_check;
	Checkbox jason_music_check;
	Checkbox jason_spawn_during_day_check;
	Checkbox ft13th_game_music_check;
	Button button_done;
	Button button_reset;
	Button button_cancel;

	public JasonConfigGuiScreen(JasonConfigGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 242;
		this.imageHeight = 240;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("friday_jason:textures/screens/jason_config_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		jason_spawn_time_input.render(ms, mouseX, mouseY, partialTicks);
		jason_killed_cooldown_input.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (jason_spawn_time_input.isFocused())
			return jason_spawn_time_input.keyPressed(key, b, c);
		if (jason_killed_cooldown_input.isFocused())
			return jason_killed_cooldown_input.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		jason_spawn_time_input.tick();
		jason_killed_cooldown_input.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.friday_jason.jason_config_gui.label_jason_config"), 7, 5, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.friday_jason.jason_config_gui.label_jason_spawn_time"), 7, 23, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.friday_jason.jason_config_gui.label_jason_killed_cooldown"), 7, 59, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.friday_jason.jason_config_gui.label_does_jason_get_faster_at_bloodst"), 7, 95, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.friday_jason.jason_config_gui.label_does_jason_get_stronger_with_eac"), 7, 131, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.friday_jason.jason_config_gui.label_jason_music"), 161, 23, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.friday_jason.jason_config_gui.label_jason_spawn_during_day"), 106, 167, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.friday_jason.jason_config_gui.label_ft13th_game_music"), 7, 167, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		jason_spawn_time_input = new EditBox(this.font, this.leftPos + 8, this.topPos + 36, 118, 18, Component.translatable("gui.friday_jason.jason_config_gui.jason_spawn_time_input"));
		jason_spawn_time_input.setMaxLength(32767);
		guistate.put("text:jason_spawn_time_input", jason_spawn_time_input);
		this.addWidget(this.jason_spawn_time_input);
		jason_killed_cooldown_input = new EditBox(this.font, this.leftPos + 8, this.topPos + 72, 118, 18, Component.translatable("gui.friday_jason.jason_config_gui.jason_killed_cooldown_input"));
		jason_killed_cooldown_input.setMaxLength(32767);
		guistate.put("text:jason_killed_cooldown_input", jason_killed_cooldown_input);
		this.addWidget(this.jason_killed_cooldown_input);
		button_done = new Button(this.leftPos + 188, this.topPos + 215, 46, 20, Component.translatable("gui.friday_jason.jason_config_gui.button_done"), e -> {
			if (true) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new JasonConfigGuiButtonMessage(0, x, y, z));
				JasonConfigGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_done", button_done);
		this.addRenderableWidget(button_done);
		button_reset = new Button(this.leftPos + 133, this.topPos + 215, 51, 20, Component.translatable("gui.friday_jason.jason_config_gui.button_reset"), e -> {
			if (true) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new JasonConfigGuiButtonMessage(1, x, y, z));
				JasonConfigGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_reset", button_reset);
		this.addRenderableWidget(button_reset);
		button_cancel = new Button(this.leftPos + 73, this.topPos + 215, 56, 20, Component.translatable("gui.friday_jason.jason_config_gui.button_cancel"), e -> {
			if (true) {
				FridayJasonMod.PACKET_HANDLER.sendToServer(new JasonConfigGuiButtonMessage(2, x, y, z));
				JasonConfigGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_cancel", button_cancel);
		this.addRenderableWidget(button_cancel);
		does_jason_get_faster_at_bloodstage_3_check = new Checkbox(this.leftPos + 7, this.topPos + 107, 20, 20, Component.translatable("gui.friday_jason.jason_config_gui.does_jason_get_faster_at_bloodstage_3_check"), false);
		guistate.put("checkbox:does_jason_get_faster_at_bloodstage_3_check", does_jason_get_faster_at_bloodstage_3_check);
		this.addRenderableWidget(does_jason_get_faster_at_bloodstage_3_check);
		does_jason_get_stronger_with_each_blood_stage_check = new Checkbox(this.leftPos + 7, this.topPos + 143, 20, 20, Component.translatable("gui.friday_jason.jason_config_gui.does_jason_get_stronger_with_each_blood_stage_check"), false);
		guistate.put("checkbox:does_jason_get_stronger_with_each_blood_stage_check", does_jason_get_stronger_with_each_blood_stage_check);
		this.addRenderableWidget(does_jason_get_stronger_with_each_blood_stage_check);
		jason_music_check = new Checkbox(this.leftPos + 161, this.topPos + 35, 20, 20, Component.translatable("gui.friday_jason.jason_config_gui.jason_music_check"), false);
		guistate.put("checkbox:jason_music_check", jason_music_check);
		this.addRenderableWidget(jason_music_check);
		jason_spawn_during_day_check = new Checkbox(this.leftPos + 106, this.topPos + 179, 20, 20, Component.translatable("gui.friday_jason.jason_config_gui.jason_spawn_during_day_check"), false);
		guistate.put("checkbox:jason_spawn_during_day_check", jason_spawn_during_day_check);
		this.addRenderableWidget(jason_spawn_during_day_check);
		ft13th_game_music_check = new Checkbox(this.leftPos + 7, this.topPos + 179, 20, 20, Component.translatable("gui.friday_jason.jason_config_gui.ft13th_game_music_check"), false);
		guistate.put("checkbox:ft13th_game_music_check", ft13th_game_music_check);
		this.addRenderableWidget(ft13th_game_music_check);
	}
}
