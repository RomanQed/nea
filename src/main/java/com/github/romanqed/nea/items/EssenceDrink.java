package com.github.romanqed.nea.items;

import com.github.romanqed.nea.config.DrinkConfig;
import com.github.romanqed.nea.config.NeaConfig;
import com.github.romanqed.nea.util.ItemDrink;
import com.github.romanqed.nea.util.OldResearchUtil;
import com.github.romanqed.nea.util.ThaumcraftUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;

public class EssenceDrink extends ItemDrink {
    private final Aspect aspect;
    private final int bonus;
    private final int duration = NeaConfig.penaltyDuration * 20;

    public EssenceDrink(String name, Aspect aspect) {
        super(Items.GLASS_BOTTLE);
        this.aspect = aspect;
        this.bonus = DrinkConfig.bonus;
        // Set name
        setRegistryName(name);
        setUnlocalizedName(name);
        // Set always drinkable
        this.setAlwaysDrinkable(true);
        // Set stack size
        this.setMaxStackSize(DrinkConfig.stackSize);
        // Set drink duration
        this.setDrinkDuration(DrinkConfig.drinkDuration);
    }

    @Override
    protected void onDrunk(ItemStack stack, World world, EntityPlayer player) {
        // Skip logical client side
        if (world.isRemote) {
            return;
        }
        EntityPlayerMP playerMP = (EntityPlayerMP) player;
        if (!OldResearchUtil.addAspect(playerMP, aspect, bonus) && duration != 0) {
            player.addPotionEffect(new PotionEffect(MobEffects.POISON, duration));
        }
        int warp = DrinkConfig.warp;
        if (warp == 0) {
            return;
        }
        ThaumcraftUtil.addWarp(playerMP, warp);
    }
}
