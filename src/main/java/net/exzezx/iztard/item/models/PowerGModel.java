package net.exzezx.iztard.item.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class PowerGModel <T extends LivingEntity> extends EntityModel<T> {
    public final ModelRenderer powerg;

    public PowerGModel() {
        textureWidth = 64;
        textureHeight = 64;

        powerg = new ModelRenderer(this);
        powerg.setRotationPoint(-1.0F, -9.0F, 0.0F);
        powerg.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
        powerg.setTextureOffset(24, 12).addBox(-3.0F, -1.0F, -5.0F, 8.0F, 4.0F, 1.0F, 0.0F, false);
        powerg.setTextureOffset(24, 23).addBox(-4.0F, -3.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        powerg.setTextureOffset(24, 20).addBox(4.0F, -3.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        powerg.setTextureOffset(0, 4).addBox(5.0F, -3.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        powerg.setTextureOffset(0, 0).addBox(-4.0F, -3.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        powerg.setTextureOffset(6, 16).addBox(5.0F, -3.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        powerg.setTextureOffset(0, 12).addBox(-1.0F, -4.0F, -5.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
        powerg.setTextureOffset(24, 17).addBox(0.0F, -3.0F, 4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        powerg.setTextureOffset(18, 12).addBox(-4.0F, -3.0F, 4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        powerg.setTextureOffset(12, 16).addBox(-4.0F, -3.0F, 2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        powerg.setTextureOffset(0, 16).addBox(-4.0F, -3.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        powerg.setTextureOffset(12, 12).addBox(5.0F, -3.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        powerg.setTextureOffset(24, 5).addBox(4.0F, -3.0F, 4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        powerg.setTextureOffset(12, 16).addBox(5.0F, -1.0F, -5.0F, 1.0F, 4.0F, 10.0F, 0.0F, false);
        powerg.setTextureOffset(0, 12).addBox(-4.0F, -1.0F, -5.0F, 1.0F, 4.0F, 10.0F, 0.0F, false);
        powerg.setTextureOffset(24, 0).addBox(-3.0F, -1.0F, 4.0F, 8.0F, 4.0F, 1.0F, 0.0F, false);
    }
    @Override
    public void setRotationAngles(T t, float v, float v1, float v2, float v3, float v4) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int light, int overlay, float v, float v1, float v2, float v3) {
        this.powerg.render(matrixStack, iVertexBuilder, light, overlay);
    }
}
