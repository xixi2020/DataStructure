package dataStructure.tree.binaryTree;

/**
 * 543. 二叉树的直径
 * 简单
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 * 输入：root = [1,2]
 * 输出：1
 */
public class DiameterOfBinaryTree {

    //这里注意ans的作用范围
    int ans = 0;

    //第一种方法：最大深度，再相加值
    public int diameterOfBinaryTree(TreeNode root) {
        //前序思想求最大直径
        traverse(root);
        //后序思想
        maxDepth2(root);
//        dfs(root);
        return ans;

    }

    //把计算「直径」的逻辑放在后序位置
    private int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);
        //放在 `maxDepth` 的后序位置，因为 `maxDepth` 的后序位置是知道左右子树的最大深度的。
        int myDiameter = leftMax + rightMax;
        ans = Math.max(myDiameter, ans);
        return Math.max(leftMax, rightMax) + 1;
    }

    //前序思想：记录每一个节点的左右最大深度之和
    private void traverse(TreeNode root) {
        //遍历终止条件
        if (root == null) return;
        ////前序位置无法获取子树信息，所以只能让每个节点调用 `maxDepth` 函数去算子树的深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        //节点的直径：左右节点的深度之和
        int myDiameter = leftMax + rightMax;
        //记录最大深度
        ans = Math.max(myDiameter, ans);
        //这里是前序的思想：前序记录值
        traverse(root.left);
        traverse(root.right);

    }

    //每个节点的最大深度
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
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
