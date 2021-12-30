package fr.titi.infinityore.word.gen;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;



public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        for (OreGen ore : OreGen.values()) {
            OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    ore.getBlock().get().defaultBlockState(), ore.getMaxVeinSize());


            ConfiguredPlacement<TopSolidRangeConfig> configConfiguredPlacement = Placement.RANGE.configured(
                    new TopSolidRangeConfig(ore.getMaxHeight(), ore.getMinHeight(), ore.getMaxHeight()));

            ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configConfiguredPlacement);

            event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);

        }
    }

    private static ConfiguredFeature<?, ?> registerOreFeature (OreGen ore, OreFeatureConfig oreFeatureConfig,
                                                               ConfiguredPlacement configuredPlacement) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(),
                Feature.ORE.configured(oreFeatureConfig).decorated(configuredPlacement)
                        .squared().count(ore.getMaxVeinSize()));

    }
}
