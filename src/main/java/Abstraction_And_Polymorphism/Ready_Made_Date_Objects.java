package Abstraction_And_Polymorphism;

import java.util.Calendar;

class DateObj {
    public static void main(String[] args) {
        int day = Calendar.getInstance().get(Calendar.DATE);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1; // because January - 0
        int year = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("Today is : " + day + "." + month + "." + year);
    }
}
