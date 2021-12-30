package fr.titi.infinityore.data.lang;

import fr.titi.infinityore.InfinityOre;
import fr.titi.infinityore.data.DataGeneration;
import fr.titi.infinityore.init.ModBlocks;
import fr.titi.infinityore.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class LangGenerator extends LanguageProvider {

    public LangGenerator(DataGenerator generator, String modid, String locale) {
        super(generator, modid, locale);
    }

    public LangGenerator(DataGenerator generator) {
        super(generator, InfinityOre.MODID, "en_us");
    }

    private void block(PrefixHelper helper) {
        helper.add(ModBlocks.OSMIUM_ORE.get(), "Osmium ore");
    }

    private void Item(PrefixHelper helper) {
        helper.add(ModItems.OSMIUM_INGOT.get(), "Osmium Ingot");
    }

    private void Categories(PrefixHelper helper) {

        add("itemGroup.infinityoretab", "InfinityOreTab");
    }

    @Override
    public void addBlock(Supplier<? extends Block> key, String name) {
        super.addBlock(key, name);
    }

    @Override
    protected void addTranslations() {
        PrefixHelper helper = new PrefixHelper(this);

        block(helper);
        Item(helper);
        Categories(helper);

    }

    @Override
    public void add(Block key, String name) {
        if (key != null) super.add(key, name);
    }

    @Override
    public void add(Item key, String name) {
        if (key != null) super.add(key, name);
    }
    public static class PrefixHelper {
        private LangGenerator generator;
        private String prefix;

        public PrefixHelper(LangGenerator generator){
            this.generator = generator;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix + ".";
        }

        public void add(String translationKey, String translation) {
            generator.add(prefix + translationKey, translation);
        }

        public void add(Block key, String name) {
            if (key != null) generator.add(key, name);
        }

        public void add(Item key, String name) {
            if (key != null) generator.add(key, name);
        }

    }
}
