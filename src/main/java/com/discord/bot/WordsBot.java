package com.discord.bot;

import com.discord.util.CommonConstants;
import com.discord.util.WordsUsageService;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class WordsBot extends ABot {
    public static final String ADD = "!add";
    protected static final String WORD = "Word ";
    protected static final String HAS_BEEN_ADDED_FOR = " has been added for ";
    protected static final String IS_ALREADY_COUNTED_FOR = " is already counted for.";
    protected static final String EMPTY_WORD = "Empty word";
    public static final String HAS_BEEN_COUNTED_FOR = " has been counted for ";
    public static final String SUM = "!sum";

    protected static WordsUsageService ms = new WordsUsageService();

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

        if (msg.equals(SUM)){
            channel.sendMessage(ms.getWordsSummary()).queue();
        }else if (msg.startsWith(ADD)) {
            channel.sendMessage(addCommand(msg, authorName)).queue();
        }else if(ms.containsWord(msg)){
            ms.updateWord(msg, authorName);
            channel.sendMessage(WORD + msg + HAS_BEEN_COUNTED_FOR + authorName).queue();
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
        String[] splittedMessage =  message.split(CommonConstants.SPACE);
        String result = CommonConstants.EMPTY_STRING;

        if(splittedMessage.length == 2) {
            result = splittedMessage[1];
        }

        return result;
    }

}
