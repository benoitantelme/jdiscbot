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

    private static WordsUsageService ms = new WordsUsageService();

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        ms.addWord("apple");

        JDA jda = new JDABuilder(AccountType.BOT).setToken(BotToken.TOKEN).buildBlocking();
        jda.addEventListener(new WordsBot());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot())
            return;

        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        String msg = message.getContent();

        if (msg.equals("!sum")){
            channel.sendMessage(ms.getWordsSummary()).queue();
        }else if(ms.containsWord(msg)){


        }else{
            channel.sendMessage(msg).queue();
        }

    }

}
