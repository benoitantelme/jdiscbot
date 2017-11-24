package com.discord.bot;

import com.discord.util.SteamService;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.json.JSONObject;

import javax.security.auth.login.LoginException;

public class SteamBot extends ABot {
    public static final String NEWS = "!news";
    public static final String NO_GAME_SPECIFIED_FOR_NEWS = "No game specified for news.";
    public static final String ERROR = "error";

    private SteamService service = new SteamService();

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        SteamBot bot = new SteamBot();
        bot.createBot(ABot.STEAM);

        SteamService service = new SteamService();
        JSONObject myObj = service.getGameNewsJson("PLAYERUNKNOWN'S BATTLEGROUNDS");
        System.out.println(myObj);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (fromBot(event))
            return;

        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContent();

        if (msg.startsWith(NEWS)) {
            channel.sendMessage(newsCommand(msg)).queue();
        }
    }

    protected String newsCommand(String msg) {
        String word = getArgForCmd(msg);
        String outputMessage;

        if (!word.isEmpty()) {
            JSONObject jsonNews = service.getGameNewsJson(word);
            String news = jsonNews.has(ERROR) ? jsonNews.get(ERROR).toString() : service.parseGameNews(jsonNews);

            // output message max length
            if (news.length() > 1997)
                news = news.substring(0, 1998);
            outputMessage = news;
        } else {
            outputMessage = NO_GAME_SPECIFIED_FOR_NEWS;
        }

        return outputMessage;
    }


}
