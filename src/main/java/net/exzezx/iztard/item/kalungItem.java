package net.exzezx.iztard.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.exzezx.iztard.EventBus.IztardItemCapability;
import net.exzezx.iztard.Iztard;
import net.exzezx.iztard.item.models.KalungModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nullable;
import java.util.UUID;

public class kalungItem extends Item {
    public static final ResourceLocation TEXTURES = new ResourceLocation(
            Iztard.modId + ":textures/curios/kalung.png"
    );
    public kalungItem(Properties properties) {
        super(properties);
    }

    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return IztardItemCapability.createProvider(new ICurio() {
            private Object model;
            public void curioTick(String identifier, int index, LivingEntity livingEntity) {
                if (this.canUnequip(identifier, livingEntity)){
                    livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE,1000,3, true, true));
                    livingEntity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 1000, 2, true, true));

                }
            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> atts = HashMultimap.create();
                atts.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, Iztard.modId + ":attack_damage_bonus", 5
                , AttributeModifier.Operation.ADDITION));
                return atts;
            }

            public boolean canRender(String identifier, int index, LivingEntity livingEntity) {
                return true;
            }

            public void render(String identifier, int index, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

                if (!(this.model instanceof KalungModel)){
                    model = new KalungModel();
                }
                KalungModel kalung = (KalungModel) this.model;

                ICurio.RenderHelper.followBodyRotations(livingEntity,kalung);
                kalung.setLivingAnimations(livingEntity, limbSwing, limbSwingAmount, partialTicks);
                kalung.setRotationAngles(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                IVertexBuilder builder = ItemRenderer
                        .getBuffer(renderTypeBuffer, kalung.getRenderType(TEXTURES), false,
                                stack.hasEffect());
                kalung.render(matrixStack,builder, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        });
    }

    public boolean hasEffect(ItemStack p_77636_1_) {
        return true;
    }
}
