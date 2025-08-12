package com.wjx.kablade.util.renderingQueue.Actions;

import com.wjx.kablade.util.Vec3f;

public class ActionBase {
    public boolean hasTween = false;
    public byte tweenType = 0;//0:Linear 1:Ease-In 2:Ease-Out 3:Ease-In-Out
    public boolean isRelative;
    public Vec3f motion;

    public float time;

    public int objId;

    public byte type = 0;

    public boolean doRemove = false;

    public static float getEasing(byte type, float t) {
        t = Math.min(1, t);
        t = Math.max(0, t);
        switch(type) {
            case 0: return t;
            case 1: return t * t;
            case 2: return 1 - (1 - t) * (1 - t);
            case 3: return t < 0.5 ? 2*t*t : (float) (1 - Math.pow(-2 * t + 2, 2) / 2);
            default: return t;
        }
    }

    public ActionBase(byte type,Vec3f motion, float time, int objId, byte tweenType, boolean isRelative) {
        this.type = type;
        this.motion = motion;
        this.time = time;
        this.objId = objId;
        this.tweenType = tweenType;
        this.isRelative = isRelative;
        hasTween = true;
    }

    public ActionBase(byte type,Vec3f motion, float time, int objId,boolean isRelative) {
        this.type = type;
        this.motion = motion;
        this.time = time;
        this.objId = objId;
        this.isRelative = isRelative;
        hasTween = false;
    }

    public Vec3f calculateRelativeMotion(Vec3f prev){
        if(!isRelative){
            return new Vec3f( motion.x - prev.x, motion.y - prev.y, motion.z - prev.z);
        }
        return motion;
    }


}
