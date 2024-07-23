package com.github.romanqed.nea;

import com.github.romanqed.nea.items.*;
import com.github.romanqed.nea.registry.ItemRegistry;
import com.github.romanqed.nea.registry.Registry;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.aspects.Aspect;

@Mod.EventBusSubscriber(modid = NeaMod.MOD_ID)
public final class NeaItems {
    // Drinks
    public static final Item AIR_DRINK;
    public static final Item IGNIS_DRINK;
    public static final Item ORDO_DRINK;
    public static final Item PERDITIO_DRINK;
    public static final Item TERRA_DRINK;
    public static final Item WATER_DRINK;

    // Briquettes
    public static final Item AIR_BRIQUET;
    public static final Item IGNIS_BRIQUET;
    public static final Item ORDO_BRIQUET;
    public static final Item PERDITIO_BRIQUET;
    public static final Item TERRA_BRIQUET;
    public static final Item WATER_BRIQUET;

    // Sanity drink
    public static final Item SANITY_DRINK;

    // Sanity briquet
    public static final Item SANITY_BRIQUET;

    // Basic drink
    public static final Item BASIC_DRINK;

    // Basic briquet
    public static final Item BASIC_BRIQUET;

    private static final Registry<Item> REGISTRY = new ItemRegistry(NeaMod.CREATIVE_TAB);

    static {
        // Drinks
        AIR_DRINK = REGISTRY.add(new EssenceDrink("nea:air_drink", Aspect.AIR));
        IGNIS_DRINK = REGISTRY.add(new EssenceDrink("nea:ignis_drink", Aspect.FIRE));
        ORDO_DRINK = REGISTRY.add(new EssenceDrink("nea:ordo_drink", Aspect.ORDER));
        PERDITIO_DRINK = REGISTRY.add(new EssenceDrink("nea:perditio_drink", Aspect.ENTROPY));
        TERRA_DRINK = REGISTRY.add(new EssenceDrink("nea:terra_drink", Aspect.EARTH));
        WATER_DRINK = REGISTRY.add(new EssenceDrink("nea:water_drink", Aspect.WATER));

        // Briquettes
        AIR_BRIQUET = REGISTRY.add(new EssenceBriquet("nea:air_briquet", Aspect.AIR));
        IGNIS_BRIQUET = REGISTRY.add(new EssenceBriquet("nea:ignis_briquet", Aspect.FIRE));
        ORDO_BRIQUET = REGISTRY.add(new EssenceBriquet("nea:ordo_briquet", Aspect.ORDER));
        PERDITIO_BRIQUET = REGISTRY.add(new EssenceBriquet("nea:perditio_briquet", Aspect.ENTROPY));
        TERRA_BRIQUET = REGISTRY.add(new EssenceBriquet("nea:terra_briquet", Aspect.EARTH));
        WATER_BRIQUET = REGISTRY.add(new EssenceBriquet("nea:water_briquet", Aspect.WATER));

        // Sanity drink
        SANITY_DRINK = REGISTRY.add(new SanityDrink("nea:sanity_drink"));

        // Sanity briquet
        SANITY_BRIQUET = REGISTRY.add(new SanityBriquet("nea:sanity_briquet"));

        // Basic drink
        BASIC_DRINK = REGISTRY.add(new BasicDrink("nea:drink"));

        // Basic briquet
        BASIC_BRIQUET = REGISTRY.add(new BasicBriquet("nea:briquet"));

        // Creative tab icon
        NeaMod.CREATIVE_TAB.setTabIconItem(AIR_DRINK);
    }

    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> event) {
        REGISTRY.register(event.getRegistry());
    }
}
