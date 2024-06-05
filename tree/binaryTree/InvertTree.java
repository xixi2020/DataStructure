package dataStructure.tree.binaryTree;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        //叶子节点先进行转换，后面根节点的左右节点再进行转换
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
