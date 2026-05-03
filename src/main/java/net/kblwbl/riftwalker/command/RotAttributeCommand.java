package net.kblwbl.riftwalker.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.kblwbl.riftwalker.registry.ModAttachmentTypes;
import net.kblwbl.riftwalker.registry.ModEffects;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Objects;

import static net.kblwbl.riftwalker.RiftWalker.MOD_ID;

@SuppressWarnings("UnstableApiUsage")
public class RotAttributeCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        var root = CommandManager.literal(MOD_ID);

        root.then(CommandManager.literal("rot_attribute")
            .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("add")
                    .then(CommandManager.argument("player", EntityArgumentType.player())
                    .executes(RotAttributeCommand::addRot)
        )));

        root.then(CommandManager.literal("rot_attribute")
            .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("remove")
                    .then(CommandManager.argument("player", EntityArgumentType.player())
                    .executes(RotAttributeCommand::removeRot)
        )));

        dispatcher.register(root);
    }

    public static int addRot(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {

        ServerPlayerEntity entity = EntityArgumentType.getPlayer(context, "player");

        try {
            if (Boolean.TRUE.equals(entity.getAttached(ModAttachmentTypes.ROTTED))) {

                entity.addStatusEffect(new StatusEffectInstance(ModEffects.RIFT_ROT, -1, 0, false, false));
                context.getSource().sendError(Text.literal("Target is already under the effects of Rift Rot. Applied effect anyway."));
                return 0;

            } else {
                entity.setAttached(ModAttachmentTypes.ROTTED, true);
                entity.addStatusEffect(new StatusEffectInstance(ModEffects.RIFT_ROT, -1, 0, false, false));
                context.getSource().sendMessage(Text.literal("Applied Rift Rot Effect & Attribute to " + Objects.requireNonNull(entity.getDisplayName()).getString()));
                return 1;
            }

        } catch( Exception e ){ context.getSource().sendError(Text.literal( "This is probably the dev's fault, please reach out!!! " + e)); }
        return -1;
    }

    public static int removeRot(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {

        ServerPlayerEntity entity = EntityArgumentType.getPlayer(context, "player");

        try {
        if (Boolean.FALSE.equals(entity.getAttached(ModAttachmentTypes.ROTTED))) {
            entity.removeStatusEffect(ModEffects.RIFT_ROT);
            context.getSource().sendError(Text.literal("Target is not under the effects of Rift Rot. Removed effect anyway."));
            return 0;

        } else {
            entity.setAttached(ModAttachmentTypes.ROTTED, false);
            entity.removeStatusEffect(ModEffects.RIFT_ROT);
            context.getSource().sendMessage(Text.literal("Removed Rift Rot Effect & Attribute from " + Objects.requireNonNull(entity.getDisplayName()).getString()));
            return 1;
        }
        } catch( Exception e ){ context.getSource().sendError(Text.literal( "This is probably the dev's fault, please reach out!!! " + e)); }
        return -1;
    }

}

