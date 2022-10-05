package DataStructure.Sort;

//基数排序
public class Count {
    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 26, 21, 4, 3, 1, 11};
        int n = 9;

        System.out.println("排序前：");
        print_arr(arr);

        counting_sort(arr, n);

        System.out.println("\n排序后：");
        print_arr(arr);
    }

    static void counting_sort(int[] arr, int len) {
        if (len < 1) return;

        // 寻找最大的元素
        int max = arr[0];
        for (int i = 1; i < len; i++)
            if (arr[i] > max) max = arr[i];

        // 分配一个长度为max+1的数组存储计数，并初始化为0
        int[] count = new int[max + 1];

        // 计数
        for (int i = 0; i < len; i++)
            count[arr[i]]++;

        // 统计计数的累计值
        for (int i = 1; i < max + 1; i++)
            count[i] += count[i - 1];

        // 创建一个临时数组保存结果
        int[] output = new int[len];

        // 将元素放到正确的位置上
        for (int i = 0; i < len; i++) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // 将结果复制回原数组
        System.arraycopy(output, 0, arr, 0, len);
        // for (int i = 0; i < len; i++){
        //     arr[i] = output[i];
        // }
    }

    public static void print_arr(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
