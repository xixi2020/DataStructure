package dataStructure.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inoder(root, list);
        return list;

    }

    //用递归的方式
    private void inoder(TreeNode root, List<Integer> list) {
        //终止条件
        if (root ==null){
            return;
        }
        //中序遍历
        if (root.left != null){
            inoder(root.left ,list);
        }
        list.add(root.val);
        if (root.right != null){
            inoder(root.right, list);
        }
    }

    //用迭代的方式来遍历
    public List <Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList <>();
        Stack<TreeNode> stack = new Stack <>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
