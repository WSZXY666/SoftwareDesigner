package DataStructure.Suanfa;

import static java.lang.Math.abs;

public class fdgn {
    static int N = 4;
    static int[] q = new int[N + 1]; // 存储皇后的列号

    public static void main(String[] args) {
        queen();
    }

    static boolean check(int j) { // 检查第 j 个皇后的位置是否合法
        for (int i = 1; i < j; i++) {
            if (q[i] == q[j] || abs(i - j) == abs(q[i] - q[j])) { // 判断是否在同一列和同一斜线上
                return false;
            }
        }
        return true;
    }

    static void queen() { // 求解 N 皇后 方案
        int i, answer = 0; // 方案数
        for (i = 1; i <= N; i++) {
            q[i] = 0;
        }
        int j = 1; // 表示正在摆放第 j 个皇后
        while (j >= 1) {
            q[j] = q[j] + 1; // 让第 j 个皇后向后一列摆放

            while (q[j] <= N && !check(j)) { // 判断第 j 个皇后的位置是否合法
                q[j] = q[j] + 1; // 不合法就往后一个位置摆放
            }

            if (q[j] <= N) { // 表示第 j 个皇后的找到一个合法的摆放位置
                if (j == N) { // 找到了 N 皇后的一组解
                    answer = answer + 1;
                    System.out.print("方案" + answer + "：");

                    for (i = 1; i <= N; i++) {
                        System.out.print(q[i] + " ");
                    }
                    System.out.print("\n");
                } else {
                    j = j + 1; // 继续摆放下一个皇后
                }
            } else { // 表示第 j 个皇后找不到一个合法的摆放位置
                q[j] = 0; // 还原第 j 个皇后的位置
                j = j - 1; // 回溯
            }
        }
    }
}
