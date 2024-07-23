package com.github.romanqed.nea.util;

import net.minecraft.entity.player.EntityPlayerMP;
import thaumcraft.api.capabilities.IPlayerWarp;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;

public final class ThaumcraftUtil {

    private ThaumcraftUtil() {
    }

    public static void addWarp(EntityPlayerMP player, int amount) {
        IPlayerWarp warp = ThaumcraftCapabilities.getWarp(player);
        warp.add(IPlayerWarp.EnumWarpType.TEMPORARY, amount);
        warp.sync(player);
    }

    public static void reduceWarp(EntityPlayerMP player, int amount) {
        IPlayerWarp warp = ThaumcraftCapabilities.getWarp(player);
        warp.reduce(IPlayerWarp.EnumWarpType.TEMPORARY, amount);
        warp.sync(player);
    }
}
