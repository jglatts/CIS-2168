// class Tree definition

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {
   private TreeNode<T> root;
   
   // constructor initializes an empty Tree of integers
   public Tree() { root = null; }

   // insert a new node in the binary search tree
   public void insertNode(T insertValue) {
      if (root == null)
         root = new TreeNode<T>(insertValue); // create root node
      else
         // call the insert method from TreeNode
         // this preserves the ordering of LESS-LEFT of the BinTree
         root.insert(insertValue); 
   }

   // begin preorder traversal
   public void preorderTraversal() {
      preorderHelper(root);
   }

   // recursive method to perform preorder traversal
   private void preorderHelper(TreeNode<T> node) {
      if (node == null) return; // base case

      System.out.printf("%s ", node.data); // output node data
      preorderHelper(node.leftNode); // traverse left subtree
      preorderHelper(node.rightNode); // traverse right subtree
   }

   // begin inorder traversal
   public void inorderTraversal() {
      inorderHelper(root);
   }

   // recursive method to perform inorder traversal
   private void inorderHelper(TreeNode<T> node) {
      if (node == null)  return;

      inorderHelper(node.leftNode); // traverse left subtree
      System.out.printf("%s ", node.data); // output node data
      inorderHelper(node.rightNode); // traverse right subtree
   }

   // begin postorder traversal
   public void postorderTraversal() {
      postorderHelper(root);
   }

   // recursive method to perform postorder traversal
   private void postorderHelper(TreeNode<T> node) {
      if (node == null) return;

      postorderHelper(node.leftNode); // traverse left subtree
      postorderHelper(node.rightNode); // traverse right subtree
      System.out.printf("%s ", node.data); // output node data
   }

   // return a reference to the root of this tree
   public TreeNode<T> getRoot() { 
       return this.root;
   }

   // get the depth of this node
   private int depth(TreeNode<T> node) {
        // YOUR CODE HERE
        // try and write this down
        int left, right;
        if (node == null) return 0; 
        else {
            left = depth(node.leftNode);
            right = depth(node.rightNode);
        }
        return (left > right) ? left+1 : right+1; 
   }

   // get depth of this tree
   public int depth() {
      return depth(this.root);
   }
      
   // begin contains method
   public TreeNode<T> contains(T value) {
       return containsHelper(value, root);
   }
   
   // recurisvely check if a given key is in the tree
   private TreeNode<T> containsHelper(T key, TreeNode<T> node) {
        if (node == null || node.data == key) return node;    // base case
        if (node.data.compareTo(key) > 0) return containsHelper(key, node.leftNode);
        return containsHelper(key, node.rightNode);
   }
   
   // begin outputTree method
   public void outputTree() {
       outputTreeHelper(root, 0);
   }
    
   // outputTreeHelper method
   // recurisvley print the tree in veritcal orientaion
   private void outputTreeHelper(TreeNode<T> node, int totalSpaces) {
        while (node != null) {
            outputTreeHelper(node.rightNode, totalSpaces+5);  // traverse right subtree
            for (int i = 0; i < totalSpaces; ++i) System.out.print(" ");
            System.out.printf("%s\n", node.data);              
            node = node.leftNode;
            totalSpaces += 5;
        }
   }   
   
   public void levelOrder() {
       if (root != null) levelOrderHelper(root);
       else System.out.println("Empty Tree!");
   }
   
   private void levelOrderHelper(TreeNode<T> node) {
       Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>() {};
       queue.add(node);
       while (!queue.isEmpty()) {
           TreeNode<T> t =  queue.remove();
           System.out.println(t.data);
           if (t.leftNode != null) 
               queue.add(t.leftNode);
           if (t.rightNode != null) 
               queue.add(t.rightNode);
       }
   }
   
} 