package Generics.Collections_HashMaps_Wildcards;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

// More into Collections...

class ClubMember implements Comparable<ClubMember> {
    private String name;
    private int height;

    public ClubMember(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }
    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(ClubMember other) {
        return Integer.compare(this.height, other.height);
    }

    @Override
    public String toString() {
        return name + " (" + height + " cm)";
    }
}

class ClubMembersApp {
    public static void main(String[] args) {
        List<ClubMember> clubMembers = new ArrayList<>();
        clubMembers.add(new ClubMember("Haris", 182));
        clubMembers.add(new ClubMember("Becir", 187));
        clubMembers.add(new ClubMember("Tarik", 184));


        Collections.sort(clubMembers);

        System.out.println("Sorted Club Members: " + clubMembers);
        searchMember(clubMembers, 180);
        searchMember(clubMembers, 187);
    }

    public static void searchMember(List<ClubMember> clubMembers, int height) {
        ClubMember wanted = new ClubMember("Name", height);
        int index = Collections.binarySearch(clubMembers, wanted);

        if (index >= 0) {
            System.out.println("A person who is " + height + " cm tall was found at index " + index);
            System.out.println("Name: " + clubMembers.get(index).getName());
        } else {
            System.out.println("No person found with height " + height + " cm.");
        }
    }
}



