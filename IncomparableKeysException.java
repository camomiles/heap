/**
 * This class is a IncomparableKeysException of the Heap implementation. It is implemented through doubly-linked list.
 * It is part of Assignment 3 for the Data Structures and Algorithms subject in Bond University.
 *
 * Class implements extends Exception and thrown when given keys for nodes cannot be compared between each other.
 *
 * @author Roman Yakobnyuk
 * @date 04/08/2013
 */
public class IncomparableKeysException extends RuntimeException {

    public IncomparableKeysException(String message) {
        super(message);
    }
}
