package net.exzezx.iztard.Registrys;

import net.exzezx.iztard.Iztard;
import net.exzezx.iztard.IztardRegistry;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;

public class BiomeRegistry {

    public static final RegistryKey<Biome>MOUNTED = register("mounted");

    private static RegistryKey<Biome>register(String nameBiome){
        IztardRegistry.RegistryMethod.registerBiome(nameBiome, BiomeMaker.makeVoidBiome());
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Iztard.modId,nameBiome));
    }
}
