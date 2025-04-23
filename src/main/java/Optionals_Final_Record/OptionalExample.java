package Optionals_Final_Record;

import java.util.Optional;

record Wolf(String name, int age) {}

class OptionalExample {

    public static Optional<Wolf> getWolfByNameOptional(String name){

        return Optional.ofNullable(null);
    }

    public static void main(String[] args) {
        Optional<Wolf> wolfOptional = getWolfByNameOptional("Strasni");

        if(wolfOptional.isPresent())
            System.out.println("Age: " + wolfOptional.get().age());
        else if(wolfOptional.isEmpty())
            System.out.println("NO VALUE IN IT");


        Wolf defaultWolf = new Wolf("Default", 0);
        Wolf wolf1 = wolfOptional.orElse(defaultWolf);
        System.out.println("Wolf (orElse): " + wolf1);


        Wolf wolf2 = wolfOptional.orElseGet(() -> new Wolf("Generated", 1));
        System.out.println("Wolf (orElseGet): " + wolf2);


        try {
            Wolf wolf3 = wolfOptional.orElseThrow(() -> new RuntimeException("No wolf found!"));
            System.out.println(wolf3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
