package Generics.More_Into_Arrays;

// Returning array from a Method
public class ReturningArray {

    public static int[] generateNumbers() {
        int[] numbers = new int[4];

        numbers[0] = 5;
        numbers[1] = 10;
        numbers[2] = 15;
        numbers[3] = 20;

        return numbers;
    }

    public static void main(String[] args) {
        int[] values = generateNumbers();

        for(int v : values) {
            System.out.println(v);
        }
    }

}
