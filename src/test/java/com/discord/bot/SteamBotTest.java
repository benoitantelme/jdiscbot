package com.discord.bot;

import com.discord.constants.CommonConstants;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.restaction.ChannelAction;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SteamBotTest {

    private static final String GOOD_CMD = SteamBot.NEWS + CommonConstants.SPACE + CommonConstants.PLAYERUNKNOWN_S_BATTLEGROUNDS;
    private static final String BAD_CMD = SteamBot.NEWS + CommonConstants.SPACE + "aaa";
    private static final String EMPTY_CMD = SteamBot.NEWS + CommonConstants.SPACE;
    private static final String EMPTY_CMD_2 = SteamBot.NEWS;
    private static final String GAME_NOT_FOUND = "Game not found";

    @Test
    public void testOnMessageReceived() {
        SteamBot bot = new SteamBot();

        //create mocks
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        User author = mock(User.class);
        MessageChannel channel = mock(MessageChannel.class);
        Message message = mock(Message.class);
        RestAction restAction = mock(ChannelAction.class);

        //manage author identity
        when(event.getAuthor()).thenReturn(author);
        when(author.isBot()).thenReturn(false);
        when(author.getName()).thenReturn("author");

        //plug channel and message
        when(event.getChannel()).thenReturn(channel);
        when(event.getMessage()).thenReturn(message);

        //test add command
        when(message.getContent()).thenReturn(GOOD_CMD);
        when(channel.sendMessage(anyString())).thenReturn(restAction);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(anyString());

        when(message.getContent()).thenReturn(BAD_CMD);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(GAME_NOT_FOUND);

        when(message.getContent()).thenReturn(EMPTY_CMD);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(SteamBot.NO_GAME_SPECIFIED_FOR_NEWS);

        // invocation occurs twice ...
        when(message.getContent()).thenReturn(EMPTY_CMD_2);
        bot.onMessageReceived(event);
        verify(channel, times(2)).sendMessage(SteamBot.NO_GAME_SPECIFIED_FOR_NEWS);
    }
}
