package dataStructure.tree.binaryTree;

import java.util.*;

/**
 *给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 */
public class RightSideView {
        public List<Integer> rightSideView(TreeNode root) {
            //记录每一层最右边的节点，只记录一次
            Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
            int max_depth = -1;
            //记录每个根节点，先左后右
            Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
            //用来记录深度，每个深度只取最右边的节点
            Deque<Integer> depthStack = new LinkedList<Integer>();
            nodeStack.push(root);
            depthStack.push(0);
            //当前节点没有子节点，不进行记录
            while (!nodeStack.isEmpty()) {
                TreeNode node = nodeStack.pop();
                int depth = depthStack.pop();

                if (node != null) {
                    // 维护二叉树的最大深度
                    max_depth = Math.max(max_depth, depth);

                    // 如果不存在对应深度的节点我们才插入
                    if (!rightmostValueAtDepth.containsKey(depth)) {
                        rightmostValueAtDepth.put(depth, node.val);
                    }

                    nodeStack.push(node.left);
                    nodeStack.push(node.right);
                    //左右节点都记录
                    depthStack.push(depth + 1);
                    depthStack.push(depth + 1);
                }
            }
            //遍历视图
            List<Integer> rightView = new ArrayList<Integer>();
            for (int depth = 0; depth <= max_depth; depth++) {
                rightView.add(rightmostValueAtDepth.get(depth));
            }

            return rightView;
        }
}

