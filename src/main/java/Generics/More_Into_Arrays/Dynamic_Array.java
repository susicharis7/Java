package Generics.More_Into_Arrays;

// This method is particularly useful in scenarios where the exact number of elements is unknown at compile time, allowing arrays to be created based on dynamic conditions.

class DArray {
    public static void main(String[] args) {
        int capacity = 50;
        int[] data = new int[capacity];

        if(data.length == capacity) {
            System.out.println("The array size is : " + capacity);
        } else {
            System.out.println("Unexpected results. The array size is not " + capacity);
        }
    }
}
