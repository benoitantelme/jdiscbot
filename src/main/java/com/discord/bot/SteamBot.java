package com.discord.bot;

import com.discord.util.SteamService;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class SteamBot extends ABot {
    protected static final String NEWS = "!news";
    protected static final String NO_GAME_SPECIFIED_FOR_NEWS = "No game specified for news.";

    private SteamService service = new SteamService();

    public static void main(String[] args)
            throws LoginException, RateLimitedException, InterruptedException {
        SteamBot bot = new SteamBot();
        bot.createBot(ABot.STEAM);

        SteamService service = new SteamService();
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

    private String newsCommand(String msg) {
        String word = getArgForCmd(msg);
        String outputMessage;

        if (!word.isEmpty()) {
            String news = service.getGameNews(word);

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
