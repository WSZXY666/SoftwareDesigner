package DataStructure.Sort;

//希尔排序
public class Shell {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 21, 4, 3, 1, 11};
        int n = arr.length;

        System.out.println("排序前：");
        print_arr(arr);
        System.out.println("\n");

        System.out.println("排序过程；");
        shell_sort(arr, n); //排序

        System.out.println("\n排序后：");
        print_arr(arr);
    }

    static void shell_sort(int[] arr, int len) {
        // 初始增量：len/2，每一趟之后除以二
        int k = 1;
        for (int gap = len / 2; gap > 0; gap /= 2, k++) { //6,3,1
            // 每一趟采用插入排序
            System.out.println("第" + k + "趟排序：");
            for (int i = gap; i < len; i++) {
                int temp = arr[i], j;
                for (j = i; j >= gap; j -= gap) {
                    if (arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
                print_arr(arr);
                System.out.print("\n");
            }
        }
    }

    public static void print_arr(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
