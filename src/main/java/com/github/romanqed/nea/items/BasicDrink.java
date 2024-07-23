package com.github.romanqed.nea.items;

import com.github.romanqed.nea.config.DrinkConfig;
import com.github.romanqed.nea.util.ItemDrink;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BasicDrink extends ItemDrink {

    public BasicDrink(String name) {
        super(Items.GLASS_BOTTLE);
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
    }
}
