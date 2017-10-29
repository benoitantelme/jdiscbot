package com.discord.util;

import java.util.HashMap;
import java.util.Map;

public class WordsUsageService {

    /**
     * Map of words to map of author to count
     */
    protected final Map<String, Map<String, Integer>> wordsUsage = new HashMap<>();

    protected String getWordsSummary() {
        StringBuilder sb = new StringBuilder();

        wordsUsage.keySet().forEach(key -> {
            sb.append("For word ").append(key).append("\n");
            wordsUsage.get(key).entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                    forEach((e) -> sb.append("  ").append(e.getValue()).append(" times for author ").append(e.getKey()).append("\n"));
        });

        return sb.toString();
    }

    public void updateWords(String word, String author) throws Exception {
        if (wordsUsage.containsKey(word)) {
            wordsUsage.get(word).merge(author, 1, (int1, int2) -> int1 + int2);
        }else{
            throw new Exception("Word " + word + " is not counted yet.");
        }
    }

    public void addWordIfMissing(String word) {
        wordsUsage.put(word, new HashMap<>());
    }
}
