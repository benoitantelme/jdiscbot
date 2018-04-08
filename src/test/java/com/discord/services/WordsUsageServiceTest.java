package com.discord.services;

import com.discord.constants.CommonConstants;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class WordsUsageServiceTest {
    private static final String APPLE = "apple";
    private static final String TEST = "test";
    private static final String TEST_2 = "test2";

    @Test
    public void testWordsMap() {
        WordsUsageService ws = initialiseService(APPLE);

        ws.updateWord(APPLE, TEST);
        ws.updateWord(APPLE, TEST_2);

        ws.updateWord("bird", TEST);

        assertEquals(1, ws.wordsUsage.entrySet().size());

        Map<String, Integer> apples = ws.wordsUsage.get(APPLE);
        assertEquals(2, apples.entrySet().size());
        assertTrue(apples.get(TEST).equals(1));
    }

    @Test
    public void testWordsSummary() {
        WordsUsageService ws = initialiseService(null);

        String result = ws.getWordsSummary();
        assertTrue(result.isEmpty());

        ws.addWord(APPLE);
        result = ws.getWordsSummary();
        assertFalse(result.isEmpty());

        ws.updateWord(APPLE, TEST);
        ws.updateWord(APPLE, TEST_2);
        result = ws.getWordsSummary();
        assertFalse(result.isEmpty());
    }

    @Test
    public void testContainsWord() {
        WordsUsageService ws = initialiseService(null);
        assertFalse(ws.containsWord(APPLE));

        ws.addWord(APPLE);
        assertTrue(ws.containsWord(APPLE));

        assertTrue(ws.containsWord("a apple"));
        assertTrue(ws.containsWord("apple a"));

        assertFalse(ws.containsWord("applea"));
        assertFalse(ws.containsWord("aapple"));

        assertFalse(ws.containsWord(CommonConstants.EMPTY_STRING));
        assertFalse(ws.containsWord(CommonConstants.SPACE));
        assertFalse(ws.containsWord(null));
    }

    @Test
    public void testAddWord() {
        WordsUsageService ws = initialiseService(null);
        ws.addWord(APPLE);
        assertTrue(ws.containsWord(APPLE));
    }

    private WordsUsageService initialiseService(String word) {
        WordsUsageService ws = new WordsUsageService();

        if (word != null)
            ws.addWord(word);

        return ws;
    }

}
