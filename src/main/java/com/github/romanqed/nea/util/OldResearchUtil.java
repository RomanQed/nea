package com.github.romanqed.nea.util;

import com.github.romanqed.nea.NeaMod;
import com.wonginnovations.oldresearch.OldResearch;
import com.wonginnovations.oldresearch.common.lib.network.PacketAspectPool;
import com.wonginnovations.oldresearch.common.lib.network.PacketHandler;
import com.wonginnovations.oldresearch.config.ModConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public final class OldResearchUtil {
    private OldResearchUtil() {
    }

    public static boolean addAspect(EntityPlayerMP player, Aspect aspect, int amount) {
        try {
            AspectList aspects = getPlayerAspects(player);
            int count = aspects.getAmount(aspect);
            if (count >= ModConfig.aspectTotalCap) {
                return false;
            }
            aspects.add(aspect, amount);
            sendAddAspect(player, aspect, amount, count + amount);
        } catch (Throwable e) {
            NeaMod.logger.error("Cannot add aspect to player due to", e);
        }
        return true;
    }

    public static AspectList getPlayerAspects(EntityPlayer player) {
        String name = player.getGameProfile().getName();
        return OldResearch.proxy.getPlayerKnowledge().getAspectsDiscovered(name);
    }

    public static void sendAddAspect(EntityPlayerMP player, Aspect aspect, int amount, int total) {
        String tag = aspect.getTag();
        PacketHandler.INSTANCE.sendTo(new PacketAspectPool(tag, amount, total), player);
    }
}
