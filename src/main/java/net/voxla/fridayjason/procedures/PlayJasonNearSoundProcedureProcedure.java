package net.voxla.fridayjason.procedures;

import net.voxla.fridayjason.entity.JasonVoorheesEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class PlayJasonNearSoundProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double PlaySoundX = 0;
		double PlaySoundZ = 0;
		if ((entity instanceof JasonVoorheesEntity _datEntL0 && _datEntL0.getEntityData().get(JasonVoorheesEntity.DATA_HasPlayerFoundThisJason)) == false
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_AiStage) : 0) == 0
				&& (entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_IsPlayerNotNearSoundTimer) : 0) < 400) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_IsPlayerNotNearSoundTimer, (int) ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_IsPlayerNotNearSoundTimer) : 0) + 1));
		}
		if ((entity instanceof JasonVoorheesEntity _datEntI ? _datEntI.getEntityData().get(JasonVoorheesEntity.DATA_IsPlayerNotNearSoundTimer) : 0) >= 400) {
			if (entity instanceof JasonVoorheesEntity _datEntSetI)
				_datEntSetI.getEntityData().set(JasonVoorheesEntity.DATA_IsPlayerNotNearSoundTimer, 0);
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 400, 400, 400), e -> true).isEmpty()) {
				PlaySoundX = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() + Mth.nextInt(RandomSource.create(), -30, 30);
				PlaySoundZ = ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ() + Mth.nextInt(RandomSource.create(), -30, 30);
				if (Math.random() > 0.7) {
					if (!world.isClientSide()) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(PlaySoundX, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) PlaySoundX, (int) PlaySoundZ) + 1, PlaySoundZ),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:ambient.jason.near")), SoundSource.AMBIENT, 4, 1);
							} else {
								_level.playLocalSound(PlaySoundX, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) PlaySoundX, (int) PlaySoundZ) + 1), PlaySoundZ,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:ambient.jason.near")), SoundSource.AMBIENT, 4, 1, false);
							}
						}
					}
				}
			}
		}
	}
}
