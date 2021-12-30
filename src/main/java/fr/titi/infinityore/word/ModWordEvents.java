package fr.titi.infinityore.word;

import fr.titi.infinityore.word.gen.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "infinityore")
public class ModWordEvents {

    @SubscribeEvent
    public static void biomeLoading(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
    }

}
