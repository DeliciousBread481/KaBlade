package com.wjx.kablade.util.renderingQueue;

import com.wjx.kablade.util.renderingQueue.Actions.ActionBase;
import mods.flammpfeil.slashblade.client.model.obj.WavefrontObject;

public class RenderDyObj {
    public int id;
    public ActionBase nearTranslate;
    public ActionBase nearRotate;
    public ActionBase nearScale;
    public float prevTimeT;
    public float prevTimeR;
    public float prevTimeS;

}
