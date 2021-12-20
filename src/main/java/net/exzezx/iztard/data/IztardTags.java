package net.exzezx.iztard.data;

import net.exzezx.iztard.Iztard;
import net.exzezx.iztard.Registrys.IztardItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosApi;

import javax.annotation.Nullable;

public class IztardTags {
   public static class Items extends ItemTagsProvider {
        public Items(DataGenerator generator,BlockTagsProvider blockTagsProvider ,ExistingFileHelper helper) {
            super(generator, blockTagsProvider, Iztard.modId, helper);
        }
        public static final ITag.INamedTag<Item>HEADS = tags("heads_slot");
        public static final ITag.INamedTag<Item>CHEST = tags("chests_slot");
        public static final ITag.INamedTag<Item>LEGGINGS = tags("leggings_slot");
        public static final ITag.INamedTag<Item>SANDAL = tags("sandal_slot");



        @Override
        protected void registerTags() {
            getOrCreateBuilder(HEADS).add(new Item[]{
                IztardItems.PowerGe
            });
            getOrCreateBuilder(CHEST).add(new Item[]{
                    IztardItems.KALUNG_ITEM
            });
            getOrCreateBuilder(LEGGINGS).add(new Item[]{

            });
            getOrCreateBuilder(SANDAL).add(new Item[]{

            });
        }
        private static ITag.INamedTag<Item>tag(String name){
            return ItemTags.createOptional(new ResourceLocation(Iztard.modId,name));
        }
        private static ITag.INamedTag<Item>tags(String name){
            return ItemTags.createOptional(new ResourceLocation(CuriosApi.MODID,name));
        }
   }
   public static class Blocks extends BlockTagsProvider {

       public static final ITag.INamedTag<Block>GLOW = tag("glowing");

       public Blocks(DataGenerator dataGenerator,  @Nullable ExistingFileHelper existingFileHelper) {
           super(dataGenerator, Iztard.modId, existingFileHelper);
       }

       @Override
       protected void registerTags() {
           getOrCreateBuilder(GLOW).add(net.minecraft.block.Blocks.GLOWSTONE, net.minecraft.block.Blocks.SEA_LANTERN);
       }
       private static ITag.INamedTag<Block>tag(String name){
           return BlockTags.createOptional(new ResourceLocation(Iztard.modId,name));
       }
   }
}
