package DataStructure.Tree;

public class houOrder {
    public static void main(String[] args) {
        TreeNode3 node1 = new TreeNode3(1);
        TreeNode3 node2 = new TreeNode3(2);
        TreeNode3 node3 = new TreeNode3(3);
        TreeNode3 node4 = new TreeNode3(4);
        TreeNode3 node5 = new TreeNode3(5);
        TreeNode3 node6 = new TreeNode3(6);
        TreeNode3 node7 = new TreeNode3(7);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;

        System.out.println("后序遍历：");
        houOrderD(node1);
    }

    static void houOrderD(TreeNode3 root) {
        if (root == null) {
            return;
        }
        houOrderD(root.left);
        houOrderD(root.right);
        System.out.print(root.value + " ");
    }
}

class TreeNode3 {
    int value;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3(int value) {
        this.value = value;
    }
}
