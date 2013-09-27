/**
 * This class is a BinaryTree class of the Heap implementation. It is implemented through doubly-linked list.
 * It is part of Assignment 3 for the Data Structures and Algorithms subject in Bond University.
 *
 * Class implements simple binary tree, providing access to the tree root and following methods:

 *  - public TreeNode getRoot()                                             - returns value of the root
 *  - public void setRoot(TreeNode r)                                       - sets new root value
 *  - public void addChild(TreeNode parent, TreeNode child)                 - add new child to the given node in the binary tree
 *  - public void removeChild(TreeNode child)                               - remove child from Binary Tree
 *
 * @author Roman Yakobnyuk
 * @date 04/08/2013
 */

public class BinaryTree {
    private TreeNode root = null;

    public TreeNode getRoot(){
        /**
         * This method returns value of the root
         */
        return root;
    }

    public void setRoot(TreeNode r){
        /**
         * This method sets new value of the root
         */
        root = r;
    }

    public void addChild(TreeNode parent, TreeNode child){
        /**
         * This method adds new child to the given node. If child has left child already - add right child.
         */
        child.setParent(parent);

        if ( parent.getLeft() == null){
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    public void removeChild(TreeNode child){
        /**
         * This method removes child from the binary tree by removing link to that child from the parent node.
         */

        if ( child.getParent() != null){

            TreeNode parent = child.getParent();

            if (parent.getLeft() == child){
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }

        }
        // If root is deleted - set root to null
        if ( child == root ){
            root = null;
        }

    }
}
