/**
 * This class is a TreeNode class of the Heap implementation. It is implemented through doubly-linked list.
 * It is part of Assignment 3 for the Data Structures and Algorithms subject in Bond University.
 *
 * Class TreeNode for constructing BinaryTree. This class is used as value type in Deque to store TreeNodes as pointers to the frontier.
 * TreeNode provides following functionality:
 *
 *  - public TreeNode(Comparable k,Object v, TreeNode l, TreeNode r, TreeNode p)   - constructor method
 *  - public TreeNode(Comparable k,Object v)                                       - constructor method
 *
 *  - public TreeNode getLeft() { return left; }                                   -- Set of getter and setter methods for class variables
 *  - public void setLeft(TreeNode left) {this.left = left;}
 *  - public TreeNode getRight() {return right;}
 *  - public void setRight(TreeNode right) {this.right = right;}
 *  - public TreeNode getParent() { return parent;}
 *  - public void setParent(TreeNode parent) {this.parent = parent;}
 *  - public Object getValue() {return value;}
 *  - public Comparable getKey(){return key;}
 *  - public void setKey(Comparable k){ key = k;}
 *  - public void setValue(Object v){value = v;}                                   --
 *
 *  - public boolean hasTwoChildren()                                              - returns true if this node has two children
 *
 * @author Roman Yakobnyuk
 * @date 04/08/2013
 */

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private Comparable key;
    private Object value;

    public TreeNode(Comparable k,Object v, TreeNode l, TreeNode r, TreeNode p){
        /**
         * This method is a constructor class for TreeNode
         */
        left = l;
        right = r;
        parent = p;
        value = v;
        key = k;
    }

    public TreeNode(Comparable k,Object v){
        /**
         * This method is a constructor class for DequeNode
         */
        this(k,v,null,null,null);
    }

    /**
     * This set of methods are setter and getter methods for the following class variables:
     * - left   = left child
     * - right  = right child
     * - parent = parent node
     * - key    = key value
     * - value  = value
     */
    public TreeNode getLeft() { return left; }
    public void setLeft(TreeNode left) {this.left = left;}
    public TreeNode getRight() {return right;}
    public void setRight(TreeNode right) {this.right = right;}
    public TreeNode getParent() { return parent;}
    public void setParent(TreeNode parent) {this.parent = parent;}
    public Object getValue() {return value;}
    public Comparable getKey(){return key;}
    public void setKey(Comparable k){ key = k;}
    public void setValue(Object v){value = v;}

    public boolean hasTwoChildren(){
        /**
         * This method returns true if this node has two children
         */
        if ( left != null && right != null){
            return true;
        } else {
            return false;
        }
    }
}
