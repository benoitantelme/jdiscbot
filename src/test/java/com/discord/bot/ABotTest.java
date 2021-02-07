package com.discord.bot;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ABotTest {

    private static final WordsBot bot = new WordsBot();

    @Test
    public void testFromBot() {
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
        try {
            bot.createBot(ABot.WORDS);
        } catch (Exception e) {
            assertNull(e);
        }

        assertNotNull(bot);
    }
}
