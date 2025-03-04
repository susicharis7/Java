package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface VeryImportant {

}

class Lion {
    String name;

    public Lion(String name) {
        this.name = name;
    }

}


class Main10 {
    public static void main(String[] args) {
        Lion lion = new Lion("Lav");
        System.out.println(lion.getClass().isAnnotationPresent(VeryImportant.class));
    }
}
