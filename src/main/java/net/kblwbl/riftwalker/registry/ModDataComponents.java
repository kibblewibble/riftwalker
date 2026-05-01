package net.kblwbl.riftwalker.registry;

import com.mojang.serialization.Codec;
import net.kblwbl.riftwalker.RiftWalker;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponents {

    //----====(( COMPONENTS ))====----\\
    public static final ComponentType<Boolean> PLAGUED =
            register("plagued", builder -> builder.codec(Codec.BOOL));

    //----====(( REGISTERS ))====----\\
    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(RiftWalker.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void init(){}
}
