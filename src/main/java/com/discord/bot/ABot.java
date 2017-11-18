package com.discord.bot;

import com.discord.constants.BotConstants;
import com.discord.constants.CommonConstants;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public abstract class ABot extends ListenerAdapter {

    protected boolean fromBot(MessageReceivedEvent event) {
        boolean result = false;
        User author = event.getAuthor();
        if (author.isBot())
            result = true;

        return result;
    }

    protected void createBot() throws LoginException, RateLimitedException, InterruptedException {
        JDA jda = new JDABuilder(AccountType.BOT).setToken(BotConstants.TOKEN).buildBlocking();
        jda.addEventListener(new WordsBot());
    }

    protected String getArgForCmd(String message){
        String[] splittedMessage =  message.split(CommonConstants.SPACE);
        String result = CommonConstants.EMPTY_STRING;

        if(splittedMessage.length == 2) {
            result = splittedMessage[1];
        }

        return result;
    }
}
