package dataStructure.tree.binarySearchTree;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
 * 平衡二叉搜索树。
 *
 *  二叉搜索树（BinarySearchTree，简称BST)
 *  是一种特殊的二叉树结构，它具有以下特点：
 *  有序性：对于BST中的每个节点，其左子树中的所有节点的值都小于该节点的值，而右子树中的所有节点的值都大于该节点的值。
 *  递归性：BST的每个子树也是BST，即子树中的节点仍然满足有序性和递归性。
 *  无重复值：BST中不允许存在相同值的节点。
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        //当是左边叶子节点的时候mid减1会为负数
        if (left > right) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}
