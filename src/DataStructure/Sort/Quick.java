package DataStructure.Sort;

public class Quick {
    //快速排序(取首元素)
    static void quick1_Sort(int[] a, int min, int max) {
        if (min >= max) {
            return;
        }
        int i = min, j = max, star = a[min];
        while (i < j) {
            while (i < j && a[j] >= star) {
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i] <= star) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = star;
        print(a);
        quick1_Sort(a, min, i - 1);
        quick1_Sort(a, i + 1, max);
    }

    //快速排序(取尾元素)
    static void quick2_Sort(int[] a, int min, int max) {
        if (min >= max) {
            return;
        }
        int i = min, j = max, star = a[max];
        while (i < j) {
            while (i < j && a[i] <= star) {
                i++;
            }
            a[j] = a[i];
            while (i < j && a[j] >= star) {
                j--;
            }
            a[i] = a[j];
        }
        a[i] = star;
        print(a);
        quick2_Sort(a, min, i - 1);
        quick2_Sort(a, i + 1, max);
    }

    //快速排序(取中间元素)
    static void quick3_Sort(int[] a, int min, int max) {
        if (min >= max) {
            return;
        }
        int i = min - 1, j = max + 1, star = a[(min + max) / 2];
        while (i < j) {
            do {
                i++;
            } while (a[i] < star);
            do {
                j--;
            } while (a[j] > star);
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        print(a);
        quick3_Sort(a, min, j);
        quick3_Sort(a, j + 1, max);
    }

    //封装函打印函数
    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] e1 = {5, 56, 8, 23, 6, 9, 1, 42, 7};
        int[] e2 = {2, 51, 38, 3, 16, 9, 10, 4, 27};
        int[] e3 = {12, 65, 8, 53, 16, 59, 1, 24, 37};

        System.out.println("（首基准）排序前：");
        print(e1);
        System.out.println("排序过程：");
        quick1_Sort(e1, 0, e1.length - 1);
        System.out.println("排序后：");
        print(e1);

        System.out.println("\n（尾基准）排序前：");
        print(e2);
        System.out.println("排序过程：");
        quick2_Sort(e2, 0, e2.length - 1);
        System.out.println("排序后：");
        print(e2);

        System.out.println("\n（中间基准）排序前：");
        print(e3);
        System.out.println("排序过程：");
        quick3_Sort(e3, 0, e3.length - 1);
        System.out.println("排序后：");
        print(e3);
    }
}
