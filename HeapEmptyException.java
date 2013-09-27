/**
 * This class is a HeapEmptyException of the Heap implementation. It is implemented through doubly-linked list.
 * It is part of Assignment 3 for the Data Structures and Algorithms subject in Bond University.
 *
 * Class implements extends Exception and thrown when trying to remove from empty heap.
 *
 * @author Roman Yakobnyuk
 * @date 04/08/2013
 */
public class HeapEmptyException extends RuntimeException {

    public HeapEmptyException(String message) {
    super(message);
    }
}
