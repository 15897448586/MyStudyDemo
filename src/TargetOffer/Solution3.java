package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/16 12:50
 */
public class Solution3 {

    public String pathEncryption(String path) {
        char[] chars = path.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                chars[i] =' ';
            }
        }
        return new String(chars);
    }
}
