package net.morthen.resource_nether_ores;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.morthen.resource_nether_ores.provider.*;
import net.morthen.resource_nether_ores.registries.BlockRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;

@Mod(OreConstants.MOD_ID)
public class ResourceNetherOres {

    public ResourceNetherOres(IEventBus bus) {
        BlockRegistry.init();
    }

    @EventBusSubscriber(modid = OreConstants.MOD_ID)
    public static class Datagen {
        @SubscribeEvent
        public static void generate(GatherDataEvent.Client event) {
            event.createWorldRegistryObjects(DataPackProv.BUILDER, Set.of(OreConstants.MOD_ID));
            event.createReloadableRegistryObjects(new RegistrySetBuilder()
                    .add(Registries.LOOT_TABLE, BlockLootProv.create()), Set.of(OreConstants.MOD_ID));
            event.createBlockAndItemTags(BlockTagProv::new, ItemTagProv::new);
            event.createProvider(ModelProv::new);
        }
    }
}
