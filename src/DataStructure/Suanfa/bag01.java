package DataStructure.Suanfa;

//0-1背包问题（动态规划法）
public class bag01 {
    public static void main(String[] args) {
        int N = 5, W = 11, i, j; //N为物品数量，W为背包容量
        int[] v = {0, 1, 6, 18, 22, 28}; // 物品价值数组
        int[] w = {0, 1, 2, 5, 6, 7}; // 物品重量数组
        int[][] f = new int[N + 1][W + 1]; // 子问题解数组

        for (i = 1; i <= N; i++) {
            for (j = 1; j <= W; j++) {
                f[i][j] = f[i - 1][j]; // 默认不选第 i 个物品

                if (j >= w[i]) { // 选第 i 个物品的前提条件
                    // 等于 不选第 i 个物品 和 选第 i 个物品 两者的较大值
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - w[i]] + v[i]);
                }
                // 上方是写法 1
                //============================================================
                // 下方是写法 2
                /*
                if (j >= w[i]) { // 选第 i 个物品的前提条件
                    // 等于 不选第 i 个物品 和 选第 i 个物品 两者的较大值
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - w[i]] + v[i]);
                } else { // 不选第 i 个物品
                    f[i][j] = f[i - 1][j]; // 等于 从前 i - 1 个物品中选，背包容量为 j 时的最大价值
                }
                */
            }
        }
        System.out.println(f[N][W] + "\n");
        print_arr(f);
    }

    static void print_arr(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }
}
