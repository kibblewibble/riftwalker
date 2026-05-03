package net.kblwbl.riftwalker.registry;

import net.kblwbl.riftwalker.RiftWalker;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static void init(){}

    //----====(( COMPONENTS ))====----\\

    //----====(( REGISTERS ))====----\\
    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE,
                RiftWalker.id(name),
                builderOperator.apply(ComponentType.builder()).build());
    }
}
