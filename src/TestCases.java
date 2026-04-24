
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
        // Test 01
        // Testing World(int width=2, int height=3)
        System.out.println("Test 01:\nTesting World(int width=2, int height=3) method.");
        System.out.println("Expected output: w=2, h=3");
        System.out.print("Actual output:");
        World world1 = new World(2, 3); // creates a new world with width=2 height=3
        System.out.printf("w=%d, h=%d %n%n", world1.world.length, world1.world[0].length); //formats with width and height

        // Test 02
        // Testing printWorld() with width=2, height=3, world is empty
        System.out.println("Test 02:\nTesting printWorld() method. w=2, h=3, world is empty.");
        System.out.println(
                        """
                Expected output:
                World:
                +-+-+
                | | |
                +-+-+
                | | |
                +-+-+
                | | |
                +-+-+
                """);
        System.out.println("Actual output:");
        world1.printWorld(); //prints the world

        // Test 03
        // Testing Print world with objects in the world.
        System.out.println("Test 03:\nTesting printWorld() method. w=3, h=4, Rocks=3");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+-+
        |R| | |
        +-+-+-+
        | |R| |
        +-+-+-+
        | | |R|
        +-+-+-+
        | | | |
        +-+-+-+
        """);
        World world2 = new World(3, 4); // new world width=3 height=4
        world2.world[0][0] = new Rock(new Point(0,0), world2.world); // new rock at Point(0,0)
        world2.world[1][1] = new Rock(new Point(1,1), world2.world); // new rock at Point(1,1)
        world2.world[2][2] = new Rock(new Point(2,2), world2.world); // new rock at Point(2,2)
        System.out.println("Actual output:");
        world2.printWorld();

        // Test 04
        // Test addRock() method. w=2, h=3, Rocks=1
        System.out.println("Test 04:\nTesting addRock() method. w=2, h=3, Rocks=1");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+or+-+-+or+-+-+or+-+-+or+-+-+or+-+-+ 
        |R| |  | |R|  | | |  | | |  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        | | |  | | |  |R| |  | |R|  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        | | |  | | |  | | |  | | |  |R| |  | |R|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        """);
        world1.addRock();
        System.out.println("Actual output:");
        world1.printWorld();

        // Test 05
        // Test addPaper() method. w=2, h=3, paper=1
        System.out.println("Test 05:\nTesting addPaper() method. w=2, h=3, Paper=1");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+or+-+-+or+-+-+or+-+-+or+-+-+or+-+-+ 
        |P| |  | |P|  | | |  | | |  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        | | |  | | |  |P| |  | |P|  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        | | |  | | |  | | |  | | |  |P| |  | |P|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        """);
        World world3 = new World(2, 3);
        world3.addPaper();
        System.out.println("Actual output:");
        world3.printWorld();

        // Test 06
        // Test addScissors() method. w=2, h=3, scissors = 1
        System.out.println("Test 06:\nTesting addScissors() method. w=2, h=3, Scissors=1");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+or+-+-+or+-+-+or+-+-+or+-+-+or+-+-+ 
        |S| |  | |S|  | | |  | | |  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        | | |  | | |  |S| |  | |S|  | | |  | | |
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        | | |  | | |  | | |  | | |  |S| |  | |S|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        """);
        World world4 = new World(2, 3);
        world4.addScissors();
        System.out.println("Actual output:");
        world4.printWorld();

        // Test 07
        // Test findEmpty() method indirectly using world1. w=2, h=3, Rocks=12
        System.out.println("Test 07:\nTesting findEmpty() method. w=2, h=3, Rocks=12");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+-+-+
        |R|R|R|R|
        +-+-+-+-+
        |R|R|R|R|
        +-+-+-+-+
        |R|R|R|R|
        +-+-+-+-+
        """);
        World world7 = new World(4, 3); // new world width=3 height=4
        for (int xWorld7 = 0; xWorld7 < world7.width - 1; xWorld7++){
            for (int yWorld7 = 0; yWorld7 < world7.height; yWorld7++){
                world7.world[xWorld7][yWorld7] = new Rock(new Point(xWorld7,yWorld7), world7.world);
            }
        }
        world7.world[3][0] = new Rock(new Point(3,0), world7.world); // new rock at Point(3,0)
        world7.world[3][1] = new Rock(new Point(3,1), world7.world); // new rock at Point(3,1)
        world7.addRock();
        System.out.println("Actual output:");
        world7.printWorld();


        // Test 08
        // Test findEmpty() method indirectly using world1. w=2, h=3, Rocks=5
        System.out.println("Test 08:\nTesting findEmpty() method. w=2, h=3, Rocks=5");
        System.out.println(
                """
        Expected output:
        World:
        +-+-+or+-+-+or+-+-+or+-+-+or+-+-+or+-+-+ 
        |R|R|  |R|R|  |R|R|  |R|R|  |R| |  | |R|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        |R|R|  |R|R|  |R| |  | |R|  |R|R|  |R|R|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        |R| |  | |R|  |R|R|  |R|R|  |R|R|  |R|R|
        +-+-+  +-+-+  +-+-+  +-+-+  +-+-+  +-+-+ 
        """);
        world1.addRock();
        world1.addRock();
        world1.addRock();
        world1.addRock();
        System.out.println("Actual output:");
        world1.printWorld();

        // Test 09
        // Test getRandomWidth() and getRandomHeight() method. w=2, h=3
        System.out.println("Test 09:\nTesting getRandomWidth() and getRandomHeight() method. w=2, h=3");
        System.out.println(
                """
        Expected output:
        getRandomWidth = 0 or 1
        getRandomHeight = 0, 1, or 2
        """);
        System.out.println("Actual output:");
        System.out.printf("getRandomWidth = %d%n" +
                "getRandomHeight = %d", world1.getRandomWidth(), world1.getRandomHeight());

        // Test 10
        // Test initializeObjects method.
        System.out.println("Test 10:\nTesting initializeObjects method.");
        System.out.println(
                """
        Expected output: A world with 2 rocks 2 paper and 2 scissors.
        ex:
        +-+-+
        |R|P|
        +-+-+
        |P|S|
        +-+-+
        |S|R|
        +-+-+
        """);
        System.out.println("Actual output:");
        World world10 = new World(2, 3);
        world10.initializeObjects(2);
        world10.printWorld();
    }
}
