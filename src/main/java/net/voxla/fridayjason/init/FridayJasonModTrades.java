
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.voxla.fridayjason.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FridayJasonModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == FridayJasonModVillagerProfessions.CAMPER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(FridayJasonModBlocks.FIR_LOG.get(), 16), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(FridayJasonModBlocks.FIR_LOG.get(), 32),

					new ItemStack(Items.EMERALD, 2), 20, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(FridayJasonModBlocks.FIR_LOG.get()),

					new ItemStack(Blocks.CAMPFIRE), 10, 10, 0.07f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Blocks.SPRUCE_SAPLING),

					new ItemStack(FridayJasonModBlocks.FIR_SAPLING.get()), 15, 7, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(FridayJasonModBlocks.FIR_LOG.get()),

					new ItemStack(Items.EMERALD, 10), 15, 15, 0.07f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(Blocks.COBBLESTONE, 64), 30, 10, 0.03f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(FridayJasonModBlocks.FIR_WOOD.get(), 4), 20, 10, 0.03f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.COMPASS),

					new ItemStack(Items.EMERALD, 15), 3, 20, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND_SWORD), new ItemStack(FridayJasonModItems.SLASHERS_MACHETE.get()), 2, 1000, 0f));
		}
	}
}
