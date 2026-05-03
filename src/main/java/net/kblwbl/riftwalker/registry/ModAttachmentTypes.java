package net.kblwbl.riftwalker.registry;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.kblwbl.riftwalker.RiftWalker;

@SuppressWarnings("UnstableApiUsage")
public class ModAttachmentTypes {
    public static void init(){}

    public static final AttachmentType<Boolean> ROTTED = AttachmentRegistry.create(
            RiftWalker.id("rotted"),
            booleanBuilder -> booleanBuilder
                    .initializer(() -> false)
                    .persistent(Codec.BOOL)
                    .copyOnDeath()
    );
}
