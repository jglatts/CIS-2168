package problemtree;

import java.util.*;

public class ProblemTree {
   private static List<Integer> nodeList = new LinkedList<>();
   static Set set = new TreeSet<>();
   
   // returns a list of binary-tree nodes in in-order.
   public static List<Integer> createList(TreeNode<Integer> node) {
      // YOUR CODE HERE
      preOrder(node);
      //postOrder(node);
      //inOrder(node);
      return nodeList;
   }
   
   public static void preOrder(TreeNode<Integer> node) {
      // Preorder = root, left, right
      if (node == null) return;
      nodeList.add((int)node.data);
      preOrder(node.left); // traverse left subtree
      preOrder(node.right); // traverse right subtree
   }
   
   public static void inOrder(TreeNode<Integer> node) {
      // Inorder = left, root, right 
      if (node == null) return;   
      inOrder(node.left);
      nodeList.add((int)node.data);
      inOrder(node.right);   
   }

    public static void postOrder(TreeNode<Integer> node) {
      // Postorder = left, right, root     
      if (node == null) return;
      postOrder(node.left);
      postOrder(node.right);    
      nodeList.add((int)node.data);
    }
   
   public static void main(String[] args) {
      // Declare the 11 nodes for the problem 1 example
      TreeNode               root,
                  node1,                node2,
          node3,         node4,     node5,
      node6, node7,  node8,  node9,    node10;

      // Initialize problem 1 tree data
      root = new TreeNode(49);
      node1 = new TreeNode(21);
      node2 = new TreeNode(68);
      node3 = new TreeNode(20);
      node4 = new TreeNode(40);
      node5 = new TreeNode(55);
      node6 = new TreeNode(11);
      node7 = new TreeNode(19);
      node8 = new TreeNode(33);
      node9 = new TreeNode(44);
      node10 = new TreeNode(66);

      // link the nodes as shown in the picture
      // (the tree picture is in the homework instructions)
      // this is different then the picture 20 and 19 are swapped
      root.left = node1; root.right = node2;
      node1.left = node3; node1.right = node4;
      node2.left = node5;
      node3.left = node6; node3.right = node7;
      node4.left = node8; node4.right = node9;
      node5.right = node10;

      // print the list of tree nodes
      System.out.println(createList(root));
      //System.out.println(createList(node3));
   }
}
