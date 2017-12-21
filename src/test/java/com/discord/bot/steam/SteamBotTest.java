package com.discord.bot.steam;

import com.discord.constants.CommonConstants;
import com.discord.util.SteamService;
import com.discord.util.SteamServiceTest;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.restaction.ChannelAction;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SteamBotTest {

    private static final String GOOD_NEWS_CMD = SteamBot.NEWS + CommonConstants.SPACE + CommonConstants.PLAYERUNKNOWN_S_BATTLEGROUNDS;
    private static final String BAD_NEWS_CMD = SteamBot.NEWS + CommonConstants.SPACE + "aaa";
    private static final String EMPTY_NEWS_CMD = SteamBot.NEWS + CommonConstants.SPACE;
    private static final String EMPTY_NEWS_CMD_2 = SteamBot.NEWS;

    private static final String GOOD_PLAYER_CMD = SteamBot.PLAYER + CommonConstants.SPACE + SteamServiceTest.PLAYER_ID;
    private static final String UNKNOWN_PLAYER_CMD = SteamBot.PLAYER + CommonConstants.SPACE + "aaa";
    private static final String EMPTY_PLAYER_CMD = SteamBot.PLAYER + CommonConstants.SPACE;
    private static final String EMPTY_PLAYER_CMD_2 = SteamBot.PLAYER;

    private final SteamBot bot = new SteamBot();
    private final MessageReceivedEvent event = mock(MessageReceivedEvent.class);
    private final MessageChannel channel = mock(MessageChannel.class);
    private final Message message = mock(Message.class);
    private final RestAction restAction = mock(ChannelAction.class);


    @Before
    public void init() {
        User author = mock(User.class);

        //manage author identity
        when(event.getAuthor()).thenReturn(author);
        when(author.isBot()).thenReturn(false);
        when(author.getName()).thenReturn("author");

        //plug channel and message
        when(event.getChannel()).thenReturn(channel);
        when(event.getMessage()).thenReturn(message);
    }

    @Test
    public void testOnMessageReceivedForNewsCmd() {
        //test add command
        when(message.getContent()).thenReturn(GOOD_NEWS_CMD);
        when(channel.sendMessage(anyString())).thenReturn(restAction);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(anyString());

        when(message.getContent()).thenReturn(BAD_NEWS_CMD);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(SteamService.GAME_NOT_FOUND);

        when(message.getContent()).thenReturn(EMPTY_NEWS_CMD);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(SteamBot.NO_GAME_SPECIFIED_FOR_NEWS);

        // invocation occurs twice ...
        when(message.getContent()).thenReturn(EMPTY_NEWS_CMD_2);
        bot.onMessageReceived(event);
        verify(channel, times(2)).sendMessage(SteamBot.NO_GAME_SPECIFIED_FOR_NEWS);
    }

    @Test
    public void testOnMessageReceivedForPlayerInfoCmd() {
        //test add command
        when(message.getContent()).thenReturn(GOOD_PLAYER_CMD);
        when(channel.sendMessage(anyString())).thenReturn(restAction);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(anyString());

        when(message.getContent()).thenReturn(UNKNOWN_PLAYER_CMD);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(SteamService.PLAYER_NOT_FOUND);

        when(message.getContent()).thenReturn(EMPTY_PLAYER_CMD);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(SteamBot.NO_PLAYER_SPECIFIED_FOR_INFO);

        // invocation occurs twice ...
        when(message.getContent()).thenReturn(EMPTY_PLAYER_CMD_2);
        bot.onMessageReceived(event);
        verify(channel, times(2)).sendMessage(SteamBot.NO_PLAYER_SPECIFIED_FOR_INFO);
    }

}
