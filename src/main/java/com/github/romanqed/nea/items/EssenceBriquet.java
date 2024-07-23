package com.github.romanqed.nea.items;

import com.github.romanqed.nea.config.BriquetConfig;
import com.github.romanqed.nea.config.NeaConfig;
import com.github.romanqed.nea.util.ItemPlayerFood;
import com.github.romanqed.nea.util.OldResearchUtil;
import com.github.romanqed.nea.util.ThaumcraftUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;

public class EssenceBriquet extends ItemPlayerFood {
    private final Aspect aspect;
    private final int bonus;
    private final int duration = NeaConfig.penaltyDuration * 20;

    public EssenceBriquet(String name, Aspect aspect) {
        super(BriquetConfig.healBonus, BriquetConfig.saturation);
        this.aspect = aspect;
        this.bonus = BriquetConfig.bonus;
        // Set briquet name
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        // Set always edible
        this.setAlwaysEdible();
        // Set stack size
        this.setMaxStackSize(BriquetConfig.stackSize);
        // Set drink duration
        this.setEatDuration(BriquetConfig.eatDuration);
    }

    public Aspect getAspect() {
        return aspect;
    }

    @Override
    protected void onEaten(ItemStack stack, World world, EntityPlayer player) {
        // Skip logical client side
        if (world.isRemote) {
            return;
        }
        EntityPlayerMP playerMP = (EntityPlayerMP) player;
        if (!OldResearchUtil.addAspect(playerMP, aspect, bonus) && duration != 0) {
            player.addPotionEffect(new PotionEffect(MobEffects.POISON, duration));
        }
        int warp = BriquetConfig.warp;
        if (warp == 0) {
            return;
        }
        ThaumcraftUtil.addWarp(playerMP, warp);
    }
}
