package com.github.romanqed.nea.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractRegistry<T extends IForgeRegistryEntry<T>> implements Registry<T> {
    protected final List<T> entries;
    private final Consumer<IForgeRegistry<T>> handler;

    protected AbstractRegistry(List<T> entries) {
        this.entries = entries;
        this.handler = getSidedHandler();
    }

    private Consumer<IForgeRegistry<T>> getSidedHandler() {
        // Get physical side
        Side side = FMLCommonHandler.instance().getSide();
        if (side == Side.CLIENT) {
            return this::registerClient;
        }
        if (side == Side.SERVER) {
            return this::registerServer;
        }
        throw new IllegalArgumentException("Unknown side: " + side);
    }

    @SideOnly(Side.CLIENT)
    protected abstract void registerClient(IForgeRegistry<T> registry);

    @SideOnly(Side.SERVER)
    protected abstract void registerServer(IForgeRegistry<T> registry);

    @Override
    public void register(IForgeRegistry<T> registry) {
        handler.accept(registry);
    }

    @Override
    public T get(ResourceLocation location) {
        for (T entry : entries) {
            ResourceLocation temp = entry.getRegistryName();
            if (temp == null) {
                continue;
            }
            if (temp.equals(location)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public T get(String name) {
        for (T entry : entries) {
            ResourceLocation location = entry.getRegistryName();
            if (location == null) {
                continue;
            }
            String temp = location.toString();
            if (temp.equals(name)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return Collections.unmodifiableList(entries);
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public T add(T t) {
        Objects.requireNonNull(t);
        entries.add(t);
        return t;
    }

    @Override
    public void add(List<T> list) {
        list.forEach(t -> {
            Objects.requireNonNull(t);
            entries.add(t);
        });
    }
}
