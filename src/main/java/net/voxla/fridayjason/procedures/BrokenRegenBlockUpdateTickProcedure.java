package net.voxla.fridayjason.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class BrokenRegenBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos(x, y, z), "BlockName")).equals("")) {
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(x, y, z), "IsPane")) == true) {
				if (!world.isClientSide()) {
					{
						BlockPos _bp = new BlockPos(x, y, z);
						BlockState _bs = Blocks.GLASS_PANE.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					if (world.getBlockState(new BlockPos(x + 1, y, z)).canOcclude()) {
						{
							BlockPos _pos = new BlockPos(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("east") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
					}
					if (world.getBlockState(new BlockPos(x - 1, y, z)).canOcclude()) {
						{
							BlockPos _pos = new BlockPos(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("west") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
					}
					if (world.getBlockState(new BlockPos(x, y, z + 1)).canOcclude()) {
						{
							BlockPos _pos = new BlockPos(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("south") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
					}
					if (world.getBlockState(new BlockPos(x, y, z - 1)).canOcclude()) {
						{
							BlockPos _pos = new BlockPos(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("north") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
					}
				}
			} else if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(x, y, z), "IsPane")) == false) {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getString(tag);
							return "";
						}
					}.getValue(world, new BlockPos(x, y, z), "BlockName"))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			}
		}
	}
}
