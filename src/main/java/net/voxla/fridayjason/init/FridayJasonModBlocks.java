
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.block.StrippedFirWoodBlock;
import net.voxla.fridayjason.block.StrippedFirLogBlock;
import net.voxla.fridayjason.block.FirWoodBlock;
import net.voxla.fridayjason.block.FirTrapdoorBlock;
import net.voxla.fridayjason.block.FirStairsBlock;
import net.voxla.fridayjason.block.FirSlabBlock;
import net.voxla.fridayjason.block.FirSaplingFlowerPotBlock;
import net.voxla.fridayjason.block.FirSaplingBlock;
import net.voxla.fridayjason.block.FirPressurePlateBlock;
import net.voxla.fridayjason.block.FirPlanksBlock;
import net.voxla.fridayjason.block.FirLogBlock;
import net.voxla.fridayjason.block.FirLeavesBlock;
import net.voxla.fridayjason.block.FirFenceGateBlock;
import net.voxla.fridayjason.block.FirFenceBlock;
import net.voxla.fridayjason.block.FirDoorBlock;
import net.voxla.fridayjason.block.FirButtonBlock;
import net.voxla.fridayjason.block.BrokenRegenBlockBlock;
import net.voxla.fridayjason.FridayJasonMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

public class FridayJasonModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, FridayJasonMod.MODID);
	public static final RegistryObject<Block> FIR_LOG = REGISTRY.register("fir_log", () -> new FirLogBlock());
	public static final RegistryObject<Block> FIR_WOOD = REGISTRY.register("fir_wood", () -> new FirWoodBlock());
	public static final RegistryObject<Block> STRIPPED_FIR_LOG = REGISTRY.register("stripped_fir_log", () -> new StrippedFirLogBlock());
	public static final RegistryObject<Block> STRIPPED_FIR_WOOD = REGISTRY.register("stripped_fir_wood", () -> new StrippedFirWoodBlock());
	public static final RegistryObject<Block> FIR_PLANKS = REGISTRY.register("fir_planks", () -> new FirPlanksBlock());
	public static final RegistryObject<Block> FIR_STAIRS = REGISTRY.register("fir_stairs", () -> new FirStairsBlock());
	public static final RegistryObject<Block> FIR_SLAB = REGISTRY.register("fir_slab", () -> new FirSlabBlock());
	public static final RegistryObject<Block> FIR_FENCE = REGISTRY.register("fir_fence", () -> new FirFenceBlock());
	public static final RegistryObject<Block> FIR_FENCE_GATE = REGISTRY.register("fir_fence_gate", () -> new FirFenceGateBlock());
	public static final RegistryObject<Block> FIR_DOOR = REGISTRY.register("fir_door", () -> new FirDoorBlock());
	public static final RegistryObject<Block> FIR_TRAPDOOR = REGISTRY.register("fir_trapdoor", () -> new FirTrapdoorBlock());
	public static final RegistryObject<Block> FIR_LEAVES = REGISTRY.register("fir_leaves", () -> new FirLeavesBlock());
	public static final RegistryObject<Block> FIR_SAPLING = REGISTRY.register("fir_sapling", () -> new FirSaplingBlock());
	public static final RegistryObject<Block> FIR_PRESSURE_PLATE = REGISTRY.register("fir_pressure_plate", () -> new FirPressurePlateBlock());
	public static final RegistryObject<Block> FIR_BUTTON = REGISTRY.register("fir_button", () -> new FirButtonBlock());
	public static final RegistryObject<Block> BROKEN_REGEN_BLOCK = REGISTRY.register("broken_regen_block", () -> new BrokenRegenBlockBlock());
	public static final RegistryObject<Block> FIR_SAPLING_FLOWER_POT = REGISTRY.register("fir_sapling_flower_pot", () -> new FirSaplingFlowerPotBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			FirLeavesBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			FirLeavesBlock.itemColorLoad(event);
		}
	}
}
