package net.exzezx.iztard.data;

import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ForgeLootTableProvider;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTableGenerator extends LootTableProvider {
    public LootTableGenerator(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> p_validate_1_, ValidationTracker p_validate_2_) {

    }
}
