package dataStructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 使用两种方法：递归和栈
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private boolean check(TreeNode q, TreeNode p) {
        //递归返回条件
        if (q == null && p == null ){
            return true;
        }
        //代表高度不同，一个有子节点，一个没有
        if (q == null || p == null){
            return false;
        }
        return q.val == p.val && check(q.left,p.right) && check(q.right,p.left);

    }

    //用非递归的方式进行
    public boolean check1(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}
