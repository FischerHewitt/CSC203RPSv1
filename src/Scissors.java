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

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Random;

public class Scissors {
    static int scissorsCount = 0;
    private Object[][] world;
    private Point position;

=======
// Documentation
// Scissors.java
// Purpose: this class represents a scissor entity that moves around the world

// Scissors() -> Scissors
// Purpose: this constructor initializes a scissor object with a position and world
// Examples: Scissor(new Point(3,4), world) -> new Scissor at position (3,4)

// getEntityPosition() -> Point
// Purpose: this function returns the current position of the scissor
// Examples: getEntityPosition() -> Point(3,4)

// setEntityPosition() -> void
// Purpose: this function sets the scissors to a new position
// Examples: setEntityPosition(new Point(5,6)) -> scissor is now at (5,6)

//totalScissor() -> int
//Purpose: this function calculates the total number of scissors
//Examples: totalScissor() -> 5

// checkNeighbors() -> ArrayList
// Purpose: this function checks all neighboring cells around the scissors and returns a list of valid positions
// Examples: checkNeighbors() -> [(2,2), (2,3), (3,2)]

//moveScissor() -> void
//Purpose: this function moves the scissors in a direction (N, E, S, W)
//Examples: moveScissor() -> scissor moves from Point(1, 1) to Point(2, 2)

//scissorAttack() -> void
//Purpose: this function attacks an object if it is on either side of it
//Examples: scissorAttack() -> removes adjacent rock if it is next to scissor


import java.util.ArrayList;
import java.util.Random;

public class Scissors {
    // Current scissor position
    // Random number generator

    // Scissor count
    public static int scissorsCount = 0;
    private Object[][] world;
    private Point position;

    // Increment scissors count
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
    public Scissors(Point position, Object[][] world){
        this.position = position;
        this.world = world;
        scissorsCount++;
    }

<<<<<<< HEAD
=======
    // Get current position
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
    public Point getEntityPosition() {
        return position;
    }

<<<<<<< HEAD
=======
    // Set current position
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
    public void setEntityPosition(Point position) {
        this.position = position;
    }

<<<<<<< HEAD
    public ArrayList<Point> checkNeighbors() {
        ArrayList<Point> neighbors = new ArrayList<>();

        // Check all positions around the rock
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
=======
    // Check neighbors
    public ArrayList<Point> checkNeighbors(){
        ArrayList<Point> neighbors = new ArrayList<>();

        // Check all positions around the rock
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
                int newX = position.getPointX() + x;
                int newY = position.getPointY() + y;

                // Add to list if within bounds
<<<<<<< HEAD
                if ((newX < this.world.length) && (0 <= newX) && (newY < this.world[0].length) && (0 <= newY)) {
=======
                if((newX < this.world.length) && (0 <= newX) && (newY < this.world[0].length) && (0 <= newY)){
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
                    neighbors.add(new Point(newX, newY));
                }
            }
        }
        return neighbors;
    }


<<<<<<< HEAD
=======
    // Move scissor
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
    public void moveScissors(){
        ArrayList<Point> neighbors = checkNeighbors();

        // Pick a random position from the list,
        Random rand = new Random();
        Point newPosition = neighbors.get(rand.nextInt(neighbors.size()));
        setEntityPosition(newPosition);
    }

<<<<<<< HEAD
=======

    // Scissor attack
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
    public void scissorsAttack() {
        ArrayList<Point> neighbors = checkNeighbors();
        for (Point p : neighbors) {
            if(world[p.getPointX()][p.getPointY()] instanceof Paper){
                world[p.getPointX()][p.getPointY()] = null;
<<<<<<< HEAD
                Paper.paperCount++;
=======
                Paper.paperCount--;
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
            }
        }
    }
}
