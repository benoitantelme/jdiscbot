package com.discord.bot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordsBotTest {

    @Test
    public void testGetWordForAdd(){
        String goodCommand = "!add apple";
        String emptyCommand = "!add";
        String emptyCommand2 = "!add ";
        String wrongCommand = "!adda";

        WordsBot bot = new WordsBot();
        assertEquals("apple", bot.getWordForAdd(goodCommand));
        assertEquals(WordsBot.EMPTY_STRING, bot.getWordForAdd(emptyCommand));
        assertEquals(WordsBot.EMPTY_STRING, bot.getWordForAdd(emptyCommand2));
        assertEquals(WordsBot.EMPTY_STRING, bot.getWordForAdd(wrongCommand));
    }
}
