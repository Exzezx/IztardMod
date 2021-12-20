package net.exzezx.iztard.item.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class KalungModel extends BipedModel<LivingEntity> {
    private final ModelRenderer kalung;
    public KalungModel() {
        super(2.0F);
        kalung = new ModelRenderer(this);
        kalung.setRotationPoint(0.0F, 1.0F, 0.0F);
        kalung.setTextureOffset(5, 6).addBox(-4.0F, -1.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(6, 3).addBox(3.0F, -1.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(9, 5).addBox(2.0F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(4, 9).addBox(-3.0F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(0, 9).addBox(-2.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(8, 8).addBox(-1.0F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(0, 7).addBox(0.0F, 1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(7, 1).addBox(1.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(0, 4).addBox(-1.0F, 2.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(2, 1).addBox(-4.0F, -1.0F, -2.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);
        kalung.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 0.0F, false);
        kalung.setTextureOffset(0, 1).addBox(3.0F, -1.0F, -2.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);

    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder vertexBuilder, int a, int b, float c, float d, float e, float f) {
        this.kalung.render(matrixStack, vertexBuilder, a, b, c, d, e, f);
    }
}
