package CodeBrainstorming.Hash;

/**
 * @Author zlx
 * @Date 2024/5/17 12:06
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteCount = new int[26];
        int[] magazineCount = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteCount[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            magazineCount[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ransomNoteCount[i] > magazineCount[i]) return false;
        }
        return true;
    }
}
