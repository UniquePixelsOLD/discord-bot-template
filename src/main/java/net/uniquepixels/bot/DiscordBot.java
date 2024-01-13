package net.uniquepixels.bot;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.uniquepixels.bot.discord.builder.commands.handler.CommandListener;
import net.uniquepixels.bot.mongo.MongoConnection;

public class DiscordBot extends ListenerAdapter {
    public DiscordBot() throws InterruptedException {

        MongoConnection mongoConnection = new MongoConnection();

        JDABuilder builder = JDABuilder.createDefault(System.getenv("DISCORD_TOKEN"));

        builder.addEventListeners(new CommandListener());

        builder.setActivity(Activity.watching("Discord UP Template"));

        JDA bot = builder.build().awaitReady();


    }

    public static void main(String[] args) throws InterruptedException {
        new DiscordBot();
    }
}