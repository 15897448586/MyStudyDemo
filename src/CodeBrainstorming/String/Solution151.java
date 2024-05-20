package CodeBrainstorming.String;

/**
 * @Author zlx
 * @Date 2024/5/20 15:51
 */
public class Solution151 {
    public String reverseWords(String s) {
        int n =  s.length();
        char[] chs = s.toCharArray();
        int i = n - 1;
        StringBuilder sb  = new StringBuilder();
        while (i >= 0) {
            int j = i;
            while (i >= 0 && chs[i] == ' ') {
                i--;
            }
            if(i != j && (j != n - 1 && i >= 0)) sb.append(' ');
            StringBuilder temp = new StringBuilder();
            while (i >= 0 && chs[i] != ' ') {
                temp.append(chs[i]);
                i--;
            }
            sb.append(temp.reverse());
        }
        return sb.toString();
    }
}
