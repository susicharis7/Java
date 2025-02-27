package Encapsulation_And_Inheritance;

/*
By defining a new method the readability of the main program has improved.
Pay attention to the descriptive name of the method: the name describes exactly what the method does.
Next, we can remove the advising comments here we print numbers , because the name of the method speaks for itself.
*/

import java.util.ArrayList;
import java.util.List;

class SlicingSeperateTasksIntoMethods {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(3);
        numList.add(4);
        numList.add(3);

        System.out.println("Numbers in the beginning: ");
        print(numList);

        remove(numList,3);
        remove(numList,4);

        System.out.println("Numbers after removal: ");
        print(numList);

    }

    public static void print(List<Integer> nums) {
        for(int n : nums) {
            System.out.println(n);
        }
    }

    public static void remove(List<Integer> nums, int removed) {
        while(nums.contains(Integer.valueOf(removed))) {
            nums.remove(Integer.valueOf(removed));
        }
    }


}
