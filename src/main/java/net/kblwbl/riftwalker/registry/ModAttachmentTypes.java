package net.kblwbl.riftwalker.registry;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.fabricmc.fabric.impl.attachment.AttachmentRegistryImpl;
import net.kblwbl.riftwalker.RiftWalker;

import java.util.function.Consumer;

@SuppressWarnings("UnstableApiUsage")
public class ModAttachmentTypes {

    //----====(( ATTACHMENTS ))====----\\
    public static final AttachmentType<Boolean> ROTTED = register(
            "rotted",
booleanBuilder -> booleanBuilder
                    .initializer(() -> false)
                    .persistent(Codec.BOOL)
                    .copyOnDeath());

    public static final AttachmentType<Boolean> REALM_VISIBLE = register(
            "realm_visible",
booleanBuilder -> booleanBuilder
                    .initializer(() -> false)
                    .persistent(Codec.BOOL));

    public static final AttachmentType<Boolean> REALM_WITHIN = register(
            "realm_within",
booleanBuilder -> booleanBuilder
                    .initializer(() -> false)
                    .persistent(Codec.BOOL));


    //----====(( REGISTERS ))====----\\
    public static void init(){}

    private static <A> AttachmentType<A> register (String id, Consumer<AttachmentRegistry.Builder<A>> consumer) {
        AttachmentRegistry.Builder<A> builder = AttachmentRegistryImpl.builder();
        consumer.accept(builder);
        return builder.buildAndRegister(RiftWalker.id(id));
    }
}
