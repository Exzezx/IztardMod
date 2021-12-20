package net.exzezx.iztard.data;

import net.exzezx.iztard.Iztard;
import net.exzezx.iztard.Registrys.IztardItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModelGenerator extends ItemModelProvider {
    public ModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Iztard.modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture(IztardItems.KALUNG_ITEM.getRegistryName().toString(), new ResourceLocation("item/generated"),"layer0", new ResourceLocation("iztard:item/kalung_ajaib"));
        singleTexture(IztardItems.PowerGe.getRegistryName().toString(),new ResourceLocation("item/generated"),"layer0", new ResourceLocation("iztard:item/power_ge"));
    }
}
