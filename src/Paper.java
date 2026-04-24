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
=======

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
// Paper.java
// Purpose: this class represents a paper entity that moves around the world

// Paper() -> Paper
// Purpose: this constructor initializes a paper object with a position and world
// Examples: Paper(new Point(3,4), world) -> new Paper at position (3,4)

// getEntityPosition() -> Point
// Purpose: this function returns the current position of the paper
// Examples: getEntityPosition() -> Point(3,4)

// setEntityPosition() -> void
// Purpose: this function sets the paper to a new position
// Examples: setEntityPosition(new Point(5,6)) -> paper is now at (5,6)

//totalPaper() -> int
//Purpose: this function calculates the total number of papers
//Examples: totalPaper() -> 5

// checkNeighbors() -> ArrayList
// Purpose: this function checks all neighboring cells around the paper and returns a list of valid positions
// Examples: checkNeighbors() -> [(2,2), (2,3), (3,2)]

//movePaper() -> void
//Purpose: this function moves the paper in a direction (N, E, S, W)
//Examples: movePaper() -> paper moves from Point(1, 1) to Point(2, 2)

//paperAttack() -> void
//Purpose: this function attacks an object if it is on either side of it
//Examples: paperAttack() -> removes adjacent scissor if it is next to paper


>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
import java.util.ArrayList;
import java.util.Random;

public class Paper {
<<<<<<< HEAD

    static int paperCount = 0;
    private Object[][] world;
    private Point position;

=======
    // Current paper position
    // Random number generator

    // Paper count
    public static int paperCount = 0;
    private Object[][] world;
    private Point position;

    // Increment paper count
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
    public Paper(Point position, Object[][] world){
        this.position = position;
        this.world = world;
        paperCount++;
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
    // Move paper
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
    public void movePaper(){
        ArrayList<Point> neighbors = checkNeighbors();

        // Pick a random position from the list,
        Random rand = new Random();
        Point newPosition = neighbors.get(rand.nextInt(neighbors.size()));
        setEntityPosition(newPosition);
    }

<<<<<<< HEAD
=======

    // Paper attack
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
    public void paperAttack() {
        ArrayList<Point> neighbors = checkNeighbors();
        for (Point p : neighbors) {
            if(world[p.getPointX()][p.getPointY()] instanceof Rock){
                world[p.getPointX()][p.getPointY()] = null;
                Rock.rockCount--;
            }
        }
    }
<<<<<<< HEAD


=======
>>>>>>> 8d43ff2a9cefd67cfa7acdf4b3669547817f0175
}

