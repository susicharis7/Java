package Records_And_Optionals;

// Optional is simply a container for an object. It either contains an object, or doesnt...
// We use optionals in order to avoid having the null pointer exception when accessing certain objects.

record Wolf(String name, int age) {
    public static Wolf getWolfByName(String name) {
        return null;
    }

    public static void main(String[] args) {
        Wolf wolf = getWolfByName("Strasni");
       // System.out.println(wolf.age()); // NullPointerException

        if(wolf != null) {
            System.out.println(wolf.age());
        } else {
            System.out.println("No wolf!");
        }
    }
}

