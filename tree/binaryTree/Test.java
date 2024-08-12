package dataStructure.tree.binaryTree;

/**
 * 这里提供各个算法的测试方法
 */
public class Test {
    public static void main(String[] args) {

            TreeNode treeNode1 = new TreeNode(1);
            TreeNode treeNode2 = new TreeNode(2,null,null);
            TreeNode treeNode3 = new TreeNode(3,null,null);
            TreeNode treeNode4 = new TreeNode(4,null,null);
            treeNode3.right = treeNode4;
            //最近公共祖先
            //LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
            //中序遍历
            InorderTraversal inorderTraversal = new InorderTraversal();

            treeNode1.right = treeNode3;
            treeNode1.left = treeNode2;
            System.out.println(inorderTraversal.inorderTraversal(treeNode1).toString());

        }

}
