package DataStructure.Sort;

//选择排序
public class Selection {
    public static void main(String[] args) {
        int[] arr = {7, 9, 19, 2, 2};
        int n = arr.length;

        System.out.println("排序前：");
        print_arr(arr);
        System.out.println("\n");

        System.out.println("排序过程；");
        selection_sort(arr, n); //排序

        System.out.println("\n排序后：");
        print_arr(arr);
    }

    static void selection_sort(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            int min = i; //排序开始前默认a[0]的值最小，用min记录其下标
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j; //找到比a[0]小的数后，用min记录其下标
                }
            }
            int temp = arr[min]; //将最小值与当前值交换
            arr[min] = arr[i];
            arr[i] = temp;
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
