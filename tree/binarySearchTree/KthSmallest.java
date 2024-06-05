package dataStructure.tree.binarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 这种找大小的值，可以优先考虑使用栈的方式，因为根节点一定是保留在最后的
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            while (root != null || !stack.isEmpty()) {
                //遍历左子树，栈顶是最小的数
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                //用栈来保留根节点，根节点是最早入栈最早出栈的
                root = stack.pop();
                //不是第k个，减1
                --k;
                if (k == 0) {
                    break;
                }
                //左边都比完了，开始比右子树
                root = root.right;
            }
            return root.val;
        }
}
