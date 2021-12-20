package net.exzezx.iztard.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeServer()){
            IztardTags.Blocks blocks = new IztardTags.Blocks(generator,existingFileHelper);
            generator.addProvider(new IztardTags.Items(generator,blocks,existingFileHelper));
            generator.addProvider(new LangGenerator(generator));
            generator.addProvider(new RecipesGenerator(generator));
            generator.addProvider(new AdvencementGenerator(generator, existingFileHelper));
        }
        if (event.includeClient()){
            generator.addProvider(new ModelGenerator(generator, existingFileHelper));
        }
    }
}
