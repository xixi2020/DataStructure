package dataStructure.tree.binaryTree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */
public class LowestCommonAncestor {



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果左节点或者右节点是p或者q就直接返回它的根节点
        if (root == null || root == p || root == q) return root;
        //分别返回q和p的根节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //代表根节点都在左子树
        if (left == null) return right;
        //代表根节点都在右子树
        if (right == null) return left;
        return root;

    }
}
