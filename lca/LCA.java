import java.util.*;

/**
 * Created by liunian on 15-10-19.
 * 思路：构建 根节点到 所求节点的路径(stack)
 * 然后寻找相同最后节点
 */
public class LCA {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> preMap = searchTree(root);

        Stack<TreeNode> pathp = getPath(preMap, p);
        Stack<TreeNode> pathq = getPath(preMap, q);
        TreeNode pre = null;
        while (!pathp.isEmpty() && !pathq.isEmpty()) {
            if(pathp.peek().equals(pathq.peek())) {
                pre = pathp.pop();
                pathq.pop();
            } else {
                break;
            }
        }
        return pre;
    }


    public static Map<TreeNode, TreeNode> searchTree(TreeNode root) {
        Map<TreeNode, TreeNode> preMap = new HashMap<TreeNode, TreeNode>();
        if(root == null) {
            return preMap;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        preMap.put(root, null);

        while (!que.isEmpty()) {
            TreeNode top = que.remove();
            if(top.left != null) {
                que.add(top.left);
                preMap.put(top.left, top);
            }

            if(top.right != null) {
                que.add(top.right);
                preMap.put(top.right, top);
            }
        }
        return preMap;
    }

    public static Stack<TreeNode> getPath(Map<TreeNode, TreeNode> preMap,TreeNode p) {
        Stack<TreeNode> path = new Stack<TreeNode>();
        while (p != null) {
            path.push(p);
            p = preMap.get(p);
        }
        return path;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode com = lowestCommonAncestor(root, root, root.right);
        System.out.println(com.val);
    }
}
