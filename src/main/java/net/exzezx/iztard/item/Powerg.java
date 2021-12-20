package net.exzezx.iztard.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.exzezx.iztard.EventBus.IztardItemCapability;
import net.exzezx.iztard.Iztard;
import net.exzezx.iztard.item.models.PowerGModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nullable;
import java.util.UUID;

public class Powerg extends Item {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Iztard.modId + ":textures/curios/golden_clawns.png");
    public Powerg(Properties properties) {
        super(properties.maxStackSize(1));
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return IztardItemCapability.createProvider(new ICurio() {
            private Object model;
            @Override
            public void curioTick(String identifier, int index, LivingEntity livingEntity) {
                if (livingEntity instanceof PlayerEntity){
                    if (canEquip(identifier, livingEntity)){
                        ((PlayerEntity) livingEntity).abilities.allowFlying = true;
                        ((PlayerEntity) livingEntity).abilities.isFlying = true;
                    }
                    if (canUnequip(identifier, livingEntity)){
                        ((PlayerEntity) livingEntity).abilities.allowFlying = false;
                        ((PlayerEntity) livingEntity).abilities.isFlying =false;
                    }
                }

            }

            @Override
            public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid) {
                Multimap<Attribute, AttributeModifier> attb = HashMultimap.create();
                attb.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, Iztard.modId + ":speed_bonus",0.4D, AttributeModifier.Operation.ADDITION));
                return attb;
            }

            @Override
            public boolean canRender(String identifier, int index, LivingEntity livingEntity) {
                return true;
            }

            @Override
            public void render(String identifier, int index, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                if (!(this.model instanceof PowerGModel)) {
                    model = new PowerGModel<>();
                }
                PowerGModel<?> powers = (PowerGModel<?>) this.model;
                ICurio.RenderHelper.followHeadRotations(livingEntity, powers.powerg);
                IVertexBuilder vertexBuilder = ItemRenderer
                        .getBuffer(renderTypeBuffer, powers.getRenderType(TEXTURES), false,
                                false);
                powers.render(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
                        1.0F);
            }
        });
    }
}
