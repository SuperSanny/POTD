//LeetCode: https://leetcode.com/problems/excel-sheet-column-title/
import java.util.*;
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();
        while(columnNumber-- > 0){
            int column = columnNumber%26+'A';
            title.append((char)column);
            columnNumber /= 26;
        }
        return title.reverse().toString();
    }
    public static void main(String[] args) {
        int columnNumber = 26;
        System.out.println(convertToTitle(columnNumber));
    }
}
