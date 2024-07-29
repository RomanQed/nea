package com.github.romanqed.nea;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = NeaMod.MOD_ID,
        name = NeaMod.NAME,
        version = NeaMod.VERSION,
        dependencies = "required-after:oldresearch;after:*")
public class NeaMod {
    public static final String MOD_ID = "nea";
    public static final String NAME = "Not Enough Aspects";
    public static final String VERSION = "1.0";
    public static final CreativeTab CREATIVE_TAB = new CreativeTab(MOD_ID);

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }
}
