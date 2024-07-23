package com.github.romanqed.nea.items;

import com.github.romanqed.nea.config.BriquetConfig;
import com.github.romanqed.nea.util.ItemPlayerFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BasicBriquet extends ItemPlayerFood {

    public BasicBriquet(String name) {
        super(BriquetConfig.healBonus, BriquetConfig.saturation);
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

    @Override
    protected void onEaten(ItemStack stack, World world, EntityPlayer player) {
    }
}
