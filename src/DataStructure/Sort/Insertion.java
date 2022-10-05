package DataStructure.Sort;

//直接插入排序
public class Insertion {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 15, 4, 3, 1, 11};
        int n = 9;

        System.out.println("排序前：");
        print_arr(arr);
        System.out.println("\n");

        System.out.println("排序过程；");
        insertion_sort(arr, n); //排序

        System.out.println("\n排序后：");
        print_arr(arr);
    }

    static void insertion_sort(int[] arr, int len) {
        for (int i = 1; i < len; i++) {
            int temp = arr[i], j;
            // 往后挪动比key小的值
            for (j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            // 将key放到正确位置
            arr[j + 1] = temp;
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


