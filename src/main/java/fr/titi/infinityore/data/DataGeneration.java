package fr.titi.infinityore.data;

import fr.titi.infinityore.InfinityOre;
import fr.titi.infinityore.data.lang.LangGenerator;
import fr.titi.infinityore.data.recipe.RecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = InfinityOre.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData (final GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();

        if (event.includeServer()) {
            generator.addProvider(new RecipeGenerator(generator));

        }
        if (event.includeClient()) {
            generator.addProvider(new LangGenerator(generator));

        }

    }

}
