package com.wjx.kablade.util.renderingQueue;

import mods.flammpfeil.slashblade.client.model.obj.Face;
import mods.flammpfeil.slashblade.client.model.obj.WavefrontObject;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class RenderModel {
    public byte modelType = 0; //0:WavefrontObject 1:JavaModel(ModelBase)

    public WavefrontObject objModel;

    public int objColor = 0xFFFFFFFF;

    public ResourceLocation texModel = null;

    public RenderModel(WavefrontObject objModel){
        this.modelType = 0;
        this.objModel = objModel;
    }

    public void doRender(Minecraft mc){
        if(modelType == 0){
            mc.getTextureManager().bindTexture(texModel);
            Face.setColor(objColor);
            objModel.renderAll();
            Face.resetColor();
        }
    }

    public void doRender(){
        Minecraft mc = Minecraft.getMinecraft();
        doRender(mc);
    }

}
