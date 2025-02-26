package Abstraction_And_Polymorphism;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class ObjPol {

    public static void printManyTimes(Object object,int times) {
        for(int i = 0; i < times; i++) {
            System.out.println(object.toString());
        }
    }

    public static void polymorphicBehavior() {
        Serializable serializableString = new String("string");
        CharSequence charSequenceString = "string";
        Comparable<String> comparableString = "string";
    }

    public static void printCharacters(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            System.out.println(charSequence.charAt(i));
        }
    }


    public static void main(String[] args) {
        String string = "String";
        Object objString = "Another String";

        String secString = "Character String";
        Object obj2String = string;

        Object obj3String = "Another one";
        // String thirdString = obj3String; - This doesn't work (obj3String is an object!!)




        List<String> words = new ArrayList<String>();
        words.add("polymorphism");
        words.add("inheritance");
        words.add("encapsulation");
        words.add("abstraction");

        printManyTimes("Becir", 5);
        printManyTimes(words, 5);

    }
}
