
package net.voxla.fridayjason.potion;

import net.voxla.fridayjason.procedures.InjuryOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class InjuryMobEffect extends MobEffect {
	public InjuryMobEffect() {
		super(MobEffectCategory.HARMFUL, -10092544);
	}

	@Override
	public String getDescriptionId() {
		return "effect.friday_jason.injury";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		InjuryOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
