package com.github.romanqed.nea.config;

import net.minecraftforge.common.config.Config;

@Config(modid = "nea", category = "drinks")
public final class DrinkConfig {

    @Config.RangeInt(min = 1, max = 50)
    public static int bonus = 20;

    @Config.RangeInt(min = 0, max = 500)
    public static int warp = 1;

    @Config.RangeInt(min = 1, max = 500)
    public static int warpReduce = 5;

    @Config.RangeInt(min = 1, max = 64)
    public static int stackSize = 64;

    @Config.RangeInt(min = 1, max = 64)
    public static int drinkDuration = 32;
}
