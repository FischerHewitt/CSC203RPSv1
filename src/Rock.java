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

//moveRock() -> void
//Purpose: this function moves the rock in a direction (N, E, S, W)
//Examples: moveRock() -> rock moves from Point(1, 1) to Point(2, 2)

//rockAttack() -> void
//Purpose: this function attacks an object if it is on either side of it
//Examples: rockAttack() -> removes adjacent paper if it is next to rock


public class Rock {
    // Current rock position
    // Random number generator

    // Rock count
    private static int rockCount = 0;
    String[][] world;
    Point position;

    // Increment rock count
    public Rock(Point position, String[][] world){
        this.position = position;
        this.world = world;
        rockCount++;
    }

    // Get
    public Point getEntityPosition() {
        return position;
    }

    // Set
    public void setEntityPosition(Point position) {
        this.position = position;
    }

    // Move rock
    public void moveRock(World myWorld){
        // Move position
        myRock.position.getX = 1;
        myRock.position.getY = 1;
    }

    // Rock attack
    public void rockAttack(){

    }

}