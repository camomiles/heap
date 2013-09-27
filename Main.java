/**
 * This class is a main class of the Heap implementation. It is implemented through doubly-linked list.
 * It is part of Assignment 3 for the Data Structures and Algorithms subject in Bond University.
 *
 * Class runs tests over heap implementation:
 *  1. Inserting given amount of test objects with keys generated randomly into the heap.
 *  2. Check isEmpty function to answer false.
 *  3. Remove all objects from the heap printing them out on remove.
 *  4. Check isEmpty function again.
 *
 * Number of elements is specified by constant NUM_ELEMENTS
 *
 *
 * @author Roman Yakobnyuk
 * @date 04/08/2013
 */


public class Main {
    public static void main(String args[]){

        // Edit number of elements here.
        final int NUM_ELEMENTS = 100000;

        Heap heap = new HeapQueue();

        System.out.print("\n == Testing heap implemented through doubly-linked list == " +
                "\n" +
                "\n Inserting " + NUM_ELEMENTS + " random elements into the heap...");

        // Insert elements with randomly generated int keys
        for(int x = 0; x < NUM_ELEMENTS; x++){
            heap.insert((int) (Math.random()*100), " #" + x);
        }

        System.out.print("\n  - Done!" +
                "\n" +
                "\n Testing isEmpty() function -> " + heap.isEmpty() + "" +
                "\n  - Done!" +
                "\n" +
                "\n Removing " + NUM_ELEMENTS + " from the heap...\n");

        // Remove elements
        for(int y = 0; y < NUM_ELEMENTS; y++){
            System.out.print(heap.remove());
        }

        System.out.print("\n  - Done!" +
                "\n" +
                "\n Testing isEmpty() function again -> " + heap.isEmpty() +
                "\n  - Done!" +
                "\n" +
                "\n == End ==");


    }
}
