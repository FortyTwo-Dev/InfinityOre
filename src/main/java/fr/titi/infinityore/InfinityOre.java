package fr.titi.infinityore;

import fr.titi.infinityore.init.ModBlocks;
import fr.titi.infinityore.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InfinityOre.MODID)
public class InfinityOre {

    public static final String MODID = "infinityore";

    public InfinityOre() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);

    }




    private void setup (final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void clientSetup(FMLClientSetupEvent event) {


    }
}
