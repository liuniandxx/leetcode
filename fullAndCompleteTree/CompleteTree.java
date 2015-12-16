import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liunian on 15-10-20.
 * 判断一个二叉树是不是完全二叉树:
 * 思路： 按层遍历(BST)， 当一个节点只有右孩子没有左孩子，肯定不是，
 * 当一个节点没有右孩子，那么其后面节点都将没有孩子，否则不是完全二叉树
 */
public class CompleteTree {
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);

        boolean hasChild = true;

        while (!que.isEmpty()) {
            TreeNode head = que.remove();
            if (!hasChild) {
                if (head.left != null || head.right != null) {
                    return false;
                }
            } else {
                if (head.left == null && head.right != null) {
                    return false;
                }

                if (head.right == null) {
                    hasChild = false;
                }

                if(head.left != null) {
                    que.add(head.left);
                }

                if(head.right != null) {
                    que.add(head.right);
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.right = new TreeNode(7);

        System.out.println(isCompleteTree(root));
    }
}
