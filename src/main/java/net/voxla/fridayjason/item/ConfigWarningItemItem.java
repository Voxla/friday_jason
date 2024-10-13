
package net.voxla.fridayjason.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ConfigWarningItemItem extends Item {
	public ConfigWarningItemItem() {
		super(new Item.Properties().tab(null).stacksTo(1).rarity(Rarity.COMMON));
	}
}
