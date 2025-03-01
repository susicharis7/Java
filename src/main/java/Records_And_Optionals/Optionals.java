package Records_And_Optionals;

// Optional is simply a container for an object. It either contains an object, or doesnt...
// We use optionals in order to avoid having the null pointer exception when accessing certain objects.

import java.util.Optional;

record Wolf(String name, int age) {
    public static Wolf getWolfByName(String name) {
        return null;
    }

    public static Optional<Wolf> getWolfByNameOptional(String name) {
        return Optional.ofNullable(null);
    }

    public static void main(String[] args) {
        Wolf wolf = getWolfByName("Strasni");
       // System.out.println(wolf.age()); // NullPointerException

        if(wolf != null) {
            System.out.println(wolf.age());
        } else {
            System.out.println("No wolf!");
        }


        Optional<Wolf> wolfOptional = getWolfByNameOptional("Strasni");
        if(wolfOptional.isPresent()) {
            System.out.println(wolfOptional.get().age());
        } else if(wolfOptional.isEmpty()) {
            System.out.println("No value in it!");
        }
    }
}

