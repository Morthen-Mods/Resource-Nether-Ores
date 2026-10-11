package net.morthen.resource_nether_ores.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.morthen.resource_nether_ores.OreConstants;
import net.morthen.resource_nether_ores.registries.BlockRegistry;
import net.morthen.resourcelibrary.registration.RegistryObject;

public class OreFeatures {

    public static final ResourceKey<Feature> NETHER_COAL_ORE_FEATURE = createKey("nether_coal_ore");
    public static final ResourceKey<Feature> NETHER_COPPER_ORE_FEATURE = createKey("nether_copper_ore");
    public static final ResourceKey<Feature> NETHER_DIAMOND_ORE_FEATURE = createKey("nether_diamond_ore");
    public static final ResourceKey<Feature> NETHER_EMERALD_ORE_FEATURE = createKey("nether_emerald_ore");
    public static final ResourceKey<Feature> NETHER_IRON_ORE_FEATURE = createKey("nether_iron_ore");
    public static final ResourceKey<Feature> NETHER_LAPIS_ORE_FEATURE = createKey("nether_lapis_ore");
    public static final ResourceKey<Feature> NETHER_REDSTONE_ORE_FEATURE = createKey("nether_redstone_ore");

    public static void bootstrap(BootstrapContext<Feature> context) {
        context.register(NETHER_COAL_ORE_FEATURE, getOreFeature(BlockRegistry.NETHER_COAL_ORE, 17));
        context.register(NETHER_COPPER_ORE_FEATURE, getOreFeature(BlockRegistry.NETHER_COPPER_ORE, 8));
        context.register(NETHER_DIAMOND_ORE_FEATURE, getOreFeature(BlockRegistry.NETHER_DIAMOND_ORE, 8));
        context.register(NETHER_EMERALD_ORE_FEATURE, getOreFeature(BlockRegistry.NETHER_EMERALD_ORE, 7));
        context.register(NETHER_IRON_ORE_FEATURE, getOreFeature(BlockRegistry.NETHER_IRON_ORE, 8));
        context.register(NETHER_LAPIS_ORE_FEATURE, getOreFeature(BlockRegistry.NETHER_LAPIS_ORE, 7));
        context.register(NETHER_REDSTONE_ORE_FEATURE, getOreFeature(BlockRegistry.NETHER_REDSTONE_ORE, 8));
    }

    private static OreFeature getOreFeature(RegistryObject<Block> block, int size) {
        return new OreFeature(new BlockMatchTest(Blocks.NETHERRACK),
                block.get().defaultBlockState(), size);
    }

    private static ResourceKey<Feature> createKey(String id) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(OreConstants.MOD_ID, id));
    }
}
