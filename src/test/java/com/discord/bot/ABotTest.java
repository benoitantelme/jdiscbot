package com.discord.bot;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ABotTest {

    @Test
    public void testFromBot() {
        WordsBot bot = new WordsBot();

        MessageReceivedEvent event = mock(MessageReceivedEvent.class);
        User author = mock(User.class);
        when(event.getAuthor()).thenReturn(author);

        when(author.isBot()).thenReturn(true);
        assertTrue(bot.fromBot(event));

        when(author.isBot()).thenReturn(false);
        assertFalse(bot.fromBot(event));
    }

    @Test
    public void testCreateBot() {
        WordsBot bot = new WordsBot();
        try {
            bot.createBot(ABot.WORDS);
        } catch (Exception e) {
            assertNull(e);
        }

        assertTrue(bot instanceof WordsBot);
    }
}
