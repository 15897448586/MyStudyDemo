package CodeBrainstorming.Hash;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/5/17 12:10
 */
public class Solution49 {
    int[] map =  new int[26];
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = countChar(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public String countChar(String str) {
        Arrays.fill(map, 0);
        char[] chars = str.toCharArray();
        for (char c : chars) {
            map[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                sb.append((char) (i + 'a')).append(map[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams01(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
