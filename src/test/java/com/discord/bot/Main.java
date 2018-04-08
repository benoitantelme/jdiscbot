package com.discord.bot;

import com.discord.util.SteamService;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

/**
 * Used to test bots manually
 */
public class Main {

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {

        WordsBot bot = new WordsBot();
//        bot.createBot(ABot.WORDS);
        bot.createBot(ABot.STEAM);
        SteamService service = new SteamService();
        System.out.println(service.getStoreFeatured());
    }

}