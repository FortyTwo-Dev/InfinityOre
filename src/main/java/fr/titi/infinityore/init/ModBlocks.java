package fr.titi.infinityore.init;

import fr.titi.infinityore.InfinityOre;
import fr.titi.infinityore.utils.InfinityOreTab;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, InfinityOre.MODID);
    //

    public static final RegistryObject<Block> BLOCK_TEST = createBlock("block_test", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE).strength(3.0f, 3.0f)));


    //
    public static RegistryObject<Block> createBlock(String name, Supplier <? extends Block> supplier) {

        RegistryObject<Block> Block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(Block.get(), new Item.Properties().tab(InfinityOreTab.TAB)));
        return Block;
    }

}
