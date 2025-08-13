package com.wjx.kablade.util.renderingQueue;

import com.wjx.kablade.util.Vec3f;
import com.wjx.kablade.util.renderingQueue.Actions.ActionBase;
import net.minecraft.client.renderer.GlStateManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RenderQueue {
    public List<RenderObj> objs = new java.util.ArrayList<>();
    public List<ActionBase> actions = new java.util.ArrayList<>();
    public Map<Integer,RenderModel> modelBinding = new java.util.HashMap<>();
    public List<RenderDyObj> dyObjs = new ArrayList<>();

    public void addObj(RenderObj obj)
    {
        objs.add(obj);
    }
    public void addAction(ActionBase action)
    {
        actions.add( action);
    }
    public void addModel(int id,RenderModel model)
    {
        modelBinding.put(id, model);
    }

    public void doRender(float time,double x, double y, double z, float yaw)
    {
        for (int j = 0;j<dyObjs.size();j++){

            RenderDyObj obj = dyObjs.get(j);

            if(obj.nearTranslate != null){
                if(obj.nearTranslate.time< time){
                    obj.prevTimeT = obj.nearTranslate.time;
                    if(obj.nearTranslate.doRemove){
                        dyObjs.remove(j);
                        j--;
                    }
                    Vec3f motion = obj.nearTranslate.calculateRelativeMotion(objs.get(obj.nearTranslate.objId).pos);
                    objs.get(obj.nearTranslate.objId).addPos(motion.x,motion.y,motion.z);
                    boolean flag = false;
                    for(int i = 0;i<actions.size();i++){
                        ActionBase action = actions.get(i);
                        if(action.objId == obj.id&& action.type == 0){

                            obj.nearTranslate = action;
                            actions.remove(i);
                            flag = true;
                            break;

                        }
                    }
                    if(!flag){
                        obj.nearTranslate = null;
                    }
                }
            }
            if(obj.nearRotate != null){
                if(obj.nearRotate.time< time){
                    obj.prevTimeR = obj.nearRotate.time;
                    if(obj.nearRotate.doRemove){
                        dyObjs.remove(j);
                        j--;
                    }
                    Vec3f motion = obj.nearRotate.calculateRelativeMotion(objs.get(obj.nearRotate.objId).rotate);
                    objs.get(obj.nearRotate.objId).addRotate(motion.x,motion.y,motion.z);
                    boolean flag = false;
                    for(int i = 0;i<actions.size();i++){
                        ActionBase action = actions.get(i);
                        if(action.objId == obj.id&& action.type == 1){

                            obj.nearRotate = action;
                            actions.remove(i);
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        obj.nearRotate = null;
                    }
                }
            }
            if(obj.nearScale != null){
                if(obj.nearScale.time< time){
                    obj.prevTimeS = obj.nearScale.time;
                    if(obj.nearScale.doRemove){
                        dyObjs.remove(j);
                        j--;
                    }
                    Vec3f motion = obj.nearScale.calculateRelativeMotion(objs.get(obj.nearScale.objId).scale);
                    objs.get(obj.nearScale.objId).addScale(motion.x,motion.y,motion.z);
                    boolean flag = false;
                    for(int i = 0;i<actions.size();i++){
                        ActionBase action = actions.get(i);
                        if(action.objId == obj.id&& action.type == 2){

                            obj.nearScale = action;
                            actions.remove(i);
                            flag = true;
                            break;
                        }
                    }
                    if(!flag)
                        obj.nearScale = null;
                }
            }


            Vec3f posOffset = new Vec3f(0,0,0);
            Vec3f rotateOffset = new Vec3f(0,0,0);
            Vec3f scaleOffset = new Vec3f(0,0,0);
            if(obj.nearTranslate!=null){
                ActionBase action = obj.nearTranslate;
                if(action.hasTween)
                {
                    Vec3f relativeMotion = action.calculateRelativeMotion(objs.get(action.objId).pos);
                    float relativeTime = 1 - ((action.time - time) / (action.time - obj.prevTimeT));
                    posOffset = new Vec3f(relativeMotion.x * ActionBase.getEasing(action.tweenType, relativeTime),
                            relativeMotion.y * ActionBase.getEasing(action.tweenType, relativeTime),
                            relativeMotion.z * ActionBase.getEasing(action.tweenType, relativeTime));
                }
            }
            if(obj.nearRotate!=null){
                ActionBase action = obj.nearRotate;
                if (action.hasTween)
                {
                    Vec3f relativeMotion = action.calculateRelativeMotion(objs.get(action.objId).rotate);
                    float relativeTime = 1 - ((action.time - time) / (action.time - obj.prevTimeR));
                    rotateOffset = new Vec3f(relativeMotion.x * ActionBase.getEasing(action.tweenType, relativeTime),
                            relativeMotion.y * ActionBase.getEasing(action.tweenType, relativeTime),
                            relativeMotion.z * ActionBase.getEasing(action.tweenType, relativeTime));
                }
            }
            if(obj.nearScale!=null){
                ActionBase action = obj.nearScale;
                if (action.hasTween)
                {
                    Vec3f relativeMotion = action.calculateRelativeMotion(objs.get(action.objId).scale);
                    float relativeTime =1 - ((action.time - time) / (action.time - obj.prevTimeS));
                    scaleOffset = new Vec3f(relativeMotion.x * ActionBase.getEasing(action.tweenType, relativeTime),
                            relativeMotion.y * ActionBase.getEasing(action.tweenType, relativeTime),
                            relativeMotion.z * ActionBase.getEasing(action.tweenType, relativeTime));
                }
            }
            GlStateManager.pushMatrix();
            float yaa = -yaw;
            GlStateManager.translate(x,y,z);
            GlStateManager.rotate(yaa,0,1,0);
            GlStateManager.translate(objs.get(obj.id).pos.x+ posOffset.x,objs.get(obj.id).pos.y+ posOffset.y,objs.get(obj.id).pos.z+ posOffset.z);

            GlStateManager.rotate(objs.get(obj.id).rotate.x+rotateOffset.x,1,0,0);
            GlStateManager.rotate(objs.get(obj.id).rotate.y+rotateOffset.y,0,1,0);
            GlStateManager.rotate(objs.get(obj.id).rotate.z+rotateOffset.z,0,0,1);
            GlStateManager.scale(objs.get(obj.id).scale.x+scaleOffset.x,objs.get(obj.id).scale.y+scaleOffset.y,objs.get(obj.id).scale.z+scaleOffset.z);
            modelBinding.get(obj.id).doRender();
            GlStateManager.popMatrix();


        }
    }
    public void initialize()
    {
        for(int j = 0;j<objs.size();j++){
            RenderDyObj obj = new RenderDyObj();
            obj.id = j;

                    obj.prevTimeT = 0;
                    for(int i = 0;i<actions.size();i++){
                        ActionBase action = actions.get(i);
                        if(action.objId == obj.id&& action.type == 0){

                            obj.nearTranslate = action;
                            actions.remove(i);
                            break;

                        }
                    }




                    obj.prevTimeR = 0;
                    for(int i = 0;i<actions.size();i++){
                        ActionBase action = actions.get(i);
                        if(action.objId == obj.id&& action.type == 1){

                            obj.nearRotate = action;
                            actions.remove(i);
                            break;
                        }
                    }




                    obj.prevTimeS = 0;
                    for(int i = 0;i<actions.size();i++){
                        ActionBase action = actions.get(i);
                        if(action.objId == obj.id&& action.type == 2){

                            obj.nearScale = action;
                            actions.remove(i);
                            break;
                        }
                    }
                    dyObjs.add(obj);


        }
    }

}
