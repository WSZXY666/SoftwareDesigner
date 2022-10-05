package DataStructure.Tree;

public class midOrder {
    public static void main(String[] args) {
        TreeNode2 node1 = new TreeNode2("A");
        TreeNode2 node2 = new TreeNode2("B");
        TreeNode2 node3 = new TreeNode2("C");
        TreeNode2 node4 = new TreeNode2("D");
        TreeNode2 node5 = new TreeNode2("E");
        TreeNode2 node6 = new TreeNode2("F");
        TreeNode2 node7 = new TreeNode2("G");

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;

        System.out.println("中序遍历：");
        midOrderD(node1);
    }

    static void midOrderD(TreeNode2 root) {
        if (root == null) {
            return;
        }
        midOrderD(root.left);
        System.out.print(root.value + " ");
        midOrderD(root.right);
    }
}

class TreeNode2 {
    String value;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(String value) {
        this.value = value;
    }
}
