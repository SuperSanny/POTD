//LeetCode: https://leetcode.com/problems/text-justification/
import java.util.*;
public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < words.length){
            List<String> list = getWords(i, words, maxWidth);
            i += list.size();
            result.add(createLine(list, i, words, maxWidth));
        }
        return result;
    }
    private static List<String> getWords(int i, String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int currLen = 0;
        while(i < words.length && currLen + words[i].length() <= maxWidth) {
            result.add(words[i]);
            currLen += words[i].length()+1;
            i++;
        }
        return result;
    }
    private static String createLine(List<String> line, int i, String[] words, int maxWidth) {
        int len = -1;
        for (String word : line) {
            len += word.length() + 1;
        }
        int extraSpace = maxWidth - len;
        if (line.size() == 1 || i == words.length) return String.join(" ", line)+ " ".repeat(extraSpace);
        int wordCount = line.size()-1;
        int spacePerWord = extraSpace/wordCount;
        int needsExtraSpace = extraSpace % wordCount;
        for(int j = 0; j < needsExtraSpace; j++) {
            line.set(j, line.get(j) + " ");
        }
        for(int j = 0; j < wordCount; j++) {
            line.set(j, line.get(j) + " ".repeat(spacePerWord));
        }
        return String.join(" ", line);
    }
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth));
    }
}
