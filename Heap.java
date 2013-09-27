/**
 * This class is a Heap interface of the Heap implementation. It is implemented through doubly-linked list.
 * It is part of Assignment 3 for the Data Structures and Algorithms subject in Bond University.
 *
 * Class implements interface for operating over Heap data-storage. Heap Queue implements this interface.
 *
 * It links to following methods:
 *  - public Object front()                             - returns value of the front object, which it the root of the tree.
 *  - public void insert(Comparable key, Object obj)    - inserts new element into the heap
 *  - public Object remove()                            - returns front object and removes it from the heap.
 *  - public boolean isEmpty()                          - returns true if heap is empty, otherwise false.
 *
 * @author Roman Yakobnyuk
 * @date 04/08/2013
 */
public interface Heap {
    public void insert(Comparable key, Object e);
    public Object remove();
    public Object front();
    public boolean isEmpty();
}
