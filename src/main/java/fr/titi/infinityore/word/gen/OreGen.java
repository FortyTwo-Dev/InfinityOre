package fr.titi.infinityore.word.gen;


import fr.titi.infinityore.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreGen {
    //generation de minerais
    //osmium
    ORE_OSMIUM(Lazy.of(ModBlocks.OSMIUM_ORE), 8, 25, 50);

    //autre

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreGen(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreGen get(Block block) {
        for (OreGen ore : values()) {
            if(block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}




