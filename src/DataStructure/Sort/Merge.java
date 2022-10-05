package DataStructure.Sort;

//归并排序
public class Merge {
    public static void main(String[] args) {
        int[] arr = {9, 52, 3, 7, 12, 5, 4, 1, 11};
        int n = 9;
        int[] tempArr = new int[n];

        System.out.println("排序前：");
        print_arr(arr);

        merge_sort(arr, tempArr, 0, 8); //排序

        System.out.println("\n排序后：");
        print_arr(arr);
    }

    // 划分部分
    public static void merge_sort(int[] arr, int[] tempArr, int left, int right) {
        // 如果只有一个元素，那么不需要继续划分
        // 只有一个元素的区域，本生就是有序的，只需要被归并即可
        if (left < right) {
            // 找中间点
            int mid = (left + right) / 2;
            // 递归划分左半区
            merge_sort(arr, tempArr, left, mid);
            // 递归划分右半区
            merge_sort(arr, tempArr, mid + 1, right);
            // 合并已经排序的部分
            merge(arr, tempArr, left, mid, right);
        }
    }

    // 合并部分
    public static void merge(int[] arr, int[] tempArr, int left, int mid, int right) {
        // 标记左半区第一个未排序的元素
        int l_head = left;
        // 标记右半区第一个未排序的元素
        int r_head = mid + 1;
        // 临时数组元素的下标
        int p = left;

        // 合并
        while (l_head <= mid && r_head <= right) {
            if (arr[l_head] < arr[r_head]) {
                tempArr[p++] = arr[l_head++]; // 左半区第一个剩余元素更小
            } else {
                tempArr[p++] = arr[r_head++]; // 右半区第一个剩余元素更小
            }
        }

        // 合并左半区剩余的元素
        while (l_head <= mid) {
            tempArr[p++] = arr[l_head++];
        }

        // 合并右半区剩余的元素
        while (r_head <= right) {
            tempArr[p++] = arr[r_head++];
        }

        // 把临时数组中合并后的元素复制回原来的数组
        while (left <= right) {
            arr[left] = tempArr[left];
            left++;
        }
    }

    public static void print_arr(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
