package com.github.romanqed.nea.items;

import com.github.romanqed.nea.config.DrinkConfig;
import com.github.romanqed.nea.util.ItemDrink;
import com.github.romanqed.nea.util.ThaumcraftUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SanityDrink extends ItemDrink {
    private final int warpReduce;

    public SanityDrink(String name) {
        super(Items.GLASS_BOTTLE);
        this.warpReduce = DrinkConfig.warpReduce;
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
        ThaumcraftUtil.reduceWarp((EntityPlayerMP) player, warpReduce);
    }
}
