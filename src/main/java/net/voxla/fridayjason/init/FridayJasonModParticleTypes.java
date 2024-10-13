
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.FridayJasonMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class FridayJasonModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, FridayJasonMod.MODID);
	public static final RegistryObject<SimpleParticleType> BLOOD_DRIP = REGISTRY.register("blood_drip", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> BLOOD_POOF = REGISTRY.register("blood_poof", () -> new SimpleParticleType(true));
}
