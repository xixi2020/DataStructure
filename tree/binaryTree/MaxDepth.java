package dataStructure.tree.binaryTree;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * 简单
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 *
 * 输入：root = [1,null,2]
 * 输出：2
 */
public class MaxDepth {
    /**
     * Definition for a binary tree node.
     */
    //这里使用非递归的方法
    public int maxDepth(TreeNode root) {
        //第一种用递归的方式进行深度的遍历
        // return root == null ? 0 :
        //     Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        //第二种 使用非递归：层级遍历
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //队尾添加元素
        queue.offer(root);
        //记录还需要遍历的节点,此处即需要遍历root节点
        int preCount = 1;
        //记录左右节点，当左右结点不再有节点就为0
        int pCount = 0;
        //记录遍历的层数
        int level = 0;

        while(!queue.isEmpty()){
            //获取当前遍历的节点
            TreeNode temp = queue.poll();
            //还需要遍历的次数，每遍历一个节点就减一，直到这一层的节点全部遍历完成
            preCount--;
            //判断左右结点是否需要遍历
            if (temp.left != null) {
                queue.offer(temp.left);
                pCount++;
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                pCount++;
            }

            //这一层遍历完毕，层数加一
            if (preCount == 0) {
                preCount = pCount;
                pCount = 0;
                // System.out.println();
                level++;
            }
        }

        return level;

    }

    //记录结果
    int res = 0;
    //记录深度
    int depth = 0;
    //使用递归的思路
    public int maxDepth2(TreeNode root) {
        traverse(root);
        return res;

    }

    //使用递归的思路来记录最大深度
    private void traverse(TreeNode root) {
        //终止条件
        if (root == null) return;
        //每进入一层深度加一
        depth ++;
        //到达叶子节点：记录深度
        if (root.left == null && root.right == null){
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        //当前层级遍历结束
        depth --;
    }

    //使用分解的思路来计算：通过子树的最大深度来推算
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        //计算左右子树的最大深度
        int leftDepth = maxDepth3(root.left);
        int rightDepth = maxDepth3(root.right);
        //左右子树对比：注意这里要加上根节点
        int res = Math.max(leftDepth, rightDepth) + 1;

        return res;

    }

}
