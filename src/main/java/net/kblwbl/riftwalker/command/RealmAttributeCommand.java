package net.kblwbl.riftwalker.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.kblwbl.riftwalker.registry.ModAttachmentTypes;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Objects;

import static net.kblwbl.riftwalker.RiftWalker.MOD_ID;

@SuppressWarnings({"UnstableApiUsage", "unused"})
public class RealmAttributeCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        var root = CommandManager.literal(MOD_ID);

        // Makes player VISIBLE from within realm - visible from inside and outside \\
        root.then(CommandManager.literal("realmAttribute")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("visible")
                    .then(CommandManager.literal("add")
                        .then(CommandManager.argument("player", EntityArgumentType.player())
                                .executes(RealmAttributeCommand::addRealmVisible)
                        ))));
        root.then(CommandManager.literal("realmAttribute")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("visible")
                    .then(CommandManager.literal("remove")
                        .then(CommandManager.argument("player", EntityArgumentType.player())
                                .executes(RealmAttributeCommand::removeRealmVisible)
                        ))));


        // Puts player INTO the realm - invisible from outside \\
        root.then(CommandManager.literal("realmAttribute")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("within")
                        .then(CommandManager.literal("add")
                                .then(CommandManager.argument("player", EntityArgumentType.player())
                                        .executes(RealmAttributeCommand::addRealmWithin)
                                ))));
        root.then(CommandManager.literal("realmAttribute")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("within")
                        .then(CommandManager.literal("remove")
                                .then(CommandManager.argument("player", EntityArgumentType.player())
                                        .executes(RealmAttributeCommand::removeRealmWithin)
                                ))));

        dispatcher.register(root);
    }

    public static int addRealmVisible(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity entity = EntityArgumentType.getPlayer(context, "player");

        try {
            if (Boolean.TRUE.equals(entity.getAttached(ModAttachmentTypes.REALM_VISIBLE))) {
                context.getSource().sendError(Text.literal("Target already has the Realm Visible attribute."));
                return 0;

            } else {
                entity.setAttached(ModAttachmentTypes.REALM_VISIBLE, true);
                context.getSource().sendMessage(Text.literal("Applied Realm Visible attribute to " + Objects.requireNonNull(entity.getDisplayName()).getString()));
                return 1;
            }

        } catch( Exception e ){ context.getSource().sendError(Text.literal( "This is probably the dev's fault, please reach out!!! " + e)); }
        return -1;
    }

    public static int removeRealmVisible(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity entity = EntityArgumentType.getPlayer(context, "player");

        try {
            if (Boolean.FALSE.equals(entity.getAttached(ModAttachmentTypes.REALM_VISIBLE))) {
                context.getSource().sendError(Text.literal("Target is not under the effects of Realm Visible."));
                return 0;

            } else {
                entity.setAttached(ModAttachmentTypes.REALM_VISIBLE, false);
                context.getSource().sendMessage(Text.literal("Removed Realm Visible attribute from " + Objects.requireNonNull(entity.getDisplayName()).getString()));
                return 1;
            }
        } catch( Exception e ){ context.getSource().sendError(Text.literal( "This is probably the dev's fault, please reach out!!! " + e)); }
        return -1;
    }

    public static int addRealmWithin(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity entity = EntityArgumentType.getPlayer(context, "player");

        try {
            if (Boolean.TRUE.equals(entity.getAttached(ModAttachmentTypes.REALM_WITHIN))) {
                context.getSource().sendError(Text.literal("Target already has the Realm Within attribute."));
                return 0;

            } else {
                entity.setAttached(ModAttachmentTypes.REALM_WITHIN, true);
                context.getSource().sendMessage(Text.literal("Applied Realm Within attribute to " + Objects.requireNonNull(entity.getDisplayName()).getString()));
                return 1;
            }

        } catch( Exception e ){ context.getSource().sendError(Text.literal( "This is probably the dev's fault, please reach out!!! " + e)); }
        return -1;
    }

    public static int removeRealmWithin(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity entity = EntityArgumentType.getPlayer(context, "player");

        try {
            if (Boolean.FALSE.equals(entity.getAttached(ModAttachmentTypes.REALM_WITHIN))) {
                context.getSource().sendError(Text.literal("Target is not under the effects of Realm Within."));
                return 0;

            } else {
                entity.setAttached(ModAttachmentTypes.REALM_WITHIN, false);
                context.getSource().sendMessage(Text.literal("Removed Realm Within attribute from " + Objects.requireNonNull(entity.getDisplayName()).getString()));
                return 1;
            }
        } catch( Exception e ){ context.getSource().sendError(Text.literal( "This is probably the dev's fault, please reach out!!! " + e)); }
        return -1;
    }

}
