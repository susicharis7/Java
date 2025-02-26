package Abstraction_And_Polymorphism;

import java.util.ArrayList;

class FootballClub {
    private String name;
    private int yearOfFoundation;
    private ArrayList<Person> players;

    public FootballClub(String name, int yearOfFoundation) {
        this.name = name;
        this.yearOfFoundation = yearOfFoundation;
        this.players = new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYearOfFoundation() {
        return yearOfFoundation;
    }
    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }
    public ArrayList<Person> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Person> players) {
        this.players = players;
    }


    public boolean isAcceptedAsPlayer(Person player) {
        return player.getAge() > 18;
    }

    public void addPlayer(Person player) {
        if (isAcceptedAsPlayer(player))
            this.players.add(player);
    }

    public String toString() {
        String playersString = "";

        for (Person player : players) {
            playersString += player.toString() + "\n";
        }
        return playersString;
    }
}
