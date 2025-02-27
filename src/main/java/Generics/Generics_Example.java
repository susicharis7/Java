package Generics;

/*
Example: create a class ClubMember, which represent the young people and children who belong to the club.
The members have to eat in order of height, so the club members will implement the interface Comparable.
The interface Comparable also takes as type parameter the class which it is compared to.
As type parameter, we use the ClubMember class.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ClubMember implements Comparable<ClubMember> {
    private String name;
    private int height;

    public ClubMember(String name, int height) {
        this.name = name;
        this.height = height;
    }
    public String getName() {
        return this.name;
    }
    public int getHeight() {
        return this.height;
    }
    @Override
    public String toString() {
        return this.getName() + " (" + this.getHeight() + ")";
    }
    @Override
    public int compareTo(ClubMember clubMember) {
        if(this.height == clubMember.getHeight()) {
            return 0;
        } else if (this.height > clubMember.getHeight()) {
            return 1;
        } else {
            return -1;
        }
    }
}


class Run {
    public static void main(String[] args) {
        List<ClubMember> clubMembers = new ArrayList<ClubMember>();
        clubMembers.add(new ClubMember("mikael", 182));
        clubMembers.add(new ClubMember("matti", 187));
        clubMembers.add(new ClubMember("joel", 184));

        System.out.println(clubMembers);
        Collections.sort(clubMembers);
        System.out.println(clubMembers);
    }
}

