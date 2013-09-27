/**
 * This class is a Deque class of the Heap implementation. It is implemented through doubly-linked list.
 * It is part of Assignment 3 for the Data Structures and Algorithms subject in Bond University.
 *
 * Class implements doubly-linked list of DequeNode classes that keep TreeNodes as values.
 * It is used to keep frontier of the binary tree for further use.
 * Used as an additional data-structure for the heap.
 *
 * It describes following methods:
 *  - public void insertAtFront(TreeNode obj)   - inserts new TreeNode at the front of the deque
 *  - public void insertAtRear(TreeNode obj)    - inserts new TreeNode at the rear of the deque
 *  - public void removeFront()                 - remove front element of the deque
 *  - public void removeRear()                  - remove rear element of the deque
 *  - public TreeNode accessFront()             - access front element of the deque
 *  - public TreeNode accessRear()              - access rear element of the deque
 *  - public boolean isEmpty()                  - returns true if deque is empty, otherwise false.
 *
 * @author Roman Yakobnyuk
 * @date 04/08/2013
 */

public class Deque {
    private DequeNode front = null;
    private DequeNode rear = null;


    public void insertAtFront(TreeNode obj){
        /**
         * This method inserts new TreeNode at the front of the deque
         *
         * @param obj TreeNode to insert
         */
        if (front == null){
            front = new DequeNode(obj);
            rear = front;
        } else {
            front = new DequeNode(obj,null,front);
            front.getNext().setLast(front);
        }
    }

    public void insertAtRear(TreeNode obj){
        /**
         * This method inserts new TreeNode at the rear of the deque
         *
         * @param obj TreeNode to insert
         */
        if (rear != null){
            DequeNode newRear = new DequeNode(obj,rear,null);
            rear.setNext(newRear);
            rear = newRear;
        }
    }

    public void removeFront(){
        /**
         * This method removes TreeNode at the front of the deque
         */
        front = front.getNext();
    }

    public void removeRear(){
        /**
         * This method removes TreeNode at the rear of the deque
         */
        rear = rear.getLast();
    }

    public TreeNode accessFront(){
        /**
         * This method returns TreeNode at the front of the deque
         */
        return front.getValue();
    }

    public TreeNode accessRear(){
        /**
         * This method removes TreeNode at the rear of the deque
         */
        return rear.getValue();
    }

    public boolean isEmpty(){
        /**
         * This method returns true, if deque is empty and false otherwise.
         */
        if (front == null){
            return true;
        } else {
            return false;
        }
    }

}
