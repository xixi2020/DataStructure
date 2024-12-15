package dataStructure.tree.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 `root` ，返回其节点值的 **锯齿形层序遍历** 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        //用来记录最终的结果
       List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        //用栈来记录每一层的节点
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        //用flag来控制方向true是从左开始，右是从右开始
        boolean flag = true;

        //记录节点
        while(!que.isEmpty()){
            //每一层的节点个数
            int size = que.size();
            //记录当前层数的节点
            LinkedList<Integer> levelRes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                //从左开始记录到res中
                if (flag){
                    //尾部加入
                    levelRes.addLast(node.val);
                }else{
                    //头部加入，也就是倒序加入
                    levelRes.addFirst(node.val);
                }
                //加入左右结点
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            //改变下一层遍历方向
            flag = !flag;
            res.add(levelRes);
        }
        return res;
    }
}
