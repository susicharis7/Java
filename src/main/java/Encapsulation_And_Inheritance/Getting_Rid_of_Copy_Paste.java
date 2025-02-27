package Encapsulation_And_Inheritance;

import java.util.ArrayList;
import java.util.List;

/*
What could be called the Original sin of a programmer is to create copy-paste code.
This means using the same code in multiple places by copy-pasting it around the source code.
In our example, the printing of the list is done twice.
The code that handles the printing part should be separated as its own method...
*/

class NoMoreCopyPaste {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(4);
        nums.add(7);
        nums.add(3);

        System.out.println("The numbers in the beginning: ");
        print(nums);

        while(nums.contains(Integer.valueOf(3))) {
            nums.remove(Integer.valueOf(3));
        }

        System.out.println("Numbers after removal: ");
        print(nums);

    }


    public static void print(List<Integer> insideNums) {
        for(int num : insideNums) {
            System.out.println(num);
        }
    }
}
