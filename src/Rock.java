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

// Documentation
// Rock.java
// Purpose: this class represents a rock entity that moves around the world

// Rock() -> Rock
// Purpose: this constructor initializes a rock object with a position and world
// Examples: Rock(new Point(3,4), world) -> new Rock at position (3,4)

// getEntityPosition() -> Point
// Purpose: this function returns the current position of the rock
// Examples: getEntityPosition() -> Point(3,4)

// setEntityPosition() -> void
// Purpose: this function sets the rock to a new position
// Examples: setEntityPosition(new Point(5,6)) -> rock is now at (5,6)

//totalRock() -> int
//Purpose: this function calculates the total number of rocks
//Examples: totalRock() -> 5

// checkNeighbors() -> ArrayList
// Purpose: this function checks all neighboring cells around the rock and returns a list of valid positions
// Examples: checkNeighbors() -> [(2,2), (2,3), (3,2)]

//moveRock() -> void
//Purpose: this function moves the rock in a direction (N, E, S, W)
//Examples: moveRock() -> rock moves from Point(1, 1) to Point(2, 2)

//rockAttack() -> void
//Purpose: this function attacks an object if it is on either side of it
//Examples: rockAttack() -> removes adjacent paper if it is next to rock


import java.util.ArrayList;
import java.util.Random;

public class Rock {
    // Current rock position
    // Random number generator

    // Rock count
    public static int rockCount = 0;
    private Object[][] world;
    private Point position;

    // Increment rock count
    public Rock(Point position, Object[][] world){
        this.position = position;
        this.world = world;
        rockCount++;
    }

    // Get current position
    public Point getEntityPosition() {
        return position;
    }

    // Set current position
    public void setEntityPosition(Point position) {
        this.position = position;
    }

    // Check neighbors
    public ArrayList<Point> checkNeighbors(){
        ArrayList<Point> neighbors = new ArrayList<>();

        // Check all positions around the rock
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                int newX = position.getPointX() + x;
                int newY = position.getPointY() + y;

                // Add to list if within bounds
                if((newX < this.world.length) && (0 <= newX) && (newY < this.world[0].length) && (0 <= newY)){
                    neighbors.add(new Point(newX, newY));
                }
            }
        }
        return neighbors;
    }


    // Move rock
    public void moveRock(){
        ArrayList<Point> neighbors = checkNeighbors();

        // Pick a random position from the list,
        Random rand = new Random();
        Point newPosition = neighbors.get(rand.nextInt(neighbors.size()));
        setEntityPosition(newPosition);
    }


    // Rock attack
    public void rockAttack() {
        ArrayList<Point> neighbors = checkNeighbors();
        for (Point p : neighbors) {
            if(world[p.getPointX()][p.getPointY()] instanceof Scissors){
                world[p.getPointX()][p.getPointY()] = null;
                    Scissors.scissorsCount--;
            }
        }
    }
}