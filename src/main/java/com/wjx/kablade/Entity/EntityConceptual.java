package com.wjx.kablade.Entity;

import com.wjx.kablade.util.MathFunc;
import com.wjx.kablade.util.Vec3f;
import com.wjx.kablade.util.renderingQueue.Actions.ActionBase;
import com.wjx.kablade.util.renderingQueue.RenderModel;
import com.wjx.kablade.util.renderingQueue.RenderObj;
import com.wjx.kablade.util.renderingQueue.RenderQueue;
import mods.flammpfeil.slashblade.ability.StylishRankManager;
import mods.flammpfeil.slashblade.entity.selector.EntitySelectorAttackable;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.IThrowableEntity;

import javax.annotation.Nonnull;

import java.util.List;

import static com.wjx.kablade.Entity.Render.RenderConceptual.*;

public class EntityConceptual extends Entity implements IThrowableEntity {
    public RenderQueue queue;
    public EntityConceptual(World world) {
        super(world);
        ticksExisted = 0;
    }

    public EntityConceptual(World world,EntityLivingBase ownerIn){
        super(world);
        ticksExisted = 0;
        this.rotationYaw = ownerIn.rotationYaw;
        this.owner = ownerIn;
    }

    public EntityLivingBase owner=null;
    public ItemStack blade = null;

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
        return owner;
    }

    @Override
    public void setThrower(Entity entity) {
        if(entity instanceof EntityLivingBase)
            owner = (EntityLivingBase) entity;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(ticksExisted>60){
            this.setDead();
        }
        if (ticksExisted > 6 && ticksExisted < 35){
            World world1 = this.world;
            if (!world1.isRemote) {
                if(ticksExisted % 4 == 0)
                {
                    List<Entity> list = world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().grow(8.0D, 4.0D, 8.0D), EntitySelectorAttackable.getInstance());
                    for (Entity entity : list) {

                        {
                            if (entity instanceof EntityLivingBase && !(entity.equals(owner))) {
                                EntityLivingBase living = (EntityLivingBase) entity;
                                if (owner instanceof EntityPlayer) {
                                    float extraDamage = 0;
                                    if (blade != null) {
                                        blade.hitEntity(living, (EntityPlayer) owner);

                                        extraDamage = MathFunc.amplifierCalc(ItemSlashBlade.BaseAttackModifier.get(blade.getTagCompound()), 5f);
                                    }
                                    StylishRankManager.setNextAttackType(this.owner, StylishRankManager.AttackTypes.SlashDim);

                                    StylishRankManager.doAttack(this.owner);
                                    ((EntityPlayer) owner).onCriticalHit(living);
                                    living.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) owner), 20.0F + extraDamage);
                                    if (blade != null) {
                                        blade.getItem().hitEntity(blade, living, (EntityPlayer) owner);


                                    }
                                    living.hurtTime = 0;
                                    living.hurtResistantTime = 0;


                                } else {
                                    living.attackEntityFrom(DamageSource.causeMobDamage(owner), 20.0F);
                                    living.hurtTime = 0;
                                    living.hurtResistantTime = 0;
                                }


                            }
                        }
                    }
                }

            }
        }
    }
}
