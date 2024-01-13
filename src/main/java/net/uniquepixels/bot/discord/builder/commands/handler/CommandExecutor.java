package net.uniquepixels.bot.discord.builder.commands.handler;

import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import net.uniquepixels.bot.discord.builder.commands.CommandBuilder;

public abstract class CommandExecutor<E> {

    private final CommandDataImpl data;

    private final Class<E> type;

    public Class<E> getType() {
        return type;
    }

    public CommandExecutor(CommandBuilder builder, Class<E> clazz) {
        this.data = builder.buildData();
        this.type = clazz;
    }

    public CommandDataImpl getData() {
        return data;
    }

    public abstract void onEvent(E event);

}
