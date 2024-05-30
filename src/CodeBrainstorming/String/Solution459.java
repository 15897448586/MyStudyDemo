package CodeBrainstorming.String;

/**
 * @Author zlx
 * @Date 2024/5/24 9:31
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
