/**
 * This class is a DequeNode class of the Heap implementation. It is implemented through doubly-linked list.
 * It is part of Assignment 3 for the Data Structures and Algorithms subject in Bond University.
 *
 * Class implements DequeNode for the Deque class to operate. This nodes are building blocks of the doubly-linked list and provide following functionality:
 *
 *  - public DequeNode(TreeNode v, DequeNode l, DequeNode r)                - constructor class
 *  - public DequeNode(TreeNode v)                                          - constructor class
 *  - public DequeNode getNext()                                            - get next node
 *  - public DequeNode getLast()                                            - get previous node
 *  - public TreeNode getValue()                                            - get value of this node
 *  - public void setNext (DequeNode n)                                     - set next node
 *  - public void setLast (DequeNode l)                                     - set previous node
 *
 * @author Roman Yakobnyuk
 * @date 04/08/2013
 */

public class DequeNode {
    private DequeNode next;  // Next node
    private DequeNode last;  // Previous node
    private TreeNode value;  // Value

    public DequeNode(TreeNode v, DequeNode l, DequeNode n){
        /**
         * This method is a constructor class for DequeNode
         */
        value = v;
        next = n;
        last = l;
    }

    public DequeNode(TreeNode v){
        /**
         * This method is a constructor class for DequeNode
         */
        this(v,null,null);
    }


    /**
     * This set of methods are setter and getter methods for the following class variables:
     * - next
     * - last
     * - value
     */
    public DequeNode getNext(){ return next; }
    public DequeNode getLast(){ return last; }
    public TreeNode getValue(){ return value; }
    public void setNext (DequeNode n){ next = n; }
    public void setLast (DequeNode l){ last = l; }
}
