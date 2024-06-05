package dataStructure.tree.binaryTree;

/**
 * 437. 路径总和 III
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class PathSumTwo {
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        //先算由根节点触发，包括自己的节点，满足相加为val的情况
        int ret = rootSum(root, targetSum);
        //再计算左右子树。
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, long targetSum) {
            int ret = 0;

            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }

            //这里的targetSum也是每次传递与递减的
            ret += rootSum(root.left, targetSum - val);
            ret += rootSum(root.right, targetSum - val);
            return ret;
    }

    int ans, t;
    public int pathSum1(TreeNode root, int _t) {
        t = _t;
        dfs1(root);
        return ans;
    }
    void dfs1(TreeNode root) {
        if (root == null) return;
        //先遍历自己左右节点包括自己满足路径的情况
        dfs2(root, root.val);
        //再遍历自己的左右结点满足路径的情况，最后全部相加。
        dfs1(root.left);
        dfs1(root.right);
    }
    void dfs2(TreeNode root, long val) {
        if (val == t) ans++;
        if (root.left != null) dfs2(root.left, val + root.left.val);
        if (root.right != null) dfs2(root.right, val + root.right.val);
    }

    //前缀方法进行优化，这里待补充


}
