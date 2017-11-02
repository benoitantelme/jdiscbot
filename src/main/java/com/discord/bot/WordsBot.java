package com.discord.bot;

import com.discord.util.BotConstants;
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

public class WordsBot extends ABOT {
    protected static final String EMPTY_STRING = "";
    public static final String WORD = "Word ";
    public static final String HAS_BEEN_ADDED_FOR = " has been added for ";
    public static final String IS_ALREADY_COUNTED_FOR = " is already counted for.";
    public static final String EMPTY_WORD = "Empty word";

    private static WordsUsageService ms = new WordsUsageService();

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        ms.addWord("apple");

        WordsBot bot = new WordsBot();
        bot.createBot();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(fromBot(event))
            return;

        String authorName = event.getAuthor().getName();

        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        String msg = message.getContent();

        if (msg.equals("!sum")){
            channel.sendMessage(ms.getWordsSummary()).queue();
        }else if (msg.startsWith("!add")) {
            channel.sendMessage(addCommand(msg, authorName)).queue();
        }else if(ms.containsWord(msg)){
            ms.updateWord(msg, authorName);
            channel.sendMessage(WORD + msg + " has been counted for " + authorName).queue();
        }else{
            channel.sendMessage(msg).queue();
        }

    }

    protected String addCommand(String msg, String authorName){
        String word = getWordForAdd(msg);
        String outputMessage = null;

        if(!word.isEmpty()){
            if(ms.containsWord(word)){
                outputMessage = WORD + word + IS_ALREADY_COUNTED_FOR;
            }else{
                ms.addWord(word);
                outputMessage = WORD + word + HAS_BEEN_ADDED_FOR + authorName;
            }
        }else{
            outputMessage = EMPTY_WORD;
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
