
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.item.SlashersMacheteItem;
import net.voxla.fridayjason.item.HeartOfTheSlasherItem;
import net.voxla.fridayjason.item.ConfigWarningItemItem;
import net.voxla.fridayjason.item.ConfigTooltipItem6Item;
import net.voxla.fridayjason.item.ConfigTooltipItem5Item;
import net.voxla.fridayjason.item.ConfigTooltipItem4Item;
import net.voxla.fridayjason.item.ConfigTooltipItem3Item;
import net.voxla.fridayjason.item.ConfigTooltipItem2Item;
import net.voxla.fridayjason.item.ConfigTooltipItem1Item;
import net.voxla.fridayjason.FridayJasonMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

public class FridayJasonModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FridayJasonMod.MODID);
	public static final RegistryObject<Item> FIR_LOG = block(FridayJasonModBlocks.FIR_LOG, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FIR_WOOD = block(FridayJasonModBlocks.FIR_WOOD, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> STRIPPED_FIR_LOG = block(FridayJasonModBlocks.STRIPPED_FIR_LOG, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> STRIPPED_FIR_WOOD = block(FridayJasonModBlocks.STRIPPED_FIR_WOOD, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FIR_PLANKS = block(FridayJasonModBlocks.FIR_PLANKS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FIR_STAIRS = block(FridayJasonModBlocks.FIR_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FIR_SLAB = block(FridayJasonModBlocks.FIR_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FIR_FENCE = block(FridayJasonModBlocks.FIR_FENCE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FIR_FENCE_GATE = block(FridayJasonModBlocks.FIR_FENCE_GATE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FIR_DOOR = doubleBlock(FridayJasonModBlocks.FIR_DOOR, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FIR_TRAPDOOR = block(FridayJasonModBlocks.FIR_TRAPDOOR, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FIR_LEAVES = block(FridayJasonModBlocks.FIR_LEAVES, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> FIR_SAPLING = block(FridayJasonModBlocks.FIR_SAPLING, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> FIR_PRESSURE_PLATE = block(FridayJasonModBlocks.FIR_PRESSURE_PLATE, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> FIR_BUTTON = block(FridayJasonModBlocks.FIR_BUTTON, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> HEART_OF_THE_SLASHER = REGISTRY.register("heart_of_the_slasher", () -> new HeartOfTheSlasherItem());
	public static final RegistryObject<Item> SLASHERS_MACHETE = REGISTRY.register("slashers_machete", () -> new SlashersMacheteItem());
	public static final RegistryObject<Item> BROKEN_REGEN_BLOCK = block(FridayJasonModBlocks.BROKEN_REGEN_BLOCK, null);
	public static final RegistryObject<Item> FIR_SAPLING_FLOWER_POT = block(FridayJasonModBlocks.FIR_SAPLING_FLOWER_POT, null);
	public static final RegistryObject<Item> CONFIG_TOOLTIP_ITEM_1 = REGISTRY.register("config_tooltip_item_1", () -> new ConfigTooltipItem1Item());
	public static final RegistryObject<Item> CONFIG_TOOLTIP_ITEM_2 = REGISTRY.register("config_tooltip_item_2", () -> new ConfigTooltipItem2Item());
	public static final RegistryObject<Item> CONFIG_TOOLTIP_ITEM_3 = REGISTRY.register("config_tooltip_item_3", () -> new ConfigTooltipItem3Item());
	public static final RegistryObject<Item> CONFIG_TOOLTIP_ITEM_4 = REGISTRY.register("config_tooltip_item_4", () -> new ConfigTooltipItem4Item());
	public static final RegistryObject<Item> CONFIG_WARNING_ITEM = REGISTRY.register("config_warning_item", () -> new ConfigWarningItemItem());
	public static final RegistryObject<Item> CONFIG_TOOLTIP_ITEM_5 = REGISTRY.register("config_tooltip_item_5", () -> new ConfigTooltipItem5Item());
	public static final RegistryObject<Item> CONFIG_TOOLTIP_ITEM_6 = REGISTRY.register("config_tooltip_item_6", () -> new ConfigTooltipItem6Item());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
