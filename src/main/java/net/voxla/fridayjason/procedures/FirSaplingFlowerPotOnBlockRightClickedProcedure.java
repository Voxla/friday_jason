package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.init.FridayJasonModBlocks;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class FirSaplingFlowerPotOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == FridayJasonModBlocks.FIR_SAPLING.get().asItem())) {
			world.setBlock(new BlockPos(x, y, z), Blocks.FLOWER_POT.defaultBlockState(), 3);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(FridayJasonModBlocks.FIR_SAPLING.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
