package fr.titi.infinityore.utils;


import fr.titi.infinityore.InfinityOre;
import fr.titi.infinityore.init.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModConfiguredFeature {

    public ConfiguredFeature<?, ?> ORE_OSMIUM;

    public void init(){

        ORE_OSMIUM = register("ore_osmium", Feature.ORE.configured(new OreFeatureConfig (OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.OSMIUM_ORE.get().defaultBlockState(), 6))
                .squared()
                .range(34));

    }

    public <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature){

        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);

    }

    @SubscribeEvent
    public void BiomeLoading(BiomeLoadingEvent event){

        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (event.getCategory() != Biome.Category.NETHER){
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_OSMIUM);
        }

    }


}
