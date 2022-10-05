package DataStructure.Sort;

public class Quick {
    //快速排序(取首元素)
    static void quick1_Sort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r, pivot = a[l];
        while (i < j) {
            while (i < j && a[j] >= pivot) {
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i] <= pivot) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = pivot;
        quick1_Sort(a, l, i - 1);
        quick1_Sort(a, i + 1, r);
    }

    //快速排序(取尾元素)
    static void quick2_Sort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r, pivot = a[r];
        while (i < j) {
            while (i < j && a[i] <= pivot) {
                i++;
            }
            a[j] = a[i];
            while (i < j && a[j] >= pivot) {
                j--;
            }
            a[i] = a[j];
        }
        a[i] = pivot;
        quick2_Sort(a, l, i - 1);
        quick2_Sort(a, i + 1, r);
    }

    //快速排序(取中间元素)
    static void quick3_Sort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l - 1, j = r + 1, pivot = a[(l + r) / 2];
        while (i < j) {
            do {
                i++;
            } while (a[i] < pivot);
            do {
                j--;
            } while (a[j] > pivot);
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        quick3_Sort(a, l, j);
        quick3_Sort(a, j + 1, r);
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
        System.out.println("排序前：");
        print(e1);
        print(e2);
        print(e3);

        quick1_Sort(e1, 0, e1.length - 1);
        System.out.println("排序后1：");
        print(e1);

        quick2_Sort(e2, 0, e2.length - 1);
        System.out.println("排序后2：");
        print(e2);

        quick3_Sort(e3, 0, e3.length - 1);
        System.out.println("排序后3：");
        print(e3);
    }
}
