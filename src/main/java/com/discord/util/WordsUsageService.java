package com.discord.util;

import java.util.HashMap;
import java.util.Map;

public class WordsUsageService {

    /**
     * Map of words to map of author to count
     */
    protected final Map<String, Map<String, Integer>> wordsUsage = new HashMap<>();

    public boolean containsWord(String word) {
        return wordsUsage.containsKey(word);
    }

    public void updateWord(String word, String author) {
        if (wordsUsage.containsKey(word)) {
            wordsUsage.get(word).merge(author, 1, (int1, int2) -> int1 + int2);
        }else{
            System.out.println("Word " + word + " is not counted yet.");
        }
    }

    public void addWord(String word) {
        wordsUsage.put(word, new HashMap<>());
    }

    public String getWordsSummary() {
        StringBuilder sb = new StringBuilder();

        wordsUsage.keySet().forEach(key -> {
            sb.append("For word ").append(key).append("\n");
            wordsUsage.get(key).entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                    forEach((e) -> sb.append("  ").append(e.getValue()).append(" times for author ").append(e.getKey()).append("\n"));
        });

        return sb.toString();
    }
}
