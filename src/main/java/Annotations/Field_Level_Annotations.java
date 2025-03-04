package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantString {

}

class Fox {
    @ImportantString
    private String name;
    private int numOfLegs;

    public Fox(String name, int numOfLegs) {
        this.name = name;
        this.numOfLegs = numOfLegs;
    }
}

class Main01 {
    public static void main(String[] args) throws IllegalAccessException {
        Fox fox = new Fox("Lisica",4);
        for(Field f : fox.getClass().getDeclaredFields()) {
            if(f.isAnnotationPresent(ImportantString.class)) {
                f.setAccessible(true);
                Object value = f.get(fox);

                if(value instanceof String myFoxName) { // String myFoxName = (String) value
                    System.out.println("The field name is : " + f.getName() + " and its value in uppercase is : " + myFoxName.toUpperCase());
                }
            }
        }
    }
}