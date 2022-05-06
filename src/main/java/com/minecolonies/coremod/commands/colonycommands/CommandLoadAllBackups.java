package com.minecolonies.coremod.commands.colonycommands;

import com.minecolonies.coremod.commands.commandTypes.IMCOPCommand;
import com.minecolonies.coremod.util.BackUpHelper;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TranslatableComponent;

import static com.minecolonies.api.util.constant.translation.CommandTranslationConstants.COMMAND_COLONY_LOAD_BACKUP_SUCCESS;

public class CommandLoadAllBackups implements IMCOPCommand
{
    /**
     * What happens when the command is executed after preConditions are successful.
     *
     * @param context the context of the command execution
     */
    @Override
    public int onExecute(final CommandContext<CommandSourceStack> context)
    {
        BackUpHelper.loadAllBackups();
        context.getSource().sendSuccess(new TranslatableComponent(COMMAND_COLONY_LOAD_BACKUP_SUCCESS), true);
        return 1;
    }

    /**
     * Name string of the command.
     */
    @Override
    public String getName()
    {
        return "loadAllColoniesFromBackup";
    }
}
