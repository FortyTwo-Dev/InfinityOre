package fr.titi.infinityore.init;

import fr.titi.infinityore.InfinityOre;
import fr.titi.infinityore.utils.InfinityOreTab;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InfinityOre.MODID);

    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () ->
            new Item(new Item.Properties().stacksTo(16).tab(InfinityOreTab.TAB)));

}
