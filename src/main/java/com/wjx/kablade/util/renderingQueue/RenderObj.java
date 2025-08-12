package com.wjx.kablade.util.renderingQueue;

import com.wjx.kablade.util.Vec3f;

public class RenderObj {
    public Vec3f pos;
    public Vec3f rotate;
    public Vec3f scale;

    public RenderObj(Vec3f pos, Vec3f rotate, Vec3f scale) {
        this.pos = pos;
        this.rotate = rotate;
        this.scale = scale;
    }
    public RenderObj(float x, float y, float z, float rx, float ry, float rz, float sx, float sy, float sz) {
        this.pos = new Vec3f(x,y,z);
        this.rotate = new Vec3f(rx,ry,rz);
        this.scale = new Vec3f(sx,sy,sz);
    }

    public void setPos(float x, float y, float z) {
        this.pos.x = x;
        this.pos.y = y;
        this.pos.z = z;
    }

    public void setRotate(float rx, float ry, float rz) {
        this.rotate.x = rx;
        this.rotate.y = ry;
        this.rotate.z = rz;
    }

    public void setScale(float sx, float sy, float sz) {
        this.scale.x = sx;
        this.scale.y = sy;
        this.scale.z = sz;
    }

    public void setPos(Vec3f pos) {
        this.pos = pos;
    }

    public void setRotate(Vec3f rotate) {
        this.rotate = rotate;
    }

    public void setScale(Vec3f scale) {
        this.scale = scale;
    }

    public Vec3f getPos() {
        return pos;
    }

    public Vec3f getRotate() {
        return rotate;
    }

    public Vec3f getScale() {
        return scale;
    }

    public void addPos(float x, float y, float z) {
        this.pos.x += x;
        this.pos.y += y;
        this.pos.z += z;
    }

    public void addRotate(float rx, float ry, float rz) {
        this.rotate.x += rx;
        this.rotate.y += ry;
        this.rotate.z += rz;
    }

    public void addScale(float sx, float sy, float sz) {
        this.scale.x += sx;
        this.scale.y += sy;
        this.scale.z += sz;
    }


}
