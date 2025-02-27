package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Slot<T> {
    private T key;

    public void setValue(T key) {
        this.key = key;
    }

    public T getValue() {
        return this.key;
    }

    public static void main(String[] args) {
        Slot<String> string = new Slot<>();
        string.setValue(":)");

        System.out.println(string.getValue());

        // An important part of Java data structures are programmed to be generic.
        // For instance, ArrayList receives one parameter, HashMap two.

        List<String> strings = new ArrayList<String>();
        Map<String, String> keyCouples = new HashMap<String, String>();
    }
}
