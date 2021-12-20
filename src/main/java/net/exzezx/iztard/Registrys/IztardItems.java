package net.exzezx.iztard.Registrys;

import net.exzezx.iztard.Iztard;
import net.exzezx.iztard.IztardRegistry;
import net.exzezx.iztard.item.Powerg;
import net.exzezx.iztard.item.kalungItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.ObjectHolder;

import static net.exzezx.iztard.IztardRegistry.RegistryMethod.regItem;

@ObjectHolder(Iztard.modId)
public class IztardItems {
    public static final Item KALUNG_ITEM = regItem("kalung_ajaib", new kalungItem(new Item.Properties().maxStackSize(1).group(Iztard.GenTab)));
    public static final Item PowerGe = regItem("power_ge", new Powerg(new Item.Properties().group(Iztard.GenTab)));

}
