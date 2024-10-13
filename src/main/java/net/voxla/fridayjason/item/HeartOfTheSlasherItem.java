
package net.voxla.fridayjason.item;

import net.voxla.fridayjason.procedures.HeartOfTheSlasherItemInInventoryTickProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class HeartOfTheSlasherItem extends Item {
	public HeartOfTheSlasherItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal(" "));
		list.add(Component.literal("\u00A77When in inventory:"));
		list.add(Component.literal("\u00A79+Water breathing"));
		list.add(Component.literal("\u00A79+Strength III"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		HeartOfTheSlasherItemInInventoryTickProcedure.execute(entity);
	}
}
