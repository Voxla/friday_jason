
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.voxla.fridayjason.init;

import net.voxla.fridayjason.FridayJasonMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public class FridayJasonModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FridayJasonMod.MODID);
	public static final RegistryObject<SoundEvent> AMBIENT_JASON_NEAR = REGISTRY.register("ambient.jason.near", () -> new SoundEvent(new ResourceLocation("friday_jason", "ambient.jason.near")));
	public static final RegistryObject<SoundEvent> ENTITY_PLAYER_HEARTBEAT_SLOW = REGISTRY.register("entity.player.heartbeat_slow", () -> new SoundEvent(new ResourceLocation("friday_jason", "entity.player.heartbeat_slow")));
	public static final RegistryObject<SoundEvent> ENTITY_PLAYER_HEARTBEAT_FAST = REGISTRY.register("entity.player.heartbeat_fast", () -> new SoundEvent(new ResourceLocation("friday_jason", "entity.player.heartbeat_fast")));
	public static final RegistryObject<SoundEvent> MUSIC_JASON_CHASING = REGISTRY.register("music.jason.chasing", () -> new SoundEvent(new ResourceLocation("friday_jason", "music.jason.chasing")));
	public static final RegistryObject<SoundEvent> MUSIC_JASON_SEARCHING = REGISTRY.register("music.jason.searching", () -> new SoundEvent(new ResourceLocation("friday_jason", "music.jason.searching")));
	public static final RegistryObject<SoundEvent> ENTITY_PLAYER_JUMPSCARE_JASON = REGISTRY.register("entity.player.jumpscare.jason", () -> new SoundEvent(new ResourceLocation("friday_jason", "entity.player.jumpscare.jason")));
	public static final RegistryObject<SoundEvent> ENTITY_JASON_DEATH = REGISTRY.register("entity.jason.death", () -> new SoundEvent(new ResourceLocation("friday_jason", "entity.jason.death")));
	public static final RegistryObject<SoundEvent> ENTITY_JASON_ARM_DISAPPEAR = REGISTRY.register("entity.jason_arm.disappear", () -> new SoundEvent(new ResourceLocation("friday_jason", "entity.jason_arm.disappear")));
	public static final RegistryObject<SoundEvent> ENTITY_JASON_HURT = REGISTRY.register("entity.jason.hurt", () -> new SoundEvent(new ResourceLocation("friday_jason", "entity.jason.hurt")));
	public static final RegistryObject<SoundEvent> MUSIC_JASON_CHASING_FTGAME = REGISTRY.register("music.jason.chasing_ftgame", () -> new SoundEvent(new ResourceLocation("friday_jason", "music.jason.chasing_ftgame")));
	public static final RegistryObject<SoundEvent> MUSIC_JASON_SEARCHING_FTGAME = REGISTRY.register("music.jason.searching_ftgame", () -> new SoundEvent(new ResourceLocation("friday_jason", "music.jason.searching_ftgame")));
	public static final RegistryObject<SoundEvent> ENTITY_PLAYER_JUMPSCARE_JASON_FTGAME = REGISTRY.register("entity.player.jumpscare.jason_ftgame", () -> new SoundEvent(new ResourceLocation("friday_jason", "entity.player.jumpscare.jason_ftgame")));
}
