import java.util.*;

public class TextAnalysisTool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // User Input
        System.out.println("Please enter a paragraph or a lengthy text:");
        String text = scanner.nextLine();
        
        // Character Count
        int charCount = text.length();
        System.out.println("Total number of characters: " + charCount);
        
        // Word Count
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        System.out.println("Total number of words: " + wordCount);
        
        // Most Common Character
        char mostCommonChar = findMostCommonChar(text);
        System.out.println("Most common character: " + mostCommonChar);
        
        // Character Frequency
        System.out.println("Please enter a character to check its frequency:");
        char charToCheck = scanner.nextLine().toLowerCase().charAt(0);
        int charFrequency = countCharFrequency(text, charToCheck);
        System.out.println("Frequency of character '" + charToCheck + "': " + charFrequency);
        
        // Word Frequency
        System.out.println("Please enter a word to check its frequency:");
        String wordToCheck = scanner.nextLine().toLowerCase();
        int wordFrequency = countWordFrequency(words, wordToCheck);
        System.out.println("Frequency of word '" + wordToCheck + "': " + wordFrequency);
        
        // Unique Words
        int uniqueWordCount = countUniqueWords(words);
        System.out.println("Number of unique words: " + uniqueWordCount);
        
        scanner.close();
    }
    
    private static char findMostCommonChar(String text) {
        text = text.replaceAll("\\s", "").toLowerCase();
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return Collections.max(charCountMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    
    // For check the frequency of the input character

    private static int countCharFrequency(String text, char charToCheck) {
        text = text.toLowerCase();
        int frequency = 0;
        for (char c : text.toCharArray()) {
            if (c == charToCheck) {
                frequency++;
            }
        }
        return frequency;
    }
    
    private static int countWordFrequency(String[] words, String wordToCheck) {
        int frequency = 0;
        for (String word : words) {
            if (word.toLowerCase().equals(wordToCheck)) {
                frequency++;
            }
        }
        return frequency;
    }
    
    private static int countUniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        return uniqueWords.size();
    }
}
