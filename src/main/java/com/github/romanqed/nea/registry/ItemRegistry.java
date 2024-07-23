package com.github.romanqed.nea.registry;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.LinkedList;

public class ItemRegistry extends AbstractRegistry<Item> {
    private static final String INVENTORY_VARIANT = "inventory";

    private final CreativeTabs tab;

    public ItemRegistry(CreativeTabs tab) {
        super(new LinkedList<>());
        this.tab = tab;
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item) {
        ResourceLocation name = item.getRegistryName();
        if (name == null) {
            return;
        }
        ModelResourceLocation modelLocation = new ModelResourceLocation(name, INVENTORY_VARIANT);
        ModelBakery.registerItemVariants(item, modelLocation);
        ModelLoader.setCustomModelResourceLocation(item, 0, modelLocation);
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected void registerClient(IForgeRegistry<Item> registry) {
        for (Item item : entries) {
            item.setCreativeTab(tab);
            registry.register(item);
            registerModel(item);
        }
    }

    @Override
    @SideOnly(Side.SERVER)
    protected void registerServer(IForgeRegistry<Item> registry) {
        for (Item item : entries) {
            item.setCreativeTab(tab);
            registry.register(item);
        }
    }
}
