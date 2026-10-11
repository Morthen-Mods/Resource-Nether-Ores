package net.morthen.resource_nether_ores.provider;

import net.minecraft.core.registries.SingleRegistryBootstrap;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.morthen.resource_nether_ores.registries.BlockRegistry;
import net.morthen.resourcelibrary.registration.RegistryObject;

import java.util.List;
import java.util.Set;

public class BlockLootProv extends BlockLootSubProvider {

    public static SingleRegistryBootstrap<LootTable> create() {
        return new LootTableProvider(Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(BlockLootProv::new, LootContextParamSets.BLOCK)));
    }

    protected BlockLootProv(LootTableSubProvider.Context context) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), context);
    }

    @Override
    protected void generate() {
        this.add(BlockRegistry.NETHER_COAL_ORE.get(), createOreDrop(BlockRegistry.NETHER_COAL_ORE.get(), Items.COAL));
        this.add(BlockRegistry.NETHER_COPPER_ORE.get(), createCopperOreDrops(BlockRegistry.NETHER_COPPER_ORE.get()));
        this.add(BlockRegistry.NETHER_IRON_ORE.get(), createOreDrop(BlockRegistry.NETHER_IRON_ORE.get(), Items.RAW_IRON));
        this.add(BlockRegistry.NETHER_DIAMOND_ORE.get(), createOreDrop(BlockRegistry.NETHER_DIAMOND_ORE.get(), Items.DIAMOND));
        this.add(BlockRegistry.NETHER_EMERALD_ORE.get(), createOreDrop(BlockRegistry.NETHER_EMERALD_ORE.get(), Items.EMERALD));
        this.add(BlockRegistry.NETHER_LAPIS_ORE.get(), createLapisOreDrops(BlockRegistry.NETHER_LAPIS_ORE.get()));
        this.add(BlockRegistry.NETHER_REDSTONE_ORE.get(), createRedstoneOreDrops(BlockRegistry.NETHER_REDSTONE_ORE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
