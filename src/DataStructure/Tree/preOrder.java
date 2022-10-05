package DataStructure.Tree;

import java.util.Stack;

/**
 * 前序遍历的递归实现与非递归实现
 * 前序遍历首先访问根节点 然后遍历左子树，最后遍历右子树。
 * 在遍历左右子树时，仍然先访问根结点，然后遍历左子树，最后遍历右子树。
 * 若二叉树为空则结束返回否则
 * （1）访问根结点
 * （2)前序遍历左子树
 * （3）前序遍历右子树
 */
public class preOrder {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode("A");
        TreeNode node2 = new TreeNode("B");
        TreeNode node3 = new TreeNode("C");
        TreeNode node4 = new TreeNode("D");
        TreeNode node5 = new TreeNode("E");
        TreeNode node6 = new TreeNode("F");
        TreeNode node7 = new TreeNode("G");

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;

        System.out.println("先序遍历：");
        preOrderD(node1);
        System.out.print("\n");
        preOrderFd(node1);
    }

    static void preOrderD(TreeNode root) {
        //递归实现
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderD(root.left);
        preOrderD(root.right);
    }

    /**
     * 非递归实现：
     * 用栈结构，把遍历到的结点押进栈，没子结点时再出栈
     */
    static void preOrderFd(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); //进栈
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop(); //出栈
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}

class TreeNode {
    String value;
    TreeNode left;
    TreeNode right;

    TreeNode(String value) {
        this.value = value;
    }
}
