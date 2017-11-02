package com.discord.bot;

import com.discord.util.BotConstants;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public abstract class ABOT extends ListenerAdapter {

    public boolean fromBot(MessageReceivedEvent event) {
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
}
