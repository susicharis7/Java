package Generics.Static_And_Non_Static;

class TicketPrices {
public static final double SINGLE_TICKET_ADULT = 2.50;
public static final double TRAM_TICKET_ADULT = 2.50;

public static double getSingleTicketAdult() {
    return TicketPrices.SINGLE_TICKET_ADULT;
}
}

class Person {
    private String name;
    private double money;

    // constructor
    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public void addMoney(double amount) {
        if(amount > 0) {
            this.money += amount;
        }
    }

    public boolean enoughMoneyForSigleTicket() {
        if(this.money >= TicketPrices.getSingleTicketAdult()) {
            return true;
        }

        return false;
    }
}

