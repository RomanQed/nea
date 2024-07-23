package com.github.romanqed.nea.config;

import net.minecraftforge.common.config.Config;

@Config(modid = "nea", category = "common")
public final class NeaConfig {

    @Config.RangeInt(min = 0, max = 3600)
    public static int penaltyDuration = 60;
}
