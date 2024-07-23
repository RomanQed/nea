package com.github.romanqed.nea.items;

import com.github.romanqed.nea.config.BriquetConfig;
import com.github.romanqed.nea.util.ItemPlayerFood;
import com.github.romanqed.nea.util.ThaumcraftUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SanityBriquet extends ItemPlayerFood {
    private final int warpReduce;

    public SanityBriquet(String name) {
        super(BriquetConfig.healBonus, BriquetConfig.saturation);
        this.warpReduce = BriquetConfig.warpReduce;
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
        // Skip logical client side
        if (world.isRemote) {
            return;
        }
        ThaumcraftUtil.reduceWarp((EntityPlayerMP) player, warpReduce);
    }
}
