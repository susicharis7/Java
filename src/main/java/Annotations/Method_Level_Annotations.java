package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RunImmediately {

}

record Lav(String name) {
    @RunImmediately
    public void saySomething() {
        System.out.println("Lav says something...");
    }

    public void sayButDontRun() {
        System.out.println("I said it but did not run...");
    }
}

class Main11 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Lav lav = new Lav("Lavcina");

        for(Method m : lav.getClass().getDeclaredMethods()) {
            if(m.isAnnotationPresent(RunImmediately.class)) {
                System.out.println("Method name is : " + m.getName());
                m.invoke(lav);
            }
        }
    }
}