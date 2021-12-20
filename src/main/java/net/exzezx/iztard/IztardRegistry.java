package net.exzezx.iztard;

import com.google.common.collect.Lists;
import net.exzezx.iztard.Registrys.BiomeRegistry;
import net.exzezx.iztard.Registrys.IztardItems;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;

import javax.annotation.Nonnull;
import java.util.List;

@Mod.EventBusSubscriber(modid = Iztard.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IztardRegistry {
    public static final List<Item>ITEMS = Lists.newArrayList();
    public static final List<Biome>BIOMES = Lists.newArrayList();

    @SubscribeEvent
    public static void registryItem(RegistryEvent.Register<Item>event){
        new IztardItems();
        for (Item item : ITEMS){
            event.getRegistry().register(item);
        }
    }
    @SubscribeEvent
    public static void registryBiome(RegistryEvent.Register<Biome>event){
        new BiomeRegistry();
        for (Biome biome : BIOMES){
            event.getRegistry().register(biome);
        }
    }

    public static class RegistryMethod {

        public static Item regItem(@Nonnull String name, @Nonnull Item item){
            item.setRegistryName(new ResourceLocation(Iztard.modId,name));
            ITEMS.add(item);
            return item;
        }
        public static Biome registerBiome(String name, Biome biome){
            biome.setRegistryName(new ResourceLocation(Iztard.modId, name));
            BIOMES.add(biome);
            return biome;
        }
    }
}
