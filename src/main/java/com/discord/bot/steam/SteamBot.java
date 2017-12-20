package com.discord.bot.steam;

import com.discord.bot.ABot;
import com.discord.util.SteamService;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class SteamBot extends ABot {
    protected static final String NEWS = "!news";
    protected static final String PLAYER = "!player";
    protected static final String NO_GAME_SPECIFIED_FOR_NEWS = "No game specified for news.";
    protected static final String NO_PLAYER_SPECIFIED_FOR_INFO = "No player id specified for info.";

    private final SteamService service = new SteamService();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (fromBot(event))
            return;

        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContent();

        String result = null;
        if (msg.startsWith(NEWS)) {
            result = newsCommand(msg);
        }else if (msg.startsWith(PLAYER)) {
            result = playerInfoCommand(msg);
        }
        if(result != null){
            // output message max length
            if (result.length() > 1997)
                result = result.substring(0, 1998);
            channel.sendMessage(result).queue();
        }

    }

    private String newsCommand(String msg) {
        String word = getArgForCmd(msg);
        String outputMessage;

        if (!word.isEmpty()) {
            outputMessage = service.getGameNews(word);
        } else {
            outputMessage = NO_GAME_SPECIFIED_FOR_NEWS;
        }

        return outputMessage;
    }

    private String playerInfoCommand(String msg) {
        String playerId = getArgForCmd(msg);
        String outputMessage;

        if (!playerId.isEmpty()) {
            outputMessage = service.getPlayerInfo(playerId);
        } else {
            outputMessage = NO_PLAYER_SPECIFIED_FOR_INFO;
        }

        return outputMessage;
    }


}
