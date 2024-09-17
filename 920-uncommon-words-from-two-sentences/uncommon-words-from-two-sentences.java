import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        
        // Use HashMap to store word frequencies
        HashMap<String, Integer> map = new HashMap<>();
        
        // Add words to the map
        addWordsToMap(map, arr1);
        addWordsToMap(map, arr2);
        
        // List to store the words with value 1
        ArrayList<String> uncommonWords = new ArrayList<>();
        
        // Collect all words with a frequency of 1
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                uncommonWords.add(key);
            }
        }
        
        // Convert list to array and return
        return uncommonWords.toArray(new String[0]);
    }

    // Method to update the map with word counts
    private void addWordsToMap(HashMap<String, Integer> map, String[] arr) {
        for (String word : arr) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }
}