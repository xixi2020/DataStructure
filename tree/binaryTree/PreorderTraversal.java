package dataStructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 前序算法的两种思路：遍历和分解
 */
public class PreorderTraversal {
    //接收结果的list
    List<Integer> res = new LinkedList<>();
    //使用遍历的思维
    public List<Integer> preorderTraversal1(TreeNode root) {
        //前序遍历
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        //退出条件
        if (root == null ) return;
        //前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
    //使用分解的思路：根节点加左子树加右子树遍历结果
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        //加入根节点
        res.add(root.val);
        res.addAll(preorderTraversal2(root.left));
        res.addAll(preorderTraversal2(root.right));
        return res;
    }
}
