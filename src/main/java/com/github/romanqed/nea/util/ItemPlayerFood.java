package com.github.romanqed.nea.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ItemPlayerFood extends ItemFood {
    protected int duration;

    public ItemPlayerFood(int amount, float saturation) {
        super(amount, saturation, false);
        this.duration = 32;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return duration;
    }

    public void setEatDuration(int duration) {
        this.duration = duration;
    }

    protected abstract void onEaten(ItemStack stack, World world, EntityPlayer player);

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        onEaten(stack, worldIn, player);
    }
}
