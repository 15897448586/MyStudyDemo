package TargetOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/4/17 14:08
 */
public class Solution9 {
    private char[] wordChars;
    private boolean[][] visited;
    private char[][] board;

    private final int[][] array = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int rows;

    private int cols;

//    private HashSet<String> set = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        wordChars = word.toCharArray();
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == wordChars[0] && backtrack(0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int wordIndex, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) return false;
        if (wordIndex >= wordChars.length || wordChars[wordIndex] != board[i][j]) return false;
        if (wordIndex == wordChars.length - 1 && wordChars[wordIndex] == board[i][j]) return true;
        String key = "" + wordIndex+i +j;
//        if (set.contains(key)) return false;
        visited[i][j] = true;
//        set.add(key);
        for (int k = 0; k < 4; k++) {
            int[] ints = array[k];
            int nextI = i + ints[0];
            int nextJ = j + ints[1];
            boolean backtrack = backtrack(wordIndex + 1, nextI, nextJ);
            if (backtrack) return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution9 s = new Solution9();
//        String[][] board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
//        String word = "ABCCED";
        String[][] board = {{"A","B","C","E"},{"S","F","E","S"},{"A","D","E","E"}};
        String word = "ABCESEEEFS";
//        String[][] board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
//        String word = "ABCB";
        char[][] chs = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                chs[i][j] = board[i][j].charAt(0);
            }
        }
        boolean exist = s.exist(chs, word);
        System.out.println(exist);
    }
}
