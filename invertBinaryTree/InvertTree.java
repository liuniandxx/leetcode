/**
 * 
 * @author liunian 
 * 2015/07/01
 * 
 *  树的镜像
 * 
 *  使用递归： 先求左右子树的镜像，再交换左右子树
 * 
 *  分四种情况： 
 *  1. 树为空，或者树左右子树都为空， 直接返回其本身 
 *  2. 树左子树为空，右子树不为空，求其右子树的镜像，将其镜像设置为左子树，右子树设置为空 
 *  3. 树右子树为空，左子树不为空，求其左子树的镜像，将其镜像设置为右子树，左子树设置为空 
 *  4. 树左右子树都不为空，分别求左右子树的镜像，
 *     将左子树的镜像设置为原树的右子树， 
 *     将右子树的镜像设置为原树的左子树
 *
 */
public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
		// 树为空，或者树左右子树都为空
		if (root == null || (root.left == null && root.right == null)) {
			return root;
		} else if (root.left == null) {
			//树左子树为空，右子树不为空
			root.left = invertTree(root.right);
			root.right = null;
		} else if (root.right == null) {
			// 树右子树为空，左子树不为空
			root.right = invertTree(root.left);
			root.left = null;
		} else {
			//树左右子树都不为空
			TreeNode keepLeft = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(keepLeft);
		}
		return root;
	}
}
