package QuestionBank.Conditional_And_Loops;

/*
a, b, c = 0, 0, 0 . Write a java program to print all permutations using those three variables
          Output : 000 , 001 ,002, 003, 004, 005 ,006, 007, 008, 009, 010, 011 …… 999
 */

class NinethTask {
    public static void main(String[] args) {

        for(int a = 0; a <= 9; a++) {
            for(int b = 0; b <= 9; b++) {
                for(int c = 0; c <= 9; c++) {
                    System.out.printf("%d%d%d%n", a,b,c);
                }
            }
        }



    }
}

