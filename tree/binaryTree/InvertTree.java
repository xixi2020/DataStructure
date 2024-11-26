package dataStructure.tree.binaryTree;

/**
 * 226. 翻转二叉树
 * 简单
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertTree {
    //这里是直接使用递归的方式进行交换
    public TreeNode invertTree(TreeNode root) {
        //// 遍历二叉树，交换每个节点的子节点
        //        traverse(root);
        if (root == null) return null;
        //叶子节点先进行转换，后面根节点的左右节点再进行转换
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    //使用前序遍历的递归思维
    void traverse(TreeNode root) {
        if (root == null) return;
        //前序位置
        //临时交换节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //进行下一次交换
        traverse(root.left);
        traverse(root.right);
    }
    //使用分解的思想：先翻转左右子树，最后反转root
    //定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
    public TreeNode invertTree01(TreeNode root) {
        if (root == null) return null;
        //翻转左子树
        TreeNode left = invertTree01(root.left);
        TreeNode right = invertTree01(root.right);

        root.left = right;
        root.right = left;
        return root;
    }


}
