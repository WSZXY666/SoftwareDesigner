package DataStructure.Suanfa;

public class partbag {
    static int N = 5;
    static int W = 10;
    static int[] v_temp = new int[N + 1];
    static int[] w_temp = new int[N + 1]; // 物品价值数组 和 物品重量数组的临时数组
    static double[] vw_temp = new double[N + 1]; // 物品单位重量价值数组的临时数组
    static double[] answer = new double[N + 1]; // 解方案数组

    public static void main(String[] args) {
        int[] v = {0, 6, 3, 5, 4, 6}; // 物品价值数组
        int[] w = {0, 2, 2, 6, 5, 4}; // 物品重量数组
        double[] vw = new double[N + 1]; // 物品单位重量价值数组
        int i;

        // 初始化 物品单位重量价值数组
        for (i = 1; i <= N; i++) {
            vw[i] = (double) v[i] / w[i];
        }

        System.out.print("排序前：\n");
        show(v, w, vw);

        merge_sort(v, w, vw, 1, N);

        System.out.print("\n排序后：\n");
        show(v, w, vw);

        double result = Max_Value(v, w, vw);
        System.out.print("\nresult = ");
        System.out.printf("%.1f", result);
        System.out.print("\n解方案结果：");
        for (i = 1; i <= N; i++) {
            System.out.printf("%.1f", answer[i]);
            System.out.print(" ");
        }
    }

    // 归并排序
    static void merge_sort(int[] v, int[] w, double[] vw, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        merge_sort(v, w, vw, l, mid);
        merge_sort(v, w, vw, mid + 1, r);

        int i = l, j = mid + 1, k = 1;
        while (i <= mid && j <= r) {
            if (vw[i] >= vw[j]) { // 按照 物品单位重量价值数组 从大到小的顺序排序
                vw_temp[k] = vw[i];
                v_temp[k] = v[i];
                w_temp[k] = w[i];
                k++;
                i++;
            } else {
                vw_temp[k] = vw[j];
                v_temp[k] = v[j];
                w_temp[k] = w[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            vw_temp[k] = vw[i];
            v_temp[k] = v[i];
            w_temp[k] = w[i];
            k++;
            i++;
        }

        while (j <= r) {
            vw_temp[k] = vw[j];
            v_temp[k] = v[j];
            w_temp[k] = w[j];
            k++;
            j++;
        }

        for (i = l, j = 1; i <= r; i++, j++) {
            vw[i] = vw_temp[j];
            v[i] = v_temp[j];
            w[i] = w_temp[j];
        }
    }

    // 打印出物品价值、重量、单位重量价值数组
    static void show(int[] v, int[] w, double[] vw) {
        int i;

        System.out.print("物品价值数组：");
        for (i = 1; i <= N; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.print("\n");

        System.out.print("物品重量数组：");
        for (i = 1; i <= N; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.print("\n");

        System.out.print("物品单位重量价值数组：");
        for (i = 1; i <= N; i++) {
            System.out.printf("%.1f", vw[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    // 求解部分背包问题最优解
    static double Max_Value(int[] v, int[] w, double[] vw) {
        double result = 0.0;
        int i;
        int W_temp = W;

        for (i = 1; i <= N; i++) {
            if (W_temp >= w[i]) { // 当前背包容量 大于等于 物品重量 就直接全部装入到背包中
                answer[i] = 1.0;
                result = result + v[i];
                W_temp = W_temp - w[i];
            } else { // 当前背包容量 小于 物品重量 就应该将该物品的一部分装入到背包中
                break;
            }
        }

        if (W_temp > 0 && i <= N) { // 当前背包还有剩余容量 并且 还有可选的物品
            answer[i] = (double) W_temp / w[i];
            result = result + W_temp * vw[i];
        }
        return result;
    }
}


