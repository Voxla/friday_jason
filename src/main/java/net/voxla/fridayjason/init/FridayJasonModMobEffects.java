
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.potion.InjuryMobEffect;
import net.voxla.fridayjason.FridayJasonMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class FridayJasonModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FridayJasonMod.MODID);
	public static final RegistryObject<MobEffect> INJURY = REGISTRY.register("injury", () -> new InjuryMobEffect());
}
