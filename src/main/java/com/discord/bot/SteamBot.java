package com.discord.bot;

import com.discord.util.SteamService;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.json.JSONObject;

import javax.security.auth.login.LoginException;

public class SteamBot extends ABot {

    public static final String NEWS = "!news";

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        WordsBot bot = new WordsBot();
        bot.createBot();

        SteamService service = new SteamService();
        JSONObject myObj = service.getGameNews("PLAYERUNKNOWN'S BATTLEGROUNDS");
        System.out.println(myObj);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (fromBot(event))
            return;

        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContent();

        if (msg.startsWith(NEWS)) {

        }
    }

}
