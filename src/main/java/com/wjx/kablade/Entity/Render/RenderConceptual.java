package com.wjx.kablade.Entity.Render;

import com.wjx.kablade.Entity.EntityConceptual;
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

import static org.lwjgl.opengl.GL11.*;

public class RenderConceptual extends Render<EntityConceptual> {
    public RenderConceptual(RenderManager manager) {
        super(manager);

    }

    private void initializeQueue(EntityConceptual entity) {  
        if (entity.queue == null) {  
            entity.queue = new RenderQueue();

            RenderModel model1 = new RenderModel(modelE1);  
            RenderModel model2 = new RenderModel(modelE2);  
            model1.texModel = texE1;  
            model2.texModel = texE1;  
            model1.objColor = 0xFFFFCCFF;  
            model2.objColor = 0xFFFFCCFF;

            RenderObj obj1 = new RenderObj(-1f,2.2f,1.2f,5,-14,122,2,2,2);
            RenderObj obj3 = new RenderObj(-0.8f,2.3f,1.8f,5,-14,122,2,2,2);
            RenderObj obj4 = new RenderObj(-0.7f,2.6f,2f,18,-14,90,2,2,2);
            RenderObj obj6 = new RenderObj(1.6f,3.4f,2.1f,-1.4f,-7.3f,-3.55f,2,2,2);
            RenderObj obj8 = new RenderObj(-1.3f,1.3f,1.2f,60f,68f,-71f,2,2,2);
            RenderObj obj9 = new RenderObj(-1.1f,2.7f,2f,18,-14,90,1.2f,1.2f,1.2f);
            RenderObj obj11 = new RenderObj(-2.1f,1.6f,-1.5f,14.6f,10.4f,-27.4f,2f,2f,2f);

            RenderObj obj2 = new RenderObj(1.5f,1.5f,2.5f,-30,57.5f,0,1.2f,1.2f,1.2f);
            RenderObj obj5 = new RenderObj(1.1f,2.3f,2.7f,-22f,53f,-2.5f,1.2f,1.2f,1.2f);
            RenderObj obj7 = new RenderObj(0f,1f,0f,-22f,53f,-2.5f,1.2f,1.2f,1.2f);
            RenderObj obj10 = new RenderObj(0.8f,2.7f,2.7f,71,-18f,-72,1.5f,1.5f,1.5f);

            ActionBase o1_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,0, false);
            ActionBase o1_2 = new ActionBase((byte)2,new Vec3f(0,0,0),5,0, false);
            ActionBase o1_3 = new ActionBase((byte)2,new Vec3f(2,2,2),8,0,(byte)7, true);
            ActionBase o1_4 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),12,0,true);
            ActionBase o1_5 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),15,0,( byte) 7,false);
            o1_5.doRemove = true;

            ActionBase o2_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,1, false);
            ActionBase o2_2 = new ActionBase((byte)2,new Vec3f(0,0,0),5,1, false);
            ActionBase o2_3 = new ActionBase((byte)2,new Vec3f(1.2f,1.2f,1.2f),8,1,(byte)7, true);
            ActionBase o2_4 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),12,1,true);
            ActionBase o2_5 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),15,1,( byte) 7,false);
            o2_5.doRemove = true;

            ActionBase o3_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,2, false);
            ActionBase o3_2 = new ActionBase((byte)2,new Vec3f(0,0,0),7,2, false);
            ActionBase o3_3 = new ActionBase((byte)2,new Vec3f(2,2,2),12,2,(byte)7, true);
            ActionBase o3_4 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),22,2, true);
            ActionBase o3_5 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),24,2,(byte)7,false);
            o3_5.doRemove = true;

            ActionBase o4_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,3, false);
            ActionBase o4_2 = new ActionBase((byte)2,new Vec3f(0,0,0),7,3, false);
            ActionBase o4_3 = new ActionBase((byte)2,new Vec3f(2,2,2),12,3,(byte)7, true);
            ActionBase o4_4 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),24,3, true);
            ActionBase o4_5 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),40,3,(byte)7,false);
            o4_5.doRemove = true;

            ActionBase o5_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,4, false);
            ActionBase o5_2 = new ActionBase((byte)2,new Vec3f(0,0,0),7,4, false);
            ActionBase o5_3 = new ActionBase((byte)2,new Vec3f(1.2f,1.2f,1.2f),12,4,(byte)7, true);
            ActionBase o5_4 = new ActionBase((byte)1,new Vec3f(0f,0f,0f),12,4,true);
            ActionBase o5_5 = new ActionBase((byte)0,new Vec3f(0f,0f,0f),12,4,true);
            ActionBase o5_6 = new ActionBase((byte)0,new Vec3f(0.9f,2.4f,2.7f),20,4,( byte) 7,false);
            ActionBase o5_7 = new ActionBase((byte)1,new Vec3f(-19f,73f,-5f),20,4,( byte) 7,false);
            ActionBase o5_8 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),15,4, true);
            ActionBase o5_9 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),20,4,(byte)7, false);
            o5_9.doRemove = true;

            ActionBase o6_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,5, false);
            ActionBase o6_2 = new ActionBase((byte)2,new Vec3f(0,0,0),7,5, false);
            ActionBase o6_3 = new ActionBase((byte)2,new Vec3f(2,2,2),15,5,(byte)7, true);
            ActionBase o6_4 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),18,5,true);
            ActionBase o6_5 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),20,5,(byte)7,false);
            o6_5.doRemove = true;

            ActionBase o7_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,6, false);
            ActionBase o7_2 = new ActionBase((byte)2,new Vec3f(0,0,0),10,6, false);
            ActionBase o7_3 = new ActionBase((byte)2,new Vec3f(1.2f,1.2f,1.2f),15,6,(byte)7, true);
            ActionBase o7_4 = new ActionBase((byte)1,new Vec3f(0f,0f,0f),10,6,true);
            ActionBase o7_5 = new ActionBase((byte)1,new Vec3f(0f,90f,0f),40,6,true);
            ActionBase o7_6 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),40,6,( byte)7,false);
            o7_6.doRemove = true;

            ActionBase o8_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,7, false);
            ActionBase o8_2 = new ActionBase((byte)2,new Vec3f(0,0,0),10,7, false);
            ActionBase o8_3 = new ActionBase((byte)2,new Vec3f(2,2,2),15,7,(byte)7, true);
            ActionBase o8_4 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),18,7,true);
            ActionBase o8_5 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),20,7,(byte)7,false);
            o8_5.doRemove = true;

            ActionBase o9_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,8, false);
            ActionBase o9_2 = new ActionBase((byte)2,new Vec3f(0,0,0),12,8, false);
            ActionBase o9_3 = new ActionBase((byte)2,new Vec3f(2,2,2),15,8,(byte)7, true);
            ActionBase o9_4 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),24,8, true);
            ActionBase o9_5 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),40,8,(byte)7,false);
            o9_5.doRemove = true;

            ActionBase o10_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,9, false);
            ActionBase o10_2 = new ActionBase((byte)2,new Vec3f(0,0,0),18,9, false);
            ActionBase o10_3 = new ActionBase((byte)2,new Vec3f(1.5f,1.5f,1.5f),20,9,(byte)7, true);
            ActionBase o10_6 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),22,9, true);
            ActionBase o10_4 = new ActionBase((byte)1,new Vec3f(0f,0f,0f),15,9,true);
            ActionBase o10_5 = new ActionBase((byte)1,new Vec3f(-89f,11f,-112f),24,9,(byte)3,false);
            ActionBase o10_7 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),24,9,(byte)7,false);
            o10_7.doRemove = true;

            ActionBase o11_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,10, false);
            ActionBase o11_2 = new ActionBase((byte)2,new Vec3f(0,0,0),18,10, false);
            ActionBase o11_3 = new ActionBase((byte)2,new Vec3f(2f,2f,2f),20,10,(byte)7, true);
            ActionBase o11_4 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),24,10, true);
            ActionBase o11_5 = new ActionBase((byte)2,new Vec3f(0f,0f,0f),40,10,(byte)7,false);
            o11_5.doRemove = true;

            entity.queue.addObj(obj1);
            entity.queue.addObj(obj2);
            entity.queue.addObj(obj3);
            entity.queue.addObj(obj4);
            entity.queue.addObj(obj5);
            entity.queue.addObj(obj6);
            entity.queue.addObj(obj7);
            entity.queue.addObj(obj8);
            entity.queue.addObj(obj9);
            entity.queue.addObj(obj10);
            entity.queue.addObj(obj11);

            entity.queue.addModel(0,model1);
            entity.queue.addModel(1,model2);
            entity.queue.addModel(2,model1);
            entity.queue.addModel(3,model1);
            entity.queue.addModel(4,model2);
            entity.queue.addModel(5,model1);
            entity.queue.addModel(6,model2);
            entity.queue.addModel(7,model1);
            entity.queue.addModel(8,model1);
            entity.queue.addModel(9,model2);
            entity.queue.addModel(10,model1);

            entity.queue.addAction(o1_1);
            entity.queue.addAction(o1_2);
            entity.queue.addAction(o1_3);
            entity.queue.addAction(o1_4);
            entity.queue.addAction(o1_5);

            entity.queue.addAction(o2_1);
            entity.queue.addAction(o2_2);
            entity.queue.addAction(o2_3);
            entity.queue.addAction(o2_4);
            entity.queue.addAction(o2_5);

            entity.queue.addAction(o3_1);
            entity.queue.addAction(o3_2);
            entity.queue.addAction(o3_3);
            entity.queue.addAction(o3_4);
            entity.queue.addAction(o3_5);

            entity.queue.addAction(o4_1);
            entity.queue.addAction(o4_2);
            entity.queue.addAction(o4_3);
            entity.queue.addAction(o4_4);
            entity.queue.addAction(o4_5);

            entity.queue.addAction(o5_1);
            entity.queue.addAction(o5_2);
            entity.queue.addAction(o5_3);
            entity.queue.addAction(o5_4);
            entity.queue.addAction(o5_5);
            entity.queue.addAction(o5_6);
            entity.queue.addAction(o5_7);
            entity.queue.addAction(o5_8);
            entity.queue.addAction(o5_9);

            entity.queue.addAction(o6_1);
            entity.queue.addAction(o6_2);
            entity.queue.addAction(o6_3);
            entity.queue.addAction(o6_4);
            entity.queue.addAction(o6_5);

            entity.queue.addAction(o7_1);
            entity.queue.addAction(o7_2);
            entity.queue.addAction(o7_3);
            entity.queue.addAction(o7_4);
            entity.queue.addAction(o7_5);
            entity.queue.addAction(o7_6);

            entity.queue.addAction(o8_1);
            entity.queue.addAction(o8_2);
            entity.queue.addAction(o8_3);
            entity.queue.addAction(o8_4);
            entity.queue.addAction(o8_5);

            entity.queue.addAction(o9_1);
            entity.queue.addAction(o9_2);
            entity.queue.addAction(o9_3);
            entity.queue.addAction(o9_4);
            entity.queue.addAction(o9_5);

            entity.queue.addAction(o10_1);
            entity.queue.addAction(o10_2);
            entity.queue.addAction(o10_3);
            entity.queue.addAction(o10_4);
            entity.queue.addAction(o10_5);
            entity.queue.addAction(o10_6);
            entity.queue.addAction(o10_7);

            entity.queue.addAction(o11_1);
            entity.queue.addAction(o11_2);
            entity.queue.addAction(o11_3);
            entity.queue.addAction(o11_4);
            entity.queue.addAction(o11_5);

            entity.queue.initialize();
        }
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
    public static final WavefrontObject modelE2 = new WavefrontObject(new ResourceLocationRaw("kablade:effects/cnzy/edg/ed2.obj"));
    public static final ResourceLocation texE1 = new ResourceLocation("kablade:effects/cnzy/edg/1.png");



    @Override
    public void doRender(@Nonnull EntityConceptual entity, double x, double y, double z, float entityYaw, float partialTicks) {

        initializeQueue(entity);

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        Tessellator tessellator = Tessellator.getInstance();

        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GL11.glDisable(GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL_BLEND);//开启混合

        Minecraft mc = Minecraft.getMinecraft();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        float time = entity.ticksExisted + partialTicks;

        float lastx = OpenGlHelper.lastBrightnessX;
        float lasty = OpenGlHelper.lastBrightnessY;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        rendIntro(entity, x, y, z, entityYaw, partialTicks, tessellator, bufferBuilder,mc,time);
        GL11.glEnable(GL11.GL_CULL_FACE);

        rendEdg(entity, x, y, z, entityYaw, partialTicks, tessellator,mc,time);



        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lastx, lasty);
        OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE, GL11.GL_ZERO);
        GL11.glEnable(GL_LIGHTING);

        GL11.glDisable(GL_BLEND);//开启混合
    }




    public void rendIntro(EntityConceptual entity, double x, double y, double z, float entityYaw, float partialTicks,Tessellator tessellator, BufferBuilder bufferBuilder,Minecraft mc,float time){
        GlStateManager.pushMatrix();

        GlStateManager.translate(x, y + 1, z);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GlStateManager.rotate(-entityYaw, 0f, 1f, 0f);


        GL11.glRotatef(-mc.getRenderManager().playerViewY+entityYaw,0,1,0);
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

        entity.queue.doRender(time,x,y,z,entityYaw);

    }
}
