package dataStructure.tree.binaryTree;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    /**
     * Definition for a binary tree node.
     */
    class Solution {
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
    }
}
