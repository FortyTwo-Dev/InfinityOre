package fr.titi.infinityore.utils;

import fr.titi.infinityore.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class InfinityOreTab extends ItemGroup {

    public static final InfinityOreTab TAB = new InfinityOreTab(ItemGroup.TABS.length, "infinitytab");

    public InfinityOreTab(int i, String label) {
        super(i, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.OSMIUM_INGOT.get());
    }
}
