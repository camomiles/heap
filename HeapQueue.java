/**
 * This class is a HeapQueue class of the Heap implementation. It is implemented through doubly-linked list.
 * It is part of Assignment 3 for the Data Structures and Algorithms subject in Bond University.
 *
 * Class implements all class signatures from Heap interface, and operates over Binary Tree and Deque in order to do so.
 *
 * It describes following methods:
 *  - public Object front()                             - returns value of the front object, which it the root of the tree.
 *  - public void insert(Comparable key, Object obj)    - inserts new element into the heap
 *  - public Object remove()                            - returns front object and removes it from the heap.
 *  - private void bubbleUp(TreeNode node)              - bubbles given node up in the tree if parents key is lower.
 *  - private void bubbleDown(TreeNode node)            - bubbles given node down in the tree if at least one of the children has bigger key. If both - swaps with the one with bigger key.
 *  - public boolean isEmpty()                          - returns true if heap is empty, otherwise false.
 *
 * @author Roman Yakobnyuk
 * @date 04/08/2013
 */

public class HeapQueue implements Heap {
    private BinaryTree tree = new BinaryTree();
    private Deque deque = new Deque();

    public Object front(){
        /**
         * This method gives access to the front of the heap without deleting it.
         */
        return tree.getRoot().getValue();
    }

    public void insert(Comparable key,Object obj){
        /**
         * This method inserts new TreeNode created from key and object parameters to the Binary Tree and Deque to manage.
         *
         * @param key - key to compare inserted values. should be comparable using .compareTo with other inserted keys.
         * @param obj - value to store within TreeNode
         */
        if ( deque.isEmpty() ){
            // If deque is empty -> heap is empty. We can create new TreeNode and put it into the root.
            TreeNode node = new TreeNode(key,obj);
            tree.setRoot(node);
            deque.insertAtFront(node);
        } else {
            // Create new node and add it the tree
            TreeNode newNode = new TreeNode(key,obj);
            tree.addChild(deque.accessFront(), newNode);

            // If the next insertion point now has two children -> deque from front
            if (deque.accessFront().hasTwoChildren()){
                deque.removeFront();
            }

            // Enqueue new node to the rear of the frontier deque
            deque.insertAtRear(newNode);
            // Bubble this node up
            bubbleUp(newNode);
        }
    }

    public Object remove(){
        /**
         * This method removes value from the top of the heap to return it.
         * It also deletes it from the binary tree and deque to keep track of the frontier
         *
         */

        if (this.isEmpty()){
            throw new HeapEmptyException(" Cannot remove from an empty heap. ");
        }

        Object returnValue;
        TreeNode root = tree.getRoot();
        TreeNode node = deque.accessRear();

        // If root item removed then set root equal to null
        if ( root == node ){
            tree.setRoot(null);
        } else {
            // If right child is deleted - add parent to the frontier as next insertion point
            if ( node.getParent().getRight() != null && node == node.getParent().getRight()){
                deque.insertAtFront(node.getParent());
            }
        }

        // fill root from the last inserted point
        returnValue = root.getValue();
        root.setValue(node.getValue());
        root.setKey(node.getKey());

        // Delete last inserted point node from the tree and deque
        tree.removeChild(node);
        deque.removeRear();
        // If can be bubbled - bubble it down
        if (root.getLeft() != null){
            bubbleDown(root);
        }
        // Return value
        return returnValue;
    }

    private void bubbleUp(TreeNode node){
        /**
         * This method swaps contents of the given node and it's parent if given node's key is higher then one parent has.
         * If the node swapped and can be swapped again - this method is called on the node recursively until it cannot be bubbled up anymore
         *
         * @param node - node to bubble up
         */
        try{
        if (node.getKey().compareTo(node.getParent().getKey()) == 1){

            // Save contents of the given node
            Object tempVal = node.getValue();
            Comparable tempKey = node.getKey();
            // Fill node with its parent contents
            node.setValue(node.getParent().getValue());
            node.setKey(node.getParent().getKey());
            // Fill parent with node's saved contents
            node.getParent().setValue(tempVal);
            node.getParent().setKey(tempKey);

            // If node has grandparent - check if can be bubbled up again by recursive call to itself
            if ( node.getParent().getParent() != null){
                bubbleUp(node.getParent());
            }
        }
        } catch (ClassCastException e){
             throw new IncomparableKeysException(" Cannot compare keys '" + node.getKey() + "' and '" + node.getParent().getKey() + "'");
        }
    }

    private void bubbleDown(TreeNode node){
        /**
         * This method swaps contents of the given node and one of its children, if one of them has higher key then node has.
         * In case if both children have bigger key values - the one with bigger is chosen to swap.
         * If can be bubbled down again - method would cal for itself on the child.
         *
         * @param node - node to bubble down
         */

        Object tempVal = node.getValue();
        Comparable tempKey = node.getKey();
        // If has two children
        if ( node.getRight() != null ){
            // If at least one of them is bigger
            if ( node.getKey().compareTo(node.getLeft().getKey()) == -1 || node.getKey().compareTo(node.getRight().getKey()) == -1){
                // If right one - swap with it
                if ( node.getRight().getKey().compareTo(node.getLeft().getKey()) == 1 ){
                    node.setValue(node.getRight().getValue());
                    node.setKey(node.getRight().getKey());

                    node.getRight().setValue(tempVal);
                    node.getRight().setKey(tempKey);
                    // Check child
                    bubbleDown(node.getRight());
                // Otherwise swap with left one.
                } else {
                    node.setValue(node.getLeft().getValue());
                    node.setKey(node.getLeft().getKey());

                    node.getLeft().setValue(tempVal);
                    node.getLeft().setKey(tempKey);
                    // Check child
                    bubbleDown(node.getLeft());
                }
            }

        } else {
            // If only one child and it is higher - swap but don't repeat anymore
            if ( node.getLeft() != null &&  node.getKey().compareTo(node.getLeft().getKey()) == -1 ){
                node.setValue(node.getLeft().getValue());
                node.setKey(node.getLeft().getKey());

                node.getLeft().setValue(tempVal);
                node.getLeft().setKey(tempKey);
            }
        }

    }

    public boolean isEmpty(){
        /**
         * This method returns true, if heap is empty or false otherwise.
         *
         */
        if (tree.getRoot() == null){
            return true;
        } else {
            return false;
        }
    }
}
