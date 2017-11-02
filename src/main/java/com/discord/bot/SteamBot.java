package com.discord.bot;

import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class SteamBot extends ABot {

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        WordsBot bot = new WordsBot();
        bot.createBot();
    }


}
