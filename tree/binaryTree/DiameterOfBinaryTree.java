package dataStructure.tree.binaryTree;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class DiameterOfBinaryTree {

    //这里注意ans的作用范围
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;

    }

    //用递归的方法，分别找root左子树最深和右子树最深，相加路径的值
    private int dfs(TreeNode node) {
        //这里一定要注意返回是负数，因为最后一个节点返回的左右节点一定是0
        if (node == null)
            return -1; // 下面 +1 后，对于叶子节点就刚好是 0
        int lLen = dfs(node.left) + 1; // 左子树最大链长+1
        int rLen = dfs(node.right) + 1; // 右子树最大链长+1
        ans = Math.max(ans, lLen + rLen); // 两条链拼成路径
        //注意这里的返回值一定是要求最后一次递归能返回什么
        return Math.max(lLen, rLen); // 当前子树最大链长
    }
}
