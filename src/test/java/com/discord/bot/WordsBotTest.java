package com.discord.bot;

import com.discord.constants.CommonConstants;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.restaction.ChannelAction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WordsBotTest {

    private static final String APPLE = "apple";
    private static final String GOOD_COMMAND = WordsBot.ADD + CommonConstants.SPACE + APPLE;
    private static final String AUTHOR = "author";
    private static final String WHATEVER = "whatever";

    @Test
    public void testGetWordForAdd() {
        String emptyCommand2 = WordsBot.ADD + CommonConstants.SPACE;
        String wrongCommand = WordsBot.ADD + "a";

        WordsBot bot = new WordsBot();
        assertEquals(APPLE, bot.getArgForCmd(GOOD_COMMAND));
        assertEquals(CommonConstants.EMPTY_STRING, bot.getArgForCmd(WordsBot.ADD));
        assertEquals(CommonConstants.EMPTY_STRING, bot.getArgForCmd(emptyCommand2));
        assertEquals(CommonConstants.EMPTY_STRING, bot.getArgForCmd(wrongCommand));
    }

    @Test
    public void testAddCommand() {
        WordsBot bot = new WordsBot();
        assertTrue(bot.addCommand(WordsBot.ADD, null).contains(WordsBot.EMPTY_WORD));
        assertTrue(bot.addCommand(WordsBot.ADD + " pie", null).contains(WordsBot.HAS_BEEN_ADDED_FOR));

        bot.addCommand(GOOD_COMMAND, null);
        assertTrue(bot.addCommand(GOOD_COMMAND, null).contains(WordsBot.IS_ALREADY_COUNTED_FOR));
    }

    @Test
    public void testOnMessageReceived() {
        WordsBot bot = new WordsBot();

        //create mocks
        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        User author = mock(User.class);
        MessageChannel channel = mock(MessageChannel.class);
        Message message = mock(Message.class);
        RestAction restAction = mock(ChannelAction.class);

        //manage author identity
        when(event.getAuthor()).thenReturn(author);
        when(author.isBot()).thenReturn(false);
        when(author.getName()).thenReturn(AUTHOR);

        //plug channel and message
        when(event.getChannel()).thenReturn(channel);
        when(event.getMessage()).thenReturn(message);

        //test sum command
        when(message.getContent()).thenReturn(WordsBot.SUM);
        when(channel.sendMessage(anyString())).thenReturn(restAction);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(bot.ms.getWordsSummary());

        //test add command
        when(message.getContent()).thenReturn(GOOD_COMMAND);
        when(channel.sendMessage(anyString())).thenReturn(restAction);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(WordsBot.WORD + APPLE + WordsBot.HAS_BEEN_ADDED_FOR + AUTHOR);

        //test word command
        bot.ms.addWord(APPLE);
        when(message.getContent()).thenReturn(APPLE);
        when(channel.sendMessage(anyString())).thenReturn(restAction);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(WordsBot.WORD + APPLE + WordsBot.HAS_BEEN_COUNTED_FOR + AUTHOR);

        //test random command
        bot.ms.addWord(APPLE);
        when(message.getContent()).thenReturn(WHATEVER);
        when(channel.sendMessage(anyString())).thenReturn(restAction);
        bot.onMessageReceived(event);
        verify(channel, times(1)).sendMessage(WHATEVER);
    }
}
