package com.github.romanqed.nea.util;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public abstract class ItemDrink extends Item {
    protected Item container;
    protected boolean alwaysDrinkable;
    protected int duration;

    protected ItemDrink(Item container) {
        this.container = container;
        this.alwaysDrinkable = true;
        this.duration = 32;
        this.maxStackSize = 1;
    }

    public boolean isAlwaysDrinkable() {
        return alwaysDrinkable;
    }

    public void setAlwaysDrinkable(boolean alwaysDrinkable) {
        this.alwaysDrinkable = alwaysDrinkable;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return duration;
    }

    public void setDrinkDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    protected abstract void onDrunk(ItemStack stack, World world, EntityPlayer player);

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (playerIn.canEat(this.alwaysDrinkable)) {
            playerIn.setActiveHand(handIn);
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        } else {
            return new ActionResult<>(EnumActionResult.FAIL, stack);
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entity) {
        if (!(entity instanceof EntityPlayer)) {
            return stack;
        }
        EntityPlayer player = (EntityPlayer) entity;
        if (player instanceof EntityPlayerMP) {
            EntityPlayerMP serverPlayer = (EntityPlayerMP) entity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
        }
        onDrunk(stack, worldIn, player);
        if (!player.capabilities.isCreativeMode) {
            stack.shrink(1);
        }
        // If stack is empty, replace it with container
        if (stack.isEmpty()) {
            return new ItemStack(container);
        }
        // If stack is not empty, then we need to add empty container to player and return stack
        player.inventory.placeItemBackInInventory(worldIn, new ItemStack(container));
        return stack;
    }
}
