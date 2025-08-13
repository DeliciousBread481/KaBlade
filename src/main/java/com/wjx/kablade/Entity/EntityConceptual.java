package com.wjx.kablade.Entity;

import com.wjx.kablade.util.Vec3f;
import com.wjx.kablade.util.renderingQueue.Actions.ActionBase;
import com.wjx.kablade.util.renderingQueue.RenderModel;
import com.wjx.kablade.util.renderingQueue.RenderObj;
import com.wjx.kablade.util.renderingQueue.RenderQueue;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.IThrowableEntity;

import javax.annotation.Nonnull;

import static com.wjx.kablade.Entity.Render.RenderConceptual.*;

public class EntityConceptual extends Entity implements IThrowableEntity {
    public RenderQueue queue;
    public EntityConceptual(World world) {
        super(world);
        ticksExisted = 0;
        queue = new RenderQueue();
        RenderModel model1 = new RenderModel(modelE1);
        RenderModel model2 = new RenderModel(modelE2);
        model1.texModel = texE1;
        model2.texModel = texE1;
        model1.objColor = 0xFFFFFFFF;
        model2.objColor = 0xFFFFFFFF;
        RenderObj obj1 = new RenderObj(-1f,2.2f,1.2f,5,-14,122,2,2,2);
        RenderObj obj2 = new RenderObj(1,2.1f,2.5f,-30,57.5f,0,1.2f,1.2f,1.2f);

        ActionBase o1_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,0, false);
        ActionBase o1_2 = new ActionBase((byte)2,new Vec3f(0,0,0),5,0, false);
        ActionBase o1_3 = new ActionBase((byte)2,new Vec3f(2,2,2),15,0,(byte)3, true);
        ActionBase o2_1 = new ActionBase((byte)2,new Vec3f(0,0,0),0,1, false);
        ActionBase o2_2 = new ActionBase((byte)2,new Vec3f(0,0,0),5,1, false);
        ActionBase o2_3 = new ActionBase((byte)2,new Vec3f(1.5f,1.5f,1.5f),15,1,(byte)3, true);


        queue.addObj(obj1);
        queue.addObj(obj2);
        queue.addModel(0,model1);
        queue.addModel(1,model2);
        queue.addAction(o1_1);
        queue.addAction(o1_2);
        queue.addAction(o1_3);
        queue.addAction(o2_1);
        queue.addAction(o2_2);
        queue.addAction(o2_3);

        queue.initialize();
    }

    public EntityLivingBase owner=null;
    public ItemSlashBlade blade = null;

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(@Nonnull NBTTagCompound nbtTagCompound) {

    }

    @Override
    protected void writeEntityToNBT(@Nonnull NBTTagCompound nbtTagCompound) {

    }

    @Override
    public Entity getThrower() {
        return null;
    }

    @Override
    public void setThrower(Entity entity) {

    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(ticksExisted>60){
            this.setDead();
        }
    }
}
