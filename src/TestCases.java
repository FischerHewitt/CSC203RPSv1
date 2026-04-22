
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


Testing Framework:
System.out.println("Testing moveRock() method. Current position ( %d, %d )." ,
        getEntityPosition().x, getEntityPosition().y );
        System.out.println("Expected output one of: " +
                "( 3, 7 ), ( 3, 6 ), ( 3, 8 ), ( 4, 6 ), ( 4, 8 ), ( 5, 7 ), (5, 6 ), ( 5, 8 )");
        System.out.printf("Actual output: (%d, %d).", getEntityPosition().x, getEntityPosition().y );
 */


import java.util.Arrays;

public class TestCases {
    public static void main(String[] args){
        System.out.println("Test 01:\nTesting  World(int width=2, int height=3) method.");
        System.out.println("Expected output: w=2, h=3");
        System.out.print("Actual output:");
        World world1 = new World(2, 3);
        System.out.printf("w=%d, h=%d", world1.world.length, world1.world[0].length);


    }
}
