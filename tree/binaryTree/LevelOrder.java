package dataStructure.tree.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 一层一层遍历二叉树
 */
public class LevelOrder {
    //用递归的方法，要注意全局变量
    private List<List<Integer>> list = new ArrayList<>() ;

    public List<List<Integer>> levelOrder(TreeNode root) {
        dns(root,0);
        return list;
    }

    //用非递归的方式进行
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        //用一个栈来保存每一层的节点，并且用一个参数currentLevelSize来判断每个节点的数量
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每一层都用一个list保存
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //将每一层的list都加入这个总的list中
            ret.add(level);
        }

        return ret;
    }


    //用递归的方法
    public void dns(TreeNode node,int lever){
        if(node == null) return;
        //这里的size很重要，用来判断是不是这一层的第一个数
        if(list.size()==lever) list.add(new ArrayList<Integer>());

        list.get(lever).add(node.val);
        //每一层的层级都要带上，先建立数组，执行操作，再遍历
        dns(node.left,lever+1);
        dns(node.right,lever+1);
    }
}
