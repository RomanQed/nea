package com.github.romanqed.nea.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.List;

public interface Registry<T extends IForgeRegistryEntry<T>> {
    T get(ResourceLocation location);

    T get(String name);

    List<T> getAll();

    T add(T t);

    void add(List<T> list);

    void register(IForgeRegistry<T> registry);

    void clear();
}
