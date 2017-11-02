package com.discord.bot;

import com.discord.util.SteamService;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.json.JSONObject;

import javax.security.auth.login.LoginException;

public class SteamBot extends ABot {

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        WordsBot bot = new WordsBot();
        bot.createBot();

        SteamService service = new SteamService();
        JSONObject myObj = service.getGameNews("PLAYERUNKNOWN'S BATTLEGROUNDS");
        System.out.println(myObj);
    }


}
