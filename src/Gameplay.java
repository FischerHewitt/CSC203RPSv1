//Steps
// 1. Ask for user input for dimensions (ex. width: 3, height: 3)
// 2. Ask for user input for entities ("How many of each rock paper scissors do you want
//in the world (ie, three rocks, three papers, three scissors. input: 3)
// 3. check if the amount of rocks, papers, and scissors provided will fit in the world space
// 4. run world function and print result
import com.sun.jdi.IntegerType;

import java.util.Scanner;
/*
    Developers: Fischer Hewitt, Sameeka Molugu, Mason Brown
    Date: 04/20/2026
    Project 2: RPSv1
    Description: Build a rock paper scissors game that has a world full of rock, paper, and scissors, then they move
    around randomly and the last object standing is the winner.
    world view print view with coordinate labels
   0 1 2 3 (x)      ^ 0 1 2
  +-+-+-+-+           ^ ^ ^
0 | | | | |        0
  +-+-+-+-+           - - -
1 | | | | |        1
  +-+-+-+-+           - - -
2 | | | | |        2
  +-+-+-+-+           v v v
(y)                          v
*/



public class Gameplay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Rock, paper, scissors game \n");
        System.out.println("What is the width of your matrix?: ");
        String w = input.nextLine();
        System.out.println("What is the length of your matrix?: ");
        String l = input.nextLine();
        int wInt = Integer.parseInt(w);
        int lInt = Integer.parseInt(l);
        World GameWorld = new World(wInt, lInt);

        System.out.println("How many of each rock paper scissors do you want\n" +
                "in the world (ie, three rocks, three papers, three scissors. input: 3");
        String Objects = input.nextLine();
        int objInts = Integer.parseInt(Objects);

        GameWorld.addEntity();
        GameWorld.initializeObjects(objInts);

        GameWorld.playRound();

    }
}
