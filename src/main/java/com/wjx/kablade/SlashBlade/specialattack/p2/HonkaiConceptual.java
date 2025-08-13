package com.wjx.kablade.SlashBlade.specialattack.p2;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.wjx.kablade.Entity.EntityConceptual;
import com.wjx.kablade.Entity.EntityThunderEdgeAttack;
import com.wjx.kablade.Main;
import com.wjx.kablade.init.PotionInit;
import com.wjx.kablade.network.MessageDizuiKuo;
import com.wjx.kablade.util.MathFunc;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.specialattack.SpecialAttackBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class HonkaiConceptual extends SpecialAttackBase {
    @Override
    public String toString() {
        return "conceptual";
    }

    @Override
    public void doSpacialAttack(ItemStack itemStack, EntityPlayer entityPlayer) {
        World world = entityPlayer.getEntityWorld();
        if (!world.isRemote){
            EntityConceptual t = new EntityConceptual(world,entityPlayer);
            t.setPosition(entityPlayer.posX,entityPlayer.posY,entityPlayer.posZ);
            t.setThrower(entityPlayer);
            t.blade = itemStack;

            world.spawnEntity(t);

        }
    }
}
