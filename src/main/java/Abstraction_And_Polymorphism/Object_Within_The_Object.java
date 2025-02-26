package Abstraction_And_Polymorphism;


class MyDate {
    int day;
    int month;
    int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public boolean earlier(MyDate compared) {
        if(this.year < compared.getYear()) {
            return true;
        }

        if(this.year == compared.getYear() && this.month < compared.getMonth()) {
            return true;
        }

        if(this.year == compared.getYear() && this.month == compared.getMonth() && this.day < compared.getDay())
            return true;

        return false;
    }
}

class NewPerson {
    private String name;
    private int age;
    private int weight;
    private int height;
    private MyDate dateOfBirth;

    public NewPerson(String name, int day, int month, int year) {
        this.name = name;
        this.age = 0;
        this.weight = 0;
        this.height = 0;
        this.dateOfBirth = new MyDate(day,month,year);
    }

    public String toString() {
        return this.name + " , born " + this.dateOfBirth;
    }
}


