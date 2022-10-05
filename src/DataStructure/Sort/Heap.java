package DataStructure.Sort;

//堆排序
public class Heap {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 21, 4, 3, 1, 11};
        int n = 9;

        System.out.println("排序前：");
        print_arr(arr);

        heap_sort(arr, n);

        System.out.println("\n排序后：");
        print_arr(arr);
    }

    static void heapify(int[] arr, int len, int i) {
        int largest = i;
        int lson = i * 2 + 1;
        int rson = i * 2 + 2;

        if (lson < len && arr[largest] < arr[lson])
            largest = lson;
        if (rson < len && arr[largest] < arr[rson])
            largest = rson;
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, len, largest);
        }
    }

    // 堆排序入口
    static void heap_sort(int[] arr, int len) {
        int i;
        // 建堆
        for (i = len / 2 - 1; i >= 0; i--)
            heapify(arr, len, i);

        // 排序
        for (i = len - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void print_arr(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
