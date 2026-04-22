//Steps
// 1. Ask for user input for dimensions (ex. width: 3, height: 3)
// 2. Ask for user input for entities ("How many of each rock paper scissors do you want
//in the world (ie, three rocks, three papers, three scissors. input: 3)
// 3. check if the amount of rocks, papers, and scissors provided will fit in the world space
// 4. run world function and print result
import com.sun.jdi.IntegerType;

import java.util.Scanner;



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
                "//in the world (ie, three rocks, three papers, three scissors. input: 3");
        String Objects = input.nextLine();

    }
}
