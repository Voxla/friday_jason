package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.init.FridayJasonModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class JasonBreakGlassPaneProcProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String BlockN = "";
		boolean P1 = false;
		boolean P2 = false;
		boolean P3 = false;
		boolean P4 = false;
		boolean PW = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -1;
		for (int index0 = 0; index0 < 3; index0++) {
			sy = 0;
			for (int index1 = 0; index1 < 3; index1++) {
				sz = -1;
				for (int index2 = 0; index2 < 3; index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("friday_jason:glass_panes")))) {
						BlockN = ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock()).toString();
						PW = (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp5
								&& (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getValue(_getbp5);
						if (((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock().getStateDefinition().getProperty("north") instanceof BooleanProperty _getbp7
								&& (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getValue(_getbp7)) == true) {
							P1 = true;
						}
						if (((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock().getStateDefinition().getProperty("south") instanceof BooleanProperty _getbp9
								&& (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getValue(_getbp9)) == true) {
							P2 = true;
						}
						if (((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock().getStateDefinition().getProperty("west") instanceof BooleanProperty _getbp11
								&& (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getValue(_getbp11)) == true) {
							P3 = true;
						}
						if (((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock().getStateDefinition().getProperty("east") instanceof BooleanProperty _getbp13
								&& (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getValue(_getbp13)) == true) {
							P4 = true;
						}
						if (!world.isClientSide()) {
							world.levelEvent(2001, new BlockPos(x + sx, y + sy, z + sz), Block.getId((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))));
							{
								BlockPos _bp = new BlockPos(x + sx, y + sy, z + sz);
								BlockState _bs = FridayJasonModBlocks.BROKEN_REGEN_BLOCK.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
									if (_property != null && _bs.getValue(_property) != null)
										try {
											_bs = _bs.setValue(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								BlockEntity _be = world.getBlockEntity(_bp);
								CompoundTag _bnbt = null;
								if (_be != null) {
									_bnbt = _be.saveWithFullMetadata();
									_be.setRemoved();
								}
								world.setBlock(_bp, _bs, 3);
								if (_bnbt != null) {
									_be = world.getBlockEntity(_bp);
									if (_be != null) {
										try {
											_be.load(_bnbt);
										} catch (Exception ignored) {
										}
									}
								}
							}
							if (!world.isClientSide()) {
								BlockPos _bp = new BlockPos(x + sx, y + sy, z + sz);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putString("BlockName", BlockN);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = new BlockPos(x + sx, y + sy, z + sz);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putBoolean("IsPane", true);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
