package dataStructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 简单
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 */
public class MinDepth {
    //记录最小深度
    int minDepth = Integer.MAX_VALUE;
    //记录当前深度
    int depth = 0;
    //分别用DFS和BFS进行解决
    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        //通过深度优先算法，也就是遍历的方式来记录深度
        traverseDFS(root);
        //通过广度优先算法，也就是层级遍历的方式来记录深度
        traverseBFS(root);
        return minDepth;
    }

    //BFS广度优先算法
    //由于 BFS 逐层遍历的逻辑，第一次遇到目标节点时，所经过的路径就是最短路径，算法可能并不需要遍历完所有节点就能提前结束
    private int traverseBFS(TreeNode root) {
        //终止条件
        if (root == null) return 0;
        //用队列来记录每一次节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //初始化深度为1
        int depth = 1;
        //队列中全部元素都遍历完成：即为空
        while(!queue.isEmpty()){
            //记录当前root有几个子节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //判断当前节点是否有子节点，即当前节点为非叶子节点
                //队尾弹出元素
                TreeNode node = queue.poll();
                //判断是否为叶子节点
                if (node.right == null && node.left == null){
                    return depth;
                }
                //将子节点加入队列中
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth ++;
        }
        return depth;
    }


    //DFS深度优先算法
    private void traverseDFS(TreeNode root) {
        //终止条件
        if (root == null) return;
        depth ++;
        //如果当前节点是叶子节点，就记录最小深度的值
        if (root.left == null && root.right == null){
            minDepth = Math.min(minDepth, depth);
        }
        traverseDFS(root.left);
        traverseDFS(root.right);
        //左右自述都便利完成了，深度减一
        depth --;
    }

}
