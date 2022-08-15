package DataStructure.List;

public class Shunlist {
    final int N = 10; //容量
    int[] a;
    int n; //表长

    void init() { //初始化
        a = new int[N];
        for (int i = 0; i < N / 2; i++) {
            a[i] = i + 1;
        }
        n = N / 2;

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }

    void insert(int k, int x) {
        if (k < 1 || k > n + 1) {
            System.out.print("插入的位置不合法！");
        } else {
            for (int i = n; i >= k; i--) { //将要插入的位置后面的元素向后移一位的操作
                a[i] = a[i - 1];
            }
            a[k - 1] = x; //用要插入的数替换原来位置的数
            n++;

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.print("\n");
        }
    }

    void delete(int k) {
        if (k < 1 || k > n) {
            System.out.print("删除的位置不合法！");
        } else {
            for (int i = k - 1; i < n; i++) { //删除的元素后面的元素向前移一位
                a[i] = a[i + 1];
            }
            n--;

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.print("\n");
        }
    }

    void getElements(int k) {
        if (k < 1 || k > n) {
            System.out.print("查找的位置不合法！");
        } else {
            System.out.print(a[k - 1]);
        }
    }

    public static void main(String[] args) {
        Shunlist list = new Shunlist();
        list.init();
        list.insert(4, 985);
        list.delete(5);
        list.getElements(4);
    }
}
