package net.kblwbl.riftwalker.registry;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.kblwbl.riftwalker.command.RealmAttributeCommand;
import net.kblwbl.riftwalker.command.RotAttributeCommand;

public class ModCommands {


    public static void init(){
        CommandRegistrationCallback.EVENT.register(RotAttributeCommand::register);
        CommandRegistrationCallback.EVENT.register(RealmAttributeCommand::register);
    }


}
