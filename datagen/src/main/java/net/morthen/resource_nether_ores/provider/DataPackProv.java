package net.morthen.resource_nether_ores.provider;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.morthen.resource_nether_ores.worldgen.OreFeatures;
import net.morthen.resource_nether_ores.worldgen.OrePlacedFeatures;

public class DataPackProv {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.FEATURE, OreFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, OrePlacedFeatures::bootstrap);
}
