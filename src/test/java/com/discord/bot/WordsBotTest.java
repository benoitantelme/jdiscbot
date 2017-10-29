package com.discord.bot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordsBotTest {

    public static final String APPLE = "apple";
    private static final String goodCommand = "!add apple";
    private static final String emptyCommand = "!add";

    @Test
    public void testGetWordForAdd(){
        String emptyCommand2 = "!add ";
        String wrongCommand = "!adda";

        WordsBot bot = new WordsBot();
        assertEquals(APPLE, bot.getWordForAdd(goodCommand));
        assertEquals(WordsBot.EMPTY_STRING, bot.getWordForAdd(emptyCommand));
        assertEquals(WordsBot.EMPTY_STRING, bot.getWordForAdd(emptyCommand2));
        assertEquals(WordsBot.EMPTY_STRING, bot.getWordForAdd(wrongCommand));
    }

    @Test
    public void testAddCommand(){
        WordsBot bot = new WordsBot();
        assertTrue(bot.addCommand(emptyCommand, null).contains(WordsBot.EMPTY_WORD));
        assertTrue(bot.addCommand(emptyCommand + " pie", null).contains(WordsBot.HAS_BEEN_ADDED_FOR));

        bot.addCommand(goodCommand, null);
        assertTrue(bot.addCommand(goodCommand, null).contains(WordsBot.IS_ALREADY_COUNTED_FOR));
    }
}
