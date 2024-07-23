package com.github.romanqed.nea.config;

import net.minecraftforge.common.config.Config;

@Config(modid = "nea", category = "briquets")
public final class BriquetConfig {

    @Config.RangeInt(min = 1, max = 50)
    public static int bonus = 10;

    @Config.RangeInt(min = 0, max = 500)
    public static int warp = 5;

    @Config.RangeInt(min = 1, max = 500)
    public static int warpReduce = 1;

    @Config.RangeInt(min = 0, max = 20)
    public static int healBonus = 0;

    @Config.RangeDouble(min = 0, max = 5)
    public static float saturation = 0;

    @Config.RangeInt(min = 1, max = 64)
    public static int stackSize = 64;

    @Config.RangeInt(min = 1, max = 64)
    public static int eatDuration = 32;
}
