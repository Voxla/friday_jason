
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.entity.ThrownMacheteEntity;
import net.voxla.fridayjason.entity.JasonVoorheesEntity;
import net.voxla.fridayjason.entity.JasonArmEntity;
import net.voxla.fridayjason.FridayJasonMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FridayJasonModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FridayJasonMod.MODID);
	public static final RegistryObject<EntityType<JasonVoorheesEntity>> JASON_VOORHEES = register("jason_voorhees",
			EntityType.Builder.<JasonVoorheesEntity>of(JasonVoorheesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(JasonVoorheesEntity::new)

					.sized(0.7f, 2.4f));
	public static final RegistryObject<EntityType<JasonArmEntity>> JASON_ARM = register("jason_arm",
			EntityType.Builder.<JasonArmEntity>of(JasonArmEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(JasonArmEntity::new)

					.sized(0.4f, 0.9f));
	public static final RegistryObject<EntityType<ThrownMacheteEntity>> THROWN_MACHETE = register("projectile_thrown_machete",
			EntityType.Builder.<ThrownMacheteEntity>of(ThrownMacheteEntity::new, MobCategory.MISC).setCustomClientFactory(ThrownMacheteEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			JasonVoorheesEntity.init();
			JasonArmEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(JASON_VOORHEES.get(), JasonVoorheesEntity.createAttributes().build());
		event.put(JASON_ARM.get(), JasonArmEntity.createAttributes().build());
	}
}
