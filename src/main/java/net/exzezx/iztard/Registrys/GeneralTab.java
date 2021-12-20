package net.exzezx.iztard.Registrys;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GeneralTab extends ItemGroup {
    public GeneralTab() {
        super("iztard.general");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(IztardItems.KALUNG_ITEM);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
