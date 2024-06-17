package CodeBrainstorming.DP;

/**
 * @Author zlx
 * @Date 2024/6/17 12:14
 */
public class Bag01 {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem1(weight,value,bagSize);
    }

    /**
     * 二维数组实现，dp数组的含义， i个物品放入j容量的背包中的最大价值
     * @param weight
     * @param value
     * @param bagSize
     */
    private static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize + 1];
//        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] +value[i])
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     * 一维数组实现 容量j的背包的最大权重，实现关键点 先遍历物品，再遍历背包容量（倒序） ，一定要注意是倒序，使用上次迭代完成的权重而不是本次更新后的权重
     * @param weight
     * @param value
     * @param bagSize
     */
    private static void testWeightBagProblem1(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.printf(dp[i] + "\t");
        }
    }
}
