
package net.voxla.fridayjason.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;

import java.util.List;

public class FirForestBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-0.55f, 0.1f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.2f, 0.8f), Climate.Parameter.span(-1.5f, 0.7f), Climate.Parameter.point(0.0f),
					Climate.Parameter.span(-0.8f, 1.5f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-0.55f, 0.1f), Climate.Parameter.span(0.3f, 1f), Climate.Parameter.span(-0.2f, 0.8f), Climate.Parameter.span(-1.5f, 0.7f), Climate.Parameter.point(1.0f),
					Climate.Parameter.span(-0.8f, 1.5f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-4995611).waterColor(4159204).waterFogColor(329011).skyColor(-4995611).foliageColorOverride(-10646182).grassColorOverride(-8210331).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addFerns(biomeGenerationSettings);
		BiomeDefaultFeatures.addSavannaGrass(biomeGenerationSettings);
		BiomeDefaultFeatures.addForestGrass(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultSeagrass(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.5f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
