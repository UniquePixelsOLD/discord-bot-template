package net.uniquepixels.bot.discord.builder.commands.handler;

import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandListener extends ListenerAdapter {

    private final static List<CommandExecutor<GenericCommandInteractionEvent>> COMMAND_LIST = new ArrayList<>();

    public static List<CommandExecutor<GenericCommandInteractionEvent>> getCommandList() {
        return COMMAND_LIST;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        Optional<CommandExecutor<GenericCommandInteractionEvent>> first = COMMAND_LIST.stream().filter(commandExecutor -> commandExecutor.getData().getName().equals(event.getName())).findFirst();
        if (first.isEmpty())
            return;

        CommandExecutor<? extends GenericCommandInteractionEvent> commandExecutor = first.get();

        if (commandExecutor.getType() == SlashCommandInteractionEvent.class)
            first.get().onEvent(event);

    }

    @Override
    public void onMessageContextInteraction(MessageContextInteractionEvent event) {

        Optional<CommandExecutor<GenericCommandInteractionEvent>> first = COMMAND_LIST.stream().filter(commandExecutor -> commandExecutor.getData().getName().equals(event.getName())).findFirst();
        if (first.isEmpty())
            return;

        CommandExecutor<? extends GenericCommandInteractionEvent> commandExecutor = first.get();

        if (commandExecutor.getType() == MessageContextInteractionEvent.class)
            first.get().onEvent(event);

    }

    @Override
    public void onUserContextInteraction(UserContextInteractionEvent event) {
        Optional<CommandExecutor<GenericCommandInteractionEvent>> first = COMMAND_LIST.stream().filter(commandExecutor -> commandExecutor.getData().getName().equals(event.getName())).findFirst();
        if (first.isEmpty())
            return;

        CommandExecutor<? extends GenericCommandInteractionEvent> commandExecutor = first.get();

        if (commandExecutor.getType() == UserContextInteractionEvent.class)
            first.get().onEvent(event);
    }
}
