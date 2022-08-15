package DataStructure.Sort;

public class main {
    //直接插入排序
    static void insertion_Sort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int temp = a[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
    }

    //希尔排序
    static void shell_Sort(int[] a, int n) {
        int gap = n;
        while (gap != 1) {
            gap /= 2;
            for (int k = 0; k < gap; k++) {
                for (int i = k + gap; i < n; i += gap) {
                    int temp = a[i], j;
                    for (j = i - gap; j >= 0; j -= gap) {
                        if (a[j] > temp) {
                            a[j + gap] = a[j];
                        } else {
                            break;
                        }
                    }
                    a[j + gap] = temp;
                }
            }
        }
    }

    //选择排序
    static void selection_Sort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    //冒泡排序
    static void bubble_Sort(int[] a, int n) {
        for (int i = n - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j + 1 <= i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

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

    //归并排序
    static void merge_Sort(int[] a, int l, int r) { //元素，左边界，右边界
        int[] t = new int[9];

        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2; //中间元素
        merge_Sort(a, l, mid);
        merge_Sort(a, mid + 1, r);

        int i = 1, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                t[k++] = a[i++];
            } else {
                t[k++] = a[j++];
            }
        }
        while (i <= mid) {
            t[k++] = a[i++];
        }
        while (j <= r) {
            t[k++] = a[j++];
        }
        for (i = 1, j = 0; i <= r; i++, j++) {
            a[i] = t[j];
        }
    }

    //封装函打印函数
    static void print(int arr[]) {
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int len = 9;
        int a[] = {2, 5, 8, 3, 6, 9, 1, 4, 7};
        int b[] = {1, 2, 3, 5, 211, 985, 520, 66, 123};
        int c[] = {2, 5, 8, 3, 6, 9, 1, 4, 7};
        int d[] = {1, 2, 3, 5, 211, 985, 520, 66, 123};
        int e1[] = {2, 5, 8, 3, 6, 9, 1, 4, 7};
        int e2[] = {2, 5, 8, 3, 6, 9, 1, 4, 7};
        int e3[] = {2, 5, 8, 3, 6, 9, 1, 4, 7};
        int f[] = {1, 2, 3, 5, 211, 985, 520, 66, 123};
        insertion_Sort(a, len);
        print(a);
        shell_Sort(b, len);
        print(b);
        selection_Sort(c, len);
        print(c);
        bubble_Sort(d, len);
        print(d);
        quick1_Sort(e1, 0, e1.length - 1);
        print(e1);
        quick2_Sort(e2, 0, e2.length - 1);
        print(e2);
        quick3_Sort(e3, 0, e3.length - 1);
        print(e3);
        merge_Sort(f, 0, f.length - 1);
        print(f);
    }
}
