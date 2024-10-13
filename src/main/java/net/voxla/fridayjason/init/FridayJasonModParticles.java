
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.client.particle.BloodPoofParticle;
import net.voxla.fridayjason.client.particle.BloodDripParticle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FridayJasonModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(FridayJasonModParticleTypes.BLOOD_DRIP.get(), BloodDripParticle::provider);
		event.register(FridayJasonModParticleTypes.BLOOD_POOF.get(), BloodPoofParticle::provider);
	}
}
