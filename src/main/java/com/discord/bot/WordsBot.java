package com.discord.bot;

import com.discord.util.BotToken;
import com.discord.util.WordsUsageService;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class WordsBot extends ListenerAdapter {

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {

        WordsUsageService ms = new WordsUsageService();

        ms.addWordIfMissing("apple");

        JDA jda = new JDABuilder(AccountType.BOT).setToken(BotToken.TOKEN).buildBlocking();
        jda.addEventListener(new WordsBot());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot())
            return;

        Message message = event.getMessage();
        String msg = message.getContent();

        MessageChannel channel = event.getChannel();
        channel.sendMessage(msg).queue();
    }

}
