package CodeBrainstorming.StackAndQueue;

/**
 * @Author zlx
 * @Date 2024/5/30 14:01
 */
public class Solution1047 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c =  s.charAt(i);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
