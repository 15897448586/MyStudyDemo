package CodeBrainstorming.String;

/**
 * @Author zlx
 * @Date 2024/5/20 14:22
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
