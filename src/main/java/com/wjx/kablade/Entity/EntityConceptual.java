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

import static com.wjx.kablade.Entity.Render.RenderConceptual.modelE1;
import static com.wjx.kablade.Entity.Render.RenderConceptual.texE1;

public class EntityConceptual extends Entity implements IThrowableEntity {
    public RenderQueue queue;
    public EntityConceptual(World world) {
        super(world);
        ticksExisted = 0;
        queue = new RenderQueue();
        RenderModel model1 = new RenderModel(modelE1);
        model1.texModel = texE1;
        RenderObj obj1 = new RenderObj(0,1,0,0,0,0,1,1,1);

        ActionBase t1 = new ActionBase((byte) 0,new Vec3f(2,0,0), 40F,0, (byte)3,true);

        ActionBase t4 = new ActionBase((byte) 1,new Vec3f(0,0,-90), 40F,0,(byte)3,true);

        queue.addObj(obj1);
        queue.addModel(0,model1);
        queue.addAction(t1);

        queue.addAction(t4);
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
