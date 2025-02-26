package Abstraction_And_Polymorphism;


import java.util.ArrayList;
import java.util.List;

class MethodReturnsObject {
    private List<Person> players;

    public MethodReturnsObject() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Person player) {
        players.add(player);
    }

    public Person oldestPlayer() {
        if (players.isEmpty()) {
            return null;
        }

        Person oldest = players.get(0);
        for (Person player : players) {
            if (oldest.getAge() < player.getAge()) {
                oldest = player;
            }
        }
        return oldest;
    }
}

class Main03 {
    public static void main(String[] args) {
        MethodReturnsObject team = new MethodReturnsObject();


        team.addPlayer(new Person("Haris", 25));
        team.addPlayer(new Person("Becir", 30));
        team.addPlayer(new Person("Tarik", 28));

        Person oldest = team.oldestPlayer();
        if (oldest != null) {
            System.out.println("Oldest player: " + oldest);
        } else {
            System.out.println("No players in the list.");
        }
    }
}