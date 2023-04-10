package DataStructure.Sort;

//冒泡排序
public class Bubble {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 20, 4, 3, 1, 11};
        int n = 9;

        System.out.println("排序前：");
        print_arr(arr);

        System.out.println("\n");
        System.out.println("排序过程：");
        bubble_sort(arr, n); //排序

        System.out.println("\n排序后：");
        print_arr(arr);
    }

    static void bubble_sort(int[] arr, int len) {
        // 外层循环：逐趟扫描
        // i>1的原因：只有一个元素的数组自然有序
        for (int i = len - 1; i > 0; i--) {
            boolean swapped = false;  // 是否发生了交换的标志
            // 一趟扫描
            for (int j = 0; j + 1 <= i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;  // 若无交换发生，结束
            print_arr(arr);
            System.out.print("\n");
        }
    }

    public static void print_arr(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
