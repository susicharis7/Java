package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RunImmediatelyNTimes {
    int times();
}

class Main12 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Lav lav = new Lav("LavAgain");
        for(Method m : lav.getClass().getDeclaredMethods()) {
            if(m.isAnnotationPresent(RunImmediatelyNTimes.class)) {
                RunImmediatelyNTimes ann = m.getAnnotation(RunImmediatelyNTimes.class);

                for(int i = 0; i < ann.times(); i++) {
                    m.invoke(lav);
                }
            }
        }
    }
}