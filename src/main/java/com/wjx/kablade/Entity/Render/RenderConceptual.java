package com.wjx.kablade.Entity.Render;

import com.wjx.kablade.Entity.EntityConceptual;
import com.wjx.kablade.Entity.EntityThunderEdgeAttack;
import com.wjx.kablade.Entity.EntityTuna;
import com.wjx.kablade.util.Vec3f;
import com.wjx.kablade.util.renderingQueue.Actions.ActionBase;
import com.wjx.kablade.util.renderingQueue.RenderModel;
import com.wjx.kablade.util.renderingQueue.RenderObj;
import com.wjx.kablade.util.renderingQueue.RenderQueue;
import mods.flammpfeil.slashblade.client.model.obj.Face;
import mods.flammpfeil.slashblade.client.model.obj.WavefrontObject;
import mods.flammpfeil.slashblade.util.ResourceLocationRaw;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;

public class RenderConceptual extends Render<EntityConceptual> {
    public RenderConceptual(RenderManager manager) {
        super(manager);

    }




    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(@Nonnull EntityConceptual entityConceptual) {
        return null;
    }

    public static final ResourceLocation EF1 = new ResourceLocation("kablade:effects/cnzy/ef1.png");
    public static final ResourceLocation EF2 = new ResourceLocation("kablade:effects/cnzy/ef2.png");

    public static final ResourceLocation EF3_1 = new ResourceLocation("kablade:effects/cnzy/ef3/1.png");
    public static final ResourceLocation EF3_2 = new ResourceLocation("kablade:effects/cnzy/ef3/2.png");
    public static final ResourceLocation EF3_3 = new ResourceLocation("kablade:effects/cnzy/ef3/3.png");

    public static final WavefrontObject modelE1 = new WavefrontObject(new ResourceLocationRaw("kablade:effects/cnzy/edg/ed1.obj"));
    public static final ResourceLocation texE1 = new ResourceLocation("kablade:effects/cnzy/edg/1.png");



    @Override
    public void doRender(@Nonnull EntityConceptual entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        Tessellator tessellator = Tessellator.getInstance();

        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GL11.glDisable(GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL_BLEND);//开启混合
        Minecraft mc = Minecraft.getMinecraft();

        float time = entity.ticksExisted + partialTicks;

        float lastx = OpenGlHelper.lastBrightnessX;
        float lasty = OpenGlHelper.lastBrightnessY;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        rendIntro(entity, x, y, z, entityYaw, partialTicks, tessellator, bufferBuilder,mc,time);

        rendEdg(entity, x, y, z, entityYaw, partialTicks, tessellator,mc,time);





        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lastx, lasty);
        OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE, GL11.GL_ZERO);
        GL11.glEnable(GL_LIGHTING);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL_BLEND);//开启混合
    }




    public void rendIntro(EntityConceptual entity, double x, double y, double z, float entityYaw, float partialTicks,Tessellator tessellator, BufferBuilder bufferBuilder,Minecraft mc,float time){
        GlStateManager.pushMatrix();

        GlStateManager.translate(x, y + 1, z);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GlStateManager.rotate(-entityYaw, 0f, 1f, 0f);


        GL11.glRotatef(-mc.getRenderManager().playerViewY,0,1,0);
        GL11.glRotatef(mc.getRenderManager().options.thirdPersonView==2?-mc.getRenderManager().playerViewX:mc.getRenderManager().playerViewX,1,0,0);
        //GlStateManager.translate(0, -0.25, 0);
        GlStateManager.scale(10,10,1);
        GlStateManager.scale(Math.sin(time/30*Math.PI*0.5),Math.sin(time/30*Math.PI*0.5),1);

        if(time>15&&time<=30){
            float val =  Math.max((float) (1f-Math.sin((time-15)/15*Math.PI*0.5)),0);
            GlStateManager.color(1f,1f,1f, val);
        }else if(time>30){
            GlStateManager.color(1f,1f,1f, 0);
        }
        else {
            GlStateManager.color(1,1,1,1);
        }




        Minecraft.getMinecraft().getTextureManager().bindTexture(EF2);
        Tessellator tess = Tessellator.getInstance();
        BufferBuilder buffer = tess.getBuffer();



        //GlStateManager.rotate(-mc.getRenderManager().playerViewX, 1, 0, 0);


        buffer.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        buffer.pos(-0.5d, -0.5d, 0).tex(0, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, -0.5d, 0).tex(1, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, 0.5d, 0).tex(1, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(-0.5d, 0.5d, 0).tex(0, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        tess.draw();
        GlStateManager.popMatrix();



        GlStateManager.pushMatrix();

        GlStateManager.translate(x, y + 1, z-0.01);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GlStateManager.rotate(-entityYaw, 0f, 1f, 0f);


        GL11.glRotatef(-mc.getRenderManager().playerViewY+entityYaw,0,1,0);
        GL11.glRotatef(mc.getRenderManager().options.thirdPersonView==2?-mc.getRenderManager().playerViewX:mc.getRenderManager().playerViewX,1,0,0);

        GlStateManager.scale(80,80,1);
        GlStateManager.scale(Math.sin(time/30*Math.PI*0.5),Math.sin(time/30*Math.PI*0.5),1);

        if(time>1&&time<=10){
            float val =  Math.max((float) (1f-Math.sin((time-1)/9*Math.PI*0.5)),0);
            GlStateManager.color(1f,1f,1f, val);
        }else if(time>10){
            GlStateManager.color(1f,1f,1f, 0);
        }
        else {
            GlStateManager.color(1,1,1,1);
        }




        Minecraft.getMinecraft().getTextureManager().bindTexture(EF1);




        buffer.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        buffer.pos(-0.5d, -0.5d, 0).tex(0, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, -0.5d, 0).tex(1, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, 0.5d, 0).tex(1, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(-0.5d, 0.5d, 0).tex(0, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        tess.draw();
        GlStateManager.popMatrix();


        GlStateManager.pushMatrix();

        GlStateManager.translate(x, y + 1, z);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GlStateManager.rotate(-entityYaw, 0f, 1f, 0f);


        GL11.glRotatef(-mc.getRenderManager().playerViewY,0,1,0);
        GL11.glRotatef(mc.getRenderManager().options.thirdPersonView==2?-mc.getRenderManager().playerViewX:mc.getRenderManager().playerViewX,1,0,0);

        GL11.glRotatef(Math.max((float) (1f-Math.sin((time-15)/15*Math.PI*0.5)),0)*30,0,0,1);
        //GlStateManager.translate(0, -0.25, 0);
        GlStateManager.scale(4,4,1);
        GlStateManager.scale(Math.sin(time/30*Math.PI*0.5),Math.sin(time/30*Math.PI*0.5),1);

        if(time>15&&time<=30){
            float val =  Math.max((float) (1f-Math.sin((time-15)/15*Math.PI*0.5)),0);
            GlStateManager.color(1f,0.8f,1f, val);
        }else if(time>30){
            GlStateManager.color(1f,0.8f,1f, 0);
        }
        else {
            GlStateManager.color(1,0.8f,1,1);
        }




        Minecraft.getMinecraft().getTextureManager().bindTexture(EF3_1);




        //GlStateManager.rotate(-mc.getRenderManager().playerViewX, 1, 0, 0);


        buffer.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        buffer.pos(-0.5d, -0.5d, 0).tex(0, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, -0.5d, 0).tex(1, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, 0.5d, 0).tex(1, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(-0.5d, 0.5d, 0).tex(0, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        tess.draw();
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();

        GlStateManager.translate(x, y + 1, z);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GlStateManager.rotate(-entityYaw, 0f, 1f, 0f);


        GL11.glRotatef(-mc.getRenderManager().playerViewY,0,1,0);
        GL11.glRotatef(mc.getRenderManager().options.thirdPersonView==2?-mc.getRenderManager().playerViewX:mc.getRenderManager().playerViewX,1,0,0);

        GL11.glRotatef(-Math.max((float) (1f-Math.sin((time-15)/15*Math.PI*0.5)),0)*20,0,0,1);
        GlStateManager.translate(0, 0, 0.01);
        GlStateManager.scale(4,4,1);
        GlStateManager.scale(Math.sin(time/30*Math.PI*0.5),Math.sin(time/30*Math.PI*0.5),1);

        if(time>15&&time<=30){
            float val =  Math.max((float) (1f-Math.sin((time-15)/15*Math.PI*0.5)),0);
            GlStateManager.color(1f,0.6f,1f, val);
        }else if(time>30){
            GlStateManager.color(1f,0.6f,1f, 0);
        }
        else {
            GlStateManager.color(1,0.6f,1,1);
        }




        Minecraft.getMinecraft().getTextureManager().bindTexture(EF3_2);




        //GlStateManager.rotate(-mc.getRenderManager().playerViewX, 1, 0, 0);


        buffer.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        buffer.pos(-0.5d, -0.5d, 0).tex(0, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, -0.5d, 0).tex(1, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, 0.5d, 0).tex(1, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(-0.5d, 0.5d, 0).tex(0, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        tess.draw();
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();

        GlStateManager.translate(x, y + 1, z);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GlStateManager.rotate(-entityYaw, 0f, 1f, 0f);


        GL11.glRotatef(-mc.getRenderManager().playerViewY,0,1,0);
        GL11.glRotatef(mc.getRenderManager().options.thirdPersonView==2?-mc.getRenderManager().playerViewX:mc.getRenderManager().playerViewX,1,0,0);

        GL11.glRotatef(Math.max((float) (1f-Math.sin((time-15)/15*Math.PI*0.5)),0)*60,0,0,1);
        GlStateManager.translate(0, 0, 0.02);
        GlStateManager.scale(4,4,1);
        GlStateManager.scale(Math.sin(time/30*Math.PI*0.5),Math.sin(time/30*Math.PI*0.5),1);

        if(time>15&&time<=30){
            float val =  Math.max((float) (1f-Math.sin((time-15)/15*Math.PI*0.5)),0);
            GlStateManager.color(1f,0.6f,1f, val);
        }else if(time>30){
            GlStateManager.color(1f,0.6f,1f, 0);
        }
        else {
            GlStateManager.color(1,0.6f,1,1);
        }




        Minecraft.getMinecraft().getTextureManager().bindTexture(EF3_3);




        //GlStateManager.rotate(-mc.getRenderManager().playerViewX, 1, 0, 0);


        buffer.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        buffer.pos(-0.5d, -0.5d, 0).tex(0, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, -0.5d, 0).tex(1, 1).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(0.5d, 0.5d, 0).tex(1, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        buffer.pos(-0.5d, 0.5d, 0).tex(0, 0).normal(0.0f, 1.0f, 0.0f).endVertex();
        tess.draw();
        GlStateManager.popMatrix();
    }

    public void rendEdg(EntityConceptual entity, double x, double y, double z, float entityYaw, float partialTicks, Tessellator tess,Minecraft mc, float time){

        GlStateManager.pushMatrix();
        /*GlStateManager.translate(x, y+1, z);
        GlStateManager.rotate(-entityYaw, 0f, 1f, 0f);
        GlStateManager.scale(1.05f,1.05f,1.05f);
       // GlStateManager.depthMask(false);
        mc.getTextureManager().bindTexture(texE1);
       // GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        Face.setColor(0xccff66ff);

        modelE1.renderAll();
        Face.resetColor();*/

        entity.queue.doRender(time,x,y,z,entityYaw);

       /* GlStateManager.popMatrix();



        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y+1, z);
        GlStateManager.rotate(-entityYaw, 0f, 1f, 0f);
        mc.getTextureManager().bindTexture(texE1);
        modelE1.renderAll();
       // GlStateManager.depthMask(true);*/

        GlStateManager.popMatrix();


    }
}
