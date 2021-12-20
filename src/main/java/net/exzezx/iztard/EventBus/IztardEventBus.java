package net.exzezx.iztard.EventBus;

import net.exzezx.iztard.Iztard;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;


public class IztardEventBus {

    private static final Logger logger = LogManager.getLogger(Iztard.modId);
    public static RegistryKey<World>OTHER;

    @Mod.EventBusSubscriber(modid = Iztard.modId,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class BOTH {
        @SubscribeEvent
        public static void setup(FMLCommonSetupEvent event){
            logger.warn("Start Iztard Setup");
            OTHER = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(Iztard.modId,"other_dimension"));
        }

        @SubscribeEvent
        public static void enqueueIMC(InterModEnqueueEvent event){
            logger.warn("send ModEnqueue");
            SlotTypePreset[] type = {
                    SlotTypePreset.BRACELET,
                    SlotTypePreset.CHARM,
                    SlotTypePreset.CURIO,
                    SlotTypePreset.BACK,
                    SlotTypePreset.BELT,
                    SlotTypePreset.BODY,
                    SlotTypePreset.HANDS,
                    SlotTypePreset.RING,
                    SlotTypePreset.NECKLACE,
            };
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                    ()-> new SlotTypeMessage.Builder("heads_slot").priority(1).icon(PlayerContainer.EMPTY_ARMOR_SLOT_HELMET).build());
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                    ()-> new SlotTypeMessage.Builder("chests_slot").priority(2).icon(PlayerContainer.EMPTY_ARMOR_SLOT_CHESTPLATE).build());
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                    ()-> new SlotTypeMessage.Builder("leggings_slot").priority(3).icon(PlayerContainer.EMPTY_ARMOR_SLOT_LEGGINGS).build());
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                    ()-> new SlotTypeMessage.Builder("sandal_slot").priority(4).icon(PlayerContainer.EMPTY_ARMOR_SLOT_BOOTS).build());
            InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE,
                    ()-> new SlotTypeMessage.Builder("power_slot").priority(5).icon(PlayerContainer.EMPTY_ARMOR_SLOT_SHIELD).build());
            for (SlotTypePreset typePreset : type){
                InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, ()-> typePreset.getMessageBuilder().build());
            }
        }
        @SubscribeEvent
        public void processIMC(final InterModProcessEvent event) {
            logger.warn("Start InterModProcess");
        }
    }
    @Mod.EventBusSubscriber(modid = Iztard.modId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class CLIENT {
        @SubscribeEvent
        public static void clientHandler(FMLClientSetupEvent event){
            logger.warn("start client side",event.getMinecraftSupplier().get().gameSettings);
        }

    }

}
