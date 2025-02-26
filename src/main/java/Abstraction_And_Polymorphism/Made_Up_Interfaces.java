package Abstraction_And_Polymorphism;

/*
Java API offers a sensible number of made-up interfaces.
Java's most used interfaces:
    List
    Map
    Set
    Collection
*/

import java.util.*;

class MadeUpInterfaces {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("Haris");

        List<String> names2 = new ArrayList<>();
        names2.add("Sumea");

        Set<String> set = new HashSet<>();
        set.add("Haris");
        set.add("Mirza");
        set.add("Amila");

        for(String key : set) {
            System.out.println(key);
        }

        Map<String, String> translations = new HashMap<String, String>();
        translations.put("gambatte", "good luck");
        translations.put("hai", "yes");

        Set<String> keys = translations.keySet();
        Collection<String> keySet = keys;

        System.out.println("Keys:");
        for(String key: keySet) {
            System.out.println(key);
        }

        System.out.println();
        System.out.println("Values:");
        Collection<String> values = translations.values();
        for(String value: values) {
            System.out.println(value);
        }

    }
}
