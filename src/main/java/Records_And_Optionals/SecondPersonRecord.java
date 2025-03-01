package Records_And_Optionals;

// As of JDK 14, we can replace our repetitions data classes with records.
// Records are immutable data classes that require only the type and name of fields.
// PersonRecord.java can be replaced with single line of code using records.


record SecondPerson(String name, int age, int height) {
    public static String UNKNOWN_ADDRESS = "Unknown";

    public SecondPerson(String name) {
        this(name,0,0);
    }

    public SecondPerson(String name, int age) {
        this(name,age,0);
    }

    public static SecondPerson unnamed(String name) {
        return new SecondPerson(name);
    }

    public int a() {
        return 1;
    }
}


