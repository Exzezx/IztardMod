package net.exzezx.iztard.data;

import net.exzezx.iztard.Iztard;
import net.exzezx.iztard.Registrys.IztardItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(DataGenerator gen) {
        super(gen, Iztard.modId, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("curios.identifier.heads_slot","Heads");
        add("curios.identifier.chests_slot","Chested");
        add("curios.identifier.leggings_slot","Leggings");
        add("curios.identifier.sandal_slot","Sandals");
        add(IztardItems.KALUNG_ITEM, "Kalung Ajaib");
        add(IztardItems.PowerGe,"GoldenClaws");
        add("itemGroup.iztard.general","Iz GeneralTab");
    }
}
