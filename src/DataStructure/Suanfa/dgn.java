package DataStructure.Suanfa;

import static java.lang.Math.abs;

public class dgn {
    static int N = 5;
    static int answer = 0;
    static int[] q = new int[N + 1]; // 存储皇后的列号

    public static void main(String[] args) {
        queen(1);
    }

    static boolean check(int j) { // 检查第 j 个皇后的位置是否合法
        for (int i = 1; i < j; i++) {
            if (q[i] == q[j] || abs(i - j) == abs(q[i] - q[j])) { // 判断是否在同一列和同一斜线上
                return false;
            }
        }
        return true;
    }

    static void queen(int j) {
        for (int i = 1; i <= N; i++) {
            q[j] = i;
            if (check(j)) { // 当摆放的皇后位置为合法时
                if (j == N) { // 找到了 N 皇后的一组解
                    answer = answer + 1;
                    System.out.print("方案" + answer + "：");
                    for (i = 1; i <= N; i++) {
                        System.out.print(" " + q[i]);
                    }
                    System.out.print("\n");
                } else {
                    queen(j + 1); // 递归摆放下一个皇后的位置
                }
            }
        }
    }
}
