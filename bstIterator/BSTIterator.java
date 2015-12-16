import java.util.Stack;

/**
 * Created by liunian on 15-10-27.
 * stack 实现 非递归中序遍历
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        helper(cur.right);
        return cur.val;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(7);

        BSTIterator iter = new BSTIterator(node);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
