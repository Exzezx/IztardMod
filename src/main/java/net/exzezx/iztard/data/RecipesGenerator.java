package net.exzezx.iztard.data;

import net.exzezx.iztard.Registrys.IztardItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;

import java.util.function.Consumer;

public class RecipesGenerator extends RecipeProvider {

    public RecipesGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(IztardItems.KALUNG_ITEM)
                .patternLine("aaa")
                .patternLine("a a")
                .patternLine(" b ")
                .key('a', Items.GOLD_INGOT)
                .key('b', Items.DIAMOND)
                .addCriterion("kalung_ajaib", InventoryChangeTrigger.Instance.forItems(IztardItems.KALUNG_ITEM))
                .build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(Items.STRING).addIngredient(Items.WHITE_WOOL).
                addCriterion("wool_to_string", InventoryChangeTrigger.Instance.forItems(Items.WHITE_WOOL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(IztardItems.PowerGe)
                .patternLine("xzx")
                .patternLine("xxx")
                .patternLine("xxx")
                .key('x', Items.GOLD_INGOT)
                .key('z', Items.DIAMOND)
                .addCriterion("power_ge", InventoryChangeTrigger.Instance.forItems(IztardItems.PowerGe))
                .build(consumer);

    }
}
