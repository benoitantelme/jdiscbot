package com.discord.bot;

import com.discord.util.BotToken;
import com.discord.util.WordsUsageService;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class WordsBot extends ListenerAdapter {
    protected static final String EMPTY_STRING = "";

    private static WordsUsageService ms = new WordsUsageService();

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        ms.addWord("apple");

        JDA jda = new JDABuilder(AccountType.BOT).setToken(BotToken.TOKEN).buildBlocking();
        jda.addEventListener(new WordsBot());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        if (author.isBot())
            return;

        String authorName = author.getName();

        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        String msg = message.getContent();

        if (msg.equals("!sum")){
            channel.sendMessage(ms.getWordsSummary()).queue();
        }else if (msg.startsWith("!add")) {
            channel.sendMessage(addCommand(msg, authorName)).queue();
        }else if(ms.containsWord(msg)){
            ms.updateWord(msg, authorName);
            channel.sendMessage("Word " + msg + " has been counted for " + authorName).queue();
        }else{
            channel.sendMessage(msg).queue();
        }

    }

    protected String addCommand(String msg, String authorName){
        String word = getWordForAdd(msg);
        String outputMessage = null;

        if(!word.isEmpty()){
            ms.addWord(word);
            outputMessage = "Word " + word + " has been added for " + authorName;
        }else{
            outputMessage = "Word " + word + " is already counted for.";
        }

        return  outputMessage;
    }

    protected String getWordForAdd(String message){
        String[] splittedMessage =  message.split(" ");
        String result = EMPTY_STRING;

        if(splittedMessage.length == 2) {
            result = splittedMessage[1];
        }

        return result;
    }

}
