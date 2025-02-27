package Generics.More_Into_Arrays;

import java.util.Arrays;
import java.util.Scanner;

class BinaryS {
    // Binary Search Algorithm
    public static int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x is greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
                // If x is smaller, ignore right half
            else
                r = m - 1;
        }
        // If element is not found
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define a sorted array
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println("Sorted array: " + Arrays.toString(arr));

        // User input
        System.out.print("Enter a number to search: ");
        int x = sc.nextInt();

        // Perform Binary Search
        int result = binarySearch(arr, x);

        // Display result
        if (result == -1)
            System.out.println("Element not found.");
        else
            System.out.println("Element found at index: " + result);

        sc.close();
    }
}


