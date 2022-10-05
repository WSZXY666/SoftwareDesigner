package DataStructure.List;

//带头结点
public class Linklist2 {
    Node2 head;

    void init() {
        head = new Node2();
        head.date = 0; //头节点没有数据
        head.next = null; //没有头节点的下一个节点
        //head.next = head; 循环单链表
    }

    boolean insert(int k, Node2 node) {
        if (k < 1 || k > head.date + 1) {  //插入位置的条件
            System.out.println("插入位置不合法！");
            return false;
        }

        int i = 0;
        Node2 p = head;
        while (i < k - 1) {  //遍历链表到要插入的位置前一个
            i++;
            p = p.next;
        }

        if (p == null) {
            System.out.println("插入位置不合法！");
            return false;
        }

        node.next = p.next; //结点关系转换
        p.next = node;
        head.date++;
        System.out.println("插入成功！");
        return true;
    }

    void delete(int k) {
        if (k < 1 || k > head.date) {
            System.out.println("删除位置不合法！");
        }

        int i = 0;
        Node2 p = head;
        while (i < k - 1) {
            i++;
            p = p.next;
        }

        Node2 s = p.next;
        p.next = s.next;
        System.out.println("删除成功！");
        head.date--;
    }

    Node2 get(int k) {
        if (k < 1 || k > head.date) {
            System.out.println("查找位置不合法！");
            return null;
        }

        int i = 1;
        Node2 p = head.next;
        while (i < k) {
            i++;
            p = p.next;
        }
        return p;
    }

    void printList() {
        Node2 p = head.next;
        while (p != null) {  //p != head 循环单链表
            System.out.print(p.date + " ");
            p = p.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Linklist2 list = new Linklist2();
        list.init();
        list.insert(1, new Node2(6));
        list.insert(2, new Node2(7));
        list.insert(3, new Node2(8));
        list.printList();
        list.insert(2, new Node2(5));
        list.printList();
        list.delete(1);
        list.printList();
        System.out.println(list.get(1).date);
    }
}

class Node2 {
    int date;
    Node2 next;

    public Node2() {

    }

    public Node2(int date) {
        this.date = date;
    }
}
