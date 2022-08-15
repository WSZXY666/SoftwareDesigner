package DataStructure.List;

//不带头结点
public class Linklist1 {
    Node list;
    int length;

    void init() {
        list = null;
        length = 0;
    }

    boolean insert(int k, Node node) {
        if (k < 1 || k > length + 1) {
            System.out.println("插入位置不合法！");
            return false;
        }

        if (k == 1) {
            node.next = list;
            list = node;
            length++;
            System.out.println("插入成功！");
            return true;
        }

        int i = 1;
        Node p = list;
        while (i < k - 1) {
            i++;
            p = p.next;
        }

        if (p == null) {
            System.out.println("插入位置不合法！");
            return false;
        }

        node.next = p.next;
        p.next = node;
        length++;
        System.out.println("插入成功！");
        return true;
    }

    boolean delete(int k) {
        if (k < 1 || k > length) {
            System.out.println("删除位置不合法！");
            return false;
        }

        if (k == 1) {
            list = list.next;
            length--;
            System.out.println("删除成功！");
            return true;
        }

        int i = 1;
        Node p = list;
        while (i < k - 1) {
            i++;
            p = p.next;
        }

        Node s = p.next;
        p.next = s.next;
        System.out.println("删除成功！");
        length--;
        return true;
    }

    Node get(int k) {
        if (k < 1 || k > length) {
            System.out.println("查找位置不合法！");
            return null;
        }

        int i = 1;
        Node p = list;
        while (i < k) {
            i++;
            p = p.next;
        }
        return p;
    }

    void printList() {
        Node p = list;
        while (p != null) {
            System.out.print(p.date + " ");
            p = p.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Linklist1 list = new Linklist1();
        list.init();
        list.insert(1, new Node(12));
        list.insert(2, new Node(34));
        list.insert(3, new Node(56));
        list.printList();
        list.insert(5, new Node(78));
        list.printList();
        list.delete(1);
        list.printList();
        System.out.println(list.get(1).date);
    }
}

class Node {
    int date;
    Node next;

    public Node(int date) {
        this.date = date;
    }
}