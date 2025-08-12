package com.wjx.kablade.Entity.Render;

import com.wjx.kablade.Entity.EntityFreezeDomain;
import com.wjx.kablade.Entity.EntityFreezeDomainEx;
import com.wjx.kablade.Main;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderFreezeDomainEx extends Render<EntityFreezeDomainEx> {
    public RenderFreezeDomainEx(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFreezeDomainEx entity) {
        return null;
    }

    @Override
    public void doRender(EntityFreezeDomainEx entity, double x, double y, double z, float entityYaw, float partialTicks) {

    }
}
