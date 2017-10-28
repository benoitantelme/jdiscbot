package com.discord.bot;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class WordsUsageServiceTest {

    public static final String APPLE = "apple";
    public static final String TEST = "test";
    public static final String TEST_2 = "test2";

    @Test
    public void testWordsMap() throws Exception {
        WordsUsageService ms = new WordsUsageService();

        ms.addWordIfMissing(APPLE);
        ms.updateWords(APPLE, TEST);
        ms.updateWords(APPLE, TEST_2);

        try {
            ms.updateWords("bird", TEST);
        } catch (Exception e) {
            assertNotNull(e);
        }

        assertEquals(1, ms.wordsUsage.entrySet().size());

        Map<String, Integer> apples = ms.wordsUsage.get(APPLE);
        assertEquals(2, apples.entrySet().size());
        assertTrue(apples.get(TEST).equals(1));
    }

    @Test
    public void testWordsSummary() throws Exception {
        WordsUsageService ms = new WordsUsageService();

        String result = ms.getWordsSummary();
        assertTrue(result.isEmpty());

        ms.addWordIfMissing(APPLE);
        result = ms.getWordsSummary();
        assertFalse(result.isEmpty());

        ms.updateWords(APPLE, TEST);
        ms.updateWords(APPLE, TEST_2);
        result = ms.getWordsSummary();
        assertFalse(result.isEmpty());
    }


}
